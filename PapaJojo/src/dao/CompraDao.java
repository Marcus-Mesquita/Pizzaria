/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import banco.ConexaoDB;
import log.CompraLog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import log.ReceitasLog;

/**
 *
 * @author Aluno
 */
public class CompraDao {
    
    private java.sql.Connection conexao;
    
    public CompraDao() throws SQLException {
        this.conexao = ConexaoDB.getConexao();
}
    public void adiciona(CompraLog c1) throws SQLException {

        //entrada de dados
        //prepara a conexão
        String sql = "insert into compra (total,cpf)"
                + "values(?,?)";
        PreparedStatement entra = conexao.prepareStatement(sql);
        //seta os valores
        entra.setDouble(1, c1.getTotal());
        entra.setLong(2, c1.getCpf());
       
        //executa o codigo sql
        entra.execute();
        entra.close();
    }
   
    //listar tabela
    //prepara a conexão
    public List<CompraLog> getLista(int ID) {
        try {
            String sql = "select * from compra where id = ?";
            PreparedStatement mostra = this.conexao.prepareStatement(sql);
            mostra.setInt(1, ID);
            ResultSet res = mostra.executeQuery();
            //cria um objeto lista
            List<CompraLog> MList = new ArrayList<CompraLog>();
            //busca os dados da tabela
            while (res.next()) {
                CompraLog c1 = new CompraLog();
                c1.setTotal(res.getDouble("total"));
                c1.setCpf(res.getInt("cpf"));
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
    
    
     public List<ReceitasLog> getReceitas(String categoria) {
        try {
            String sql = "select * from receitas where categoria = ?";
            PreparedStatement mostra = this.conexao.prepareStatement(sql);
            mostra.setString(1, categoria);
            ResultSet res = mostra.executeQuery();
            //cria um objeto lista
            List<ReceitasLog> MList = new ArrayList<ReceitasLog>();
            //busca os dados da tabela
            while (res.next()) {
                ReceitasLog c1 = new ReceitasLog();
                c1.setValor(res.getDouble("valor"));
                c1.setId(res.getLong("idreceita"));
                c1.setCategoria(res.getString("categoria"));
                c1.setIngredientes(res.getString("ingredientes"));
                c1.setTitulo(res.getString("titulo"));
                c1.setDescricao(res.getString("descricao"));
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
    
    

    public void altera(CompraLog c1) throws SQLException {

        String sql = "update compra set total=?,cpf=?"
                + "where id=?";
        PreparedStatement alt = conexao.prepareStatement(sql);
        alt.setDouble(1, c1.getTotal());
        alt.setInt(1, c1.getCpf());
        alt.execute();
        alt.close();

    }

    public void Excluir(CompraLog c1) throws SQLException {

        //exclusão de dados
        //prepara a conexão
        String sql = "delete from compra where id=?";
        PreparedStatement exclui = conexao.prepareStatement(sql);
        //seta o valor a ser excluido
        exclui.setLong(1, c1.getId());
        //executa o codigo sql
        exclui.execute();
        exclui.close();
    }
}
