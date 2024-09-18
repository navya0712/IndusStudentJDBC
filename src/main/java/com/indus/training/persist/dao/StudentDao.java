package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Student;
import com.indus.training.persist.exceptions.InvalidStudentDataException;
import java.sql.SQLException;

/**
 * Interface for performing CRUD operations on Student entities using JDBC.
 */
public interface StudentDao {

	/**
	 * Inserts a Student into the database.
	 * 
	 * @param stuObj the Student object to be inserted.
	 * @return true if the insertion is successful; false otherwise.
	 * @throws SQLException             if a database access error occurs.
	 * @throws IllegalArgumentException if the provided Student} object is null.
	 */
	boolean insertStudent(Student stuObj) throws IllegalArgumentException, SQLException;

	/**
	 * Fetches a Student from the database based on the student ID.
	 * 
	 * @param studentId the ID of the student to be fetched.
	 * @return the Student object if found.
	 * @throws SQLException                if a database access error occurs.
	 * @throws InvalidStudentDataException if the student data is invalid or not
	 *                                     found.
	 */
	Student fetchStudent(int studentId) throws SQLException, InvalidStudentDataException;

	/**
	 * Deletes a Student from the database based on the student ID.
	 * 
	 * @param studentId the ID of the student to be deleted.
	 * @return true if the deletion is successful; false otherwise.
	 * @throws SQLException if a database access error occurs.
	 */
	boolean deleteStudent(int studentId) throws SQLException;

	/**
	 * Updates the first name of a Student in the database based on the student ID.
	 * 
	 * @param studentId    the ID of the student whose first name is to be updated.
	 * @param updFirstName the new first name to be set.
	 * @return true if the update is successful; false otherwise.
	 * @throws SQLException if a database access error occurs.
	 */
	boolean updateStudentFirstName(int studentId, String updFirstName) throws SQLException;

	/**
	 * Updates the last name of a Student in the database based on the student ID.
	 * 
	 * @param studentId   the ID of the student whose last name is to be updated.
	 * @param updLastName the new last name to be set.
	 * @return true if the update is successful; false otherwise.
	 * @throws SQLException if a database access error occurs.
	 */
	boolean updateStudentLastName(int studentId, String updLastName) throws SQLException;
}
