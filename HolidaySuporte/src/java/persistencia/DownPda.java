/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import br.suporte.beans.PDA;
import br.suporte.beans.RespostaPda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.Util;

/**
 *
 * @author Rafael
 */

public class DownPda {

    
    private EntityManager em = conexao.conexao.getConexao();
    private TypedQuery<PDA> query;
    private TypedQuery<RespostaPda> queryRespostaPda;
    private Util util = new Util();
    
    public DownPda() {
        em.getTransaction().begin();  
    }
   
    public List<PDA> listar() throws Exception {          
            query = em.createNamedQuery("listaPDA2", PDA.class);
                    query.setParameter("id", util.retornaSessao().getId());
            return query.getResultList();            
    }
    
    public List<PDA> listaMeusPda() throws Exception {
            query = em.createNamedQuery("listaMeuPDA", PDA.class);
                    query.setParameter("id", util.retornaSessao().getId());
            return query.getResultList();
    }
    
    public List<PDA> listarInicio() throws Exception {
            query = em.createNamedQuery("listaPDAInicio", PDA.class);
                    //query.setParameter("id", util.retornaSessao().getId());
            return query.getResultList();            
    }
    
    public List<RespostaPda> listarRespostaPda(Integer id, String query) throws Exception {
            this.queryRespostaPda = em.createNamedQuery(query, RespostaPda.class);
                 this.queryRespostaPda.setParameter("id", id);
            return this.queryRespostaPda.getResultList();            
    }

    
    
}
