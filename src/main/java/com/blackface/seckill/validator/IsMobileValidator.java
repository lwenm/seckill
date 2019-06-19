package com.blackface.seckill.validator;

import  javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.blackface.seckill.util.ValidatorUtil;
import org.springframework.util.StringUtils;

/**
 * Author:lwenm
 * Description:
 * Date:2019/5/15
 * Time:22:07
 **/
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

    private boolean required = false;

    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(required) {
            return ValidatorUtil.isMobile(value);
        }else {
            if(StringUtils.isEmpty(value)) {
                return true;
            }else {
                return ValidatorUtil.isMobile(value);
            }
        }
    }

}

