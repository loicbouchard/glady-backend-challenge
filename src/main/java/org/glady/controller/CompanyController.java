package org.glady.controller;

import org.glady.dao.Company;
import org.glady.dto.CompanyDto;
import org.glady.service.CompanyService;
import org.jboss.resteasy.reactive.ResponseStatus;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("company")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @GET
    @Path("{id}")
    public Company getCompanyById(@PathParam("id") Integer id) {
        return companyService.getCompanyById(id);
    }

    @POST
    @ResponseStatus(201)
    public Response createCompany(@Valid CompanyDto companyDto) {
        companyService.persistCompanyFromDto(companyDto);
        return Response.status(Response.Status.CREATED).build();
    }
}
