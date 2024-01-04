import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class SQLCommands {
	// Variables used throughout the class.
	private Connection connection = null;
	private boolean status = false;
	private int StudentID;
	private String FirstName;
	private String LastName;
	private String Address;
	private String PhoneNumber;
	private String Email;
	private Date BirthDate;
	private String schema = "abc_university_database";
	
	String URL = "jdbc:mysql://localhost:3306/" + schema;
	String dbusername = "root";
	String dbpassword = "root";
	
	public SQLCommands() {
		
	}
	
	public SQLCommands(String schemaName, int operation, String s1, String s2) {
		
		try {
			connection = DriverManager.getConnection(URL, dbusername, dbpassword);
			
			String sql = "Select * FROM student WHERE Email = '" + s1 + "';";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			if(result.next()) {
				StudentID = result.getInt("StudentID");
			}
			
			switch(operation) {
				case 1:
					LogIn(connection, s1, s2);
					break;
				default:
					break;
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The LogIn function
	 * @param c
	 * @throws SQLException
	 */
	
	public boolean LogIn(Connection c, String s1, String s2) throws SQLException {
		ArrayList <String> emails = new ArrayList<>();
		ArrayList <String> passwords = new ArrayList<>();
		
		String sql = "SELECT * FROM student";
		Statement statement = c.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		// Gets all the emails and passwords for the checking of the database
		while(result.next()) {
			emails.add(result.getString("Email"));
			passwords.add(result.getString("UserPassword"));
		}
		
		// Checks if the email and password match any combination in the database
		for(int i = 0; i < emails.size(); i++) {
			if(s1.compareTo(emails.get(i))==0) {
				if(s2.compareTo(passwords.get(i))==0) {
					status = true;
					UpdateUserInfo(s1);
				}
			}
		}
		
		return true;
	}
	
	/**
	 * The SignUp function
	 * @param c
	 * @throws SQLException
	 */
	public void SignUp(String FirstName, String LastName, String Address, String Email,
			String Password, String Birthday, String PhoneNumber) {
		Random r = new Random();
		String sql = "SELECT * FROM student";
		boolean done = false;
		int newStudentID = 0;
		
		Date birthDate = null;
		
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			ResultSet result = statement.executeQuery(sql);
			ArrayList <Integer> studentID = new ArrayList<>();
			
			// Adds all StudentIDs currently in the database into the arraylist studentID
			while(result.next()) {
				studentID.add(result.getInt("StudentID"));
			}
			
			// Searches through all StudentID-s and generates a new and unique studentID
			while(!done) {
				newStudentID = r.nextInt(89999)+10000;
				done = true;
				for(int i = 0; i < studentID.size(); i++) {
					if(newStudentID == studentID.get(i)) done = false;
				}
			}
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		birthDate = Date.valueOf(Birthday); // Formated birthday to the accepted format.
		String sqlInsert = "INSERT INTO student (StudentID, FirstName, LastName, Address, PhoneNumber, Email, BirthDate, UserPassword)"
				+ "VALUES (" + newStudentID + ", '" + FirstName + "', '"+LastName+"', '"+Address+"', '"+PhoneNumber+"', '"+Email+"', '"+birthDate+"', '"+Password+"');";
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			statement.executeUpdate(sqlInsert);
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Allows us to update a change made by the user.
	 * 
	 * @param email
	 * @throws SQLException
	 */
	public void UpdateUserInfo(String email) throws SQLException {
		String sql = "SELECT * FROM student WHERE StudentID = '" + StudentID + "'";
		Connection connection = DriverManager.getConnection(URL, dbusername, dbpassword);
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		if(result.next()) {
			StudentID = result.getInt("StudentID");
			FirstName = result.getString("FirstName");
			LastName = result.getString("LastName");
			Address = result.getString("Address");
			PhoneNumber = result.getString("PhoneNumber");
			BirthDate = result.getDate("BirthDate");
			Email = result.getString("Email");
		}
	}
	
	/**
	 * Returns the status if the user is connected or not.
	 * @return
	 */
	public boolean getStatus() {
		return status;
	}
	
	/**
	 * Returns the first name.
	 * @return
	 */
	public String getFirstName() {
		return FirstName;
	}
	
	/**
	 * Returns the last name.
	 * @return
	 */
	public String getLastName() {
		return LastName;
	}
	
	/**
	 * Returns the address.
	 * @return
	 */
	public String getAddress() {
		return Address;
	}
	
	/**
	 * Returns the email.
	 * @return
	 */
	public String getEmail() {
		return Email;
	}
	
	/**
	 * Returns the phone number.
	 * @return
	 */
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	
	/**
	 * Returns Student ID.
	 * @return
	 */
	public int getStudentID() {
		return StudentID;
	}
	
	/**
	 * Return the birthday.
	 * @return
	 */
	public String getBirthDate() {
		return ""+BirthDate;
	}
	/**
	 * Returns the course name of the Course ID passed to it.
	 * @param CourseID
	 * @return
	 */
	public String getCourseName(int CourseID) {
		String sql = "SELECT * FROM course WHERE CourseID = " + CourseID + ";";
		String CourseName = "";
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			ResultSet result = statement.executeQuery(sql); 
			
			if(result.next()) CourseName = result.getString("CourseName");
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return CourseName;
	}
	/**
	 * Get the Instructor/Professor name from the course table.
	 * @param CourseID
	 * @return
	 */
	public String getProfessorName(int CourseID) {
		String sql = "SELECT * FROM course WHERE CourseID = " + CourseID + ";";
		String InstructorName = "";
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			ResultSet result = statement.executeQuery(sql); 
			
			if(result.next()) InstructorName = result.getString("InstructorName");
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return InstructorName;
	}
	
	/**
	 * Generate All the tuples for the schedule of a particular student.
	 * 
	 * @return
	 */
	public Object[][] getTuples() {
		Object[][] tuple = null;
		int rows = 0;
		String command = "SELECT * FROM schedules WHERE StudentID = " + StudentID + ";";
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			ResultSet result = statement.executeQuery(command);
			while(result.next()) rows++;
			
			c = DriverManager.getConnection(URL, dbusername, dbpassword);
			statement = c.createStatement();
			result = statement.executeQuery(command);
			tuple = new Object[rows][4];
			int row = 0;
			
			while(result.next()) {
				tuple[row][0] = getCourseName(result.getInt("CourseID"));
				tuple[row][1] = result.getString("Start_Time");
				tuple[row][2] = result.getString("End_Time");
				tuple[row][3] = result.getString("Room_Number");
				row++;
			}
			
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tuple;
	}
	
	/**
	 * A method used to drop a class.
	 * 
	 * @return
	 */
	public Object[][] getDropTuples() {
		Object[][] tuple = null;
		int rows = 0;
		String command = "SELECT * FROM schedules WHERE StudentID = " + StudentID + ";";
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			ResultSet result = statement.executeQuery(command);
			while(result.next()) rows++;
			c = DriverManager.getConnection(URL, dbusername, dbpassword);
			statement = c.createStatement();
			result = statement.executeQuery(command);
			tuple = new Object[rows][3];
			int row = 0;
			
			while(result.next()) {
				tuple[row][0] = getCourseName(result.getInt("CourseID"));
				tuple[row][1] = result.getInt("CourseID");
				tuple[row][2] = getProfessorName(result.getInt("CourseID"));
				row++;
			}
			
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		return tuple;
	}
	
	/**
	 * Set the first name of the user.
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		String sql = "UPDATE student SET FirstName = '" + firstName + "' WHERE StudentID = " + StudentID + ";";
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			statement.executeUpdate(sql);
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the last name of the user.
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		String sql = "UPDATE student SET LastName = '" + lastName + "' WHERE StudentID = " + StudentID + ";";
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			statement.executeUpdate(sql);
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the address of the user.
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		String sql = "UPDATE student SET Address = '" + address + "' WHERE StudentID = " + StudentID + ";";
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			statement.executeUpdate(sql);
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * Sets the email of the user.
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		String sql = "UPDATE student SET Email = '" + email + "' WHERE StudentID = " + StudentID + ";";
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			statement.executeUpdate(sql);
			UpdateUserInfo(email);
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the phone number of the user.
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		String sql = "UPDATE student SET PhoneNumber = '" + phoneNumber + "' WHERE StudentID = " + StudentID + ";";
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			statement.executeUpdate(sql);
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the password of the user.
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		String sql = "UPDATE student SET UserPassword = '" + password + "' WHERE StudentID = " + StudentID + ";";
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			statement.executeUpdate(sql);
			UpdateUserInfo(password);
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the birthday of the user.
	 * 
	 * @param birthDay
	 */
	public void setBirthDay(String birthDay) {
		Date day = Date.valueOf(birthDay);
		String sql = "UPDATE student SET BirthDate = '" + day + "' WHERE StudentID = " + StudentID + ";";
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			statement.executeUpdate(sql);
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Removes a class from the schedule of a student.
	 * 
	 * @param ClassID
	 */
	public void removeClass(int ClassID) {
		String sqlCommand = "DELETE FROM schedules WHERE StudentID = " + StudentID + " AND CourseID = " + ClassID + ";";
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			statement.executeUpdate(sqlCommand);
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get all enrolled classes of a particular student.
	 * @return
	 */
	public int[] getAllEnrolledClasses() {
		
		int[] classID = null;
		int arrayLength = 0;
		int currIndex = 0;
		String sqlCommand = "SELECT * FROM schedules WHERE StudentID = " + StudentID + ";";
		
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			ResultSet result = statement.executeQuery(sqlCommand);
			while(result.next()) arrayLength++;
			classID = new int[arrayLength];
			
			c = DriverManager.getConnection(URL, dbusername, dbpassword);
			statement = c.createStatement();
			result = statement.executeQuery(sqlCommand);
			while(result.next()) {
				classID[currIndex] = result.getInt("CourseID");
				currIndex++;
			}
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return classID;
	}
	
	/**
	 * Gets all the tuples without the current enrolled classes.
	 * @return
	 */
	public Object[][] getAllRemainingClasses() {
		Object[][] classes = null;
		int[] enrolledClasses = getAllEnrolledClasses();
		int[] allClasses = null;
		int[] remainingClasses = null;
		int elements = 0;
		int index = 0;
		boolean exists = false;
		String sqlCommand = "SELECT * FROM course;";
		
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			ResultSet result = statement.executeQuery(sqlCommand);
			while(result.next()) {
				elements++;
			}
			allClasses = new int[elements];
			
			c = DriverManager.getConnection(URL, dbusername, dbpassword);
			statement = c.createStatement();
			result = statement.executeQuery(sqlCommand);
			while(result.next()) {
				allClasses[index] = result.getInt("CourseID");
				index++;
			}
			
			// Remaining classes holds the CourseID-s of the classes that the student
			// hasn't enrolled yet.
			
			remainingClasses = new int[allClasses.length - enrolledClasses.length];
			index = 0;
			for(int i = 0; i < allClasses.length; i++) {
				for(int j = 0; j < enrolledClasses.length; j++) {
					if(allClasses[i] == enrolledClasses[j]) exists = true;
				}
				if(!exists) {
					remainingClasses[index] = allClasses[i];
					index++;
				}
				exists = false;
			}
			
			classes = new Object[remainingClasses.length][6];
			for(int i = 0; i < remainingClasses.length; i++) {
				String sqlCommand2 = "SELECT * FROM course WHERE CourseID = " + remainingClasses[i] + ";";
				c = DriverManager.getConnection(URL, dbusername, dbpassword);
				statement = c.createStatement();
				result = statement.executeQuery(sqlCommand2);
				if(result.next()) {
					classes[i][0] = result.getInt("CourseID");
					classes[i][1] = result.getString("CourseName");
					classes[i][2] = result.getString("InstructorName");
					classes[i][3] = result.getString("StartTime");
					classes[i][4] = result.getString("EndTime");
					classes[i][5] = result.getString("RoomNumber");
				}
			}
			
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return classes;
	}
	
	/**
	 * Selects all the past courses that the student has taken and returns them.
	 * @return
	 */
	public Object[][] getPastEnrollment() {
		
		String sql = "SELECT * FROM enrollment WHERE StudentID = " + StudentID + ";";
		Object[][] tuples = null;
		int count = 0;
		int index = 0;
		
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				count++;
			}
			tuples = new Object[count][4];
			
			c = DriverManager.getConnection(URL, dbusername, dbpassword);
			statement = c.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()) {
				tuples[index][0] = getCourseName(result.getInt("CourseID"));
				tuples[index][1] = result.getInt("CourseID");
				tuples[index][2] = result.getString("Grade");
				tuples[index][3] = result.getString("SemesterAndYear");
				index++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tuples;
	}
	
	
	/**
	 * Add a new course/class to the schedule of the student.
	 * @param CourseID
	 */
	public void addClass(int CourseID) {
		String Start_Time = "";
		String End_Time = "";
		String Room_Number = "";
		
		String sql = "SELECT * FROM course WHERE CourseID = " + CourseID + ";";
		String sqlCommand = "INSERT INTO schedules(StudentID, CourseID, Start_Time, End_Time, Room_Number) "
				+ "VALUES (StudentID, CourseID, Start_Time, End_Time, Room_Number);";
		try {
			Connection c = DriverManager.getConnection(URL, dbusername, dbpassword);
			Statement statement = c.createStatement();
			ResultSet result = statement.executeQuery(sql);
			if(result.next()) {
				Start_Time = result.getString("StartTime");
				End_Time = result.getString("EndTime");
				Room_Number = result.getString("RoomNumber");
			}
			
			sqlCommand = "INSERT INTO schedules(StudentID, CourseID, Start_Time, End_Time, Room_Number) "
					+ "VALUES (" + StudentID + ", " + CourseID + ", '" + Start_Time + "', '" + End_Time + "', '" + Room_Number + "');";
			c = DriverManager.getConnection(URL, dbusername, dbpassword);
			statement = c.createStatement();
			statement.executeUpdate(sqlCommand);
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
