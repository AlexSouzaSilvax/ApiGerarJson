/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author guana
 */
@Path("gxsVendas1")
public class GxsVendas1 {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FazendaWS
     */
    public GxsVendas1() {
    }

    /**
     * Retrieves representation of an instance of ws.GxsVendas
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {

        String json = "Apenas um teste";

        Gson gson = new Gson();

        return gson.toJson(json);
    }

    /**
     * PUT method for updating or creating an instance of GxsVendas
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
