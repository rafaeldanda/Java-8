/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

/**
 *
 * @author rafael
 */
public class Cidadee {

    private Integer id;
    private String nome;
    
    public Cidadee() {
    }

    public Cidadee(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    
}
