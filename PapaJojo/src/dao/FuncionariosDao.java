/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import banco.ConexaoDB;
import log.FuncionariosLog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class FuncionariosDao {
    
    private java.sql.Connection conexao;
    
    public FuncionariosDao() throws SQLException {
        this.conexao = ConexaoDB.getConexao();
}
    public void adiciona(FuncionariosLog c1) throws SQLException {

        //entrada de dados
        //prepara a conexão
        String sql = "insert into funcionarios (cpf,nome,salario,cargo,tel)"
                + "values(?,?,?,?,?)";
        PreparedStatement entra = conexao.prepareStatement(sql);
        //seta os valores
        entra.setLong(1, c1.getCpf());
        entra.setString(2, c1.getNome());
        entra.setDouble(3, c1.getSalario());
        entra.setString(4, c1.getCargo());
        entra.setString(5, c1.getTel());
       
        //executa o codigo sql
        entra.execute();
        entra.close();
    }
   
    //listar tabela
    //prepara a conexão
    public List<FuncionariosLog> getLista(String nome) {
        try {
            String sql = "select * from funcionarios where nome LIKE ?";
            PreparedStatement mostra = this.conexao.prepareStatement(sql);
            mostra.setString(1, nome);
            ResultSet res = mostra.executeQuery();
            //cria um objeto lista
            List<FuncionariosLog> MList = new ArrayList<FuncionariosLog>();
            //busca os dados da tabela
            while (res.next()) {
                FuncionariosLog c1 = new FuncionariosLog();
                c1.setCpf(res.getLong("cpf"));
                c1.setNome(res.getString("nome"));
                c1.setSalario(res.getDouble("salario"));
                c1.setCargo(res.getString("cargo"));
                c1.setTel(res.getString("tel"));
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
    
    

    public void altera(FuncionariosLog c1) throws SQLException {

        String sql = "update funcionarios set nome=?,salario=?,cargo=?, tel=? "
                + "where cpf=?";
        PreparedStatement alt = conexao.prepareStatement(sql);
        alt.setLong(5, c1.getCpf());
        alt.setString(1, c1.getNome());
        alt.setDouble(2, c1.getSalario());
        alt.setString(3, c1.getCargo());
        alt.setString(4, c1.getTel());

        alt.execute();
        alt.close();

    }

    public void Excluir(FuncionariosLog c1) throws SQLException {

        //exclusão de dados
        //prepara a conexão
        String sql = "delete from funcionarios where cpf=?";
        PreparedStatement exclui = conexao.prepareStatement(sql);
        //seta o valor a ser excluido
        exclui.setLong(1, c1.getCpf());
        //executa o codigo sql
        exclui.execute();
        exclui.close();
    }
}
