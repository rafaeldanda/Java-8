/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import br.suporte.beans.PessoaFisica;
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
public class DownListas {
    
    private EntityManager em = conexao.conexao.getConexao();
    private Query query;
    private List<PessoaJuridica> listaPessoaJuridica = new ArrayList<PessoaJuridica>();
    private List<Sistema> listaSistemaPessoa = new ArrayList<Sistema>();

    public DownListas() {
    }
    
    public List<PessoaFisica> getListaPessoaFisica(String query) throws Exception{
        return em.createNamedQuery(query).getResultList();       
    }
    
}
