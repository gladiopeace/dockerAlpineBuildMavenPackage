package se.docker.alpine.build.service;

import se.docker.alpine.build.model.PackageData;

import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class PackagesService
{
    private Hashtable<Integer, PackageData> packages
            = new Hashtable<>();

    int index = 0;

    public int createPackage()
    {
        PackageData packageData = new PackageData();
        packageData.setName("Apa");
        packages.put(index, packageData);
        return index++;
    }


    //  private Set<PackageData> packagesData = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
}
