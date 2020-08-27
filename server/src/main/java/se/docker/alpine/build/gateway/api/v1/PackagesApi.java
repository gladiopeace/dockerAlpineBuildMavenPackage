package se.docker.alpine.build.gateway.api.v1;

import se.docker.alpine.build.service.PackagesService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;

@Path("/v1/packages")
public class PackagesApi
{
    @Inject
    PackagesService packagesService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello()
    {
        return "Hello";
    }

    /*
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public int packageId( @Context UriInfo uriInfo)
    {
        int id = packagesService.createPackage();
        return id;
    }
     */


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response packageId( @Context UriInfo uriInfo)
    {
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(1)).build();
        String path = uri.getPath();
        Response response = Response.created(uri).status(Response.Status.OK)
            .type(MediaType.APPLICATION_JSON).build();
        return response;
    }
}