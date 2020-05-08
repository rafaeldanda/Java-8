/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros;

import br.suporte.beans.Cidade;
import br.suporte.beans.Estado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import persistencia.DownCadastros;

/**
 *
 * @author Rafael
 */
@ViewScoped
@ManagedBean
public class GerenciamentoCidade implements Serializable {

    private Cidade cidade = new Cidade();
    private List<Object> listaCidade = new ArrayList<Object>();
    private DownCadastros downCadastro = new DownCadastros();
    private Estado estado = new Estado();
    private Cidade cidade2 = new Cidade();
    private boolean b = true;
    private Cidade cidadeAlteracao = new Cidade();
    private Boolean string = false;

    public GerenciamentoCidade() throws Exception {
        this.listar();
    }

    public void novo() throws Exception {
        this.cidade = null;
        this.cidade = new Cidade();
        this.estado = null;
        this.estado = new Estado();
    }

    public String cadastrar() {
        System.err.println("Log ------ Cadastro Cidade");
        try {
            if (this.cidade.getNome() != "" && this.cidade.getEstado().getId() != null) {

                for (Object cidade : listaCidade) {
                    cidade2 = (Cidade) cidade;
                    if (cidade2.getNome().toUpperCase().trim().equals(this.cidade.getNome().toUpperCase().trim())) {
                        b = false;
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso:", "Cadastro já existente!"));
                        System.err.println("Log ------ Cadastrado já existente!");
                        break;
                    }
                }

                if (b) {
                    downCadastro.cadastrarAlterar(cidade);
                    this.listar();
                    this.novo();
                    //FacesMessage msg = new FacesMessage("Aviso:", "Cadastro Atualizado!");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso:", "Cadastro Atualizado!"));
                    System.err.println("Log ------ Cadastrado com sucesso!");
                } else {
                    b = true;
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso:", "Os campos Nome e Estado são obrigatórios!"));
            }
        } catch (Exception e) {
            System.err.println("Log ------ " + e.getMessage());
        }

        return "/cadastros/cidade/cadastroCidade";
    }

    public void listar() throws Exception {
        this.listaCidade.clear();
        this.listaCidade.addAll(downCadastro.listar("listaCidades"));

    }

    public void altera(Cidade cidade) {
        this.cidade = cidade;
    }

    public String excluir(Cidade cidade) throws Exception {

        downCadastro.desativarAtivar(cidade);
        this.listar();

        FacesMessage msg = new FacesMessage("Exclusão", "Cadastro excluído com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        return "/cadastros/cidade/cadastroCidade";
    }

    public String buscaCidade(Cidade cidade) throws Exception {
        cidade = (Cidade) downCadastro.buscar(cidade, cidade.getId());
        return cidade.getNome();
    }

    //-----------------------------
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade getCidadeAlteracao() {
        return cidadeAlteracao;
    }

    public void setCidadeAlteracao(Cidade cidadeAlteracao) {
        this.cidadeAlteracao = cidadeAlteracao;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public DownCadastros getDownCadastro() {
        return downCadastro;
    }

    public void setDownCadastro(DownCadastros downCadastro) {
        this.downCadastro = downCadastro;
    }

    public List<Object> getListaCidade() {
        return listaCidade;
    }

    public void setListaCidade(List<Object> listaCidade) {
        this.listaCidade = listaCidade;
    }

    public Boolean getString() {
        return string;
    }

    public void setString(Boolean string) {
        this.string = string;
    }
}
