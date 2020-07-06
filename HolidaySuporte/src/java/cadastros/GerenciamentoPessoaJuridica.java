/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros;

import br.suporte.beans.Cidade;
import br.suporte.beans.PessoaJuridica;
import br.suporte.beans.Sistema;
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
public class GerenciamentoPessoaJuridica implements Serializable {

    private EntityManager em = conexao.conexao.getConexao();
    private PessoaJuridica pessoaJuridica = new PessoaJuridica();
    private List<Object> listaPessoaJuridica = new ArrayList<Object>();
    private DownCadastros downCadastro = new DownCadastros();
    private PessoaJuridica pessoaJuridicaAlteracao = new PessoaJuridica();
    private PessoaJuridica empresa = new PessoaJuridica();
    private boolean b = true;
    private Boolean string = false;
    private Cidade cidade = new Cidade();
    private Sistema sistema = new Sistema();
    private List<Sistema> listaSistema = new ArrayList<Sistema>();
    private Util util = new Util();

    public GerenciamentoPessoaJuridica() throws Exception {
        this.listar();
    }

    public void novo() throws Exception {
        this.pessoaJuridica = null;
        this.pessoaJuridica = new PessoaJuridica();
        this.cidade = null;
        this.cidade = new Cidade();
        this.listaSistema.clear();
    }

    public void addSistema() throws Exception {
        listaSistema.add(this.buscaSistema(this.sistema));
    }

    public void removeSistema(Sistema sistema) {
        listaSistema.remove(sistema);

    }

    public Sistema buscaSistema(Sistema sistema) throws Exception {
        return (Sistema) downCadastro.buscar(sistema, sistema.getId());
    }

    public Cidade buscaCidade(Cidade cidade) throws Exception {
        return (Cidade) downCadastro.buscar(cidade, cidade.getId());
    }

    public void cadastrar() {
        System.err.println("Log ------ Cadastrar Pessoa Juridica");

        try {
            pessoaJuridica.setCidade(cidade);
            pessoaJuridica.setListaSistema(listaSistema);

            if (pessoaJuridica.getId() == null) {
                for (Object empresa2 : listaPessoaJuridica) {
                    empresa = (PessoaJuridica) empresa2;
                    if (empresa.getCnpj().equals(this.pessoaJuridica.getCnpj())) {
                        b = false;
                        System.err.println("Log ------ CNPJ já cadastrado!");
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso:", "CNPJ já cadastrado!"));
                        break;
                    }

                }
            }

            if (b) {
                if (this.pessoaJuridica.getNomeFantasia() != "" && this.pessoaJuridica.getCnpj() != "" && this.pessoaJuridica.getCidade().getId() != 0) {
                    if (util.validaCNPJ(pessoaJuridica.getCnpj())) {
                        downCadastro.cadastrarAlterar(pessoaJuridica);
                        FacesMessage msg = new FacesMessage("Aviso:", "Cadastro Atualizado!");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                        System.err.println("Log ------ Cadastrado com Sucesso!");
                    }
                    this.listar();
                    this.novo();
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso:", "Os campos Nome Fantasia, Cnpj, Cidade são obrigatórios!"));

                }
            } else {
                b = true;
            }
        } catch (Exception e) {
            System.err.println("Log ------ " + e.getMessage());
        }

    }

    public void listar() throws Exception {
        this.listaPessoaJuridica.clear();
        this.listaPessoaJuridica.addAll(downCadastro.listar("listaPessoaJuridica"));

    }

    public void altera(PessoaJuridica pessoaJuridica) throws Exception {
        this.listaSistema.clear();
        this.listaSistema.addAll(pessoaJuridica.getListaSistema());
        this.pessoaJuridica = pessoaJuridica;
        this.cidade = pessoaJuridica.getCidade();
    }

    public String excluir(PessoaJuridica pessoaJuridica) {
        System.err.println("Log ------ Excluir pessoa juridica");
        try {
            downCadastro.desativarAtivar(pessoaJuridica);
            this.listar();

            FacesMessage msg = new FacesMessage("Exclusão", "Cadastro excluído com sucesso.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            System.err.println("Log ------ Pessoa Juridica excluida com sucesso!");
        } catch (Exception e) {
            System.err.println("Log ------ " + e.getMessage());
        }

        return "/cadastros/pessoaJuridica/cadastroPessoaJuridica";
    }

    public String wizard(FlowEvent event) {
        return event.getNewStep();
    }

    // --------------------------------------------
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

    public List<Object> getListaPessoaJuridica() {
        return listaPessoaJuridica;
    }

    public void setListaPessoaJuridica(List<Object> listaPessoaJuridica) {
        this.listaPessoaJuridica = listaPessoaJuridica;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public PessoaJuridica getPessoaJuridicaAlteracao() {
        return pessoaJuridicaAlteracao;
    }

    public void setPessoaJuridicaAlteracao(PessoaJuridica pessoaJuridicaAlteracao) {
        this.pessoaJuridicaAlteracao = pessoaJuridicaAlteracao;
    }

    public Boolean getString() {
        return string;
    }

    public void setString(Boolean string) {
        this.string = string;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public List<Sistema> getListaSistema() {
        return listaSistema;
    }

    public void setListaSistema(List<Sistema> listaSistema) {
        this.listaSistema = listaSistema;
    }
}
