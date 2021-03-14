package fr.isen.java2.db.daos;

import java.util.List;
import fr.isen.java2.db.entities.Person;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fr.isen.java2.db.entities.Person;


/**
 * PersonDao
 */
public class PersonDao {

    public List<Person> listPersons() {
		List<Person> listPerson = new ArrayList<>();
		try (Connection connection = DataSourceFactory.getDataSource().getConnection()) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet results = statement.executeQuery("SELECT * FROM person")) {
					while (results.next()) {
                        Person person = new Person(results.getInt("idperson"),
                                                    results.getString("lastname"),
                                                    results.getString("firstname"),
                                                    results.getString("nickname"),
                                                    results.getString("phone_number"),
                                                    results.getString("address"),
                                                    results.getString("email_address"),
                                                    results.getDate("birth_date").toLocalDate());
						
						listPerson.add(person);
					}
					results.close();
					statement.close();
					connection.close();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return listPerson;
		//throw new RuntimeException("Method is not yet implemented");
	}

    public void addPerson(Person person) {
		try (Connection connection = DataSourceFactory.getDataSource().getConnection()) {
			String sqlQuery = "INSERT INTO person(lastname,firstname,nickname,phone_number," +
                                "address,email_address,birth_date)" + 
                                "VALUES(?,?,?,?,?,?,?)";
			try (PreparedStatement statement = connection.prepareStatement(
							sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, person.getLastName());
				statement.setString(2, person.getFirstName());
				statement.setString(3, person.getNickName());
				statement.setString(4, person.getPhoneNumber());
				statement.setString(5, person.getAddress());
                statement.setString(6, person.getEmailAddress());
                statement.setDate(7, Date.valueOf(person.getBirthDate()));
				statement.executeUpdate();
				connection.close();
			}
		}catch (SQLException e) {
			// Manage Exception
			e.printStackTrace();
		}
    }

    public void updatePerson(Integer id, Person person){
        try (Connection connection = DataSourceFactory.getDataSource().getConnection()) {
			String sqlQuery = "UPDATE person SET lastname = ?, firstname = ?, nickname = ?, phone_number = ?," + 
                            "address = ?, email_address = ?, birth_date = ? WHERE idperson = ?"; 
                                
			try (PreparedStatement statement = connection.prepareStatement(
							sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, person.getLastName());
				statement.setString(2, person.getFirstName());
				statement.setString(3, person.getNickName());
				statement.setString(4, person.getPhoneNumber());
				statement.setString(5, person.getAddress());
                statement.setString(6, person.getEmailAddress());
                statement.setDate(7, Date.valueOf(person.getBirthDate()));
                statement.setInt(8, id);
				statement.executeUpdate();
				connection.close();
			}
		}catch (SQLException e) {
			// Manage Exception
			e.printStackTrace();
		}
    }

    
    public void deletePerson(Person person){
        try (Connection connection = DataSourceFactory.getDataSource().getConnection()) {
			String sqlQuery = "DELETE FROM person WHERE idperson = ?"; 
                                
			try (PreparedStatement statement = connection.prepareStatement(
							sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
				statement.setInt(1, person.getId());
				statement.executeUpdate();
				connection.close();
			}
		}catch (SQLException e) {
			// Manage Exception
			e.printStackTrace();
		}
    }

    public void deletePerson(Integer id){
        try (Connection connection = DataSourceFactory.getDataSource().getConnection()) {
			String sqlQuery = "DELETE FROM person WHERE idperson = ?"; 
                                
			try (PreparedStatement statement = connection.prepareStatement(
							sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
				statement.setInt(1, id);
				statement.executeUpdate();
				connection.close();
			}
		}catch (SQLException e) {
			// Manage Exception
			e.printStackTrace();
		}
    }

}
