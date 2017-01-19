package org.redischool.product.integration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redischool.product.model.Product;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Created by ReDI on 1/13/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProductHttpTest {

    Client client = ClientBuilder.newClient();

    @Test
    public void shouldExecuteSuccessfulPost() {
        WebTarget target = client.target("http://localhost:8080/api/product");
        Response response = target.request().post(null);
        Assert.assertEquals(201, response.getStatus());
        String locationHeader = response.getHeaders().getFirst("Location").toString();
    }

    @Test
    public void shouldExecuteuccessfullPut() {
        Product product = Product.builder().id("proId").name("proName").description("proDesc").build();

        WebTarget target = client.target("http://localhost:8080/api/product");
        Response response = target.request().put(Entity.json(product));
        Assert.assertEquals(202, response.getStatus());
        String locationHeader = response.getHeaderString("Location");
    }
}
