package org.myorg.xls.utils;

import org.myorg.xls.entities.DbEntity;
import org.myorg.xls.entities.XlsEntity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DbTransformer {

    private static String MODEL_TRANSFORM_PATTERN = "%s ([^,]*)";
    private static String DIAMETER_TRANSFORM_PATTERN = "\\d+";
    private static int INIT_YEAR = 2000;
    private static int YEAR_FORMAT_DELIMITER = 100;

    public static DbEntity transform(XlsEntity excelEntity) {
        DbEntity dbEntity = new DbEntity();
        dbEntity.setBrand(excelEntity.getBrand());

        Pattern pattern = Pattern.compile(String.format(MODEL_TRANSFORM_PATTERN, excelEntity.getBrand()));
        Matcher matcher = pattern.matcher(excelEntity.getFullName());
        if (matcher.find()) {
            dbEntity.setModel(matcher.group(1));
        }

        try {
            dbEntity.setWidth(Integer.parseInt(excelEntity.getWidth()));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        try {
            dbEntity.setHeight(Integer.parseInt(excelEntity.getHight()));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

        pattern = Pattern.compile(DIAMETER_TRANSFORM_PATTERN);
        matcher = pattern.matcher(excelEntity.getDiameter());
        if (matcher.find()) {
            try {
                dbEntity.setDiameter(Integer.parseInt(matcher.group()));
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }

        dbEntity.setSeason(excelEntity.getSeason());
        dbEntity.setCountry(excelEntity.getCountry());
        try {
            dbEntity.setBalance(Integer.parseInt(excelEntity.getBalance()));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        try {
            dbEntity.setGrossPrice(Double.parseDouble(excelEntity.getGrossPrice()));
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        try {
            dbEntity.setYear(INIT_YEAR + Integer.parseInt(excelEntity.getDate()) % YEAR_FORMAT_DELIMITER);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

        return dbEntity;
    }
}
