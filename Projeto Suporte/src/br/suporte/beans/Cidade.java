package br.suporte.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="tblCidade")
@NamedQueries({@NamedQuery(name="listaCidades",query="select c from Cidade c"),
               @NamedQuery(name="buscaCidade",query="select c from Cidade c where c.id = :id")})
@XmlRootElement
public class Cidade implements Serializable{

    private static final long serialVersionUID = 1184153765907633024L;

    @Id
    @SequenceGenerator(name="SEQ_CIDADE",sequenceName="SEQ_CIDADE_INDEX",allocationSize=1)
    @GeneratedValue(generator="SEQ_CIDADE", strategy= GenerationType.SEQUENCE)
    private Integer id;

    //@NotEmpty(message = "O campo nome deve ser informado")
    //@Length(min = 1, max = 50, message = "O campo nome deve ter entre {min} e {max} caracteres")
    @Column(length=50)
    private String nome;

    
    @ManyToOne
    private Estado estado;
    
    
    @OneToMany
    private List<Pessoa> pessoa;
    
    

    public Cidade() {
        estado = new Estado();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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

    @XmlTransient
    public List<Pessoa> getPessoa() {
        return pessoa;
    }

    public void setPessoa(List<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }

    

    

    
	
}
