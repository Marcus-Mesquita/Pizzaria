/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log;

/**
 *
 * @author Aluno
 */
public class FornecedorLog {
private int idforn;
private String nome_forn, endereco, fone,email;

    public int getIdforn() {
        return idforn;
    }

    public void setIdforn(int idforn) {
        this.idforn = idforn;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome_forn() {
        return nome_forn;
    }

    public void setNome_forn(String nome_forn) {
        this.nome_forn = nome_forn;
    }

}
