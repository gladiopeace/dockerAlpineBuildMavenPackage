package se.docker.alpine.build.gateway.api.v1;

import se.docker.alpine.build.model.PackageData;
import se.docker.alpine.build.service.PackagesService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/packages/{id}")
public class PackageApi
{
    @PathParam("id")
    private String id;

    @Inject
    PackagesService packagesService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PackageData hello()
    {


        PackageData packageData = new PackageData();

        packageData.setName("apa");
        return packageData;
    }

}
