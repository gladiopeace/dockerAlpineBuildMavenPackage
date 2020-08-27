package se.docker.alpine.build.gateway.api.v1;

import io.quarkus.test.Mock;
import se.docker.alpine.build.model.PackageData;
import se.docker.alpine.build.service.PackagesService;

import javax.enterprise.context.ApplicationScoped;

@Mock
@ApplicationScoped
public class MockPackagesService extends PackagesService
{
    @Override
    public int createPackage()
    {
        return 0;
    }

    @Override
    public PackageData getPackageById(String id)
    {
        PackageData packageData = new PackageData();
        packageData.setName("mypackage");
        return packageData;
    }

}
