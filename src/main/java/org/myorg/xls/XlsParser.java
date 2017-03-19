package org.myorg.xls;


import org.myorg.xls.db.DbWriter;
import org.myorg.xls.entities.DbEntity;
import org.myorg.xls.entities.XlsEntity;
import org.myorg.xls.utils.DbTransformer;
import org.myorg.xls.utils.XlsReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XlsParser {

    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                List<XlsEntity> list = XlsReader.readFromExcel(args[0]);
                List<DbEntity> dbList = new ArrayList<>();
                for (XlsEntity xlsEntity : list) {
                    dbList.add(DbTransformer.transform(xlsEntity));
                }
                DbWriter.writeToDb(dbList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("first parameter must be path to parse *.xls file");
        }

    }
}
