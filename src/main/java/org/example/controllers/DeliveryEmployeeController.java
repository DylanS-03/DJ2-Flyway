package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.DoesNotExistException;
import org.example.exceptions.FailedToCreateException;
import org.example.models.DeliveryEmployeeRequest;
import org.example.services.DeliveryEmployeeService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;



@Api("Delivery Employee API")
@Path("/api/DeliveryEmployees")
public class DeliveryEmployeeController {

    DeliveryEmployeeService deliveryEmployeeService;

    public DeliveryEmployeeController(
            final DeliveryEmployeeService deliveryEmployeeService) {
        this.deliveryEmployeeService = deliveryEmployeeService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response testConnection() {
        try {
            return Response.ok()
                    .entity(deliveryEmployeeService.getAllDeliveryEmployees())
                    .build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(
            final DeliveryEmployeeRequest deliveryEmployeeRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(deliveryEmployeeService.createDeliveryEmployee(
                            deliveryEmployeeRequest))
                    .build();
        } catch (SQLException | FailedToCreateException e) {
            return Response.serverError().build();
        } catch (DoesNotExistException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }

}



