/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.suporte.beans.Cidade;
import br.suporte.beans.Perfil;
import br.suporte.beans.Sistema;
import br.suporte.beans.Telefone;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rafael
 */
public class PessoaFisicaa {
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private Boolean status;
    private Cidadee cidade;
    private Perfill perfil;
    private PessoaJuridicaa pessoaJuridica;

    public PessoaFisicaa() {
    }

    public PessoaFisicaa(Integer id, String nome, String email, String senha, Boolean status, Cidadee cidade, Perfill perfil, PessoaJuridicaa pessoaJuridica) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.status = status;
        this.cidade = cidade;
        this.perfil = perfil;
        this.pessoaJuridica = pessoaJuridica;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Cidadee getCidade() {
        return cidade;
    }

    public void setCidade(Cidadee cidade) {
        this.cidade = cidade;
    }

    public Perfill getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfill perfil) {
        this.perfil = perfil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PessoaJuridicaa getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridicaa pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

   
   

   
    
}
