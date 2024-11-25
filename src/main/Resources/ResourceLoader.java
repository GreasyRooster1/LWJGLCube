package main.Resources;

import java.io.File;
import java.util.HashMap;

public class ResourceLoader {
    private final String resourceLocation;
    private HashMap<String, Resource> resources = new HashMap<>();

    public ResourceLoader(String resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public void loadAllResources(){
        loadResources("");
    }

    public void loadResources(String stub){
        File dir = new File(resourceLocation+"\\"+stub);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                if (child.isDirectory()) {
                    loadResources(stub+"\\"+child.getName());
                }else{
                    resources.put(stub+"\\"+child.getName(),parseResource(resourceLocation+"\\"+stub+"\\"+child.getName()));
                }
            }
        }
    }

    public Resource parseResource(String path){
        return new Resource(path);
    }

    public Resource getResource(String identifier){
        return resources.get(identifier);
    }
}
