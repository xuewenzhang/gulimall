package com.bupt.gulimall.product.service.impl;

import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bupt.common.utils.PageUtils;
import com.bupt.common.utils.Query;

import com.bupt.gulimall.product.dao.CategoryDao;
import com.bupt.gulimall.product.entity.CategoryEntity;
import com.bupt.gulimall.product.service.CategoryService;

import static java.util.stream.Collectors.toList;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    //.stream: Java8新特性，将处理的元素集合看作是一种流，在管道中传输，并可以在管道结点上处理，如filter、sorted、map、collect

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1 查出所有分类
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        // 2 组装成父子树形结构
        // 2.1 找到所有的一级分类： 一级分类的特点是所有的父分类ID是0
        List<CategoryEntity> level1Menus = categoryEntities.stream().filter((categoryEntity) -> {
            return categoryEntity.getParentCid() == 0;
        }).map((menu)->{
            // 将当前一级菜单的所有子菜单取出来，并设置进一级菜单返回出去
            menu.setChildren(getChildrens(menu, categoryEntities));
            return menu;
            // 将所有一级菜单进行排序
        }).sorted((menu1, menu2)->{
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(toList());
        return level1Menus;
    }

    @Override
    public void removeMenubyIds(List<Long> asList) {
        //TODO 检查当前菜单是否被别的地方引用
        baseMapper.deleteBatchIds(asList);

    }


    /**
     * 递归获取某一个菜单的所有子菜单
     * @param root： 当前菜单
     * @return all: 所有菜单，查找范围
     */
    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all){
        // 首先找到当前菜单的子菜单
        List<CategoryEntity> children = all.stream().filter((categoryEntity) -> {
            return categoryEntity.getParentCid() == root.getCatId();
            // 递归去寻找每个子菜单的子菜单
        }).map((categoryEntity) -> {
            categoryEntity.setChildren(getChildrens(categoryEntity, all));
            return categoryEntity;
            // 将当前的菜单进行排序
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(toList());
        return children;
    }





}