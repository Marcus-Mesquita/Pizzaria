/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Aluno
 * 
 * public class Conexaodb_forn {
    
    public static Object con;
    public static Connection getConexao() throws SQLException{
    try { 
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Conectando ao banco");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/fornecedor","root",""); 
    }
    catch(ClassNotFoundException e){
        System.out.println("erro conexão");
    throw new SQLException(e.getMessage());
    
    }
    }

    
  }
 * 
 */
public class ConexaoDB {
    public static Object con;
    public static Connection getConexao() throws SQLException{
    try { 
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Conectando ao banco");
        return DriverManager.getConnection("jdbc:mysql://localhost/papa_jojo","root",""); 
    }
    catch(ClassNotFoundException e){
        System.out.println("erro conexão: "+ e.getMessage());
    throw new SQLException(e.getMessage());
    
    }
    }
}
