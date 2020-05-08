/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros;

import br.suporte.beans.Cidade;
import br.suporte.beans.Estado;
import br.suporte.beans.PDA;
import br.suporte.beans.PessoaFisica;
import br.suporte.beans.RespostaPda;
import br.suporte.beans.Sistema;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;
import persistencia.DownCadastros;
import persistencia.DownPda;
import util.Util;

/**
 *
 * @author Rafael
 */


@ViewScoped
@ManagedBean
public class GerenciamentoMeusPda implements Serializable{

  
   private List<Sistema> listaSistema = new ArrayList<Sistema>();
   private PDA pda = new PDA();
   private Sistema sistema = new Sistema();
   private List<PDA> listaPda = new ArrayList<PDA>();
   private List<Object> listaPdaInicio = new ArrayList<Object>();
   private List<RespostaPda> listaRespostaPda = new ArrayList<RespostaPda>();
   private DownCadastros downCadastro = new DownCadastros();
   private Util util = new Util();
   private RespostaPda respostaPda = new RespostaPda();
   private Date dataEntrada = new Date();
   private List<PessoaFisica> listaPessoaFisica = new ArrayList<PessoaFisica>(); 
   private DownPda downPda = new DownPda();
   private String batePapo = "";
  
     
           
    public GerenciamentoMeusPda() throws Exception{
    
        this.buscaSistema();
        this.listar();
        this.listaInicio();
    }
  
    public void novo() throws Exception{
     this.pda = new PDA();
     //return "/cadastros/pda/cadastroPda";
   }
        
   public String cadastrar() throws Exception{
    
      pda.setSistema(sistema);
      pda.setDataEntrada(dataEntrada);
      pda.setStatus(true);
      pda.setSugestao("");
      pda.setPessoa(util.retornaSessao());
      
      
      /*
      for(int cont = 0;cont < listaEstado.size();cont++){
          estado2 = (Estado) listaEstado.get(cont);
          if(estado2.getNome().toUpperCase().equals(estado.getNome().toUpperCase())){
              string = true;
              break;
          }
      }
      if(!string){
        downCadastro.cadastrarAlterar(estado);
        this.listar();
        string = false;
        
        FacesMessage msg = new FacesMessage("Cadastro", "Cadastrado com sucesso.");   
        FacesContext.getCurrentInstance().addMessage(null, msg);
      }else{
          FacesMessage msg = new FacesMessage("Atenção", "Já existe esse cadastro.");   
          FacesContext.getCurrentInstance().addMessage(null, msg);
      }
      
      */
      downCadastro.cadastrarAlterar(pda);
      this.listar();
      this.novo();
     
      return "/cadastros/pda/cadastroPda";
   }
   
   public void cadastraRespostaPda() throws Exception{
       this.respostaPda.setPda(this.pda);
       this.respostaPda.setPessoa(this.util.retornaSessao());
       
       downCadastro.cadastrarAlterar(respostaPda);
       this.respostaPda = new RespostaPda();
       
       //return "/cadastros/pda/cadastroPda";
   }
   
   public void verPda(PDA pda) throws Exception{
       this.pda = pda;
       this.batePapo = "";
       this.batePapo += "Código: "+this.pda.getId()+"\n";
       this.batePapo += "Cliente: "+this.pda.getPessoa().getNome()+"\n";
       this.batePapo += "Operador: "+this.pda.getOperador()+"\n";
       this.batePapo += "Data de Entrada: "+this.pda.getDataEntrada()+"\n";
       this.batePapo += "Descrição: "+this.pda.getDescricao()+"\n";
       this.batePapo += "\n"+"----------------------------------------------------------------------------------------------------"+"\n\n";
       
       
       this.listaRespostaPda.clear();
       this.listaRespostaPda.addAll(this.downPda.listarRespostaPda(pda.getId(), "listaRespostaPda"));
       
       for (int i = 0; i < this.listaRespostaPda.size(); i++) {
           this.batePapo += this.listaRespostaPda.get(i).getPessoa().getNome()+" diz:"+"\n";
           this.batePapo += this.listaRespostaPda.get(i).getResposta()+"\n\n";
       }
     // return "/cadastros/pda/cadastroPda";
   }
   
   public void verPdaInicio(PDA pda) throws Exception{
        pda.setDono(util.retornaSessao());
        downCadastro.cadastrarAlterar(pda);
        this.verPda(pda);
   }
   
   public void listar() throws Exception{
       this.listaPda.clear();
       this.listaPda.addAll(downPda.listaMeusPda());       
   }
   
   public String excluir(PDA pda) throws Exception{
       
      pda.setStatus(Boolean.FALSE);
      downCadastro.cadastrarAlterar(pda);
      this.listar();
      
      FacesMessage msg = new FacesMessage("Finalização", "Pedido de ajuda finalizado com sucesso.");   
      FacesContext.getCurrentInstance().addMessage(null, msg);
      
      return "/cadastros/pda/cadastroPda";
   }
   
   public void buscaSistema(){
       listaSistema.addAll(util.retornaSessao().getPessoaJuridica().getListaSistema());
   }
   
    //-------------------------------
    
    public void listaInicio() throws Exception{
       this.listaPdaInicio.clear();
       this.listaPdaInicio.addAll(downPda.listarInicio());
          
   }
    
     
   
   //-----------------------------

    public DownCadastros getDownCadastro() {
        return downCadastro;
    }

    public void setDownCadastro(DownCadastros downCadastro) {
        this.downCadastro = downCadastro;
    }

    public List<PDA> getListaPda() {
        return listaPda;
    }

    public void setListaPda(List<PDA> listaPda) {
        this.listaPda = listaPda;
    }

    public List<Sistema> getListaSistema() {
        return listaSistema;
    }

    public void setListaSistema(List<Sistema> listaSistema) {
        this.listaSistema = listaSistema;
    }

    public PDA getPda() {
        return pda;
    }

    public void setPda(PDA pda) {
        this.pda = pda;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public List<Object> getListaPdaInicio() {
        return listaPdaInicio;
    }

    public void setListaPdaInicio(List<Object> listaPdaInicio) {
        this.listaPdaInicio = listaPdaInicio;
    }

    public RespostaPda getRespostaPda() {
        return respostaPda;
    }

    public void setRespostaPda(RespostaPda respostaPda) {
        this.respostaPda = respostaPda;
    }

    public String getBatePapo() {
        return batePapo;
    }

    public void setBatePapo(String batePapo) {
        this.batePapo = batePapo;
    }

    
    
    
}
