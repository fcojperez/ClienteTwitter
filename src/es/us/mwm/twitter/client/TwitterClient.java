package es.us.mwm.twitter.client;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 *
 * @author afernandez
 */
public class TwitterClient {

    
    private static final String FRIENDS_TIMELINE_URI = "https://api.twitter.com/1.1/statuses/home_timeline.json";
    private static final String USER_TIMELINE_URI = "https://api.twitter.com/1.1/statuses/user_timeline.json";
    private static final String TRENDS_URI = "https://api.twitter.com/1.1/trends/place.json";
    private static final String POST_TWEET_URI = "https://api.twitter.com/1.1/statuses/update.json";
    private static int numeroDeLlamadas = 0;
    
    
    private Client client;

    public TwitterClient() {
        try {
            client = TwitterAuthorization.createClient();
        } catch (Exception ex) {
            Logger.getLogger(TwitterClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    
    public Response getFriendsTimeline() {
        final Response response = client.target(FRIENDS_TIMELINE_URI).request().get();
        if (response.getStatus() != 200) {
            String errorEntity = null;
            if (response.hasEntity()) {
                errorEntity = response.readEntity(String.class);
            }
            throw new RuntimeException("La petición a twitter no tuvo éxito. Código de respuesta: "
                    + response.getStatus() + ", razón: " + response.getStatusInfo().getReasonPhrase()
                    + ", entity: " + errorEntity);
        }
        return response;
    }
    
    
    public Response getUserTimeline(){
        System.out.println("Numero de llamadas: " + ++numeroDeLlamadas);
        final Response response = client.target(USER_TIMELINE_URI).request().get();
        if(response.getStatus() != 200){
            String errorEntity = null;
            if(response.hasEntity()){
                errorEntity = response.readEntity(String.class);
            }
            throw new RuntimeException("Request to Twitter was not succesful. Response code: "
            + response.getStatus() + " ,reason: " + response.getStatusInfo().getReasonPhrase()
            + " , entity: " + errorEntity);
        }
        return response;
    }
    public Response getTrends(String woid){
        final Response response = client.target(TRENDS_URI).queryParam("id", woid).request().get();
        if(response.getStatus() != 200){
            String errorEntity = null;
            if(response.hasEntity()){
                errorEntity = response.readEntity(String.class);
            }
            throw new RuntimeException("Request to Twitter was not succesful. Response code: "
            + response.getStatus() + " ,reason: " + response.getStatusInfo().getReasonPhrase()
            + " , entity: " + errorEntity);
        }
        return response;
    }
    
    public Response updateStatus(String status){
        MultivaluedMap<String, String> parametros = new MultivaluedHashMap<String, String>();
        parametros.add("status", status);
        final Response response = client.target(POST_TWEET_URI).request().post(Entity.form(parametros));
        if(response.getStatus() != 200){
            String errorEntity = null;
            if(response.hasEntity()){
                errorEntity = response.readEntity(String.class);
            }
            throw new RuntimeException("Request to Twitter was not succesful. Response code: "
            + response.getStatus() + " ,reason: " + response.getStatusInfo().getReasonPhrase()
            + " , entity: " + errorEntity);
        }
        return response;
    }
    
}
