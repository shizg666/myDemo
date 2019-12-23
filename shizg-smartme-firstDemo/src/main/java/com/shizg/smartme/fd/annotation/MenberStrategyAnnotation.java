package com.shizg.smartme.fd.annotation;

import com.shizg.smartme.fd.enums.MenberTypes;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MenberStrategyAnnotation {
    MenberTypes type() ;
}
