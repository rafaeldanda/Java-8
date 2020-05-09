/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

/**
 *
 * @author rafael
 */
@Path("NHA")
public class cadastroEstado {
    
    @Context
    private String context;
    

    public cadastroEstado() {
    }
    
    @GET
    @Produces("cadastroEstado/text")
    public String get(){
        
        return "ola mundo";
    }
    
    @PUT
    @Consumes("cadastroEstado/json")
    public void post(String context){
        
    }
    
    
}
