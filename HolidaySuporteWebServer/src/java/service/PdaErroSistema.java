/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import br.suporte.beans.Estado;
import com.google.gson.Gson;
import downs.DownCadastros;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author rafael
 */
@Path("HolidayPdaErroSistema")
public class PdaErroSistema {
    
    private EntityManager em = conexao.conexao.getConexao();
    private Estado estado = new Estado();
    private List<Object> listaEstado = new ArrayList<Object>();
    private DownCadastros downCadastro = new DownCadastros();
    private Gson g = new Gson();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PdaErroSistema
     */
    public PdaErroSistema() {
    }

    /**
     * Retrieves representation of an instance of service.PdaErroSistema
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of PdaErroSistema
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        try {
            
            
            
            
        } catch (Exception e) {
            System.err.println("Log ----- "+e.getMessage());
        }
        return "cadastro realizado com sucesso!";
    }
}
