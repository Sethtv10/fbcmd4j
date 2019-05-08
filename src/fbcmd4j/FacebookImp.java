/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fbcmd4j;

import facebook4j.*;
import facebook4j.auth.AccessToken;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author sethtv10
 */
public class FacebookImp {
    private static final Logger logger = LogManager.getLogger(Fbcmd4j.class);
    
    Facebook facebook;
    
    public FacebookImp() throws FacebookException{
        facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAppId("778805912500264", "4b385cb266a7ac54ee4637d800bd9dad");
        String pageAccessToken =  "EAALEUeHDeCgBABUhbqaxNx5iTzmUMInhmQyZCSHmKBgWINaBpJInzdopHoo2EMcc7DvXRY7gDvsStf3BZALZBZChXYYDqkb6laPfpsTZA1knzXTWJSVktLJHqkHHGB9c3gsMFZCWg0AbRcZApMzIbokwdjmNoQU4JqwWtCT2vvaGJbY6YiaPGhmqIidmHFZAb8wANpMQHkmUBgZDZD";
        facebook.setOAuthAccessToken(new AccessToken(pageAccessToken, null));
        
        facebook.postStatusMessage("[Este es un mensaje Automatico desde Facebook4Java]");
        logger.info("inicializando app");
         
    }
    
    public void Publish(Facebook facebook,String Message) throws FacebookException, MalformedURLException, MalformedURLException, MalformedURLException{
         logger.info("publicando");
         facebook.postStatusMessage(Message);
         logger.info("publicado");
    
    }
   public void PublishURL(Facebook facebook) throws FacebookException, MalformedURLException{
       logger.info("publicando URL");
        PrivacyParameter privacy = new PrivacyBuilder().setValue(PrivacyType.ALL_FRIENDS).build();
        PostUpdate postUpdate = new PostUpdate(new URL("http://facebook4j.org"))
            .picture(new URL("http://facebook4j.org/images/hero.png"))
            .name("Facebook4J - A Java library for the Facebook Graph API")
            .caption("facebook4j.org")
            .description("Facebook4J is a Java library for the Facebook Graph API. This library provides the ease of use like Twitter4J. Facebook4J is an unofficial library.")
            .privacy(privacy);
        String postId = facebook.postFeed(postUpdate);
        logger.info("publicado URL");
   }
    
    public void getHome(Facebook facebook) throws FacebookException{
        ResponseList<Post> feeds = facebook.getHome();
        logger.info("Obteniendo Home");
             for (int i = 0; i < feeds.size(); i++) {
            Post post = feeds.get(i);
            String message = post.getMessage();
           
            System.out.println(message);
            PagableList<Comment> comments = post.getComments();
            String date = post.getCreatedTime().toString();
            String name = post.getFrom().getName();
            String id = post.getId();
             logger.info("Post No. "+ i );
        }  
        
    }
        
    public void getFeed(Facebook facebook, String Feed) throws FacebookException{
     ResponseList<Post> feeds = facebook.getFeed(Feed,
            new Reading().limit(25));
    logger.info("Obteniendo Feed: "+ Feed);

        for (int i = 0; i < feeds.size(); i++) {
            Post post = feeds.get(i);
            String message = post.getMessage();
            System.out.println(message);

            PagableList<Comment> comments = post.getComments();
            String date = post.getCreatedTime().toString();
            String name = post.getFrom().getName();
            String id = post.getId();
            logger.info("Post No. "+ i );
        }           
    }
    
}
