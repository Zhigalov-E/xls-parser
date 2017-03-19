package org.myorg.xls.utils;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.myorg.xls.entities.XlsEntity;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class XlsReader {

    public static final int START_ROW = 2;

    public static final int COLUMN_BRAND = 5;
    public static final int COLUMN_FULL_NAME = 7;
    public static final int COLUMN_WIDTH = 2;
    public static final int COLUMN_HIGHT = 3;
    public static final int COLUMN_DIAMETR = 4;
    public static final int COLUMN_SEASON = 1;
    public static final int COLUMN_CONTRY = 12;
    public static final int COLUMN_BALANCE = 8;
    public static final int COLUMN_GROSS_PRICE = 10;
    public static final int COLUMN_YEAR_MADE = 13;

    public static List<XlsEntity> readFromExcel(String fileName) throws IOException {
        HSSFWorkbook workBook = new HSSFWorkbook(new FileInputStream(fileName));
        HSSFSheet sheet = workBook.getSheetAt(0);
        List<XlsEntity> list = new ArrayList();
        for (int i = START_ROW; i <= sheet.getLastRowNum(); i++) {
            XlsEntity excelEntity = new XlsEntity();
            HSSFRow row = (HSSFRow) sheet.getRow(i);

            excelEntity.setBrand(getStrValue(row.getCell(COLUMN_BRAND)));
            excelEntity.setFullName(getStrValue(row.getCell(COLUMN_FULL_NAME)));
            excelEntity.setWidth(getStrValue(row.getCell(COLUMN_WIDTH)));
            excelEntity.setHight(getStrValue(row.getCell(COLUMN_HIGHT)));
            excelEntity.setDiameter(getStrValue(row.getCell(COLUMN_DIAMETR)));
            excelEntity.setSeason(getStrValue(row.getCell(COLUMN_SEASON)));
            excelEntity.setCountry(getStrValue(row.getCell(COLUMN_CONTRY)));
            excelEntity.setBalance(getStrValue(row.getCell(COLUMN_BALANCE)));
            excelEntity.setGrossPrice(getStrValue(row.getCell(COLUMN_GROSS_PRICE)));
            excelEntity.setDate(getStrValue(row.getCell(COLUMN_YEAR_MADE)));
            list.add(excelEntity);
        }
        return list;
    }

    private static String getStrValue(HSSFCell cell) {
        if(cell==null) {
            return null;
        }
        double numericCellValue = 0d;
        String strValue="";
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_NUMERIC:
                numericCellValue = cell.getNumericCellValue();
                DecimalFormat decimalFormat=new DecimalFormat("#");
                strValue=decimalFormat.format(numericCellValue);
                break;
            case HSSFCell.CELL_TYPE_STRING:
                strValue=cell.getStringCellValue();
                break;
        }
        return strValue;
    }

}
