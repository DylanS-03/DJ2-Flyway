package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.services.ProjectService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;



@Api("Projects API")
@Path("/api/Projects")
public class ProjectController {
    ProjectService projectService;

    public ProjectController(
            final ProjectService projectService) {
        this.projectService = projectService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response testConnection() {
        try {
            return Response.ok()
                    .entity(projectService.getAllProjects())
                    .build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
}
