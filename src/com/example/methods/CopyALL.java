package com.example.methods;
import com.example.connect.ConnectDb;
import org.postgresql.util.PSQLException;
import java.io.IOException;
import java.sql.*;


public class CopyALL {

    public void all() throws SQLException {

        ConnectDb connectDb = new ConnectDb ( );

        String sql = "INSERT INTO postgres2.public.table_name2  (id,column_2,column_3,column_4,column_5)" +
                     "VALUES(?,?,?,?,?)ON CONFLICT (id) DO NOTHING ";
        String sql2 = "SELECT *FROM postgres.public.table_name";

        Connection ctDbPostgres = null;

        try {
            ctDbPostgres = connectDb.connect ( "demo" );
            System.out.println ( "Вы удачно подключились к базе данных postgres" );
        }
        catch ( IOException e ) {
            System.out.println ( "Ошибка подключения к базе данных postgres" );
        }
        Statement statement = null;
        if ( ctDbPostgres != null ) {
            statement = ctDbPostgres.createStatement ( );
        }
        else {
            System.out.println ( "Нет подключения к базе postgres" );
        }
        ResultSet resultSet = null;
        if ( statement != null ) {
            resultSet = statement.executeQuery ( sql2 );
        }
        else {
            System.out.println ( "Нет подключения к базе postgres" );
        }
        Connection ctDbPostgres2 = null;
        try {
            ctDbPostgres2 = connectDb.connect ( "demo2" );
            System.out.println ( "Вы удачно подключились к базе данных postgres2" );
        }
        catch ( IOException e ) {
            System.out.println ( "Ошибка подключения к базе данных postgres2" );
        }

        PreparedStatement preparedStatement = null;
        if ( ctDbPostgres2 != null ) {
            preparedStatement = ctDbPostgres2.prepareStatement ( sql );
        }
        else {
            System.out.println ( "Нет подключения к базе postgres2" );
        }
        try {
            if ( resultSet != null ) {
                new Result ( resultSet , preparedStatement );
            }
            else {
                System.out.println ( "Нет подключения к базе postgres2" );
            }
        }
        catch ( PSQLException p ) {
            System.out.println ( "Такие значения уже существуют в базе данных!" );
        }
        new Close ( resultSet , preparedStatement , statement , ctDbPostgres , ctDbPostgres2 );
    }
}

