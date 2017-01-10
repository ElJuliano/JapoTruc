package perso.shit.bull.julien.japotruc.dynamo;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.auth.CognitoCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import perso.shit.bull.julien.japotruc.dbbeans.Scores;

/**
 * Created by Julien on 10/01/2017.
 */

public class DynamoDBManager {

    private AmazonDynamoDBClient ddbClient;
    private DynamoDBMapper mapper;

    public DynamoDBManager(CognitoCredentialsProvider credentialsProvider) {
        ddbClient = new AmazonDynamoDBClient(credentialsProvider);
        mapper = new DynamoDBMapper(ddbClient);
    }

    public AmazonDynamoDBClient getClient() {
        return this.ddbClient;
    }

    public DynamoDBMapper getMapper() {
        return this.mapper;
    }

    public void save(Scores score) {
        Logger.getAnonymousLogger().log(Level.INFO, "saving score");
        mapper.save(score);
    }

    public void retrieveTable(String tableName) {

    }

}
