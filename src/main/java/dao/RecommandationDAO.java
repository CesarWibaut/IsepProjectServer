package dao;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface RecommandationDAO {
	@SqlUpdate("CREATE TABLE RECOMSTATS(total FLOAT, success FLOAT);")
	void createTable();
	
	@SqlUpdate("DROP TABLE RECOMSTATS")
	void dropTable();
	
	@SqlUpdate("INSERT INTO RECOMSTATS VALUES (0, 0)")
	void initTable();
	
	@SqlUpdate("UPDATE RECOMSTATS SET total = (Select SUM(total) from RECOMSTATS) +1")
	void addView();
	
	@SqlUpdate("UPDATE RECOMSTATS SET success = (Select SUM(success) from RECOMSTATS) +1")
	void addSuccess();
	
	@SqlQuery("SELECT SUM(success)/SUM(total) from RECOMSTATS")
	float getStats();
	
	@SqlQuery("UPDATE RECOMSTATS SET success=0, total=0")
	void reset();
}
