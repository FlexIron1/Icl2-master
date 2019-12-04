package com.example;

import com.example.methods.CopyALL;
import com.example.methods.CopyByID;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class RunApplication {

    private static boolean key = true;

    static Map<String, String> stringParser(String stringPars) {
        String[] splits = stringPars.split ( "=" );
        Map<String, String> map = new LinkedHashMap<> ();
        for (int i = 0; i < splits.length; i = +2) {
            String split = splits[i];
            for (int j = 1; j < splits.length; j = +2) {
                String s = splits[j];
                map.put ( split, s );
            }
        }
        return map;
    }

    public static void main(String[] args) throws SQLException {
        CopyALL copyALL = new CopyALL ();
        CopyByID copyByID = new CopyByID ();
        if (args.length != 0) {
            for (String argument : args) {
                if (argument.contains ( "=" )) {
                    Map<String, String> map = stringParser ( argument );
                    for (Map.Entry entry : map.entrySet ()) {
                        if (entry.getKey ().equals ( "ID" )) {
                            int number = Integer.parseInt ( (String) entry.getValue () );
                            copyByID.id ( number );
                            System.out.println ( "Данные успешно скопированы по переданному в ключ ID значение" + number );
                        } else if (entry.getKey ().equals ( "ALL" )) {
                            copyALL.all ();
                        } else if (entry.getKey ().equals ( "Select" )) {
                            InterfaceApp.main ();
                        }
                    }
                } else {
                    System.out.println ( "Не правильная команда" );
                }
            }
        } else {
            InterfaceApp.main ();
        }
    }
}



