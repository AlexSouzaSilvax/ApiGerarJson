/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Vendas.Vendas;
import Vendas.VendasDAO;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
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
@Path("gxsVendas")
public class GxsVendas {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FazendaWS
     */
    public GxsVendas() {
    }

    /**
     * Retrieves representation of an instance of ws.GxsVendas
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //   return "Eu sou foda, RESTFULL";

        VendasDAO vDAO = new VendasDAO();

        List<Vendas> listaVendas = new ArrayList<Vendas>();

        listaVendas = vDAO.lista("");

        Gson g = new Gson();

        return g.toJson(listaVendas);
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
