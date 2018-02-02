package com.freecrm.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD , ElementType.TYPE })
public @interface ExcelDataInput {
	
	public String filename() default "";
	public String name() default "excelDataInput";
	public String sheetname() default "";
	public String dataProvider() default "getTestData";
	public Class<?> dataProviderClass() default ExcelUtil.class;
 
}
