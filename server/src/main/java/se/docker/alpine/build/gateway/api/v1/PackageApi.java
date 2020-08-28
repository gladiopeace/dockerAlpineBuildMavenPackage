package se.docker.alpine.build.gateway.api.v1;

import org.jboss.resteasy.annotations.Body;
import se.docker.alpine.build.model.PackageData;
import se.docker.alpine.build.service.PackagesService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/packages/{id}")
public class PackageApi
{
    @PathParam("id")
    private String id;

    @Inject
    PackagesService packagesService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response packageData()
    {
        PackageData packageData = packagesService.getPackageById(id);
        if (packageData == null)
        {
            return Response.noContent().build();
        } else
        {
            return Response.ok().entity(packageData).build();
        }
    }

    @Path("{name}")
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response name(String body, @PathParam("name") String name)
    {
        Response response;
        PackageData packageData;
        packageData = packagesService.getPackageById(id);
        if (packageData == null)
        {
            response=  Response.noContent().build();
        } else
        {
            packageData.setName(body);
            response = Response.ok().build();
        }
        return response;
    }

}
