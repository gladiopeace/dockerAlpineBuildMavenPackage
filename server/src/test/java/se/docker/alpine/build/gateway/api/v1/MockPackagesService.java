package se.docker.alpine.build.gateway.api.v1;

import io.quarkus.test.Mock;
import se.docker.alpine.build.model.PackageData;
import se.docker.alpine.build.service.PackagesService;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Mock
@ApplicationScoped
public class MockPackagesService extends PackagesService
{
    private final Hashtable<Integer, PackageData> packages
            = new Hashtable<>();

    private Integer index = 0;

    @Override
    public int createPackage()
    {
        final PackageData packageData = new PackageData();
        packages.put(++index,packageData);
        return index;
    }

    @Override
    public PackageData getPackageById(String id)
    {
        return packages.get(Integer.parseInt(id));
    }

    @Override
    public PackageData getPackageById(Integer id)
    {
        return packages.get(id);
    }

    @Override
    public List<Integer> getIds()
    {
        return (new ArrayList<>(packages.keySet()));
    }

}
