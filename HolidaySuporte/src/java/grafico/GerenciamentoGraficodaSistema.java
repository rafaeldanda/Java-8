/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grafico;

import br.suporte.beans.PDA;
import br.suporte.beans.Sistema;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import persistencia.DownCadastros;
import persistencia.DownGraficos;

/**
 *
 * @author Rafael
 */
@ViewScoped
@ManagedBean
public class GerenciamentoGraficodaSistema implements Serializable {

    //private CartesianChartModel categoryModel;
    private BarChartModel categoryModel;
    private ChartSeries chartAtivo;
    private ChartSeries chartFechado;
    private ChartSeries boys;
    private DownGraficos downGrafico = new DownGraficos();
    private DownCadastros downCadastros = new DownCadastros();
    private List<Sistema> listaSistema = new ArrayList<Sistema>();
    private int ativo = 0;
    private int fechado = 0;
    private Sistema sistema = new Sistema();
    private List<PDA> listaPda = new ArrayList<PDA>();
    private BarChartModel model;

    public GerenciamentoGraficodaSistema() throws Exception {
        this.createCategoryModel();
    }

    public void createCategoryModel() {
        try {
            
            System.err.println("Log ----- Gradico Usuario por sistema");
            categoryModel = new BarChartModel();

            listaSistema.addAll(downGrafico.graficoClienteSistema("listaSistema"));
            listaPda.addAll(downGrafico.listaPDA("listaPDA"));

            //PDA ativo
            chartAtivo = new ChartSeries();
            chartAtivo.setLabel("Aberto");

            //PDA fechado
            chartFechado = new ChartSeries();
            chartFechado.setLabel("Fechado");

            for (int i = 0; i < listaSistema.size(); i++) {
                sistema = listaSistema.get(i);
                ativo = 0;
                fechado = 0;
                for (int j = 0; j < listaPda.size(); j++) {
                    if (listaPda.get(j).getStatus() == true && listaPda.get(j).getSistema().getId() == sistema.getId()) {
                        ativo++;
                    } else if (listaPda.get(j).getStatus() == false && listaPda.get(j).getSistema().getId() == sistema.getId()) {
                        fechado++;
                    }
                }

                chartAtivo.set(sistema.getNome(), ativo);
                chartFechado.set(sistema.getNome(), fechado);

            }

            categoryModel.addSeries(chartAtivo);
            categoryModel.addSeries(chartFechado);
            /*model = new BarChartModel();

            
            ChartSeries boys = new ChartSeries();
            boys.setLabel("Boys");
            boys.set("2004", 120);
            boys.set("2005", 100);
            boys.set("2006", 44);
            boys.set("2007", 150);
            boys.set("2008", 25);

            ChartSeries girls = new ChartSeries();
            girls.setLabel("Girls");
            girls.set("2004", 52);
            girls.set("2005", 60);
            girls.set("2006", 110);
            girls.set("2007", 135);
            girls.set("2008", 120);

            model.addSeries(boys);
            model.addSeries(girls);
            */
            
        } catch (Exception e) {
            System.err.println("Log ----- " + e.getMessage());
        }

        /* categoryModel = new CartesianChartModel();  
  
        boys = new ChartSeries();  
        boys.setLabel("Aberto");  
  
        boys.set("2004", 120);  
        boys.set("2005", 100);  
        boys.set("2006", 44);  
        boys.set("2007", 150);  
        boys.set("2008", 25);  
  
        ChartSeries girls = new ChartSeries();  
        girls.setLabel("Fechado");  
  
        girls.set("2004", 52);  
        girls.set("2005", 60);  
        girls.set("2006", 110);  
        girls.set("2007", 135);  
        girls.set("2008", 120);  
  
        categoryModel.addSeries(boys);  
        categoryModel.addSeries(girls); */
    }

    public BarChartModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(BarChartModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    
    
    

}
