/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import br.suporte.beans.Estado;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import downs.DownCadastros;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import testes.Cidadee;
import testes.Estadoo;

/**
 * REST Web Service
 *
 * @author rafael
 */
@Path("HolidayCadastroEstado")
public class HolidayCadastroEstadoResource {

    Estado estado = new Estado();
    Cidadee cidade;
    testes.Estadoo estadoo = new testes.Estadoo();
    private List<Object> listaEstado = new ArrayList<Object>();
    private DownCadastros downCadastro = new DownCadastros();
    Gson g = new Gson();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HolidayCadastroEstadoResource
     */
    public HolidayCadastroEstadoResource() {
        this.estado = new Estado();

    }

    /**
     * Retrieves representation of an instance of
     * service.HolidayCadastroEstadoResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        try {
            
            
            
            
            
        } catch (Exception e) {
            System.err.println("Log ------ "+e.getMessage());
        }
        return "";
    }

    /**
     * PUT method for updating or creating an instance of
     * HolidayCadastroEstadoResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        try {
          
            //retorna Json em Objeto de novo
            Type estadoType = new TypeToken<Estadoo>() {
            }.getType();
            estadoo = g.fromJson(content, estadoType);

            this.cadastraEstado(estadoo);
            return "Sucesso!";

        } catch (Exception e) {
            System.err.println("Log ------ " + e.getMessage());
        }
        return "Fail!";
    }

    private void cadastraEstado(Estadoo estadoo) {
        try {
            //Pega objeton JSON e seta na mão no objeto entidade br.suporte.beans.Estado
            this.estado.setId(estadoo.getId());
            this.estado.setNome(estadoo.getNome());
            this.estado.setSigla(estadoo.getSigla());
            estadoo = null;
            
            // cadastra estado no banco
            downCadastro.cadastrarAlterar(estado);

        } catch (Exception e) {
            System.err.println("Log ------ " + e.getMessage());
        }
    }
}
