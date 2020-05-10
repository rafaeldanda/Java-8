/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package downs;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Rafael
 */

public class DownCadastros implements interfaces.interfaceGerenciamento{

    
    private EntityManager em = conexao.conexao.getConexao();

    public DownCadastros() {
        //em.getTransaction().begin();
    }
    
    
       
    @Override
    public void cadastrarAlterar(Object objeto) throws Exception {
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
    }

    @Override
    public List<Object> listar(String query) throws Exception {
       return em.createNamedQuery(query).getResultList();       
    }   

    @Override
    public Object buscar(Object objeto, int query) throws Exception {
        //em.getTransaction().begin();
        return em.find(objeto.getClass(), query);        
    }

    @Override
    public void desativarAtivar(Object objeto) throws Exception {
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        
    }

    @Override
    public void exit() throws Exception {
        this.em.close();
    }

    
    
}
