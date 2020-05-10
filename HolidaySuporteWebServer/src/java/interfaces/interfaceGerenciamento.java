/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import br.suporte.beans.Estado;
import java.util.List;

/**
 *
 * @author Rafael
 */
public interface interfaceGerenciamento {
    
    public abstract void cadastrarAlterar(Object Object) throws Exception;
    public abstract List<Object> listar(String query) throws Exception;
    public abstract Object buscar(Object objeto, int query) throws Exception;
    public abstract void desativarAtivar(Object objeto) throws Exception;
    public abstract void exit() throws Exception;
        
}
