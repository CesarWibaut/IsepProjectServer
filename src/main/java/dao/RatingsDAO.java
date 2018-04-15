package dao;

import org.skife.jdbi.v2.sqlobject.*;

public interface RatingsDAO {
	
	@SqlUpdate("CREATE TABLE RATINGS(rid INTEGER PRIMARY KEY AUTOINCREMENT," + 
			"fid TEXT," + 
			"uid TEXT," + 
			"score INTEGER," + 
			"FOREIGN KEY(uid) REFERENCES users(uid));")
	void createTable();
	
	
	
}
