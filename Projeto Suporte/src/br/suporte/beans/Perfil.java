package br.suporte.beans;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tblPerfil")
@NamedQuery(name="listaPerfil",query="select p from Perfil p")
public class Perfil implements Serializable{

    @Id
    @SequenceGenerator(name="SEQ_PERFIL",sequenceName="SEQ_PERFIL_INDEX",allocationSize=1)
    @GeneratedValue(generator="SEQ_PERFIL", strategy= GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(length=50, nullable=true)
    private String nome;
    
    @Column
    private Boolean status;

    public Perfil() {
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
