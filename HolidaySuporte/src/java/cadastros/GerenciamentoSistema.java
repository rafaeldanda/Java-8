/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros;

import br.suporte.beans.Cidade;
import br.suporte.beans.Estado;
import br.suporte.beans.Sistema;
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
public class GerenciamentoSistema implements Serializable {

    private EntityManager em = conexao.conexao.getConexao();
    private Sistema sistema = new Sistema();
    private List<Object> listaSistema = new ArrayList<Object>();
    private DownCadastros downCadastro = new DownCadastros();
    private Sistema sistema2 = new Sistema();
    private Sistema sistemaAlteracao = new Sistema();
    private Boolean string = false;

    public GerenciamentoSistema() throws Exception {
        this.listar();
    }

    public void novo() throws Exception {
        this.sistema = new Sistema();
    }

    public void cadastrar() {

        /*
         * for(int cont = 0;cont < listaEstado.size();cont++){ estado2 =
         * (Estado) listaEstado.get(cont);
         * if(estado2.getNome().toUpperCase().equals(estado.getNome().toUpperCase())){
         * string = true; break; } } if(!string){
         * downCadastro.cadastrarAlterar(estado); this.listar(); string = false;
         *
         * FacesMessage msg = new FacesMessage("Cadastro", "Cadastrado com
         * sucesso."); FacesContext.getCurrentInstance().addMessage(null, msg);
         * }else{ FacesMessage msg = new FacesMessage("Atenção", "Já existe esse
         * cadastro."); FacesContext.getCurrentInstance().addMessage(null, msg);
         * }
         *
         *
         */
        System.err.println("Log ----- Cadastro Sistema");
        try {
            if (!this.sistema.getStatus().equals("") && !this.sistema.getNome().equals("")) {
                downCadastro.cadastrarAlterar(sistema);
                this.listar();
                this.novo();
                FacesMessage msg = new FacesMessage("Aviso:", "Cadastro Atualizado!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                System.err.println("Log ----- Cadastro Realizado com sucesso!");
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso:", "O campo Nome é obrigatório!"));
            }
        } catch (Exception e) {
            System.err.println("Log ----- " + e.getMessage());
        }

    }

    public void listar() throws Exception {
        this.listaSistema.clear();
        this.listaSistema.addAll(downCadastro.listar("listaSistema"));
    }

    public void altera(Sistema sistema) {
        this.sistemaAlteracao = sistema;
        this.sistema = sistema;

    }

    public void excluir(Sistema sistema) {
        System.err.println("Log ----- exclusão");
        try {
            downCadastro.desativarAtivar(sistema);
            this.listar();

            FacesMessage msg = new FacesMessage("Exclusão", "Cadastro excluído com sucesso.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            System.err.println("Log ----- " + e.getMessage());
        }

        
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

    public List<Object> getListaSistema() {
        return listaSistema;
    }

    public void setListaSistema(List<Object> listaSistema) {
        this.listaSistema = listaSistema;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public Sistema getSistema2() {
        return sistema2;
    }

    public void setSistema2(Sistema sistema2) {
        this.sistema2 = sistema2;
    }

    public Sistema getSistemaAlteracao() {
        return sistemaAlteracao;
    }

    public void setSistemaAlteracao(Sistema sistemaAlteracao) {
        this.sistemaAlteracao = sistemaAlteracao;
    }

    public Boolean getString() {
        return string;
    }

    public void setString(Boolean string) {
        this.string = string;
    }
}
