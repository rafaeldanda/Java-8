package br.suporte.beans;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tblPessoaJuridica")
@NamedQueries({@NamedQuery(name="listaPessoaJuridica",query="select p from PessoaJuridica p"),
               @NamedQuery(name="buscaPessoaRegiao",query="select p from PessoaJuridica p where p.cidade.estado.sigla = :nome")})
public class PessoaJuridica extends Pessoa{

    
    @Column
    private String cnpj;
    
    @Column
    private String nomeFantasia;
    
    @Column
    private String ie;
       
    @ManyToMany(mappedBy = "listaPessoa")
    private List<Sistema> listaSistema;
    
    @OneToMany
    private List<PessoaFisica> listaPessoaFisica;
    
    public PessoaJuridica() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public List<PessoaFisica> getListaPessoaFisica() {
        return listaPessoaFisica;
    }

    public void setListaPessoaFisica(List<PessoaFisica> listaPessoaFisica) {
        this.listaPessoaFisica = listaPessoaFisica;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    
}
