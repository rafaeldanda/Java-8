package br.suporte.beans;

import java.util.List;
import javax.persistence.*;


@Entity
@Table(name="tblPessoaFisica")
@NamedQueries({@NamedQuery(name="listaPessoas",query="select p from PessoaFisica p"),
               @NamedQuery(name="listaPessoasTipo",query="select p from PessoaFisica p where p.perfil.nome = 'Operador'")})
public class PessoaFisica extends Pessoa{

   
    @Column
    private String cpf;
    
    @OneToMany
    private List<PDA> listaPda;
    
       
    @ManyToMany(mappedBy = "listaPessoaFisica")
    private List<Emcominhamento> listaEncaminhamento; 
    
    @ManyToOne
    private PessoaJuridica pessoaJuridica;
    
    @OneToMany
    private List<RespostaPda> listaRespostaPda;
    
    public PessoaFisica() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Emcominhamento> getListaEncaminhamento() {
        return listaEncaminhamento;
    }

    public void setListaEncaminhamento(List<Emcominhamento> listaEncaminhamento) {
        this.listaEncaminhamento = listaEncaminhamento;
    }

    public List<PDA> getListaPda() {
        return listaPda;
    }

    public void setListaPda(List<PDA> listaPda) {
        this.listaPda = listaPda;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public List<RespostaPda> getListaRespostaPda() {
        return listaRespostaPda;
    }

    public void setListaRespostaPda(List<RespostaPda> listaRespostaPda) {
        this.listaRespostaPda = listaRespostaPda;
    }

	
}
