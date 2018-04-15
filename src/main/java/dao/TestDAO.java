package dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
//import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
//import org.skife.jdbi.v2.tweak.BeanMapperFactory;
//
//
//
//import java.util.List;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import pojo.User;


public interface TestDAO {
	@SqlUpdate("CREATE TABLE USER(nom text);")
	void createTable();
	
	@SqlUpdate("insert into user values('coucou')")
	void insert();
	
	@SqlQuery("select count(*) from user")
	int get();
	
	@SqlQuery("select * from user")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<User> getAll();
	
//	@SqlQuery("select * from users")
//    @RegisterMapperFactory(BeanMapperFactory.class)
//    List<> all();

	
}