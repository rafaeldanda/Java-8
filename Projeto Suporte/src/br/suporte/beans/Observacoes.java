/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.suporte.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name="tblprOjetosuporte")
public class Observacoes implements Serializable{
    
    @Id
    @SequenceGenerator(name="SEQ_OBSERVACOES",sequenceName="SEQ_OBSERVACOES_INDEX",allocationSize=1)
    @GeneratedValue(generator="SEQ_OBSERVACOES", strategy= GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(nullable=true)
    private String descricao;
    
    @ManyToOne
    private PDA pda;
    
    public Observacoes() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

   
    
    
}
