package br.suporte.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
@Entity
@Table(name="tblPda")
@NamedQueries({@NamedQuery(name="listaPDA",query="select p from PDA p"),
               @NamedQuery(name="listaPDA2",query="select p from PDA p where p.pessoa.id = :id order by p.id"),
               @NamedQuery(name="listaMeuPDA",query="select p from PDA p where p.dono.id = :id order by p.id"),
               @NamedQuery(name="listaPDAInicio",query="select p from PDA p where p.status = true and p.dono IS null order by p.id")})
public class PDA implements Serializable{

    @Id
    @SequenceGenerator(name="SEQ_PDA",sequenceName="SEQ_PDA_INDEX",allocationSize=1)
    @GeneratedValue(generator="SEQ_PDA", strategy= GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(length=50, nullable=true)
    private String titulo;
    
    @ManyToOne
    private Sistema sistema;
    
    @Column(nullable=true)
    private String descricao;
    
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    
    @Column(length=2,nullable=true)
    private Boolean status;
    
    @Column(nullable=false)
    private float nota;
    
    @Column
    private String sugestao;
    
    @ManyToOne
    private PessoaFisica dono;
    
    @ManyToOne
    private PessoaFisica pessoa;
    
    @OneToMany
    private List<ItemTrabalho> listaItemTrabalho;
    
    @OneToMany
    private List<RespostaPda> listaRespostaPda;
    
    @Transient
    private String ativoCliente;
    
    @Transient
    private String ativoGerente;
    
    @Transient
    private String ativoInicio;
    
    @Transient
    private String operador;
    
    @Transient
    private String ver;
    
    @Transient
    private String ver2;
    
    @Transient
    private String msnAtivo;
    
    @Transient
    private String msnOperador;
    
   
    public PDA() {
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
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

    public List<ItemTrabalho> getListaItemTrabalho() {
        return listaItemTrabalho;
    }

    public void setListaItemTrabalho(List<ItemTrabalho> listaItemTrabalho) {
        this.listaItemTrabalho = listaItemTrabalho;
    }

    public PessoaFisica getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaFisica pessoa) {
        this.pessoa = pessoa;
    }


    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getSugestao() {
        return sugestao;
    }

    public void setSugestao(String sugestao) {
        this.sugestao = sugestao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public PessoaFisica getDono() {
        return dono;
    }

    public void setDono(PessoaFisica dono) {
        this.dono = dono;
    }

    public String getAtivoCliente() {
        if(this.status == true){
            this.ativoCliente = "..\\..\\imagens\\status\\rejeitado.png";
        } else {
             this.ativoCliente = "..\\..\\imagens\\status\\autorizado.png";
        }
        return ativoCliente;
    }

    public void setAtivoCliente(String ativoCliente) {
        this.ativoCliente = ativoCliente;
    }

    public String getOperador() {
        if(this.dono == null){
            this.operador = "Aguardando Atendimento.";
        } else {
             this.operador = dono.getNome();
        }
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getMsnAtivo() {
        if(this.status == true){
            this.msnAtivo = "Ativo";
        } else {
             this.msnAtivo = "Finalizado";
        }
        return msnAtivo;
    }

    public void setMsnAtivo(String msnAtivo) {
        this.msnAtivo = msnAtivo;
    }

    public String getAtivoGerente() {
        if(this.status == true){
            this.ativoGerente = "..\\..\\..\\imagens\\status\\rejeitado.png";
        } else {
             this.ativoGerente = "..\\..\\..\\imagens\\status\\autorizado.png";
        }
        return ativoGerente;
    }

    public void setAtivoGerente(String ativoGerente) {
        this.ativoGerente = ativoGerente;
    }

    public String getMsnOperador() {
        return msnOperador;
    }

    public void setMsnOperador(String msnOperador) {
        this.msnOperador = msnOperador;
    }

    public List<RespostaPda> getListaRespostaPda() {
        return listaRespostaPda;
    }

    public void setListaRespostaPda(List<RespostaPda> listaRespostaPda) {
        this.listaRespostaPda = listaRespostaPda;
    }

    public String getVer() {
        return "imagens\\status\\log.png";
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getVer2() {
        return "..\\..\\..\\imagens\\status\\log.png";
    }

    public void setVer2(String ver2) {
        this.ver2 = ver2;
    }

    public String getAtivoInicio() {
        if(this.status == true){ 
            this.ativoInicio = "imagens\\status\\rejeitado.png";
        } else {
             this.ativoInicio = "imagens\\status\\autorizado.png";
        }
        return ativoInicio;
    }

    public void setAtivoInicio(String ativoInicio) {
        this.ativoInicio = ativoInicio;
    }
    
    

    
    
}
