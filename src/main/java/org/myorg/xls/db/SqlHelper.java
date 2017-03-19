package org.myorg.xls.db;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class SqlHelper {
    public static void setIntOrNull(PreparedStatement pstmt, int column, Integer value) throws SQLException {
        if (value != null) {
            pstmt.setInt(column, value);
        } else {
            pstmt.setNull(column, Types.INTEGER);
        }
    }

    public static void setStringOrNull(PreparedStatement pstmt, int column, String value) throws SQLException {
        if (value != null) {
            pstmt.setString(column, value);
        } else {
            pstmt.setNull(column, Types.CHAR);
        }
    }

    public static void setDoubleOrNull(PreparedStatement pstmt, int column, Double value) throws SQLException {
        if (value != null) {
            pstmt.setDouble(column, value);
        } else {
            pstmt.setNull(column, Types.DOUBLE);
        }
    }
}
