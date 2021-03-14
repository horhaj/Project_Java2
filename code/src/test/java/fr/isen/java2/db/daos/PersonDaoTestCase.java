package fr.isen.java2.db.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.isen.java2.db.entities.Person;

/**
 * PersonDatTestCase
 */
public class PersonDaoTestCase {

    //private PersonDao personDao = new PersonDao();


	@Before
	public void initDb() throws Exception {
		Connection connection = DataSourceFactory.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(
				"CREATE TABLE IF NOT EXISTS person (\r\n"
				+ "  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\r\n" + "  lastname VARCHAR(45) NOT NULL,\r\n"
				+ "  firstname VARCHAR(45) NOT NULL,\r\n" + "  nickname VARCHAR(45) NOT NULL,\r\n"
				+ "  phone_number VARCHAR(15) NULL,\r\n" + "  address VARCHAR(200) NULL,\r\n"
				+ "  email_address VARCHAR(150) NULL,\r\n" + " birth_date DATE NULL);");

		stmt.executeUpdate("DELETE FROM person");
		stmt.executeUpdate("INSERT INTO person(id,lastname, firstname, nickname, phone_number, address, email_address, birth_date) "
				+ "VALUES (1, 'last name 1','first name 1','nick name 1','phone 1', 'address 1', 'email_address 1','1997-11-26 12:00:00.000')");
		stmt.executeUpdate("INSERT INTO person(id,lastname, firstname, nickname, phone_number, address, email_address, birth_date) "
				+ "VALUES (2, 'last name 2','first name 2','nick name 2','phone 2', 'address 2', 'email_address 2','1997-11-14 12:00:00.000')");
		stmt.executeUpdate("INSERT INTO person(id,lastname, firstname, nickname, phone_number, address, email_address, birth_date) "
				+ "VALUES (3, 'last name 3','first name 3','nick name 3','phone 3', 'address 3', 'email_address 3','1997-11-14 12:00:00.000')");
		stmt.close();
		connection.close();

	}
}