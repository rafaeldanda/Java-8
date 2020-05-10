/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.suporte.beans.ItemTrabalho;
import br.suporte.beans.PDA;
import br.suporte.beans.PessoaJuridica;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author rafael
 */
public class Sistemaa {

    private Integer id;
    private String nome;
    private Boolean status;
  

    public Sistemaa() {
    }

    public Sistemaa(Integer id, String nome, Boolean status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
       
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

  
    

    
    
}
