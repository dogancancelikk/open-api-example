package com.example.OpenApiDemo;

import com.example.OpenApiDemo.controller.AlgorithmController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath( "/api" )
public class OpenApiDemoApplication extends Application
{
    @Override
    public Set<Class<?>> getClasses() {
        HashSet resources = new HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add( AlgorithmController.class);
    }
}