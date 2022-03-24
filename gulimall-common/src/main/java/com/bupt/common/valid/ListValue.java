package com.bupt.common.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

// 2 表明校验注解
@Documented
//指定校验器
@Constraint(
        validatedBy = { ListValueConstraintValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ListValue {
// 1 自定义注解必须包含以下三个信息
    // 从默认的配置文件中取这个值 ./ValidationMessages.properties
    String message() default "{com.bupt.common.valid.ListValue.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

//
    int[] vals() default {};
}
