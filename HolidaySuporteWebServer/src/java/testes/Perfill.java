/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import javax.persistence.Column;

/**
 *
 * @author rafael
 */
public class Perfill {
    
    private Integer id;
    private String nome;
    private Boolean status;

    public Perfill() {
    }

    public Perfill(Integer id, String nome, Boolean status) {
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
