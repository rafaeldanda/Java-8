/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros;


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
public class ListaTreinamentoDrivers {

    private EntityManager em = conexao.conexao.getConexao();
    private TreinamentoOnline treinamentoOnline = new TreinamentoOnline();
    private DownCadastros downCadastro = new DownCadastros();

    public ListaTreinamentoDrivers() throws Exception {
        this.buscar();
    }


    public void buscar() throws Exception {
        this.treinamentoOnline = (TreinamentoOnline) downCadastro.buscar(treinamentoOnline, 1);
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

    
}
