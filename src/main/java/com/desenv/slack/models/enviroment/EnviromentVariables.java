package com.desenv.slack.models.enviroment;

import com.desenv.slack.interfaces.EnviromentVariable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author matheus-de-souza-badia
 */
@Getter
@Setter
@NoArgsConstructor
public class EnviromentVariables {
    
    @EnviromentVariable(value = "warning.channel.webhook")
    public String warningChannelWebHook;
    
    @EnviromentVariable(value = "testing")
    public String testingVariable;
    
}
