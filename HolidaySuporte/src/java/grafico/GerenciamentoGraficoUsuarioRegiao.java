/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grafico;

import br.suporte.beans.Estado;
import br.suporte.beans.Pessoa;
import br.suporte.beans.PessoaJuridica;
import br.suporte.beans.Sistema;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.*;
import persistencia.DownCadastros;
import persistencia.DownGraficos;

/**
 *
 * @author Rafael
 */

@ViewScoped
@ManagedBean
public class GerenciamentoGraficoUsuarioRegiao implements Serializable{
     
   
    private BubbleChartModel bubbleModel;
    private List<Object> listaEstado = new ArrayList<Object>();
    private List<PessoaJuridica> listaPessoaJuridica = new ArrayList<PessoaJuridica>();
    private PessoaJuridica pessoaJuridica = new PessoaJuridica();
    private DownCadastros downCadastro = new DownCadastros();
    private DownGraficos downGrafico = new DownGraficos();
    private Estado estado = new Estado();
    
    
    public GerenciamentoGraficoUsuarioRegiao() throws Exception{
       createBubbleModel();
    }
  
   
    public void createBubbleModel() throws Exception{  
        bubbleModel = new BubbleChartModel(); 
        
        int cont = 0;
        
        listaEstado.addAll(downCadastro.listar("listaEstados"));
        listaPessoaJuridica.addAll(downGrafico.graficoClienteRegiao("listaPessoaJuridica"));
        
        for(int i2 = 0; i2 < listaEstado.size(); i2++) { 
            estado = (Estado) listaEstado.get(i2);
            cont = 0;
            
            for(int i = 0; i < listaPessoaJuridica.size(); i++) {
                pessoaJuridica = listaPessoaJuridica.get(i);
                if(pessoaJuridica.getCidade().getEstado().getSigla().equals(estado.getSigla())){
                  cont++;
                }
            }
            if(cont != 0){
                bubbleModel.add(new BubbleChartSeries(estado.getSigla(), cont, cont, cont));
            }
        }
                
    }

    public BubbleChartModel getBubbleModel() {
        return bubbleModel;
    }

    public void setBubbleModel(BubbleChartModel bubbleModel) {
        this.bubbleModel = bubbleModel;
    }

    public DownCadastros getDownCadastro() {
        return downCadastro;
    }

    public void setDownCadastro(DownCadastros downCadastro) {
        this.downCadastro = downCadastro;
    }

    public DownGraficos getDownGrafico() {
        return downGrafico;
    }

    public void setDownGrafico(DownGraficos downGrafico) {
        this.downGrafico = downGrafico;
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

    public List<PessoaJuridica> getListaPessoaJuridica() {
        return listaPessoaJuridica;
    }

    public void setListaPessoaJuridica(List<PessoaJuridica> listaPessoaJuridica) {
        this.listaPessoaJuridica = listaPessoaJuridica;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }
    
    
    
   
}
