package org.redischool.product.resources;


import org.redischool.product.model.Product;
import org.redischool.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.net.URI;

@Component
@Path("product")
public class ProductResource {


    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }


    @POST
    public Response create() {
        String id = productService.generateId();
        return Response.created(URI.create("product/" + id)).entity(id).build();
    }


    @Path("{id}")
    @PUT
    public Response saveProduct(@PathParam("id") String id, Product product) {
        return Response.ok().entity(productService.saveProduct(product)).build();
    }


    @Path("{id}")
    @GET
    public Response getProduct(@PathParam("id") String id) {
        return Response.ok().entity(productService.getProduct(id)).build();
    }
}
