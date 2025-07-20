/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import banco.ConexaoDB;
import log.ClienteLog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class ClienteDao {
    
    private java.sql.Connection conexao;
    
    public ClienteDao() throws SQLException {
        this.conexao = ConexaoDB.getConexao();
}
    public void adiciona(ClienteLog c1) throws SQLException {

        //entrada de dados
        //prepara a conexão
        String sql = "insert into cliente (cpf,nome,email,nascimento,contato)"
                + "values(?,?,?,?,?)";
        PreparedStatement entra = conexao.prepareStatement(sql);
        //seta os valores
        entra.setLong(1, c1.getCpf());
        entra.setString(2, c1.getNome());
        entra.setString(3, c1.getEmail());
        entra.setString(4, c1.getNascimento());
        entra.setString(5, c1.getContato());
       
        //executa o codigo sql
        entra.execute();
        entra.close();
    }
   
    //listar tabela
    //prepara a conexão
    public List<ClienteLog> getLista(String nome) {
        try {
            String sql = "select * from cliente where nome LIKE ?";
            PreparedStatement mostra = this.conexao.prepareStatement(sql);
            mostra.setString(1, nome);
            ResultSet res = mostra.executeQuery();
            //cria um objeto lista
            List<ClienteLog> MList = new ArrayList<ClienteLog>();
            //busca os dados da tabela
            while (res.next()) {
                ClienteLog c1 = new ClienteLog();
                c1.setCpf(res.getLong("cpf"));
                c1.setNome(res.getString("nome"));
                c1.setEmail(res.getString("email"));
                c1.setNascimento(res.getString("nascimento"));
                c1.setContato(res.getString("contato"));
                MList.add(c1);
            }
            res.close();
            System.out.println("fechando banco");
            mostra.close();
            return MList;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    
    public List<ClienteLog> getC(String nome) {
        try {
            String sql = "select * from cliente where cpf=?";
            PreparedStatement mostra = this.conexao.prepareStatement(sql);
            mostra.setString(1, nome);
            ResultSet res = mostra.executeQuery();
            //cria um objeto lista
            List<ClienteLog> MList = new ArrayList<ClienteLog>();
            //busca os dados da tabela
            while (res.next()) {
                ClienteLog c1 = new ClienteLog();
                c1.setCpf(res.getLong("cpf"));
                c1.setNome(res.getString("nome"));
                c1.setEmail(res.getString("email"));
                c1.setNascimento(res.getString("nascimento"));
                c1.setContato(res.getString("contato"));
                MList.add(c1);
            }
            res.close();
            System.out.println("fechando banco");
            mostra.close();
            return MList;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    
    

    public void altera(ClienteLog c1) throws SQLException {

        String sql = "update cliente set nome=?,email=?,nascimento=?,contato=?"
                + "where cpf=?";
        PreparedStatement alt = conexao.prepareStatement(sql);
        alt.setLong(5, c1.getCpf());
        alt.setString(1, c1.getNome());
        alt.setString(2, c1.getEmail());
        alt.setString(3, c1.getNascimento());
        alt.setString(4, c1.getContato());

        alt.execute();
        alt.close();

    }

    public void Excluir(ClienteLog c1) throws SQLException {

        //exclusão de dados
        //prepara a conexão
        String sql = "delete from cliente where cpf=?";
        PreparedStatement exclui = conexao.prepareStatement(sql);
        //seta o valor a ser excluido
        exclui.setLong(1, c1.getCpf());
        //executa o codigo sql
        exclui.execute();
        exclui.close();
    }
}