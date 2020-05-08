/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros;

import br.suporte.beans.Estado;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import persistencia.DownCadastros;

/**
 *
 * @author Rafael
 */
@ViewScoped
@ManagedBean
public class GerenciamentoEstado implements Serializable {

    private EntityManager em = conexao.conexao.getConexao();
    private Estado estado = new Estado();
    private List<Object> listaEstado = new ArrayList<Object>();
    private DownCadastros downCadastro = new DownCadastros();
    private Estado estado2 = new Estado();
    private Estado estadoAlteracao = new Estado();
    private boolean b = true;

    public GerenciamentoEstado() throws Exception {
        this.listar();
    }

    public void novo() throws Exception {
        this.estado = null;
        this.estado = new Estado();
    }

    public void cadastrar(ActionEvent actionEvent) throws Exception {

        if (this.estado.getNome() != null && this.estado.getSigla() != null) {

            for (Object varEstado : listaEstado) {
                estado2 = (Estado) varEstado;
               
                if (estado.getNome().toUpperCase().trim().equals(estado2.getNome().toUpperCase().trim()) && estado.getSigla().toUpperCase().equals(estado2.getSigla().toUpperCase())) {
                    b = false;
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso:", "Cadastro já existente."));
                    break;
                }
            }
            if (b) {
                b = true;
                downCadastro.cadastrarAlterar(estado);
                this.listar();
                this.novo();
                FacesMessage msg = new FacesMessage("Aviso:", "Cadastro Atualizado!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }


        } else {
            this.listar();
            this.novo();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso:", "Os campos Nome e Sigla são obrigatórios!"));
        }

    }

    public void listar() throws Exception {
        this.listaEstado.clear();
        this.listaEstado.addAll(downCadastro.listar("listaEstados"));


        //return "/cadastros/estado/cadastroEstado";
    }

    public void altera(Estado estado) {
        this.estado = estado;
    }

    public String excluir(Estado estado) throws Exception {
        downCadastro.desativarAtivar(estado);
        this.listar();

        FacesMessage msg = new FacesMessage("Exclusão", "Cadastro excluído com sucesso.");
        

        return "/cadastros/estado/cadastroEstado";
    }

    //-----------------------------
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Object> getListaEstado() {
        return listaEstado;
    }

    public void setListaEstado(List<Object> listaEstado) {
        this.listaEstado = listaEstado;
    }

    public Estado getEstadoAlteracao() {
        return estadoAlteracao;
    }

    public void setEstadoAlteracao(Estado estadoAlteracao) {
        this.estadoAlteracao = estadoAlteracao;
    }
}
