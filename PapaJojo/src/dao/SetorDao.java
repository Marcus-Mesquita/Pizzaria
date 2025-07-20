/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import banco.ConexaoDB;
import log.SetorLog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class SetorDao {
    
    private java.sql.Connection conexao;
    
    public SetorDao() throws SQLException {
        this.conexao = ConexaoDB.getConexao();
}
    public void adiciona(SetorLog c1) throws SQLException {

        //entrada de dados
        //prepara a conexão
        String sql = "insert into setor (nome_setor,descricao,obs)"
                + "values(?,?,?)";
        PreparedStatement entra = conexao.prepareStatement(sql);
        //seta os valores
        entra.setString(1, c1.getNome_setor());
        entra.setString(2, c1.getDescricao());
        entra.setString(3, c1.getObs());
       
        //executa o codigo sql
        entra.execute();
        entra.close();
    }
   
    //listar tabela
    //prepara a conexão
    public List<SetorLog> getLista(String nome_setor) {
        try {
            String sql = "select * from setor where nome_setor LIKE ?";
            PreparedStatement mostra = this.conexao.prepareStatement(sql);
            mostra.setString(1, nome_setor);
            ResultSet res = mostra.executeQuery();
            //cria um objeto lista
            List<SetorLog> MList = new ArrayList<SetorLog>();
            //busca os dados da tabela
            while (res.next()) {
                SetorLog c1 = new SetorLog();
                c1.setIdsetor(Integer.valueOf(res.getString("idsetor")));
                c1.setNome_setor(res.getString("nome_setor"));
                c1.setDescricao(res.getString("descricao"));
                c1.setObs(res.getString("obs"));
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
    
    

    public void altera(SetorLog c1) throws SQLException {

        String sql = " update setor set nome_setor = ?,descricao = ?,obs=? "
                + "where idsetor=?";
        PreparedStatement alt = conexao.prepareStatement(sql);
        alt.setString(1, c1.getNome_setor());
        alt.setString(2, c1.getDescricao());
        alt.setString(3, c1.getObs());
        alt.setInt(4, c1.getIdsetor());

        alt.execute();
        alt.close();

    }

    public void Excluir(SetorLog c1) throws SQLException {

        //exclusão de dados
        //prepara a conexão
        String sql = "delete from setor where idsetor=?";
        PreparedStatement exclui = conexao.prepareStatement(sql);
        //seta o valor a ser excluido
        exclui.setLong(1, c1.getIdsetor());
        //executa o codigo sql
        exclui.execute();
        exclui.close();
    }
}
