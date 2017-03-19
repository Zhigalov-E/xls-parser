package org.myorg.xls.db;


import org.myorg.xls.entities.DbEntity;

import java.sql.*;
import java.util.List;

public class DbWriter {
    private static final int BATCH_SIZE = 1000;
    private static final String QUERY = "INSERT INTO public.xls_data(brand, model, width, height, diameter, season, " +
            "country, balance, gross_price, year_made) \n" +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    public  static void writeToDb(List<DbEntity> dbEntities) {
        try(Connection con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(QUERY)) {
            int count = 0;
            for (DbEntity dbEntity: dbEntities) {
                pstmt.setString(1, dbEntity.getBrand());
                pstmt.setString(2, dbEntity.getModel());
                pstmt.setInt(3, dbEntity.getWidth());
                pstmt.setInt(4, dbEntity.getHeight());
                pstmt.setInt(5, dbEntity.getDiameter());
                SqlHelper.setStringOrNull(pstmt, 6, dbEntity.getSeason());
                SqlHelper.setStringOrNull(pstmt, 7, dbEntity.getCountry());
                pstmt.setInt(8, dbEntity.getBalance());
                pstmt.setDouble(9, dbEntity.getGrossPrice());
                SqlHelper.setIntOrNull(pstmt, 10, dbEntity.getYear());

                pstmt.addBatch();
                if(++count % BATCH_SIZE == 0) {
                    pstmt.executeBatch();
                }
            }
            pstmt.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
