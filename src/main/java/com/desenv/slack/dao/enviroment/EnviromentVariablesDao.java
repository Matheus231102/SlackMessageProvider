package com.desenv.slack.dao.enviroment;

import com.desenv.slack.interfaces.EnviromentVariable;
import com.desenv.slack.models.enviroment.EnviromentVariables;
import com.desenv.slack.parameters.Parameters;

/**
 *
 * @author matheus-de-souza-badia
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnviromentVariablesDao {
    
    private static final Logger LOG = LogManager.getLogger(EnviromentVariablesDao.class.getName());
    
    public static EnviromentVariables loadVariables() {
        try {
            EnviromentVariables enviromentVariables = new EnviromentVariables();
            String propertiesPath = Parameters.VARIABLES_PROPERTIES_PATH;

            return readVariables(enviromentVariables, propertiesPath);
        } catch (Exception exception) {
            LOG.error("Ocorreu um erro ao ler as variáveis de ambiente: {}", exception);
        }
        return null;
    }

    private static EnviromentVariables readVariables(EnviromentVariables enviromentVariables, String propertiesPath) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(propertiesPath)) {
            properties.load(fileInputStream);
        }
        
        /**
         * Código para carregar variáveis mais rapidamente
         */
        
        for (Field field : enviromentVariables.getClass().getDeclaredFields()) {
            EnviromentVariable enviromentVariable = field.getDeclaredAnnotation(EnviromentVariable.class);
            
            
            
            
            
        }
        
        
        enviromentVariables.setWarningChannelWebHook(properties.getProperty("warning.channel.webhook"));
        return enviromentVariables;
    }

}


