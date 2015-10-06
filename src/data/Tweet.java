package data;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class Tweet {
 
private final static String CONSUMER_KEY = "jQk9IITLDNRBnDL9No5NjNm8z";
private final static String CONSUMER_KEY_SECRET = "4fSjDDi0e5HdMEbsAqjOXGvcZBXoj4DDFUU9LPe14giaP66xFe";
String hashtag="#";
String replies="@";
public void start() throws TwitterException, IOException {
 ConfigurationBuilder builder = new ConfigurationBuilder();
 builder.setOAuthConsumerKey(CONSUMER_KEY);
 builder.setOAuthConsumerSecret(CONSUMER_KEY_SECRET);
 Configuration configuration = builder.build();
 TwitterFactory factory = new TwitterFactory(configuration);
 Twitter twitter = factory.getInstance();
 
 String accessToken = "3071228816-NdCqU95QonbptLK4wlv5OVmr6JwSm7N9WhxNork";
 String accessTokenSecret = "GyPjGchVIdH6GdkhwJXNVDW11zQdlVSaObzxl2U6Fqeq2";
 
 AccessToken oathAccessToken = new AccessToken(accessToken,accessTokenSecret);
 twitter.setOAuthAccessToken(oathAccessToken);
 Query query = new Query("lang:en");
 Date date = new Date();
 String modifiedDate= new SimpleDateFormat("20151006").format(date);
 query.setSince(modifiedDate);
 QueryResult result;
     do {
     result = twitter.search(query);
     List<Status> tweets = result.getTweets(); 
     for (Status tweet : tweets) {
    	  if(!tweet.isRetweet() && tweet.getText().indexOf('@')==-1 && tweet.getText().indexOf('#')==-1)
          System.out.println(tweet.getText());
          }
       } while ((query = result.nextQuery()) != null);

    }
public static void main(String[] args) throws Exception {
new Tweet().start();
    }

}