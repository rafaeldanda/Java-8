package br.suporte.beans;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="tblTelefone")
@XmlRootElement
public class Telefone implements Serializable{

    @Id
    @SequenceGenerator(name="SEQ_TELEFONE",sequenceName="SEQ_TELEFONE_INDEX",allocationSize=1)
    @GeneratedValue(generator="SEQ_TELEFONE", strategy= GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(length=50)
    private String nome;
    
    @Column(length=14, nullable=true)
    private String telefone;
    
    @Column(length=14, nullable=true)
    private String celular;
    
    @Column
    private Boolean publico;
    
    
    @ManyToOne
    private Pessoa pessoa;
    
   
    public Telefone() {
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    

    public Boolean getPublico() {
        return publico;
    }

    public void setPublico(Boolean publico) {
        this.publico = publico;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

   
       
    
}
