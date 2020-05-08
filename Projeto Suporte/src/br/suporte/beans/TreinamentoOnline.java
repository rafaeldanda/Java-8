/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.suporte.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name="tblTreinamentoOnline")
@NamedQueries({@NamedQuery(name="listaTreinamentoOnline",query="select e from TreinamentoOnline e")})
public class TreinamentoOnline implements Serializable{
    
    @Id
    @SequenceGenerator(name="SEQ_TREINAMENTOONLINE",sequenceName="SEQ_TREINAMENTOONLINE_INDEX",allocationSize=1)
    @GeneratedValue(generator="SEQ_TREINAMENTOONLINE", strategy= GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(length=50, nullable=true)
    private String titulo;
    
    @Column(nullable=true)
    private String descricao;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Calendar todalHoras;
    
    @Column
    private String status;
    
    @Column(length=50, nullable=true)
    private String arquivo;
    
    
    @ManyToMany(mappedBy = "listaTreinamentoOnline")
    private List<VideoAula> listaVideoAula;

    public TreinamentoOnline() {
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
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

    public List<VideoAula> getListaVideoAula() {
        return listaVideoAula;
    }

    public void setListaVideoAula(List<VideoAula> listaVideoAula) {
        this.listaVideoAula = listaVideoAula;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Calendar getTodalHoras() {
        return todalHoras;
    }

    public void setTodalHoras(Calendar todalHoras) {
        this.todalHoras = todalHoras;
    }
    
    
                    
}
