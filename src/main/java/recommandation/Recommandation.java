package recommandation;

import java.util.*;
import dao.RatingsDAO;
import static api.BDDFactory.getDbi;
/**
 * Recommandation
 */
public class Recommandation {

    private static RatingsDAO ratingsDao = getDbi().open(RatingsDAO.class);  

    public static List<Integer> getRecommandation(String email) {
        return null;
    }

}