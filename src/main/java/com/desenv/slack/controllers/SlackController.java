package com.desenv.slack.controllers;

import com.desenv.slack.api.ExceptionResponse;
import com.desenv.slack.controllers.enums.ChannelEnum;
import com.desenv.slack.facade.SlackFacade;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.time.LocalDateTime;

/**
 *
 * @author matheus-de-souza-badia
 */
@Path("/service")
public class SlackController {

    @EJB
    private SlackFacade slackFacade;

    @Path("/warning/message")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendMessageWarning(
            @QueryParam("message") String message,
            @QueryParam("channel") String channel
    ) {
        try {
            String sendedMessage = slackFacade.sendMessage(message, ChannelEnum.WARNING);

            return Response.ok(sendedMessage).build();

        } catch (Exception exception) {
            ExceptionResponse exceptionResponse = new ExceptionResponse("Ocorreu um erro ao enviar a mensagem para o canal: " + exception, null, LocalDateTime.now());
            
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(exceptionResponse)
                    .build();
        }
    }

}
