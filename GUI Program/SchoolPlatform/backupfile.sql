USE abc_university_database;
DROP TABLE department, professor, student, course, enrollment, schedules;
CREATE TABLE student (
	StudentID INT NOT NULL,
    FirstName CHAR(20) NOT NULL,
    LastName CHAR(20) NOT NULL,
    Address CHAR(50) NOT NULL,
    PhoneNumber CHAR(10) NOT NULL UNIQUE,
    Email CHAR(50) NOT NULL UNIQUE,
    BirthDate DATE NOT NULL,
    UserPassword CHAR(50) NOT NULL,
    PRIMARY KEY(StudentID)
);

CREATE TABLE department(
	DepartmentID INT NOT NULL,
    DepartmentName CHAR(50) NOT NULL,
    PRIMARY KEY(DepartmentID)
);

CREATE TABLE professor (
	ProfessorID INT NOT NULL,
    FirstName CHAR(20) NOT NULL,
    LastName CHAR(20) NOT NULL,
    Address CHAR(50) NOT NULL,
    PhoneNumber CHAR(10) NOT NULL UNIQUE,
    Email CHAR(50) NOT NULL UNIQUE,
    ProfessorPassword CHAR(50) NOT NULL,
    DepartmentID INT NOT NULL,
    PRIMARY KEY(ProfessorID)
);

CREATE TABLE course (
	CourseID INT NOT NULL,
    CourseName CHAR(50) NOT NULL UNIQUE,
    InstructorName CHAR(50) NULL,
	StartTime VARCHAR(7) NOT NULL,
    EndTime VARCHAR(7) NOT NULL,
    RoomNumber VARCHAR(10) NOT NULL,
    ProfessorID INT NOT NULL,
    DepartmentID INT NOT NULL,
    PRIMARY KEY(CourseID),
    CONSTRAINT FK_ProfessorID FOREIGN KEY(ProfessorID) REFERENCES professor(ProfessorID),
    CONSTRAINT FK_DepartmentID FOREIGN KEY(DepartmentID) REFERENCES department(DepartmentID)
);

CREATE TABLE enrollment(
	EnrollmentID INT NOT NULL,
    StudentID INT NOT NULL,
    CourseID INT NOT NULL,
    Grade CHAR(2) NOT NULL,
    SemesterAndYear CHAR(12) NOT NULL,
    PRIMARY KEY(EnrollmentID),
    FOREIGN KEY(StudentID) REFERENCES student(StudentID),
    FOREIGN KEY(CourseID) REFERENCES course(CourseID)
);

CREATE TABLE schedules(
	StudentID INT NOT NULL,
    CourseID INT NOT NULL,
    Start_Time VARCHAR(7) NOT NULL,
    End_Time VARCHAR(7) NOT NULL,
    Room_Number VARCHAR(10) NOT NULL,
    FOREIGN KEY(StudentID) REFERENCES student(StudentID),
    FOREIGN KEY(CourseID) REFERENCES course(CourseID)
);

INSERT INTO department (DepartmentID, DepartmentName) VALUES
(24, 'Computer Science'),
(55, 'Mathematics'),
(54, 'Physics'),
(53, 'Chemistry'),
(52, 'Biology'),
(29, 'English');

INSERT INTO professor(ProfessorID, FirstName, LastName, Address, PhoneNumber, Email, ProfessorPassword, DepartmentID) VALUES
(223, 'John', 'Johnes', '123 st 24', '1234567890', 'johnjohnes@email.com', '123456789', 52),
(983, 'Tony', 'Clark', '33421 st 203', '4359281028', 'clark.tony@email.com', '123456789', 29),
(451, 'Arnold', 'Turner', '20912 st 200', '3092834590', 'arnoldturner99@emmail.com', '123456789', 29),
(333, 'Freya', 'Stones', '11233 st 12', '3829103948', 'stones.freya50@email.com', '123456789', 55),
(876, 'Mia', 'Tem', '22133 st 88', '9302182394', 'temmia@email.com', '123456789', 24),
(192, 'Lisa', 'Stevens', '29132 st 20', '2938120342', 'lisa_stevens01@email.com', 'lisastevenson01', 53),
(420, 'Lucas', 'Timothy', '33269 st 221', '2901945728', 'lucastimothy@email.com', '123456789', 54),
(283, 'Jayson', 'Lang', '2031 st 2933', '3012934589', 'lang_jayson@email.com', 'jayson1977', 55),
(112, 'Spencer', 'Payne', '2000 st 200', '9302330029', 'spencer@email.com', 'spencer123', 54),
(388, 'Bill', 'Denis', '1002 st 992', '2302223921', 'bill01denis@emai.com', 'billdenis01', 24),
(900, 'Jemma', 'Meadows', '1033 st 115', '3929993333', 'meadows23@email.com', 'meadows23', 24),
(777, 'Tessa', 'Daughterty', '8823 st 229', '2331923322', 'tessa.daughterty@email.com', 'tessadaughterty123', 29);

INSERT INTO student (StudentID, FirstName, LastName, Address, PhoneNumber, Email, BirthDate, UserPassword) VALUES
(11232, 'Mark', 'Tommy', '22322 st 45', '1029456829', 'marktommy@email.com', '20000904', '123456789'), -- YEAR/MONTH/DATE
(20398, 'Hasim', 'Nurmi', '22132 st 22', '1294032819', 'hasimnurmi@email.com', '19990204', '123456789'),
(19256, 'Margarita', 'Longe', '11288 st 19', '8329123840', 'margarita.longe@email.com', '20010102', '123456789'),
(20391, 'Vincent', 'Clensy', '99288 st 20', '2093849516', 'clensyvincent@email.com', '19980707', '123456789'),
(44212, 'Anastasia', 'Timberly', '9928 st 223', '1039627488', 'anastasia.tim@email.com', '19971128', '123456789'),
(23019, 'Martin', 'Larry', '1182 st 223', '1837293029', 'martlar@email.com', '20000919', '123456789'),
(43291, 'Trent', 'Stoleng', '2000 st 119', '3067882289', 'trentstoleng@email.com', '20010807', '123456789'),
(37212, 'Pat', 'Terry', '8222 st 201', '9987739902', 'pat_terry@email.com', '19980510', '123456789'),
(21342, 'Simon', 'Lang', '2112 st 109', '9008877726', 'simonlang@email.com', '19950909', '123456789'),
(19283, 'Margarita', 'Longe', '1002 st 221', '2039412942', 'marglong@email.com', '20000203', '123456789'),
(34231, 'Elsa', 'Felis', '20391 st 22', '3992236729', 'elsa.felis@email.com', '20020309', '123456789'),
(53291, 'Austin', 'Haynes', '21132 st 20', '9230192394', 'austinhaynes@email.com', '20000525', 'haynes123'),
(55234, 'Kaden', 'Molina', '11022 st 99', '9382019345', 'molina.kaden99@email.com', '19990301', 'kadenmolina1999'),
(57522, 'Briony', 'Craig', '2299 st 123', '9322221342', 'briony25@email.com', '19950620', 'briony25'),
(59923, 'Jude', 'Mays', '1122 st 223', '9002237723', 'jude.mays@email.com', '19981010', 'judemays98'),
(66629, 'Jim', 'Meadows', '9991 st 200', '8030293321', 'meadows2000jim@email.com', '20000130', 'medaows2000'),
(99231, 'Hollie', 'Lowery', '2000 st 232', '9382019238', 'hollie@email.com', '19971221', 'hollie123'),
(82378, 'Jaime', 'Serrano', '7773 st 991', '2839102394', 'serrano52@email.com', '20010309', 'serrano20010309'),
(77732, 'Farhan', 'Pena', '1123 st 001', '2039123058', 'rena_farhan@email.com', '19940309', 'farhan1234'),
(13234, 'Kimberly', 'Villanueva', '2331 st 002', '2391023942', 'villanueva.kimberly@email.com', '20000909', 'villanueva99'),
(22222, 'Clyde', 'Sandoval', '1119 st 922', '2039123842', 'clydesandoval@email.com', '20020305', '2002clyde'),
(10000, 'test', 'test', 'test', 'test', 'test', '19000101', 'test');

INSERT INTO course (CourseID, CourseName, InstructorName, StartTime, EndTime, RoomNumber, ProfessorID, DepartmentID) VALUES
(4710, 'Database Management Systems', 'Mia Tem', '15:15PM', '16:30PM', 'SA-105', 876, 24),
(3192, 'Introduction To Physics', 'Lucas Timothy', '19:00PM', '20:45PM', 'GC-200', 420, 54),
(4230, 'Calculus I', 'Freya Stones', '10:00AM', '11:15AM', 'PC-110', 333, 55),
(4330, 'Calculus II', 'Freya Stones', '12:00AM', '13:15PM', 'PC-110', 333, 55),
(2203, 'Public Speaking', 'Arnold Turner', '13:30PM', '14:45PM', 'PG-119', 451, 29),
(3452, 'Introduction To Biology', 'John Johnes', '15:00PM', '16:45PM', 'VH-102', 223, 52),
(3053, 'Introduction To Chemistry', 'Lisa Stevens', '17:00PM', '18:45PM', 'HA-110', 192, 52),
(4411, 'Programming I', 'Bill Denis', '09:00AM', '10:45AM', 'GA-112', 388, 24),
(4412, 'Programming II', 'Bill Denis', '11:00AM', '12:45PM', 'GA-112', 388, 24),
(4555, 'Systems Programming', 'Jemma Meadows', '15:00PM', '16:15PM', 'MO-103', 900, 24),
(4677, 'Advanced Database Management', 'Mia Tem', '19:00PM', '20:15PM', 'SA-105', 876, 24),
(4782, 'Computer Architecture', 'Bill Denis', '12:30PM', '13:45PM', 'MO-119', 388, 24),
(2209, 'Rhetoric Speaking', 'Tony Clark', '10:30AM', '11:45AM', 'EN-185', 983, 29),
(2210, 'Advanced Rethoric Speaking', 'Tessa Daughterty', '10:45AM', '12:00PM', 'EN-199', 777, 29),
(3539, 'Differential Calculus', 'Jayson Lang', '11:00AM', '12:45PM', 'PS-111', 283, 55),
(3982, 'Organic Chemistry', 'Lisa Stevens', '17:30PM', '19:15PM', 'PS-135', 192, 53),
(3199, 'Quantum Physics', 'Spencer Payne', '19:00PM', '20:45PM', 'PS-115', 112, 54),
(4200, 'Introduction to Quantum Computing', 'Jemma Meadows', '20:00PM', '21:15PM', 'MO-119', 900, 24),
(4201, 'Front End Development', 'Mia Tem', '15:00PM', '16:45PM', 'SA-105', 876, 24),
(2421, 'Rethoric Writing', 'Tessa Daughterty', '17:00PM', '18:15PM', 'EN-111', 777, 29),
(3992, 'Inorganic Chemistry', 'Lisa Stevens', '09:30AM', '11:15AM', 'PC-100', 192, 53);

INSERT INTO enrollment (EnrollmentID, StudentID, CourseID, Grade, SemesterAndYear) VALUES
(1100, 11232, 4710, 'A', 'Fall 2020'),
(1101, 11232, 3192, 'A-', 'Fall 2020'),
(1102, 11232, 2203, 'B', 'Fall 2020'),

(1200, 20391, 3192, 'B+', 'Fall 2021'),
(1201, 20391, 3053, 'A-', 'Fall 2021'),
(1202, 20391, 4330, 'B-', 'Fall 2021'),
(1203, 20391, 2203, 'A', 'Fall 2021'),

(1300, 44212, 4710, 'A', 'Summer 2021'),
(1301, 44212, 4330, 'A-', 'Summer 2021'),
(1302, 44212, 3452, 'B+', 'Summer 2021'),
(1303, 44212, 2203, 'B-', 'Summer 2021'),

(1400, 37212, 3192, 'F', 'Spring 2020'),
(1401, 37212, 3452, 'A', 'Spring 2020'),
(1402, 37212, 3053, 'A-', 'Spring 2020'),
(1403, 37212, 4230, 'B', 'Spring 2020'),

(1500, 13234, 3192, 'B', 'Spring 2020'),
(1501, 13234, 4710, 'A', 'Spring 2020'),
(1502, 13234, 2203, 'A-', 'Spring 2020'),
(1503, 13234, 3053, 'B-', 'Spring 2020'),
(1504, 13234, 4330, 'B+', 'Spring 2020'),

(1600, 99231, 3192, 'A', 'Spring 2020'),
(1601, 99231, 4555, 'A', 'Spring 2020'),
(1602, 99231, 4782, 'B', 'Spring 2020'),
(1603, 99231, 3982, 'B+', 'Fall 2020'),
(1604, 99231, 2209, 'B+', 'Fall 2020'),
(1605, 99231, 3199, 'A-', 'Fall 2020'),

(1700, 66629, 3192, 'B+', 'Fall 2021'),
(1701, 66629, 3539, 'C', 'Fall 2021'),
(1702, 66629, 4230, 'A', 'Fall 2021'),
(1703, 66629, 4710, 'A', 'Spring 2022'),
(1704, 66629, 4411, 'A-', 'Spring 2022'),
(1705, 66629, 4412, 'B', 'Spring 2022'),
(1706, 66629, 4330, 'B', 'Spring 2022'),

(1800, 22222, 4710, 'A', 'Spring 2021'),
(1801, 22222, 4230, 'A', 'Spring 2021'),
(1802, 22222, 4411, 'A-', 'Spring 2021'),
(1803, 22222, 3539, 'A', 'Spring 2021'),
(1804, 22222, 2209, 'A', 'Spring 2021'),

(1900, 82378, 4782, 'B', 'Summer 2022'),
(1901, 82378, 4330, 'B-', 'Summer 2022'),
(1902, 82378, 2203, 'B+', 'Summer 2022'),

(2000, 37212, 4782, 'A', 'Spring 2020'),
(2001, 37212, 4710, 'A-', 'Spring 2020'),
(2002, 37212, 4330, 'A-', 'Spring 2020'),
(2003, 37212, 2209, 'B', 'Summer 2020'),
(2004, 37212, 4411, 'B-', 'Summer 2020'),
(2005, 37212, 3192, 'A', 'Summer 2020');

INSERT INTO schedules (StudentID, CourseID, Start_Time, End_Time, Room_Number) VALUES
(11232, 4710, '15:15PM', '16:30PM', 'SA-105'),
(11232, 3192, '19:00PM', '20:45PM', 'GC-200'),
(11232, 2203, '13:30PM', '14:45PM', 'PG-119'),

(20391, 3192, '19:00PM', '20:45PM', 'GC-200'),
(20391, 3053, '17:00PM', '18:45PM', 'PC-110'),
(20391, 4330, '12:00AM', '13:15PM', 'PC-110'),
(20391, 2203, '13:30PM', '14:45PM', 'PG-119'),
(20391, 3452, '15:00PM', '16:45PM', 'VH-102'),

(44212, 4710, '15:15PM', '16:30PM', 'SA-105'),
(44212, 4330, '12:00AM', '13:15PM', 'PC-110'),
(44212, 3452, '15:00PM', '16:45PM', 'VH-102'),
(44212, 2203, '13:30PM', '14:45PM', 'PG-119'),

(37212, 3192, '19:00PM', '20:45PM', 'GC-200'),
(37212, 3452, '15:00PM', '16:45PM', 'VH-102'),
(37212, 3053, '17:00PM', '18:45PM', 'PC-110'),
(37212, 4230, '10:00AM', '11:15AM', 'PC-110');