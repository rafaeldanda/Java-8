/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros;

import br.suporte.beans.Perfil;
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
public class GerenciamentoPerfil implements Serializable {

    private EntityManager em = conexao.conexao.getConexao();
    private Perfil perfil = new Perfil();
    private List<Object> listaPerfil = new ArrayList<Object>();
    private DownCadastros downCadastro = new DownCadastros();
    private Perfil perfil2 = new Perfil();
    private Perfil perfilAlteracao = new Perfil();
    private Boolean string = false;

    public GerenciamentoPerfil() throws Exception {
        this.listar();
    }

    public void novo() throws Exception {
        this.perfil = new Perfil();
        //return "/cadastros/perfil/cadastroPerfil";
    }

    public String cadastrar() {
        System.err.println("Log ------ Cadastro Perfil");
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
        try {
            if (!perfil.getNome().equals("")) {
                downCadastro.cadastrarAlterar(perfil);
                this.listar();
                this.novo();
                FacesMessage msg = new FacesMessage("Aviso!", "Cadastro realizado com Sucesso!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                FacesMessage msg = new FacesMessage("Aviso!", "Campo nome é Obrigatorio!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } catch (Exception e) {
            System.err.println("Log ------ " + e.getMessage());
        }

        return "/cadastros/perfil/cadastroPerfil";
    }

    public void listar() throws Exception {
        this.listaPerfil.clear();
        this.listaPerfil.addAll(downCadastro.listar("listaPerfil"));

        //return "/cadastros/perfil/cadastroPerfil";
    }

    public String alterar(Perfil perfil) throws Exception {
        //downCadastro.cadastrarAlterar(estadoAlterar);

        FacesMessage msg = new FacesMessage("Alteração", "Cadastro Alterado com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        return "/cadastros/perfil/cadastroPerfil";
    }

    public void altera(Perfil perfil) {
        this.perfil = perfil;
    }

    public String excluir(Perfil perfil) {
        try {
            System.err.println("Log ------ Perfil Excluir");
            downCadastro.desativarAtivar(perfil);
            this.listar();

            FacesMessage msg = new FacesMessage("Exclusão", "Cadastro excluído com sucesso.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
           System.err.println("Log ------ "+e.getMessage()); 
        }

        return "/cadastros/perfil/cadastroPerfil";
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

    public List<Object> getListaPerfil() {
        return listaPerfil;
    }

    public void setListaPerfil(List<Object> listaPerfil) {
        this.listaPerfil = listaPerfil;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Perfil getPerfil2() {
        return perfil2;
    }

    public void setPerfil2(Perfil perfil2) {
        this.perfil2 = perfil2;
    }

    public Perfil getPerfilAlteracao() {
        return perfilAlteracao;
    }

    public void setPerfilAlteracao(Perfil perfilAlteracao) {
        this.perfilAlteracao = perfilAlteracao;
    }

    public Boolean getString() {
        return string;
    }

    public void setString(Boolean string) {
        this.string = string;
    }
}
