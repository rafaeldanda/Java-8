package br.suporte.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name="tblEstado")
@NamedQuery(name="listaEstados",query="select e from Estado e")
public class Estado implements Serializable{

	
    private static final long serialVersionUID = -2412768362760364105L;
	
    @Id
    @SequenceGenerator(name="SEQ_ESTADO",sequenceName="SEQ_ESTADO_INDEX",allocationSize=1)
    @GeneratedValue(generator="SEQ_ESTADO", strategy= GenerationType.SEQUENCE)
    private Integer id;

    @Column(length=50)
    //@NotEmpty(message = "O campo nome deve ser informado")
    //@Length(min = 1, max = 50, message = "O campo nome deve ter entre {min} e {max} caracteres")
    private String Nome;

    @Column(length=2)
    //@NotEmpty(message = "O campo Sigla deve ser informado")
    //@Length(min = 1, max = 2, message = "O campo Sigla deve ter entre {min} e {max} caracteres")
    private String sigla;
    
    @OneToMany
    private List<Cidade> cidade;

    public Estado() {
        
    }

    public Integer getId() {
            return id;
    }

    public void setId(Integer id) {
            this.id = id;
    }

    public String getNome() {
            return Nome;
    }

    public void setNome(String nome) {
            Nome = nome;
    }

    public String getSigla() {
            return sigla;
    }

    public void setSigla(String sigla) {
            this.sigla = sigla;
    }

    public List<Cidade> getCidade() {
        return cidade;
    }

    public void setCidade(List<Cidade> cidade) {
        this.cidade = cidade;
    }
    
    

	
}
