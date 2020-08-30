package se.docker.alpine.build.service;

import se.docker.alpine.build.model.PackageData;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class PackagesService
{
    private final ConcurrentHashMap<Integer, PackageData> packages
            = new ConcurrentHashMap<>();

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
