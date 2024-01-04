This project implements a simple school platform, where a student can log in and
check all the available classes that are listed on the database of the school.

The program implements CRUD operations on a MySQL database where the student can:

1. Log in
2. Sign Up
3. Check their details
4. Check their schedule
5. Add new classes
6. Remove classes
7. Check grades on past classes
8. Edit their details

For testing out the application in your environement you will need to:

1. Install MySql server and create your own database.
2. Change the details in the SQLCommands.java file to the ones that match with your db. (URL, dbusername, dbpassword, schema)
3. In your MySql you can run a backup query to set up the tables and some default values for testing, but you can further add other entries in each table. (The file is called backupfile.sql)