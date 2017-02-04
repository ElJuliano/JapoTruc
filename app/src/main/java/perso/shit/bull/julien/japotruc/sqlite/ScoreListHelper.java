package perso.shit.bull.julien.japotruc.sqlite;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Julien on 04/02/2017.
 */

public class ScoreListHelper {

    private static ScoreListHelper helper = null;

    private ScoreListHelper() {

    };

    public ScoreListHelper getInstance() {
        if (helper == null) {
            helper = new ScoreListHelper();
        }
        return helper;
    }

    /**
     * Sort the list of Score in an ascending way, fro, the smaller to the bigger score
     * @param listScores
     * @return
     */
    public static List<ScoreBean> sortAscending(List<ScoreBean> listScores) {
        Collections.sort(listScores);
        return listScores;
    }

    /**
     * Sort the list of score bean from the bigger to the smaller score
     * @param listScores
     * @return
     */
    public static List<ScoreBean> sortDescending(List<ScoreBean> listScores) {
        Comparator<ScoreBean> comparator = new Comparator<ScoreBean>() {
            @Override
            public int compare(ScoreBean o1, ScoreBean o2) {
                return o2.getScore() - o1.getScore();
            }
        };
        Collections.sort(listScores, comparator);
        return listScores;
    }



}
