package com.desenv.slack.controllers.enums;

/**
 *
 * @author matheus-de-souza-badia
 */
public enum ChannelEnum {
    WARNING("warning");
    
    private String name;
    
    private ChannelEnum(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
