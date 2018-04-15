package dao;

import org.skife.jdbi.v2.sqlobject.*;

public interface RatingsDAO {
	
	@SqlUpdate("CREATE TABLE RATINGS(rid INTEGER PRIMARY KEY AUTOINCREMENT," + 
			"fid TEXT," + 
			"email TEXT," + 
			"score INTEGER," + 
			"FOREIGN KEY(email) REFERENCES users(email));")
	void createTable();
	
	@SqlUpdate("DROP TABLE RATINGS")
	void dropTable();
	
}
