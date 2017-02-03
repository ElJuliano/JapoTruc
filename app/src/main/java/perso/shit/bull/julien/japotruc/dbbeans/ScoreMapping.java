package perso.shit.bull.julien.japotruc.dbbeans;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

/**
 * Created by Julien on 10/01/2017.
 */
@DynamoDBTable(tableName = "ScoreMapping")
public class ScoreMapping {

    private String user_id;

    private int score;

    @DynamoDBRangeKey(attributeName = "user_id")
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String id) {
        this.user_id = id;
    }

    @DynamoDBHashKey(attributeName = "score")
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
