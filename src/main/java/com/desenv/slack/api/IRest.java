package com.desenv.slack.api;

import jakarta.ws.rs.core.Response;
import org.apache.commons.collections4.MultiValuedMap;

/**
 *
 * @author matheus-de-souza-badia
 */

public interface IRest {

    Response get(String api);
    Response get(String api, MultiValuedMap<String, String> params);
    Response post(String api, String body);
    Response post(String api, MultiValuedMap<String, String> params, String body);
    Response put(String api, String body);
    Response put(String api, MultiValuedMap<String, String> params, String body);
    Response delete(String api);
    Response delete(String api, MultiValuedMap<String, String> params);
    
}