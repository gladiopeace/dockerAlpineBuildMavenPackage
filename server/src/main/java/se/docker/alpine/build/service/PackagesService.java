package se.docker.alpine.build.service;

import se.docker.alpine.build.model.PackageData;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PackagesService
{
    private Hashtable<Integer, PackageData> packages
            = new Hashtable<>();

    private AtomicInteger index = new AtomicInteger();

    public int createPackage()
    {
        int counter = index.incrementAndGet();
        PackageData packageData = new PackageData();
        packageData.setName("Apa");
        packages.put(counter, packageData);
        return counter;
    }

    public PackageData getPackageById(String id)
    {
        return packages.get(id);
    }

    public List<Integer>  getIds()
    {
       List<Integer> listKeys = new ArrayList<Integer>( packages.keySet() );
       return listKeys;
    }
}
