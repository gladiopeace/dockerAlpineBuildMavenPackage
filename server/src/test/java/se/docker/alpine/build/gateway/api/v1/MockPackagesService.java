package se.docker.alpine.build.gateway.api.v1;

import io.quarkus.test.Mock;
import se.docker.alpine.build.model.PackageData;
import se.docker.alpine.build.service.PackagesService;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@Mock
@ApplicationScoped
public class MockPackagesService extends PackagesService
{
    private PackageData packageData = new PackageData();
   /* public MockPackagesService()
    {
        packageData.setName("mypackage");
    }*/
    @Override
    public int createPackage()
    {
        return 1;
    }

    @Override
    public PackageData getPackageById(String id)
    {
     //   packageData.setName("myPackage");
        return packageData;
    }

    @Override
    public PackageData getPackageById(Integer id)
    {
       // packageData.setName("myPackage");
        return packageData;
    }

    @Override
    public List<Integer> getIds()
    {
        List<Integer> listKeys = new ArrayList<>();
        listKeys.add(1);
        return listKeys;
    }

}
