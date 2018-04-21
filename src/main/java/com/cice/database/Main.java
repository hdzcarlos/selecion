package com.cice.database;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        /**
         * Pasos para conectar con la base de datos
         * 1ª Creamos el driver
         * 2ª creamos la conexion
         * 3ª con la clase Statement
         */
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/databasecien","root","root");
            Statement statement = connection.createStatement();
            /**
             * Creamos la sentencia SQL que deseamos hacer.
             * 1º Creamos la tabla
             * 2º hacemos un insert de 100 valores usando un bucle para insertar.
             * 3º hacemos un select de los valores que deseamos recuperar.
             *          1 Utilizamos stament.executeQuery(Sentencia SQL)
             *          2 Se almacena en un objeto de tipo ResulSet que  es una interfaz y podemos utilizar sus metodos
             *          3 Utilizamos el metodo first para recorrer el primero de los elementos de la lista y el last() el ultimo
             *          4 Almacenamos en un string lo que queremos recuperar con el metodo getString.
             *          5 Si queremos mostra todos los resultados de la tabla unicamente debemos introducir en un bucle while el metodo next del objeto resulSet.
             */
         //   String crat = "CREATE TABLE losmayores21 (id INT NOT NULL AUTO_INCREMENT, nombre VARCHAR(30) NOT NULL, PRIMARY KEY(id));";
          //  String ins = "INSERT INTO databasecien VALUES(null,'nombrePrueba')";
              String sele = " SELECT * FROM databasecien";
              ResultSet resultSet = statement.executeQuery(sele);
              while (resultSet.next()){
                  String id = resultSet.getString("id");
                  String nombre = resultSet.getString("nombre");
                  System.out.println(id +" " + nombre);
              }
              // statement.executeUpdate(crat)
            //for (int i = 0; i<100; i++){
              //  statement.executeUpdate(ins);
            connection.close();
            statement.close();
            } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}

