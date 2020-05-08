/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros;

import br.suporte.beans.Cidade;
import br.suporte.beans.Perfil;
import br.suporte.beans.PessoaFisica;
import br.suporte.beans.PessoaJuridica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import org.primefaces.event.FlowEvent;
import persistencia.DownCadastros;
import util.Util;

/**
 *
 * @author Rafael
 */
@ViewScoped
@ManagedBean
public class GerenciamentoPessoaFisica implements Serializable {

    private EntityManager em = conexao.conexao.getConexao();
    private PessoaFisica pessoaFisica = new PessoaFisica();
    private List<Object> listaPessoaFisica = new ArrayList<Object>();
    private DownCadastros downCadastro = new DownCadastros();
    private PessoaFisica pessoaFisicaAlteracao = new PessoaFisica();
    private PessoaJuridica pessoaJuridica = new PessoaJuridica();
    private PessoaJuridica pessoaJuridicaAlteracao = new PessoaJuridica();
    private Boolean string = false;
    private boolean b = true;
    private PessoaFisica pessoa = new PessoaFisica();
    private Perfil perfil = new Perfil();
    private Perfil perfilAlteracao = new Perfil();
    private Util util = new Util();
    private Cidade cidade = new Cidade();

    public GerenciamentoPessoaFisica() throws Exception {
        this.listar();
    }

    public void novo() throws Exception {
        this.pessoaFisica = new PessoaFisica();
        this.pessoaFisicaAlteracao = new PessoaFisica();
        this.perfilAlteracao = new Perfil();
        this.pessoaJuridicaAlteracao = new PessoaJuridica();
    }

    public PessoaJuridica buscaEmpresa(PessoaJuridica pessoa) throws Exception {
        return (PessoaJuridica) downCadastro.buscar(pessoa, pessoa.getId());
    }

    public Perfil buscaPerfil(Perfil perfil) throws Exception {
        return (Perfil) downCadastro.buscar(perfil, perfil.getId());

    }

    public void cadastrar() {

        System.err.println("Log ------ Cadastrar Pessoa Fisica");

        try {//verifica se pessoa já cadastrada e se cpf já esta cadastrado
            for (Object pessoa : listaPessoaFisica) {
                this.pessoa = (PessoaFisica) pessoa;
                if (pessoaJuridica.getId() == null) {
                    if (this.pessoa.getCpf().equals(pessoaFisica.getCpf())) {
                        System.err.println("Log ------ CPF já cadastrado!");
                        b = false;
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso:", "CPF já cadastrado!"));
                        break;
                    }
                }
            }
            if (b) {//verifica campos obrigatorios e cadastra usuário
                if (this.pessoaFisica.getCpf() != "" && this.pessoaFisica.getNome() != "" && this.pessoaFisica.getLogin() != ""
                        && this.pessoaFisica.getSenha() != "") {
                    this.pessoaFisica.setCidade(this.cidade);
                    pessoaFisica.setPessoaJuridica(pessoaJuridica);
                    pessoaFisica.setPerfil(perfil);
                    if (util.validaCpf(pessoaFisica.getCpf())) {
                        FacesMessage msg = new FacesMessage("Aviso:", "Cadastro Atualizado!");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                        downCadastro.cadastrarAlterar(pessoaFisica);
                        System.err.println("Log ------ Cadastro Atualizado com sucesso!");
                    }
                    this.listar();
                    this.novo();
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso:", "Os campos Nome, Cpf, Login e Senha são Obrigatórios!"));
                }
            } else {
                b = true;
            }
        } catch (Exception e) {
            System.err.println("Log ------ " + e.getMessage());
        }

    }

    public void listar() throws Exception {
        this.listaPessoaFisica.clear();
        this.listaPessoaFisica.addAll(downCadastro.listar("listaPessoas"));

    }

    public void altera(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public void excluir(PessoaFisica pessoaFisica) {
        try {
            System.out.println("Log ---- Excluir");
            downCadastro.desativarAtivar(pessoaFisica);
            this.listar();

            FacesMessage msg = new FacesMessage("Exclusão", "Cadastro excluido com sucesso.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            System.out.println("Log ---- Excluido com sucesso!");
        } catch (Exception e) {
            System.out.println("Log ---- "+e.getMessage());
        }

        //return "/cadastros/pessoaFisica/cadastroPessoaFisica";
    }

    public String wizard(FlowEvent event) {
        return event.getNewStep();
    }

    // --------------------------------------------
    public PessoaFisica getPessoaFisicaAlteracao() {
        return pessoaFisicaAlteracao;
    }

    public void setPessoaFisicaAlteracao(PessoaFisica pessoaFisicaAlteracao) {
        this.pessoaFisicaAlteracao = pessoaFisicaAlteracao;
    }

    public DownCadastros getDownCadastro() {
        return downCadastro;
    }

    public void setDownCadastro(DownCadastros downCadastro) {
        this.downCadastro = downCadastro;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Object> getListaPessoaFisica() {
        return listaPessoaFisica;
    }

    public void setListaPessoaFisica(List<Object> listaPessoaFisica) {
        this.listaPessoaFisica = listaPessoaFisica;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Perfil getPerfilAlteracao() {
        return perfilAlteracao;
    }

    public void setPerfilAlteracao(Perfil perfilAlteracao) {
        this.perfilAlteracao = perfilAlteracao;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public Boolean getString() {
        return string;
    }

    public void setString(Boolean string) {
        this.string = string;
    }

    public PessoaJuridica getPessoaJuridicaAlteracao() {
        return pessoaJuridicaAlteracao;
    }

    public void setPessoaJuridicaAlteracao(PessoaJuridica pessoaJuridicaAlteracao) {
        this.pessoaJuridicaAlteracao = pessoaJuridicaAlteracao;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
