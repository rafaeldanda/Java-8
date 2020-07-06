/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import br.suporte.beans.PDA;
import br.suporte.beans.PessoaJuridica;
import br.suporte.beans.Sistema;
import java.util.ArrayList;
import java.util.List;
import javax.management.Query;
import javax.persistence.EntityManager;


/**
 *
 * @author Rafael
 */
public class DownGraficos {

    private EntityManager em = conexao.conexao.getConexao();
    private Query query;
    private List<PessoaJuridica> listaPessoaJuridica = new ArrayList<PessoaJuridica>();
    private List<Sistema> listaSistemaPessoa = new ArrayList<Sistema>();
    
    public DownGraficos() {
    }
    
    public List<PessoaJuridica> graficoClienteRegiao(String query) throws Exception{
        return em.createNamedQuery(query).getResultList();       
    }
    
    public List<PDA> listaPDA(String query) throws Exception{
        return em.createNamedQuery(query).getResultList();       
    }
    
    public List<Sistema> graficoClienteSistema(String query) throws Exception{
        return em.createNamedQuery(query).getResultList();       
    }
    
    public void teste() throws Exception{
      System.out.println(listaPessoaJuridica.get(0).getListaSistema().size());
        
    }
    
}
