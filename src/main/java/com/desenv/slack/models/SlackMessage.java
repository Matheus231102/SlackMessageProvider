package com.desenv.slack.models;

import com.desenv.slack.interfaces.SlackMessageInterface;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author matheus-de-souza-badia
*/
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SlackMessage implements SlackMessageInterface {
    
    private final Jsonb jsonb = JsonbBuilder.create();
    
    @JsonbProperty("text")
    private String text;

    public String toJson() {
        return jsonb.toJson(this);
    }

}
