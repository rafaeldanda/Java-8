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
public class GerenciamentoGraficos implements Serializable{
     
    private PieChartModel pieModel;
    private CartesianChartModel categoryModel;
    private CartesianChartModel linearModel;
    
    private List<Object> listaEstado = new ArrayList<Object>();
    private List<Sistema> listaSistema = new ArrayList<Sistema>();
    private List<Sistema> listaSistemaPessoa = new ArrayList<Sistema>();
    private List<Object> listaObjeto = new ArrayList<Object>();
    private List<PessoaJuridica> listaPessoaJuridica = new ArrayList<PessoaJuridica>();
    private List<Pessoa> listaPessoa = new ArrayList<Pessoa>();
    private PessoaJuridica pessoaJuridica = new PessoaJuridica();
    private DownCadastros downCadastro = new DownCadastros();
    private DownGraficos downGrafico = new DownGraficos();
    private Estado estado = new Estado();
    private Pessoa pessoa = new Pessoa();
    private Sistema sistema = new Sistema();
    private String sql = "select *"+
                            " from"+
                            " pessoa,tblcidade,tblestado"+
                            " where"+
                            " pessoa.cidade_id = tblcidade.id and"+
                            " tblcidade.estado_id = tblestado.id and"+
                            " tblestado.sigla = 'RS'";
    
    public GerenciamentoGraficos() throws Exception{
       
       createCategoryModel();  
       createLinearModel();
      
    }
  
     
    
    
    public void createCategoryModel() throws Exception{  
        categoryModel = new CartesianChartModel();  
  
        ChartSeries boys = new ChartSeries();  
        boys.setLabel("Sistema 1");  
  
        boys.set("2010", 10);  
        boys.set("2011", 15);  
        boys.set("2012", 50);  
        boys.set("2013", 2);  
          
  
        ChartSeries girls = new ChartSeries();  
        girls.setLabel("Sistema 2");  
  
        girls.set("2010", 3);  
        girls.set("2011", 5);  
        girls.set("2012", 70);  
        girls.set("2013", 35);  
          
  
        //categoryModel.addSeries(boys);  
        //categoryModel.addSeries(girls);  
    } 
    
    public void createLinearModel() throws Exception{  
        linearModel = new CartesianChartModel();  
  
        LineChartSeries series1 = new LineChartSeries();  
        series1.setLabel("Series 1");  
  
        series1.set(1, 2);  
        series1.set(2, 1);  
        series1.set(3, 3);  
        series1.set(4, 6);  
        series1.set(5, 8);  
  
        LineChartSeries series2 = new LineChartSeries();  
        series2.setLabel("Series 2");  
        series2.setMarkerStyle("diamond");  
  
        series2.set(1, 6);  
        series2.set(2, 3);  
        series2.set(3, 2);  
        series2.set(4, 7);  
        series2.set(5, 9);  
  
        //linearModel.addSeries(series1);  
        //linearModel.addSeries(series2);  
    }  
    
    
    

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public CartesianChartModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CartesianChartModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    public CartesianChartModel getLinearModel() {
        return linearModel;
    }

    public void setLinearModel(CartesianChartModel linearModel) {
        this.linearModel = linearModel;
    }

   
    
    
    
    
}
