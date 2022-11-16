package org.glady.controller;

import org.glady.dto.PresentDto;
import org.glady.service.GiftService;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/gift")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GiftController {
    private final GiftService giftService;

    public GiftController(GiftService giftService){
        this.giftService = giftService;
    }

    @POST
    public Response addGiftToCustomer(@Valid PresentDto presentDto) {
        giftService.addGiftToCustomer(presentDto);
        return Response.ok().build();
    }
}
