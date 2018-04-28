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
}
