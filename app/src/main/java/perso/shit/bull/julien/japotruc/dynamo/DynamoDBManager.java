package perso.shit.bull.julien.japotruc.dynamo;

import com.amazonaws.auth.CognitoCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import perso.shit.bull.julien.japotruc.dbbeans.ScoreMapping;

/**
 * Created by Julien on 10/01/2017.
 */

public class DynamoDBManager {

    private AmazonDynamoDBClient ddbClient;
    private DynamoDBMapper mapper;

    public DynamoDBManager(CognitoCredentialsProvider credentialsProvider) {
        ddbClient = new AmazonDynamoDBClient(credentialsProvider);
        ddbClient.setRegion(Region.getRegion(Regions.US_WEST_2));
        mapper = new DynamoDBMapper(ddbClient);
    }

    public AmazonDynamoDBClient getClient() {
        return this.ddbClient;
    }

    public DynamoDBMapper getMapper() {
        return this.mapper;
    }

    /**
     * Saves a ScoreBean object in the ScoreMapping Table
     * @param score
     */
    public void save(ScoreMapping score) {
        Logger.getAnonymousLogger().log(Level.INFO, "saving score");
        mapper.save(score);
    }

    /**
     * TODO : retrieve all scores from the dynamo DB and return them as a Map
     */
    public void retrieveAllScores() {
        Runnable runnable = new Runnable() {
            public void run() {
                ArrayList<String> list = new ArrayList<String>();
                list.add("score");
                ScanResult result = ddbClient.scan("ScoreMapping", list);
                System.out.println("#######"+result.getCount()+"############");
                ScoreMapping score = new ScoreMapping();
                score.setUser_id("ElJuliano");
                score.setScore(1000);
                System.out.println("User created");
                mapper.save(score);
                result = ddbClient.scan("ScoreMapping", list);
                System.out.println("#######"+result.getCount()+"############");
                System.out.println("#######"+result.getItems().toString()+"############");
            }
        };
        Thread mythread = new Thread(runnable);
        mythread.start();
    }

    /**TODO
     * Retrieve the list with all the scores done by the user
     * @param user_id
     */
    public void retrieveUserScores (String user_id){

    }

}
