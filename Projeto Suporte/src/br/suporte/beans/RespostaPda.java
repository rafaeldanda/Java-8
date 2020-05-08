
package br.suporte.beans;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Rafael
 */
@Table(name="tblRespostaPda")
@Entity
@NamedQuery(name="listaRespostaPda",query="select r from RespostaPda r where r.pda.id = :id")
public class RespostaPda implements Serializable{

    @Id
    @SequenceGenerator(name="SEQ_RESP",sequenceName="SEQ_RESP_INDEX",allocationSize=1)
    @GeneratedValue(generator="SEQ_RESP", strategy= GenerationType.SEQUENCE)
    private Integer id;
    
    @ManyToOne
    private PDA pda;
    
    @ManyToOne
    private PessoaFisica pessoa;
    
    @Column
    private String resposta;
    
    
    public RespostaPda() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PDA getPda() {
        return pda;
    }

    public void setPda(PDA pda) {
        this.pda = pda;
    }

    public PessoaFisica getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaFisica pessoa) {
        this.pessoa = pessoa;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    
}
