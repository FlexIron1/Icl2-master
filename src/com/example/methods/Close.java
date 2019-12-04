package com.example.methods;

import java.sql.*;

class Close {
    Close(ResultSet resultSet, PreparedStatement ps,PreparedStatement preparedStatement,
          Connection connection, Connection connection2) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (connection != null) {
            connection.close();
        }
        if (connection != null) {
            connection.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection2 != null) {
            connection2.close();
        }
    }
    Close(ResultSet resultSet, PreparedStatement ps, Statement statement,
          Connection connection, Connection connection2) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (connection != null) {
            connection.close();
        }
        if (connection != null) {
            connection.close();
        }
        if (statement!=null){
            connection.close();
        }
        if (connection2 != null) {
            connection2.close();
        }
    }
}
