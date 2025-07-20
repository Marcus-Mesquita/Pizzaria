/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import banco.ConexaoDB;
import log.FornecedorLog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Aluno
 */
public class FornecedorDao {
    
    private java.sql.Connection conexao;
    
    public FornecedorDao() throws SQLException {
        this.conexao = ConexaoDB.getConexao();
}
    public void adiciona(FornecedorLog c1) throws SQLException {

        //entrada de dados
        //prepara a conexão
        String sql = "insert into fornecedor (nome_forn,endereco,fone,email) "
                + " values(?,?,?,?)";
        PreparedStatement entra = conexao.prepareStatement(sql);
        //seta os valores
        entra.setString(1, c1.getNome_forn());
        entra.setString(2, c1.getEndereco());
        entra.setString(3, c1.getFone());
        entra.setString(4, c1.getEmail());
       
        //executa o codigo sql
        entra.execute();
        entra.close();
    }
   
    //listar tabela
    //prepara a conexão
    public List<FornecedorLog> getLista(String nome) {
        try {
            String sql = "select * from fornecedor where nome_forn LIKE ?";
            PreparedStatement mostra = this.conexao.prepareStatement(sql);
            mostra.setString(1, nome);
            ResultSet res = mostra.executeQuery();
            //cria um objeto lista
            List<FornecedorLog> MList = new ArrayList<FornecedorLog>();
            //busca os dados da tabela
            while (res.next()) {
                FornecedorLog c1 = new FornecedorLog();
                c1.setIdforn(res.getInt("idforn"));
                c1.setNome_forn(res.getString("nome_forn"));
                c1.setEndereco(res.getString("endereco"));
                c1.setFone(res.getString("fone"));
                c1.setEmail(res.getString("email"));
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
    
    

    public void altera(FornecedorLog c1) throws SQLException {

        String sql = "update fornecedor set nome_forn=?,endereco=?,fone =?, email=?"
                + "where idforn=?";
        PreparedStatement alt = conexao.prepareStatement(sql);
        alt.setLong(5, c1.getIdforn());
        alt.setString(1, c1.getNome_forn());
        alt.setString(2, c1.getEndereco());
        alt.setString(3, c1.getFone());
        alt.setString(4, c1.getEmail());
       

        alt.execute();
        alt.close();

    }

    public void Excluir(FornecedorLog c1) throws SQLException {

        //exclusão de dados
        //prepara a conexão
        String sql = "delete from fornecedor where idforn=?";
        PreparedStatement exclui = conexao.prepareStatement(sql);
        //seta o valor a ser excluido
        exclui.setLong(1, c1.getIdforn());
        //executa o codigo sql
        exclui.execute();
        exclui.close();
    }
}
