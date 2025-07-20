/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import banco.ConexaoDB;
import log.ProdutosLog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class ProdutosDao {
    
    private java.sql.Connection conexao;
    
    public ProdutosDao() throws SQLException {
        this.conexao = ConexaoDB.getConexao();
}
    public void adiciona(ProdutosLog c1) throws SQLException {

        //entrada de dados
        //prepara a conexão
        String sql = "insert into produtos (estoque,valor,nome,validade)"
                + "values(?,?,?,?)";
        PreparedStatement entra = conexao.prepareStatement(sql);
        //seta os valores
        entra.setInt(1, c1.getEstoque());
        entra.setDouble(2, c1.getValor());
        entra.setString(3, c1.getNome());
        entra.setString(4, c1.getValidade());
       
        //executa o codigo sql
        entra.execute();
        entra.close();
    }
   
    //listar tabela
    //prepara a conexão
    public List<ProdutosLog> getLista(String nome) {
        try {
            String sql = "select * from produtos where nome LIKE ?";
            PreparedStatement mostra = this.conexao.prepareStatement(sql);
            mostra.setString(1, nome);
            ResultSet res = mostra.executeQuery();
            //cria um objeto lista
            List<ProdutosLog> MList = new ArrayList<ProdutosLog>();
            //busca os dados da tabela
            while (res.next()) {
                ProdutosLog c1 = new ProdutosLog();
                c1.setIdProd(res.getInt("idprod"));
                c1.setEstoque(res.getInt("estoque"));
                c1.setValor(res.getDouble("valor"));
                c1.setNome(res.getString("nome"));
                c1.setValidade(res.getString("validade"));
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
    
    

    public void altera(ProdutosLog c1) throws SQLException {

        String sql = "update produtos set estoque=?,valor=?,nome=?,validade=? "
                + "where idprod=?";
        PreparedStatement alt = conexao.prepareStatement(sql);
        alt.setInt(5, c1.getIdProd());
        alt.setInt(1, c1.getEstoque());
        alt.setDouble(2, c1.getValor());
        alt.setString(3, c1.getNome());
        alt.setString(4, c1.getValidade());

        alt.execute();
        alt.close();

    }

    public void Excluir(ProdutosLog c1) throws SQLException {

        //exclusão de dados
        //prepara a conexão
        String sql = "delete from produtos where idprod=?";
        PreparedStatement exclui = conexao.prepareStatement(sql);
        //seta o valor a ser excluido
        exclui.setInt(1, c1.getIdProd());
        //executa o codigo sql
        exclui.execute();
        exclui.close();
    }
}
