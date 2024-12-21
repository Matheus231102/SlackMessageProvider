package com.desenv.slack.api;

import java.util.Map;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
//import org.glassfish.jersey.media.multipart.FormDataMultiPart;
//import org.glassfish.jersey.media.multipart.MultiPartFeature;
//import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author matheus-de-souza-badia
 */
public class ApiRest implements IRest {

    private Client client;
    private WebTarget webTarget;

    private static final Logger LOG = LoggerFactory.getLogger(ApiRest.class.getName());

    public ApiRest(String url) {
        this.client = ClientBuilder.newClient();
        this.webTarget = this.client.target(url);
    }

//    public ApiRest(String url) {
//        TrustManager[] noopTrustManager = new TrustManager[]{
//            new X509TrustManager() {
//
//                @Override
//                public X509Certificate[] getAcceptedIssuers() {
//                    return null;
//                }
//
//                @Override
//                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
//                }
//
//                @Override
//                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
//                }
//            }
//        };
//
//        SSLContext sc;
//        try {
//            sc = SSLContext.getInstance("ssl");
//            sc.init(null, noopTrustManager, null);
//
    ////            this.client = ClientBuilder.newBuilder().sslContext(sc).build().register(LogRestFilter.class);
//            this.client = ClientBuilder.newBuilder().hostnameVerifier((hostname, session) -> true).sslContext(sc).build().register(LogRestFilter.class);
//            this.webTarget = this.client.target(url);
//        } catch (NoSuchAlgorithmException ex) {
//        } catch (KeyManagementException ex) {
//        }
//    }
    
    protected Invocation.Builder prepareRequest(String api, MultiValuedMap<String, String> params) {
        if (api != null) {
            webTarget = webTarget.path(api);
        }
        
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entries()) {
                webTarget = webTarget.queryParam(entry.getKey(), entry.getValue());
            }
        }
        webTarget.request().header("Content-Type", "application/json");
        return webTarget.request(MediaType.APPLICATION_JSON);
    }

//    protected Invocation prepareRequestToUpload(String api, MultiValuedMap<String, String> params, MultiValuedMap<String, Object> formData) throws IOException {
//        Client client = ClientBuilder.newBuilder()
//            .register(MultiPartFeature.class)
//            .build();
//        
//        // TODO: verificar como alterar dinâmicamente, a URL; bug serialização desnecessaria jersey
//        WebTarget webTarget = client.target("http://localhost:8080/MercadoShopee" + api);
    ////        webTarget.register(MultiPartFeature.class);
//
//        if (params != null && !params.isEmpty()) {
//            for (Map.Entry<String, String> entry : params.entries()) {
//                webTarget = webTarget.queryParam(entry.getKey(), entry.getValue());
//            }
//        }
//        
//        FormDataMultiPart formDataMultipart = new FormDataMultiPart();
//        
//        if (formData != null && !formData.isEmpty()) {
//            if (formData.entries() == null) {
//                throw new RuntimeException("Os valores dentro do formulário para upload estão vazios");
//            }
//            
//            for (Map.Entry<String, Object> entry : formData.entries()) {
////                    
//                if (entry.getValue() instanceof File file) {
//                    
//                    FileDataBodyPart fileDataBodyPart = new FileDataBodyPart(entry.getKey(), file);
//                    formDataMultipart.bodyPart(fileDataBodyPart);
//                    
//                } else if (entry.getValue() instanceof String string) {
//                    
//                    formDataMultipart.field(entry.getKey(), string);
//                    
//                } else {
//                    throw new UnsupportedOperationException("Tipo de Arquivo não permitido para criação do formulário para enviado do request: " + entry.getValue().getClass());
//                }
//            }
//                
//            Invocation.Builder request = webTarget.request(MediaType.APPLICATION_JSON);
//            return request.buildPost(Entity.entity(formDataMultipart, formDataMultipart.getMediaType()));
//        } else {
//            throw new RuntimeException("O formulário de envio para upload não pode ser vazio ou nulo");
//        }
//    } 
    
    public String getJson(String api, MultiValuedMap<String, String> params) {
        return get(api, params).readEntity(String.class);
    }

    @Override
    public Response get(String api) {
        return get(api, new ArrayListValuedHashMap<>());
    }

    @Override
    public Response get(String api, MultiValuedMap<String, String> params) {
        Invocation.Builder request = prepareRequest(api, params);
//        Invocation.Builder request = prepareRequestManual(api, params);
        System.out.println("Parameters: " + params);
        return request.get();
    }

    @Override
    public Response post(String api, String body) {
        return post(api, new ArrayListValuedHashMap<>(), body);
    }

    @Override
    public Response post(String api, MultiValuedMap<String, String> params, String body) {
        Invocation.Builder request = prepareRequest(api, params);
        return request.post(Entity.entity(body, MediaType.APPLICATION_JSON));
    }

//    public Response postUpload(String api, MultiValuedMap<String, String> params, MultiValuedMap<String, Object> formData) throws IOException  {
//       Invocation request = prepareRequestToUpload(api, params, formData);
//       return request.invoke(); 
//    }
    @Override
    public Response put(String api, String body) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response put(String api, MultiValuedMap<String, String> params, String body) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response delete(String api) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response delete(String api, MultiValuedMap<String, String> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
