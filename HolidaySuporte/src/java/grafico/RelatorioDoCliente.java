/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grafico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import persistencia.DownCadastros;

/**
 *
 * @author Rafael
 */
@ViewScoped
@ManagedBean
public class RelatorioDoCliente implements Serializable {

    private List<Object> listaPda = new ArrayList<Object>();
    private DownCadastros down = new DownCadastros();

    public RelatorioDoCliente() throws Exception {
        this.listar();
    }

    public void listar() throws Exception{
        this.listaPda.addAll(down.listar("listaPDA"));
    }

    public List<Object> getListaPda() {
        return listaPda;
    }

    public void setListaPda(List<Object> listaPda) {
        this.listaPda = listaPda;
    }
    
    
}
