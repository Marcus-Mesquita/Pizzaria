/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import banco.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class LoginDao {
    
    public boolean CheckLogin (String cpf,String senha) throws SQLException{
    
        Connection con = ConexaoDB.getConexao();
         ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("select * from login where cpf = ? and senha = ?");
            stmt.setString(1, cpf);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            if( rs.next()){
            check= true;
            }
            
        } catch (Exception ex) {
        }
    return check;
    }   
}
