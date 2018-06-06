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

    public List<Integer> getRecommandation(String email) {
    	List<Rating> similarRatings = ratingsDao.getSimilarRatings(email);
    	List<Rating> myRatings = ratingsDao.getMyRatings(email);
    	List<String> closestsNeighbors = getClosestNeighbour(myRatings, similarRatings);
        return null;
    }
    
    public List<String> getClosestNeighbour(List<Rating> myRatings, List<Rating> similarRatings){
        List<String> res = new ArrayList<String>();
        HashMap<String, Integer> similarities = new HashMap<String, Integer>();
        for(Rating my : myRatings) {
        	for(Rating r : similarRatings) {
        		if(areClose(my, r)) {
        			similarities.put(r.getEmail(), similarities.get(r.getEmail())==null?1:similarities.get(r.getEmail())+1);
        		}
        	}
        }
    	return res;
    }
    
    private boolean areClose(Rating my, Rating r) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean closeRating(int source, int compare) {
    	return source-1 <= compare && source + 1 >= compare;
    }
    
}