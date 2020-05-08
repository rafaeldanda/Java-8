/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author rafael
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.CidadeFacadeREST.class);
        resources.add(service.EmcominhamentoFacadeREST.class);
        resources.add(service.EstadoFacadeREST.class);
        resources.add(service.ItemTrabalhoFacadeREST.class);
        resources.add(service.ObservacoesFacadeREST.class);
        resources.add(service.PDAFacadeREST.class);
        resources.add(service.PerfilFacadeREST.class);
        resources.add(service.PessoaFacadeREST.class);
        resources.add(service.PessoaFisicaFacadeREST.class);
        resources.add(service.PessoaJuridicaFacadeREST.class);
        resources.add(service.RespostaPdaFacadeREST.class);
        resources.add(service.SistemaFacadeREST.class);
        resources.add(service.TelefoneFacadeREST.class);
        resources.add(service.TreinamentoOnlineFacadeREST.class);
        resources.add(service.VideoAulaFacadeREST.class);
    }
    
}
