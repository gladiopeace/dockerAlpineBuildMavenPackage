package se.docker.alpine.build.gateway.api.v1;

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
    public Response name(@PathParam("name") String name)
    {
        PackageData packageData;
        packageData = packagesService.getPackageById(id);
        if (packageData == null)
        {
            return Response.noContent().build();
        } else
        {
            packageData.setName(name);
            return Response.ok().build();
        }

    }

}
