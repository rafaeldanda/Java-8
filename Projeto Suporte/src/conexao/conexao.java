/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Rafael
 */
public class conexao {
 
    public static EntityManager getConexao(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Projeto_SuportePU");
        return fabrica.createEntityManager();
    }
    
}
