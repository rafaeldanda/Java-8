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
@Table(name = "tblSistema")
@NamedQuery(name = "listaSistema", query = "select s from Sistema s")
public class Sistema implements Serializable {

    @Id
    @SequenceGenerator(name = "SEQ_SISTEMA", sequenceName = "SEQ_SISTEMA_INDEX", allocationSize = 1)
    @GeneratedValue(generator = "SEQ_SISTEMA", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(length = 50, nullable = true)
    private String nome;

    @Column
    private Boolean status;

    @OneToMany
    private List<PDA> listaPda;

    @ManyToMany
    @JoinTable(name = "pessoa_tblsistema",
            joinColumns = @JoinColumn(name = "listasistema_id"),
            inverseJoinColumns = @JoinColumn(name = "pessoa_id"))
    private List<PessoaJuridica> listaPessoa;

    @OneToMany
    private List<ItemTrabalho> listaItemTrabalho;

    public Sistema() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ItemTrabalho> getListaItemTrabalho() {
        return listaItemTrabalho;
    }

    public void setListaItemTrabalho(List<ItemTrabalho> listaItemTrabalho) {
        this.listaItemTrabalho = listaItemTrabalho;
    }

    public List<PDA> getListaPda() {
        return listaPda;
    }

    public void setListaPda(List<PDA> listaPda) {
        this.listaPda = listaPda;
    }

    public List<PessoaJuridica> getListaPessoa() {
        return listaPessoa;
    }

    public void setListaPessoa(List<PessoaJuridica> listaPessoa) {
        this.listaPessoa = listaPessoa;
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
