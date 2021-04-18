package com.example.OpenApiDemo;

import io.swagger.jaxrs.config.BeanConfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class SwaggerConfigurationServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    @Override
    public void init( ServletConfig config) throws ServletException
    {
        super.init(config);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setBasePath("/OpenApiDemo-1.0-SNAPSHOT/api");
        beanConfig.setHost("localhost:8080");
        beanConfig.setTitle("Swagger Blog Post Web Services Documentation");
        beanConfig.setResourcePackage("com.example.OpenApiDemo");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan(true);
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setVersion("1.0");
    }
}