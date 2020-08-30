package se.docker.alpine.build.service;

import se.docker.alpine.build.model.PackageData;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class PackagesService
{
    private final Hashtable<Integer, PackageData> packages
            = new Hashtable<>();

    private final AtomicInteger index = new AtomicInteger();

    public int createPackage()
    {
        int counter = index.incrementAndGet();
        PackageData packageData = new PackageData();
        packages.put(counter, packageData);
        return counter;
    }

    public PackageData getPackageById(String id)
    {
        return packages.get(Integer.parseInt(id));
    }

    public PackageData getPackageById(Integer id)
    {
        return packages.get(id);
    }

    public List<Integer> getIds()
    {
        return (new ArrayList<>(packages.keySet()));
    }
}
