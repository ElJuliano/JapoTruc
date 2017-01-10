package perso.shit.bull.julien.japotruc.dbbeans;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

/**
 * Created by Julien on 10/01/2017.
 */
@DynamoDBTable(tableName = "Scores")
public class Scores {

    private String user_id;

    private int score;

    @DynamoDBIndexRangeKey(attributeName = "")
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String id) {
        this.user_id = id;
    }

    @DynamoDBIndexHashKey(attributeName = "score")
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
