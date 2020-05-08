package sessao;

import br.suporte.beans.PessoaFisica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import permissao.PermissaoUsuario;
import persistencia.DownListas;
import util.Util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rafael
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private String login;
    private String senha;
    private List<PessoaFisica> listaPessoaFisica = new ArrayList<PessoaFisica>();
    private DownListas downLista = new DownListas();
    private FacesContext fc;
    private HttpSession session;
    private Util util = new Util();
    private PessoaFisica pessoa = new PessoaFisica();

    //------------------
    private Boolean meusPdas = false;
    private Boolean inicio = false;
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
    private Boolean pessoas = false;
    private Boolean pdaCliente = false;
    private Boolean treinamento = false;
    private Boolean aulas = false;
    private Boolean treinamentoLibras = false;
    private Boolean treinamentoDrivers = false;
    private Boolean treinamentoSuporte = false;

    public Login() {
    }

    public String log() {
        System.err.println("Log ------ Login do Systema");
        try {
            listaPessoaFisica.addAll(downLista.getListaPessoaFisica("listaPessoas"));

            for (int i = 0; i < listaPessoaFisica.size(); i++) {
                if (listaPessoaFisica.get(i).getLogin().equals(this.login) && listaPessoaFisica.get(i).getSenha().equals(this.senha)) {
                    fc = FacesContext.getCurrentInstance();
                    session = (HttpSession) fc.getExternalContext().getSession(false);
                    session.setAttribute("autenticacao", listaPessoaFisica.get(i));
                    pessoa = listaPessoaFisica.get(i);
                    this.setPermissao(pessoa.getPerfil().getNome());
                    FacesMessage msg = new FacesMessage("Login", "Seja Bem Vindo " + pessoa.getNome());
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                    System.err.println("Log ------ Login feito com sucesso!");
                    return "paginaInicial";
                }
            }
        } catch (Exception e) {
            System.err.println("Log ------ " + e.getMessage());
        }

        return "fail";
    }

    public String mataSesao() {
        util.mataSessao();

        return "sair";
    }

    private void setPermissao(String perfil) {
        if (perfil.equals("Operador")) {
            this.inicio = true;
            this.meusPdas = true;
            this.cadastros = false;
            this.pda = false;
            this.graficos = false;
            this.relatorios = false;
            this.estado = false;
            this.cidade = false;
            this.empresa = false;
            this.perfil = false;
            this.sistema = false;
            this.treinamentoLibras = true;
            this.treinamentoDrivers = true;
            this.treinamentoSuporte = true;
            this.treinamento = false;
            this.aulas = false;
        } else if (perfil.equals("Gerente")) {
            this.inicio = false;
            this.cadastros = true;
            this.estado = true;
            this.meusPdas = true;
            this.pda = false;
            this.cidade = true;
            this.pessoaFisica = true;
            this.empresa = true;
            this.perfil = true;
            this.sistema = true;
            this.graficos = true;
            this.relatorioCidade = true;
            this.telefone = true;
            this.pessoas = true;
            this.cadastros = true;
            this.relatorios = true;
            this.treinamentoLibras = true;
            this.treinamentoDrivers = true;
            this.treinamentoSuporte = true;
            this.treinamento = true;
            this.aulas = true;
        } else if (perfil.equals("Cliente")) {
            this.inicio = false;
            this.estado = false;
            this.meusPdas = false;
            this.pda = false;
            this.cidade = false;
            this.pessoaFisica = false;
            this.empresa = false;
            this.perfil = false;
            this.sistema = false;
            this.graficos = false;
            this.relatorioCidade = false;
            this.telefone = false;
            this.cadastros = true;
            this.relatorios = false;
            this.pdaCliente = true;
            this.treinamentoLibras = true;
            this.treinamentoDrivers = true;
            this.treinamentoSuporte = false;
            this.treinamento = false;
            this.aulas = false;
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public DownListas getDownLista() {
        return downLista;
    }

    public void setDownLista(DownListas downLista) {
        this.downLista = downLista;
    }

    public List<PessoaFisica> getListaPessoaFisica() {
        return listaPessoaFisica;
    }

    public void setListaPessoaFisica(List<PessoaFisica> listaPessoaFisica) {
        this.listaPessoaFisica = listaPessoaFisica;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public FacesContext getFc() {
        return fc;
    }

    public void setFc(FacesContext fc) {
        this.fc = fc;
    }

    public Boolean getGraficos() {
        return graficos;
    }

    public void setGraficos(Boolean graficos) {
        this.graficos = graficos;
    }

    public Boolean getInicio() {
        return inicio;
    }

    public void setInicio(Boolean inicio) {
        this.inicio = inicio;
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

    public PessoaFisica getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaFisica pessoa) {
        this.pessoa = pessoa;
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

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
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

    public Boolean getPessoas() {
        return pessoas;
    }

    public void setPessoas(Boolean pessoas) {
        this.pessoas = pessoas;
    }

    public Boolean getPdaCliente() {
        return pdaCliente;
    }

    public void setPdaCliente(Boolean pdaCliente) {
        this.pdaCliente = pdaCliente;
    }

    public Boolean getTreinamentoLibras() {
        return treinamentoLibras;
    }

    public void setTreinamentoLibras(Boolean treinamentoLibras) {
        this.treinamentoLibras = treinamentoLibras;
    }

    public Boolean getTreinamentoDrivers() {
        return treinamentoDrivers;
    }

    public void setTreinamentoDrivers(Boolean treinamentoDrivers) {
        this.treinamentoDrivers = treinamentoDrivers;
    }

    public Boolean getTreinamentoSuporte() {
        return treinamentoSuporte;
    }

    public void setTreinamentoSuporte(Boolean treinamentoSuporte) {
        this.treinamentoSuporte = treinamentoSuporte;
    }

    public Boolean getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(Boolean treinamento) {
        this.treinamento = treinamento;
    }

    public Boolean getAulas() {
        return aulas;
    }

    public void setAulas(Boolean aulas) {
        this.aulas = aulas;
    }

    
}
