/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grafico;


import br.suporte.beans.PessoaJuridica;
import br.suporte.beans.Sistema;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.PieChartModel;
import persistencia.DownCadastros;
import persistencia.DownGraficos;

/**
 *
 * @author Rafael
 */
@ViewScoped
@ManagedBean
public class GerenciamentoGraficoUsuarioSistema implements Serializable {

    private PieChartModel pieModel;
    private List<Sistema> listaSistema = new ArrayList<Sistema>();
    private List<Sistema> listaSistemaPessoa = new ArrayList<Sistema>();
    private List<PessoaJuridica> listaPessoaJuridica = new ArrayList<PessoaJuridica>();
    private DownCadastros downCadastro = new DownCadastros();
    private DownGraficos downGrafico = new DownGraficos();

    public GerenciamentoGraficoUsuarioSistema() throws Exception {
        createPieModel();
    }

    public void createPieModel() throws Exception {
        pieModel = new PieChartModel();

        int cont = 0;

        listaSistema.addAll(downGrafico.graficoClienteSistema("listaSistema"));
        listaPessoaJuridica.addAll(downGrafico.graficoClienteRegiao("listaPessoaJuridica"));

        cont = 0;

        for (int i = 0; i < listaSistema.size(); i++) {
            pieModel.set(listaSistema.get(i).getNome(), listaSistema.get(i).getListaPessoa().size());
            
        }

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

    public List<PessoaJuridica> getListaPessoaJuridica() {
        return listaPessoaJuridica;
    }

    public void setListaPessoaJuridica(List<PessoaJuridica> listaPessoaJuridica) {
        this.listaPessoaJuridica = listaPessoaJuridica;
    }

    public List<Sistema> getListaSistema() {
        return listaSistema;
    }

    public void setListaSistema(List<Sistema> listaSistema) {
        this.listaSistema = listaSistema;
    }

    public List<Sistema> getListaSistemaPessoa() {
        return listaSistemaPessoa;
    }

    public void setListaSistemaPessoa(List<Sistema> listaSistemaPessoa) {
        this.listaSistemaPessoa = listaSistemaPessoa;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

}
