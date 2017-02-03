package perso.shit.bull.julien.japotruc.sqlite;

/**
 * Created by Julien on 03/02/2017.
 */

public class ScoreBean {

    private Integer id;
    private String userName;
    private Integer score;

    public ScoreBean(Integer key, String user, Integer sc) {
        this.id = key;
        userName = user;
        score = sc;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



}
