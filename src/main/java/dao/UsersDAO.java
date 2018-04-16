package dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import pojo.User;

public interface UsersDAO {
	
	@SqlUpdate("CREATE TABLE USERS(" + 
			"firstName TEXT NOT NULL," + 
			"lastName TEXT NOT NULL," + 
			"email TEXT PRIMARY KEY," + 
			"password TEXT NOT NULL);")
	void createTable();
	
	
	
	@SqlUpdate("DROP TABLE USERS")
	void dropTable();
	
	
	
	@SqlUpdate("Insert into users values ( :first , :last , :email , :password )")
	@RegisterMapperFactory(BeanMapperFactory.class)
	void insert(@Bind("first") String first, @Bind("last") String last, @Bind("email") String email, @Bind("password") String password);
	
	
	
	@SqlQuery("Select * from users")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<User> getAll();
	
	
	@SqlQuery("Select * from users where email = :email ")
	@RegisterMapperFactory(BeanMapperFactory.class)
	User get(@Bind("email") String email);

	
	@SqlQuery("Select * from users where email = :email and password = :password ")
	User login(@Bind("email") String email, @Bind("password") String password);
	
	@SqlQuery("Select firstName from users where email = :email")
	User getFirstName(@Bind("email") String email);
}
