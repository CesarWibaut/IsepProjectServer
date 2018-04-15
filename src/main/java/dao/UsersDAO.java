package dao;

import org.skife.jdbi.v2.sqlobject.*;

public interface UsersDAO {
	
	@SqlUpdate("CREATE TABLE USERS(" + 
			"firstName TEXT NOT NULL," + 
			"lastName TEXT NOT NULL," + 
			"email TEXT PRIMARY KEY," + 
			"password TEXT NOT NULL);")
	void createTable();
	
	@SqlUpdate("DROP TABLE USERS")
	void dropTable();
	
}
