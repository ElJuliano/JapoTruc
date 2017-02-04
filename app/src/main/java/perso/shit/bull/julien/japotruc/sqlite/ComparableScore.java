package perso.shit.bull.julien.japotruc.sqlite;

import java.io.Serializable;

/**
 * Created by Julien on 04/02/2017.
 */

public interface ComparableScore<T> extends Comparable<T>, Serializable {

    Integer getScore();
}
