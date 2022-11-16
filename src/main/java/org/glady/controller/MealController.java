package org.glady.controller;

import org.glady.dto.PresentDto;
import org.glady.service.MealService;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/meal")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MealController {
    private final MealService mealService;

    public MealController(MealService mealService){
        this.mealService = mealService;
    }

    @POST
    public Response addMealToCustomer(@Valid PresentDto presentDto) {
        mealService.addMealToCustomer(presentDto);
        return Response.ok().build();
    }
}
