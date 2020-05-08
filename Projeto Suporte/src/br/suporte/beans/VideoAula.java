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
@Table(name="tblVideoAula")
@NamedQuery(name="listaAulas",query="select e from VideoAula e")
public class VideoAula implements Serializable{
    
    @Id
    @SequenceGenerator(name="SEQ_VIDEOAULA",sequenceName="SEQ_VIDEOAULA_INDEX",allocationSize=1)
    @GeneratedValue(generator="SEQ_VIDEOAULA", strategy= GenerationType.SEQUENCE)
    private Integer id;
    
    @Column
    private String caminho;
    
    @Column(length=50,nullable=true)
    private String nome;
    
    @Column(nullable=true)
    private String descricao;
    
    @Column
    private String status;
    
     
    @ManyToMany
    @JoinTable(name = "tbltreinamentoonline_tblvideoaula",
            joinColumns = @JoinColumn(name = "listavideoaula_id"),
            inverseJoinColumns = @JoinColumn(name = "listatreinamentoonline_id"))
    private List<TreinamentoOnline> listaTreinamentoOnline;

    public VideoAula() {
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
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

    public List<TreinamentoOnline> getListaTreinamentoOnline() {
        return listaTreinamentoOnline;
    }

    public void setListaTreinamentoOnline(List<TreinamentoOnline> listaTreinamentoOnline) {
        this.listaTreinamentoOnline = listaTreinamentoOnline;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
