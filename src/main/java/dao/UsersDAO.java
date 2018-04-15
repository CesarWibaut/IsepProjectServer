package dao;

import org.skife.jdbi.v2.sqlobject.*;

public interface UsersDAO {
	
	@SqlUpdate("CREATE TABLE USERS(uid INTEGER PRIMARY KEY AUTOINCREMENT," + 
			"firstName TEXT NOT NULL," + 
			"lastName TEXT NOT NULL," + 
			"email TEXT PRIMARY KEY," + 
			"password TEXT NOT NULL);")
	void createTable();
	
	
	
}
