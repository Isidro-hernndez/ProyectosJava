package vista;

import modelo.Estacionamiento;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thank
 */
public class Principal {
    public static void main(String args[]){
        try{
            Connection conn;
            Statement instruction;
            ResultSet resultados;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/estacionamiento?=root&password=123");
            instruccion
            
        }
    }
}
