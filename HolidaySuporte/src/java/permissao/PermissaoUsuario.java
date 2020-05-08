/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package permissao;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Rafael
 */
@ManagedBean
@SessionScoped
public class PermissaoUsuario implements Serializable{
    
    private Boolean meusPdas = false;
    private Boolean inicio = true;
    private Boolean pda = false;
    private Boolean cidade = false;
    private Boolean estado = false;
    private Boolean pessoaFisica = false;
    private Boolean empresa = false;
    private Boolean perfil = false;
    private Boolean sistema = false;
    private Boolean graficos = false;
    private Boolean relatorioCidade = false;
    private Boolean telefone = false;
    private Boolean cadastros = false;
    private Boolean relatorios = false;
   

    public PermissaoUsuario() {
    }

    public Boolean getInicio() {
        return inicio;
    }

    public void setInicio(Boolean inicio) {
        this.inicio = inicio;
    }

    public Boolean getCadastros() {
        return cadastros;
    }

    public void setCadastros(Boolean cadastros) {
        this.cadastros = cadastros;
    }

    public Boolean getCidade() {
        return cidade;
    }

    public void setCidade(Boolean cidade) {
        this.cidade = cidade;
    }

    public Boolean getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Boolean empresa) {
        this.empresa = empresa;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getGraficos() {
        return graficos;
    }

    public void setGraficos(Boolean graficos) {
        this.graficos = graficos;
    }

    public Boolean getMeusPdas() {
        return meusPdas;
    }

    public void setMeusPdas(Boolean meusPdas) {
        this.meusPdas = meusPdas;
    }

    public Boolean getPda() {
        return pda;
    }

    public void setPda(Boolean pda) {
        this.pda = pda;
    }

    public Boolean getPerfil() {
        return perfil;
    }

    public void setPerfil(Boolean perfil) {
        this.perfil = perfil;
    }

    public Boolean getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(Boolean pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public Boolean getRelatorioCidade() {
        return relatorioCidade;
    }

    public void setRelatorioCidade(Boolean relatorioCidade) {
        this.relatorioCidade = relatorioCidade;
    }

    public Boolean getRelatorios() {
        return relatorios;
    }

    public void setRelatorios(Boolean relatorios) {
        this.relatorios = relatorios;
    }

    public Boolean getSistema() {
        return sistema;
    }

    public void setSistema(Boolean sistema) {
        this.sistema = sistema;
    }

    public Boolean getTelefone() {
        return telefone;
    }

    public void setTelefone(Boolean telefone) {
        this.telefone = telefone;
    }

    
}
