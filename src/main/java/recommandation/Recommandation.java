package recommandation;

import java.util.*;
import dao.RatingsDAO;
import pojo.Rating;

import static api.BDDFactory.getDbi;
/**
 * Recommandation
 */
public class Recommandation {

    private static RatingsDAO ratingsDao = getDbi().open(RatingsDAO.class);  

    public List<String> getRecommandation(String email) {
    	List<Rating> similarRatings = ratingsDao.getSimilarRatings(email);
    	System.out.println("SIMILAR " + similarRatings);
    	List<Rating> myRatings = ratingsDao.getMyRatings(email);
    	String closestNeighbor = getClosestNeighbour(myRatings, similarRatings);
    	List<String> res = ratingsDao.getRecommandations(closestNeighbor, email);
        return res;
    }
    
    private String getClosestNeighbour(List<Rating> myRatings, List<Rating> similarRatings){
        String res;
        HashMap<String, Integer> similarities = new HashMap<String, Integer>();
        for(Rating my : myRatings) {
        	for(Rating r : similarRatings) {
        		if(areClose(my, r)) {
        			similarities.put(r.getEmail(), similarities.get(r.getEmail())==null?1:similarities.get(r.getEmail())+1);
        		}
        	}
        }
        res = getList(similarities);
    	return res;
    }
    
    private String getList(HashMap<String, Integer> similarities) {
		int index = 0;
		int max = 0;
		int cpt = 0;
		for(int i : similarities.values()) {
			if(i>max) {
				max = i;
				index=cpt;
			}
			cpt++;
		}
		System.out.println(similarities);
		if(similarities.isEmpty()) {
			return null;
		}
		return (String) similarities.keySet().toArray()[index];
	}

	private boolean areClose(Rating my, Rating r) {
		if(my.getFid().equals(r.getFid())) {
			if(closeRatings(Integer.parseInt(my.getScore()), Integer.parseInt(r.getScore()))) {
				return true;
			}
		}
		return false;
	}

	private boolean closeRatings(int source, int compare) {
    	return source-1 <= compare && source + 1 >= compare;
    }
    
}