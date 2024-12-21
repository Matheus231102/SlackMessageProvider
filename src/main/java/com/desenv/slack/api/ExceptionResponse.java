package com.desenv.slack.api;


import java.io.Serializable;
import java.time.LocalDateTime;
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
public class ExceptionResponse implements Serializable {

    private String message;
    private Integer error;
    private LocalDateTime date;
    
}