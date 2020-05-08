package br.suporte.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="id_pessoa")
public class Pessoa implements Serializable{

    @Id
    @SequenceGenerator(name="SEQ_PESSOA",sequenceName="SEQ_PESSOA_INDEX",allocationSize=1)
    @GeneratedValue(generator="SEQ_PESSOA", strategy= GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(length=50)
    private String nome;
    
    @Column(length=50)
    private String email;
    
    @Column(length=10)
    private String login;
    
    @Column(length=10)
    private String senha;
    
    @Temporal(TemporalType.DATE)
    @Column
    private Calendar dataNascimento;
    
    @Column(length=2)
    private Boolean status;
    
    @Column
    private String conexao;

    @ManyToOne
    private Cidade cidade;
    
    @ManyToOne
    private Perfil perfil;
        
    @OneToMany
    private List<Telefone> listaTelefone;

    @ManyToMany
    private List<Sistema> listaSistema;
        
    public Pessoa() {
    }

    

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    

    public String getConexao() {
        return conexao;
    }

    public void setConexao(String conexao) {
        this.conexao = conexao;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Sistema> getListaSistema() {
        return listaSistema;
    }

    public void setListaSistema(List<Sistema> listaSistema) {
        this.listaSistema = listaSistema;
    }

    public List<Telefone> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(List<Telefone> listaTelefone) {
        this.listaTelefone = listaTelefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    
	
	
}
