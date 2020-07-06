/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
@Path("HolidayPda")
public class HolidayPda {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HolidayPda
     */
    public HolidayPda() {
    }

    /**
     * Retrieves representation of an instance of service.HolidayPda
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of HolidayPda
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        try {
            
            
            
            
            
        } catch (Exception e) {
            System.err.println("Log ------ "+e.getMessage());
        }
        return "fail";
    }
}
