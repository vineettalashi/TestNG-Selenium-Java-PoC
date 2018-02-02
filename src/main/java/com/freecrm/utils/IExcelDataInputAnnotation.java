package com.freecrm.utils;

import org.testng.annotations.IAnnotation;

public interface IExcelDataInputAnnotation extends IAnnotation {

	public String getFilename();
	public void setFilename(String filename);
	public String getSheetname();
	public void setSheetname(String sheetname);
}
