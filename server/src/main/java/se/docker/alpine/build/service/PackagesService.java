package se.docker.alpine.build.service;

import se.docker.alpine.build.model.PackageData;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class PackagesService
{
    private final ConcurrentHashMap<Long, PackageData> packages
            = new ConcurrentHashMap<>();

    private final AtomicLong index = new AtomicLong();

    public long createPackage()
    {
        long counter = index.incrementAndGet();
        PackageData packageData = new PackageData();
        packages.put(counter, packageData);
        return counter;
    }

    public PackageData getPackageById(String id)
    {
        return packages.get(Long.parseLong(id));
    }

    public PackageData getPackageById(Long id)
    {
        return packages.get(id);
    }

    public List<Long> getIds()
    {
        return (new ArrayList<>(packages.keySet()));
    }
}
