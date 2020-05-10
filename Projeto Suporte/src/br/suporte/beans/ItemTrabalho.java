/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.suporte.beans;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name="tblItemTrabalho")
@XmlRootElement
public class ItemTrabalho implements Serializable{
    
    @Id
    @SequenceGenerator(name="SEQ_ITEMTRABALHO",sequenceName="SEQ_ITEMTRABALHO_INDEX",allocationSize=1)
    @GeneratedValue(generator="SEQ_ITEMTRABALHO", strategy= GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(length=50)
    private String titulo;
    
    @Column(length=50)
    private String descricao;
    
    @Column(length=50)
    private String Status;
    
    @Column(length=50)
    private String print;
    
    @Column(length=50)
    private String autor;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Calendar dataPrevista;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Calendar dataEntrada;
    
    @Column(length=50)
    private String proprietario;
   
    @ManyToOne
    private Sistema sistema;
    
    @ManyToOne
    private PDA pda;

    public ItemTrabalho() {
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Calendar getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Calendar dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Calendar getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Calendar dataPrevista) {
        this.dataPrevista = dataPrevista;
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

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
