package com.bupt.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {
    private Set<Integer> set = new HashSet<>();
    @Override
    public void initialize(ListValue listValue) {
//        初始化方法  vals是listValue所有可能的值
        int[] vals = listValue.vals();
        for (int val : vals) {
            set.add(val);
        }
    }
//    判断是否校验成功  integer是待校验的值
    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {

        return set.contains(integer);
    }
}
