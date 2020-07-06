/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros;

import br.suporte.beans.TreinamentoOnline;
import br.suporte.beans.VideoAula;
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
public class GerenciamentoAulas {

    private EntityManager em = conexao.conexao.getConexao();
    private VideoAula aulas = new VideoAula();
    private List<Object> listaVideoAula = new ArrayList<Object>();
    private List<TreinamentoOnline> listaTreinamentoOnlines = new ArrayList<TreinamentoOnline>();
    private DownCadastros downCadastro = new DownCadastros();
    private TreinamentoOnline treinamentoOnline = new TreinamentoOnline();

    public GerenciamentoAulas() throws Exception {
        this.listar();
    }

    public void novo() throws Exception {
        this.aulas = null;
        this.treinamentoOnline = null;
        this.aulas = new VideoAula();
        this.treinamentoOnline = new TreinamentoOnline();
    }

    public void cadastrar(ActionEvent actionEvent) {
        System.err.println("Log ----- Cadastro aulas");
        try {
            if (!aulas.getNome().equals("") && !aulas.getStatus().equals("") && !aulas.getCaminho().equals("")) {
                listaTreinamentoOnlines.add(treinamentoOnline);
                aulas.setListaTreinamentoOnline(listaTreinamentoOnlines);
                downCadastro.cadastrarAlterar(aulas);
                this.listar();
                this.novo();
                FacesMessage msg = new FacesMessage("Aviso:", "Cadastro Atualizado!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                System.err.println("Log ----- Cadastro aulas realizado com sucesso!");
            } else {
                FacesMessage msg = new FacesMessage("Aviso:", "Campo nome, Status e Caminho Obrigatorio!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        } catch (Exception e) {
            System.err.println("Log ----- " + e.getMessage());
        }

    }

    public void listar() throws Exception {
        this.listaVideoAula.clear();
        this.listaVideoAula.addAll(downCadastro.listar("listaAulas"));
    }

    public void altera(VideoAula aulas) {
        this.aulas = aulas;
    }

    public String excluir(VideoAula aulas) throws Exception {
        downCadastro.desativarAtivar(aulas);
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

    public VideoAula getAulas() {
        return aulas;
    }

    public void setAulas(VideoAula aulas) {
        this.aulas = aulas;
    }

    public List<Object> getListaVideoAula() {
        return listaVideoAula;
    }

    public void setListaVideoAula(List<Object> listaVideoAula) {
        this.listaVideoAula = listaVideoAula;
    }

    public TreinamentoOnline getTreinamentoOnline() {
        return treinamentoOnline;
    }

    public void setTreinamentoOnline(TreinamentoOnline treinamentoOnline) {
        this.treinamentoOnline = treinamentoOnline;
    }

}
