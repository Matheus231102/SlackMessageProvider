package com.desenv.slack.dao;

import com.desenv.slack.api.RestClient;
import com.desenv.slack.dao.enviroment.EnviromentVariablesDao;
import com.desenv.slack.models.SlackMessage;
import com.desenv.slack.models.enviroment.EnviromentVariables;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author matheus-de-souza-badia
 */
@Stateless
public class SlackDao {
    private EnviromentVariables enviromentVariables = EnviromentVariablesDao.loadVariables();
    
//    public Response sendMessage(SlackMessage slackMessage, ChannelEnum channelEnum) {
    public Response sendMessageWarningChannel(SlackMessage slackMessage) {
        /*
        pegar o channel enum e buscar o webhook através de um hashmap
        */
        RestClient restClient = new RestClient.Builder()
                .url(enviromentVariables.getWarningChannelWebHook())
                .build();
        /**
         * verificar paramêtros
         */
        return restClient.post(slackMessage.toJson(), null);
    }
    
}
