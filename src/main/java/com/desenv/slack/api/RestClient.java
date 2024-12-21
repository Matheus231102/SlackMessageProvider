package com.desenv.slack.api;

import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

/**
 *
 * @author matheus-de-souza-badia
 */
public class RestClient implements Serializable {

    private final ApiRest apiRest;
    private String url;
    private String endpoint;
    private String redirectUrl;

    private RestClient(Builder builder) {
        this.url = builder.url;
        this.endpoint = builder.endpoint;
        this.redirectUrl = builder.redirectUrl;
        apiRest = new ApiRest(url);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Response get() {
        return apiRest.get(endpoint);
    }

    public Response get(MultiValuedMap<String, String> params) {
        return apiRest.get(endpoint, params);
    }

    public Response post(String body) {
        MultiValuedMap<String, String> params = new ArrayListValuedHashMap<>();
        Response response = apiRest.post(endpoint, params, body);
        return response;
    }

    public Response post(String body, MultiValuedMap<String, String> params) {
        Response response = apiRest.post(endpoint, params, body);
        return response;
    }

//    public Response postUpload(String endpoint, MultiValuedMap<String, Object> formData, MultiValuedMap<String, String> params) throws IOException {
//        return apiRest.postUpload(endpoint, params, formData);
//    }
//    
//    public Response postUpload(String endpoint, MultiValuedMap<String, Object> formData) throws IOException {
//        return apiRest.postUpload(endpoint, null, formData);
//    }
    public static class Builder {

        private String url;
        private String endpoint;
        private String redirectUrl;

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder endpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        public Builder redirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
            return this;
        }

        public RestClient build() {
            return new RestClient(this);
        }
    }
}
