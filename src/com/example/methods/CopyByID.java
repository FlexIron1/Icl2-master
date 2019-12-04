package com.example.methods;
import com.example.connect.ConnectDb;
import java.io.IOException;
import java.sql.*;

public class CopyByID {

    public void id( int id ) throws SQLException {

        ConnectDb connectDb = new ConnectDb ( );

        String sql = "INSERT INTO postgres2.public.table_name2  (id,column_2,column_3,column_4,column_5)" +
                     "VALUES(?,?,?,?,?)" + "ON CONFLICT (id) DO NOTHING";
        String sql2 = "SELECT *  FROM table_name where id = ?";

        Connection ctDbPostgres = null;
        try {
            System.out.println ( "Подключение к postgres" );
            ctDbPostgres = connectDb.connect ( "demo" );
            System.out.println ( "Вы удачно подключились к базе данных postgres" );
        }
        catch ( IOException e ) {
            System.out.println ( "Ошибка подключения к базе данных postgres" );
        }
        PreparedStatement preparedStatement = null;
        if ( ctDbPostgres != null ) {
            preparedStatement = ctDbPostgres.prepareStatement ( sql2 );
        }
        else {
            System.out.println ( "Нет подключения к базе postgres" );
        }
        if ( preparedStatement != null ) {
            preparedStatement.setInt ( 1 , id );
        }
        else {
            System.out.println ( "Нет подключения к базе postgres" );
        }
        ResultSet resultSet = null;
        if ( preparedStatement != null ) {
            resultSet = preparedStatement.executeQuery ( );
        }
        else {
            System.out.println ( "Нет подключения к базе postgres" );
        }
        Connection ctDbPostgres2 = null;
        try {
            System.out.println ( "Подключение к postgres2" );

            ctDbPostgres2 = connectDb.connect ( "demo2" );
            System.out.println ( "Вы удачно подключились к базе данных postgres2" );
        }
        catch ( IOException e ) {
            System.out.println ( "Ошибка подключения к базе данных postgres2" );
        }
        PreparedStatement ps = null;

        if (ctDbPostgres2 != null) {
            ps = ctDbPostgres2.prepareStatement ( sql );
        } else {
            System.out.println ( "Нет подключения к базе postgres2" );
        }
        if (resultSet != null) {
            new Result ( resultSet, ps );
        } else System.out.println ( "Нет подключения к базе postgres2" );
        new Close ( resultSet, ps, preparedStatement, ctDbPostgres, ctDbPostgres2 );
    }
}






