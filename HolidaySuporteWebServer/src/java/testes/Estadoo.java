/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael
 */
public class Estadoo {
    
    private Integer id;
    private String nome;
    private String sigla;
    private  List<Cidadee> listaCidade= new ArrayList<Cidadee>();

    public Estadoo() {
    }

    public Estadoo(Integer id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String Sigla) {
        this.sigla = Sigla;
    }

    
    public List<Cidadee> getListaCidade() {
        return listaCidade;
    }

    public void setListaCidade(List<Cidadee> listaCidade) {
        this.listaCidade = listaCidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    
}
