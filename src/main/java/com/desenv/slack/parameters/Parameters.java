package com.desenv.slack.parameters;

/**
 *
 * @author matheus-de-souza-badia
 */
public class Parameters {
    
    public static final String SYSTEM_DIRECTORY = System.getProperty("user.home").replace('\\', '/');
    public static final String VARIABLES_FILE_NAME = "variables.properties";
    public static final String PROJECT_PATH = "/NetBeansProjects/SlackEventMessageProvider/";
    
    public static final String VARIABLES_PROPERTIES_PATH = SYSTEM_DIRECTORY + PROJECT_PATH + VARIABLES_FILE_NAME; 
    
}
