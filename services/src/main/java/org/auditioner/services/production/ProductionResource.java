package org.auditioner.services.production;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/auditioner/productions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductionResource {

    private ProductionDAO productionDAO;

    public ProductionResource(ProductionDAO productionDAO) {
        this.productionDAO = productionDAO;
    }

    @GET
    @Path("/{production_id}")
    public Production getProduction(@PathParam("production_id") long productionId){
        return productionDAO.getProduction(productionId);
    }

    @DELETE
    @Path("/{production_id}")
    public void deleteProduction(@PathParam("production_id") long productionId)
    {
        productionDAO.deleteProduction(productionId);
    }

    @PUT
    @Path("/{production_id}")
    public void updateFamily(@PathParam("production_id") long productionId, Production production)
    {
        productionDAO.updateProduction(productionId, production);
    }
}