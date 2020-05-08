/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros;

import br.suporte.beans.Estado;
import br.suporte.beans.TreinamentoOnline;
import java.awt.event.ActionEvent;
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
 * @author rafael
 */
@ViewScoped
@ManagedBean
public class GerenciamentoTreinamento {

    private EntityManager em = conexao.conexao.getConexao();
    private TreinamentoOnline treinamentoOnline = new TreinamentoOnline();
    private List<Object> listaTreinamentoOnline = new ArrayList<Object>();
    private DownCadastros downCadastro = new DownCadastros();

    public GerenciamentoTreinamento() throws Exception {
        this.listar();
    }

    public void novo() throws Exception {
        this.treinamentoOnline = null;
        this.treinamentoOnline = new TreinamentoOnline();
    }

    public String cadastrar(ActionEvent actionEvent) {
        System.err.println("Log ----- Cadastro Treinamento Online");
        try {
            if (!treinamentoOnline.getTitulo().equals("") && !treinamentoOnline.getStatus().equals("")){
                downCadastro.cadastrarAlterar(treinamentoOnline);
                this.listar();
                this.novo();
                FacesMessage msg = new FacesMessage("Aviso:", "Cadastro Atualizado!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                System.err.println("Log ----- Cadastro Treinamento Online realizado com sucesso!");
            } else {
                FacesMessage msg = new FacesMessage("Aviso:", "Campo Titulo e Status Obrigatorio!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        } catch (Exception e) {
            System.err.println("Log ----- " + e.getMessage());
        }
        return "/cadastros/treinamento/cadastroTreinamento";
    }

    public void listar() throws Exception {
        this.listaTreinamentoOnline.clear();
        this.listaTreinamentoOnline.addAll(downCadastro.listar("listaTreinamentoOnline"));
    }

    public void altera(TreinamentoOnline treinamentoOnline) {
        this.treinamentoOnline = treinamentoOnline;
    }

    public String excluir(TreinamentoOnline treinamentoOnline) throws Exception {
        downCadastro.desativarAtivar(treinamentoOnline);
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

    public TreinamentoOnline getTreinamentoOnline() {
        return treinamentoOnline;
    }

    public void setTreinamentoOnline(TreinamentoOnline treinamentoOnline) {
        this.treinamentoOnline = treinamentoOnline;
    }

    public List<Object> getListaTreinamentoOnline() {
        return listaTreinamentoOnline;
    }

    public void setListaTreinamentoOnline(List<Object> listaTreinamentoOnline) {
        this.listaTreinamentoOnline = listaTreinamentoOnline;
    }

}
