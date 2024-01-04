import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInPanel extends JPanel implements ActionListener {
	
	// Variables used throughout this class.
	
	SQLCommands sql = null;
	Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	
	private String userEmail;
	private String userPassword;
	private String FirstName;
	private String LastName;
	private String Address;
	private String PhoneNumber;
	private String Birthday;
	private int StudentID;
	
	JTextField text1;
	JTextField text2;
	JTextField textDrop;
	
	JButton button = null;
	JButton buttonEdit = null;
	JButton buttonSchedule = null;
	JButton buttonEnrollment = null;
	JButton buttonUpdate = null;
	JButton buttonEditSchedule = null;
	JButton buttonSignUp = null;
	JButton buttonSignUpProfessor = null;
	JButton buttonSubmit = null;
	JButton buttonSubmitProfessor = null;
	JButton buttonGoBack = null;
	JButton buttonBack = null;
	JButton buttonDrop = null;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton buttonGoBackSchedule = null;
	JButton buttonDropClass = null;
	JButton buttonAddClass = null;
	
	JTextField textField1;
	JTextField textField2;
	JTextField textField3; 
	JTextField textField4; 
	JTextField textField5; 
	JTextField textField6;
	JTextField textField7; 

	/**
	 * Log-In panel draws the GUI when the user is logging in the page.
	 */
	public LogInPanel() {
		
		JLabel label1 = new JLabel();
		label1.setBounds(75, 100, 650, 50);
		label1.setText(" Welcome to the ABC University Interface");
		label1.setFont(new Font("Times New Roman", Font.BOLD, 33));
		
		JLabel label2 = new JLabel();
		label2.setBounds(325, 200, 300, 50);
		label2.setText("Continue As");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		button1 = new JButton("Student");
		button2 = new JButton("Professor");
		button3 = new JButton("Administrator");
		
		button1.setBounds(75, 300, 200, 50);
		button2.setBounds(275, 300, 200, 50);
		button3.setBounds(475, 300, 200, 50);
		
		button1.setFocusable(false);
		button2.setFocusable(false);
		button3.setFocusable(false);
		
		button1.setBackground(Color.LIGHT_GRAY);
		button2.setBackground(Color.LIGHT_GRAY);
		button3.setBackground(Color.LIGHT_GRAY);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
		this.add(label1);
		this.add(label2);
		this.add(label2);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	/**
	 * LogIn GUI page element for students.
	 */
	public void LogIn() {
		
		JLabel label = new JLabel();
		label.setText("Log In Page");
		label.setBounds(50, 25, 300, 75);
		label.setFont(new Font("Times New Roman", Font.BOLD, 48));
		
		JLabel label1 = new JLabel();
		label1.setBounds(50, 100, 250, 50);
		label1.setText("Enter Email");
		label1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		text1 = new JTextField();
		text1.setBounds(50, 150, 250, 50);
		text1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel label2 = new JLabel();
		label2.setBounds(50, 200, 250, 50);
		label2.setText("Enter Password");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		text2 = new JTextField();
		text2.setBounds(50, 250, 250, 50);
		text2.setFont(new Font("Arial", Font.PLAIN, 20));
		
		button = new JButton("Submit");
		button.setBounds(75, 310, 200, 50);
		button.setFocusable(false);
		button.setBackground(Color.LIGHT_GRAY);
		button.addActionListener(this);
		
		JLabel label3 = new JLabel();
		label3.setBounds(50, 380, 350, 20);
		label3.setText("If you don't have an account, click the Sign Up button");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		buttonSignUp = new JButton("Sign Up");
		buttonSignUp.setBounds(400, 380, 100, 20);
		buttonSignUp.setFocusable(false);
		buttonSignUp.setBackground(Color.LIGHT_GRAY);
		buttonSignUp.addActionListener(this);
		
		this.removeAll();
		this.repaint();
		this.revalidate();
		this.add(label);
		this.add(label1);
		this.add(text1);
		this.add(label2);
		this.add(text2);
		this.add(button);
		this.add(label3);
		this.add(buttonSignUp);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	/**
	 * Log In GUI element for professors.
	 */
	public void LogInProfessor() {
		
		JLabel label = new JLabel();
		label.setText("Instructor Log-In Page");
		label.setBounds(50, 25, 350, 50);
		label.setFont(new Font("Times New Roman", Font.BOLD, 35));
		
		JLabel label1 = new JLabel();
		label1.setBounds(50, 100, 250, 50);
		label1.setText("Enter Email");
		label1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		text1 = new JTextField();
		text1.setBounds(50, 150, 250, 50);
		text1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel label2 = new JLabel();
		label2.setBounds(50, 200, 250, 50);
		label2.setText("Enter Password");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		text2 = new JTextField();
		text2.setBounds(50, 250, 250, 50);
		text2.setFont(new Font("Arial", Font.PLAIN, 20));
		
		buttonSubmitProfessor = new JButton("Submit");
		buttonSubmitProfessor.setBounds(75, 310, 200, 50);
		buttonSubmitProfessor.setFocusable(false);
		buttonSubmitProfessor.setBackground(Color.LIGHT_GRAY);
		buttonSubmitProfessor.addActionListener(this);
		
		JLabel label3 = new JLabel();
		label3.setBounds(50, 380, 350, 20);
		label3.setText("If you don't have an account, click the Sign Up button");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		buttonSignUpProfessor = new JButton("Sign Up");
		buttonSignUpProfessor.setBounds(400, 380, 100, 20);
		buttonSignUpProfessor.setFocusable(false);
		buttonSignUpProfessor.setBackground(Color.LIGHT_GRAY);
		buttonSignUpProfessor.addActionListener(this);
		
		this.removeAll();
		this.repaint();
		this.revalidate();
		this.add(label);
		this.add(label1);
		this.add(text1);
		this.add(label2);
		this.add(text2);
		this.add(buttonSubmitProfessor);
		this.add(label3);
		this.add(buttonSignUpProfessor);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	/**
	 * Populate and display all the information of the Student.
	 * 
	 * @param StudentID
	 * @param FirstName
	 * @param LastName
	 * @param Email
	 * @param Address
	 * @param PhoneNumber
	 * @param BirthDate
	 */
	
	public void StudentInformation(int StudentID, String FirstName, String LastName, 
										String Email, String Address, String PhoneNumber, String BirthDate) {
		
		JLabel labelFirstName = new JLabel();
		labelFirstName.setBounds(20, 20, 500, 50);
		labelFirstName.setFont(new Font("Times New Roman", Font.BOLD, 30));
		labelFirstName.setText("First Name: " + FirstName);
		
		JLabel labelLastName = new JLabel();
		labelLastName.setBounds(20, 70, 500, 50);
		labelLastName.setFont(new Font("Times New Roman", Font.BOLD, 30));
		labelLastName.setText("Last Name: " + LastName);
		
		JLabel labelStudentID = new JLabel();
		labelStudentID.setBounds(20, 120, 500, 50);
		labelStudentID.setFont(new Font("Times New Roman", Font.BOLD, 30));
		labelStudentID.setText("StudentID: " + StudentID);
		
		JLabel labelPhoneNumber = new JLabel();
		labelPhoneNumber.setBounds(20, 170, 500, 50);
		labelPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 30));
		labelPhoneNumber.setText("Phone Number: " + PhoneNumber);
		
		JLabel labelEmail = new JLabel();
		labelEmail.setBounds(20, 220, 500, 50);
		labelEmail.setFont(new Font("Times New Roman", Font.BOLD, 30));
		labelEmail.setText("Email: " + Email);
		
		JLabel labelBirthDate = new JLabel();
		labelBirthDate.setBounds(20, 270, 500, 50);
		labelBirthDate.setFont(new Font("Times New Roman", Font.BOLD, 30));
		labelBirthDate.setText("Date of Birth: " + BirthDate);
		
		JLabel labelAddress = new JLabel();
		labelAddress.setBounds(20, 320, 500, 50);
		labelAddress.setFont(new Font("Times New Roman", Font.BOLD, 30));
		labelAddress.setText("Address: " + Address);
		
		buttonEdit = new JButton("Edit Details");
		buttonSchedule = new JButton("See Schedule");
		buttonEnrollment = new JButton("Course History");

		buttonEdit.setBounds(530, 50, 200, 50);
		buttonSchedule.setBounds(530, 100, 200, 50);
		buttonEnrollment.setBounds(530, 150, 200, 50);
		
		buttonEdit.setFocusable(false);
		buttonSchedule.setFocusable(false);
		buttonEnrollment.setFocusable(false);
		
		buttonEdit.setBackground(Color.LIGHT_GRAY);
		buttonSchedule.setBackground(Color.LIGHT_GRAY);
		buttonEnrollment.setBackground(Color.LIGHT_GRAY);
		
		buttonEdit.addActionListener(this);
		buttonSchedule.addActionListener(this);
		buttonEnrollment.addActionListener(this);
		
		this.add(labelFirstName);
		this.add(labelLastName);
		this.add(labelStudentID);
		this.add(labelEmail);
		this.add(labelPhoneNumber);
		this.add(labelAddress);
		this.add(labelBirthDate);
		this.add(buttonEdit);
		this.add(buttonSchedule);
		this.add(buttonEnrollment);
	}
	
	/**
	 * Allow the user to edit their personal details in the GUI.
	 */
	
	public void EditDetails() {
		
		this.removeAll();
		this.repaint();
		this.revalidate();
		
		JLabel label1 = new JLabel();
		label1.setBounds(50, 0, 500, 50);
		label1.setText("Enter all the details you want to modify");
		label1.setFont(new Font("Times New Roman", Font.BOLD, 29));
		label1.setBorder(border);
		
		JLabel label2 = new JLabel();
		label2.setBounds(50, 50, 250, 50);
		label2.setText("New First Name");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		textField1 = new JTextField();
		textField1.setBounds(300, 50, 250, 50);
		textField1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel label3 = new JLabel();
		label3.setBounds(50, 100, 250, 50);
		label3.setText("New Last Name");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		textField2 = new JTextField();
		textField2.setBounds(300, 100, 250, 50);
		textField2.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel label4 = new JLabel();
		label4.setBounds(50, 150, 250, 50);
		label4.setText("New Email");
		label4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		textField3 = new JTextField();
		textField3.setBounds(300, 150, 250, 50);
		textField3.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel label5 = new JLabel();
		label5.setBounds(50, 200, 250, 50);
		label5.setText("New Password");
		label5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		textField4 = new JTextField();
		textField4.setBounds(300, 200, 250, 50);
		textField4.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel label6 = new JLabel();
		label6.setBounds(50, 250, 250, 50);
		label6.setText("New Address");
		label6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		textField5 = new JTextField();
		textField5.setBounds(300, 250, 250, 50);
		textField5.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel label7 = new JLabel();
		label7.setBounds(50, 300, 250, 50);
		label7.setText("New Birthday (yyyy-mm-dd)");
		label7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		textField6 = new JTextField();
		textField6.setBounds(300, 300, 250, 50);
		textField6.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel label8 = new JLabel();
		label8.setBounds(50, 350, 250, 50);
		label8.setText("New Phone Number");
		label8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		textField7 = new JTextField();
		textField7.setBounds(300, 350, 250, 50);
		textField7.setFont(new Font("Arial", Font.PLAIN, 20));
		
		buttonUpdate = new JButton("Update");
		buttonUpdate.setBounds(600, 410, 100, 30);
		buttonUpdate.setFocusable(false);
		buttonUpdate.setBackground(Color.LIGHT_GRAY);
		buttonUpdate.addActionListener(this);
		
		buttonBack = new JButton("Go Back");
		buttonBack.setBounds(500, 410, 100, 30);
		buttonBack.setFocusable(false);
		buttonBack.setBackground(Color.LIGHT_GRAY);
		buttonBack.addActionListener(this);
		
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		this.add(label5);
		this.add(label6);
		this.add(label7);
		this.add(label8);
		this.add(textField1);
		this.add(textField2);
		this.add(textField3);
		this.add(textField4);
		this.add(textField5);
		this.add(textField6);
		this.add(textField7);
		this.add(buttonUpdate);
		this.add(buttonBack);
	}
	
	/**
	 * Populate the schedule in the GUI.
	 */
	public void Schedule() {
		
		// Refresh the page
		this.removeAll();
		this.repaint();
		this.revalidate();
		
		JLabel label1 = new JLabel();
		label1.setText("Student Name: " + FirstName + " " + LastName);
		label1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label1.setBounds(5, 5, 350, 30);
		label1.setBorder(border);
		
		JLabel label2 = new JLabel();
		label2.setText("Student ID: " + StudentID);
		label2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label2.setBounds(5, 40, 350, 30);
		label2.setBorder(border);
		
		buttonEditSchedule = new JButton("Add Class");
		buttonEditSchedule.setBounds(600, 410, 100, 30);
		buttonEditSchedule.setFocusable(false);
		buttonEditSchedule.setBackground(Color.LIGHT_GRAY);
		buttonEditSchedule.addActionListener(this);
		
		buttonBack = new JButton("Go Back");
		buttonBack.setBounds(600, 370, 100, 30);
		buttonBack.setFocusable(false);
		buttonBack.setBackground(Color.LIGHT_GRAY);
		buttonBack.addActionListener(this);
		
		buttonDrop = new JButton("Drop");
		buttonDrop.setBounds(600, 330, 100, 30);
		buttonDrop.setFocusable(false);
		buttonDrop.setBackground(Color.LIGHT_GRAY);
		buttonDrop.addActionListener(this);
		
		JTable table;
		JScrollPane scroll;

		String[] attributeNames = {"Course Name", "Start Time", "End Time", "Room Number"};
		Object[][] tuples;
		
		sql = new SQLCommands("abc_university_database", 1, userEmail, userPassword);
		tuples = sql.getTuples();
		
		table = new JTable(tuples, attributeNames);
		table.setFillsViewportHeight(true);
		scroll = new JScrollPane(table);
		scroll.setBounds(10, 80, 500, 300);
		
		
		this.add(scroll);
		this.add(label1);
		this.add(label2);
		this.add(buttonDrop);
		this.add(buttonBack);
		this.add(buttonEditSchedule);
	}
	
	/**
	 * Sign Up method that fills up the SignUp GUI page.
	 */
	public void SignUp() {
		
		this.removeAll();
		this.repaint();
		this.revalidate();
		
		JLabel label1 = new JLabel();
		label1.setBounds(50, 0, 500, 50);
		label1.setText("Fill In All Spaces");
		label1.setFont(new Font("Times New Roman", Font.BOLD, 29));
		label1.setBorder(border);
		
		JLabel label2 = new JLabel();
		label2.setBounds(50, 50, 250, 50);
		label2.setText("First Name");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		textField1 = new JTextField();
		textField1.setBounds(300, 50, 250, 50);
		textField1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel label3 = new JLabel();
		label3.setBounds(50, 100, 250, 50);
		label3.setText("Last Name");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		textField2 = new JTextField();
		textField2.setBounds(300, 100, 250, 50);
		textField2.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel label4 = new JLabel();
		label4.setBounds(50, 150, 250, 50);
		label4.setText("Email");
		label4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		textField3 = new JTextField();
		textField3.setBounds(300, 150, 250, 50);
		textField3.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel label5 = new JLabel();
		label5.setBounds(50, 200, 250, 50);
		label5.setText("Password");
		label5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		textField4 = new JTextField();
		textField4.setBounds(300, 200, 250, 50);
		textField4.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel label6 = new JLabel();
		label6.setBounds(50, 250, 250, 50);
		label6.setText("Address");
		label6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		textField5 = new JTextField();
		textField5.setBounds(300, 250, 250, 50);
		textField5.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel label7 = new JLabel();
		label7.setBounds(50, 300, 250, 50);
		label7.setText("Birthday (yyyy-mm-dd)");
		label7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		textField6 = new JTextField();
		textField6.setBounds(300, 300, 250, 50);
		textField6.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel label8 = new JLabel();
		label8.setBounds(50, 350, 250, 50);
		label8.setText("Phone Number");
		label8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		textField7 = new JTextField();
		textField7.setBounds(300, 350, 250, 50);
		textField7.setFont(new Font("Arial", Font.PLAIN, 20));
		
		buttonSubmit = new JButton("Submit");
		buttonSubmit.setBounds(600, 410, 100, 30);
		buttonSubmit.setFocusable(false);
		buttonSubmit.setBackground(Color.LIGHT_GRAY);
		buttonSubmit.addActionListener(this);
		
		buttonGoBack = new JButton("Go Back");
		buttonGoBack.setBounds(500, 410, 100, 30);
		buttonGoBack.setFocusable(false);
		buttonGoBack.setBackground(Color.LIGHT_GRAY);
		buttonGoBack.addActionListener(this);
		
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		this.add(label5);
		this.add(label6);
		this.add(label7);
		this.add(label8);
		this.add(textField1);
		this.add(textField2);
		this.add(textField3);
		this.add(textField4);
		this.add(textField5);
		this.add(textField6);
		this.add(textField7);
		this.add(buttonSubmit);
		this.add(buttonGoBack);
	}
	
	/**
	 * Drop a class from the student schedule.
	 */
	public void DropClass() {
		this.removeAll();
		this.repaint();
		this.revalidate();
		
		JLabel label1 = new JLabel();
		label1.setBounds(20, 10, 300, 50);
		label1.setText("Instructions");
		label1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		
		JLabel label2 = new JLabel();
		label2.setBounds(20, 70, 500, 25);
		label2.setText("1. Select the CourseID you want to drop.");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel label3 = new JLabel();
		label3.setBounds(20, 95, 500, 25);
		label3.setText("2. Add it to the text field below the \"Drop\" button.");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel label4 = new JLabel();
		label4.setBounds(20, 120, 500, 25);
		label4.setText("3. Click the \"Drop\" button.");
		label4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		textDrop = new JTextField();
		textDrop.setBounds(550, 420, 100, 25);
		
		JTable table;
		JScrollPane scroll;

		String[] attributeNames = {"Course Name", "CourseID", "Instructor Name"};
		Object[][] tuples;
		
		sql = new SQLCommands("abc_university_database", 1, userEmail, userPassword);
		tuples = sql.getDropTuples();
		
		table = new JTable(tuples, attributeNames);
		table.setFillsViewportHeight(true);
		scroll = new JScrollPane(table);
		scroll.setBounds(20, 150, 500, 300);
		
		buttonGoBackSchedule = new JButton("Go Back");
		buttonDropClass = new JButton("Drop");
		
		buttonGoBackSchedule.setBounds(550, 350, 100, 25);
		buttonDropClass.setBounds(550, 385, 100, 25);
		
		buttonGoBackSchedule.setFocusable(false);
		buttonDropClass.setFocusable(false);
		
		buttonGoBackSchedule.setBackground(Color.LIGHT_GRAY);
		buttonDropClass.setBackground(Color.LIGHT_GRAY);
		
		buttonGoBackSchedule.addActionListener(this);
		buttonDropClass.addActionListener(this);
		
		this.add(buttonGoBackSchedule);
		this.add(buttonDropClass);
		this.add(textDrop);
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		this.add(scroll);
	}
	
	/**
	 * Add a new class to the student schedule.
	 */
	public void AddClass() {
		this.removeAll();
		this.repaint();
		this.revalidate();
		
		JLabel label1 = new JLabel();
		label1.setBounds(20, 10, 300, 50);
		label1.setText("Instructions");
		label1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		
		JLabel label2 = new JLabel();
		label2.setBounds(20, 70, 500, 25);
		label2.setText("1. Select the CourseID you want to add.");
		label2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel label3 = new JLabel();
		label3.setBounds(20, 95, 500, 25);
		label3.setText("2. Add it to the text field below the \"Add Class\" button.");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel label4 = new JLabel();
		label4.setBounds(20, 120, 500, 25);
		label4.setText("3. Click the \"Add Class\" button.");
		label4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel label5 = new JLabel();
		label5.setBounds(530, 150, 250, 25);
		label5.setText("Notice!");
		label5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel label6 = new JLabel();
		label6.setBounds(530, 175, 250, 25);
		label6.setText("This table displays only classes");
		label6.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel label7 = new JLabel();
		label7.setBounds(530, 200, 250, 25);
		label7.setText("that you aren't currently enrolled in!");
		label7.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		textDrop = new JTextField();
		textDrop.setBounds(550, 420, 100, 25);
		
		JTable table;
		JScrollPane scroll;

		String[] attributeNames = {"CourseID", "Course Name", "Instructor Name", "Start Time", "End Time", "Room Number"};
		Object[][] tuples;
		
		sql = new SQLCommands("abc_university_database", 1, userEmail, userPassword);
		tuples = sql.getAllRemainingClasses();
		
		table = new JTable(tuples, attributeNames);
		table.setFillsViewportHeight(true);
		scroll = new JScrollPane(table);
		scroll.setBounds(20, 150, 500, 300);
		
		buttonGoBackSchedule = new JButton("Go Back");
		buttonAddClass = new JButton("Add Class");
		
		buttonGoBackSchedule.setBounds(550, 350, 100, 25);
		buttonAddClass.setBounds(550, 385, 100, 25);
		
		buttonGoBackSchedule.setFocusable(false);
		buttonAddClass.setFocusable(false);
		
		buttonGoBackSchedule.setBackground(Color.LIGHT_GRAY);
		buttonAddClass.setBackground(Color.LIGHT_GRAY);
		
		buttonGoBackSchedule.addActionListener(this);
		buttonAddClass.addActionListener(this);
		 
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		this.add(label5);
		this.add(label6);
		this.add(label7);
		this.add(buttonGoBackSchedule);
		this.add(buttonAddClass);
		this.add(textDrop);
		this.add(scroll);
	}
	
	/**
	 * Populate the table with the information from past courses.
	 */
	public void PastCourses() {
		this.removeAll();
		this.repaint();
		this.revalidate();
		
		JLabel label1 = new JLabel();
		label1.setBounds(20, 20, 250, 50);
		label1.setText("Course History");
		label1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		
		JTable table = null;
		JScrollPane scroll = null;
		
		String[] banner = {"Course Name", "CourseID", "Grade", "Course Semester"};
		Object[][] tuples = null;
				
		sql = new SQLCommands("abc_university_database", 1, userEmail, userPassword);
		tuples = sql.getPastEnrollment();
		
		table = new JTable(tuples, banner);
		table.setFillsViewportHeight(true);
		scroll = new JScrollPane(table);
		scroll.setBounds(20, 80, 500, 300);
		
		buttonBack = new JButton("Go Back");
		buttonBack.setBounds(600, 370, 100, 30);
		buttonBack.setFocusable(false);
		buttonBack.setBackground(Color.LIGHT_GRAY);
		buttonBack.addActionListener(this);
		
		this.add(label1);
		this.add(scroll);
		this.add(buttonBack);
	}
	
	
	
	public void next(int choice) {
		switch(choice) {
			case 1:
				LogIn();
				break;
			case 2:
				SignUp();
				break;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == button) {
			sql = new SQLCommands("abc_university_database", 1, text1.getText(), text2.getText());
			userEmail = text1.getText();
			userPassword = text2.getText();
			StudentID = sql.getStudentID();
			FirstName = sql.getFirstName();
			LastName = sql.getLastName();
			
			if(sql.getStatus()) {
				this.removeAll();
				
				// Refresh the page
				this.repaint();
				this.revalidate();
				
				StudentInformation(sql.getStudentID(), sql.getFirstName(), sql.getLastName(), 
						sql.getEmail(), sql.getAddress(), sql.getPhoneNumber(), sql.getBirthDate());
				
				// ----------------
			}
			else {
				
				this.repaint();
				this.revalidate();
				
				JLabel labelSuccess = new JLabel();
				labelSuccess.setBounds(400, 50, 350, 50);
				labelSuccess.setText("Could't Log In!");
				labelSuccess.setFont(new Font("Times New Roman", Font.BOLD, 30));
				labelSuccess.setForeground(Color.red);
				this.add(labelSuccess);
				this.setVisible(true);
			}
		}
		
		if(e.getSource() == buttonEdit) {
			EditDetails();
		}
		
		if(e.getSource() == buttonSchedule) {
			Schedule();
		}
		
		if(e.getSource() == buttonUpdate) {
			
			sql = new SQLCommands("abc_university_database", 1, userEmail, userPassword);
			
			if(textField1.getText().compareTo("") != 0) {
				FirstName = textField1.getText();
				sql.setFirstName(FirstName);
			}
			if(textField2.getText().compareTo("") != 0) {
				LastName = textField2.getText();
				sql.setLastName(LastName);
			}
			if(textField3.getText().compareTo("") != 0) {
				userEmail = textField3.getText();
				sql.setEmail(userEmail);
			}
			if(textField4.getText().compareTo("") != 0) {
				userPassword = textField4.getText();
				sql.setPassword(userPassword);
			}
			if(textField5.getText().compareTo("") != 0) {
				Address = textField5.getText();
				sql.setAddress(Address);
			}
			if(textField6.getText().compareTo("") != 0) {
				Birthday = textField6.getText();
				sql.setBirthDay(Birthday);
			}
			if(textField7.getText().compareTo("") != 0) {
				PhoneNumber = textField7.getText();
				sql.setPhoneNumber(PhoneNumber);
			}
		}
		
		if(e.getSource() == buttonBack) {
			sql = new SQLCommands("abc_university_database", 1, userEmail, userPassword);
			this.removeAll();
			
			// Refresh the page
			this.repaint();
			this.revalidate();
			
			StudentInformation(sql.getStudentID(), sql.getFirstName(), sql.getLastName(), 
					sql.getEmail(), sql.getAddress(), sql.getPhoneNumber(), sql.getBirthDate());
			
		}
		
		if(e.getSource() == button1 || e.getSource() == buttonGoBack) {
			next(1);
		}
		if(e.getSource() == buttonSignUp) {
			next(2);
		}
		if(e.getSource() == buttonSubmit) {
			if(textField1.getText().compareTo("") != 0 && textField2.getText().compareTo("") != 0 && textField3.getText().compareTo("") != 0 && textField4.getText().compareTo("") != 0 && textField5.getText().compareTo("") != 0 && textField6.getText().compareTo("") != 0 && textField7.getText().compareTo("") != 0) {
				sql = new SQLCommands();
				sql.SignUp(textField1.getText(), textField2.getText(), textField5.getText(), textField3.getText(), textField4.getText(), textField6.getText(), textField7.getText());
				next(1);
			}
		}
		if(e.getSource() == buttonDrop) { 
			DropClass();
		}
		if(e.getSource() == buttonGoBackSchedule) {
			Schedule();
		}
		if(e.getSource() == buttonDropClass) {
			sql = new SQLCommands("abc_university_database", 1, userEmail, userPassword);
			sql.removeClass(Integer.parseInt(textDrop.getText()));
			DropClass();
		}
		if(e.getSource() == buttonEditSchedule) {
			AddClass();
		}
		if(e.getSource() == buttonAddClass) {
			sql = new SQLCommands("abc_university_database", 1, userEmail, userPassword);
			String CourseID = textDrop.getText();
			sql.addClass(Integer.parseInt(CourseID));
			AddClass();
		}
		if(e.getSource() == buttonEnrollment) {
			PastCourses();
		}
		
		if(e.getSource() == button2) {
			LogInProfessor();
		}
	}
}
