package com.desenv.slack.facade;

import com.desenv.slack.controllers.enums.ChannelEnum;
import com.desenv.slack.dao.SlackDao;
import com.desenv.slack.models.SlackMessage;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author matheus-de-souza-badia
 */
@Stateless
public class SlackFacade {

    @EJB
    private SlackDao slackDao;
    
    /**
     * Alterar para ENUM
     * @param message
     * @param channel 
     */
    public String sendMessage(String message, ChannelEnum channel) {
        SlackMessage slackMessage = new SlackMessage(message);
        
        Response response = slackDao.sendMessageWarningChannel(slackMessage);
        
        return response.readEntity(String.class);
    }
    
}
