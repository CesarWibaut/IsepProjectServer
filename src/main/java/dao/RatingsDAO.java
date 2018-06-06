package dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import pojo.Rating;

public interface RatingsDAO {
	
	@SqlUpdate("CREATE TABLE RATINGS(rid INTEGER PRIMARY KEY AUTOINCREMENT," + 
			"fid TEXT," + 
			"email TEXT," + 
			"score INTEGER," + 
			"FOREIGN KEY(email) REFERENCES users(email));")
	void createTable();
	
	@SqlUpdate("DROP TABLE RATINGS")
	void dropTable();
	
	
	@SqlUpdate("INSERT INTO RATINGS (fid, email, score) VALUES ( :fid , :email , :score )")
	void insertRatings(@Bind("email") String email, @Bind("fid") String fid, @Bind("score") String score);
	
	
	@SqlQuery("Select * from ratings")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Rating> getAll();
	
	@SqlQuery("Select AVG(score) from ratings where fid = :id ")
	@RegisterMapperFactory(BeanMapperFactory.class)
	String getAvgScore(@Bind("id") String id);
	
	@SqlQuery("Select * from ratings where email = :email AND fid = :fid")
	@RegisterMapperFactory(BeanMapperFactory.class)
	Rating getExistingRating(@Bind("email") String email, @Bind("fid") String fid);

	@SqlUpdate("UPDATE ratings set score = :score where email = :email and fid = :fid")
	void updateRating(@Bind("email") String email, @Bind("fid") String fid, @Bind("score") String score);
	
	@SqlQuery("Select * from Ratings where email = :email ")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Rating> getMyRatings(@Bind("email") String email);
	
	@SqlQuery("Select * from Rating where email != :email AND fid in (Select fid from Ratings where email = :email)")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Rating> getSimilarRatings(@Bind("email") String email);
}
