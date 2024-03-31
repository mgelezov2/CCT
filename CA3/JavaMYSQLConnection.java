public class JavaMYSQLConnection {
    private static String MySQL_url = "";
    private static String MySQL_user = "";
    private static String MySQL_pass = "";
    private static String user;
    private static List<String> userManagement = new ArrayList<>();
    private static Scanner col_userInput = new Scanner(System.in);
    private static void collegeLogin(String MySQL_url, String MySQL_user, String MySQL_pass) throws SQLException {
        Connection collegeLogin_connection = DriverManager.getConnection(MySQL_url, MySQL_user, MySQL_pass);
        System.out.println("Database Connected!");
        System.out.println("Please enter your username: ");
        String col_username = col_userInput.nextLine();
        System.out.println("Please enter your password: ");
        String col_password = col_userInput.nextLine();
        String loginNameQuery = "SELECT colUser_full_name, colUser_login_name, colUser_password FROM users WHERE colUser_login_name = '" + col_username + "'";
        PreparedStatement PreparedLoginNameStatement = collegeLogin_connection.prepareStatement(loginNameQuery);
        ResultSet loginNameSet = PreparedLoginNameStatement.executeQuery();
        if (loginNameSet.next()) {
            String user_FN = loginNameSet.getString("colUser_full_name");
            String user_LN = loginNameSet.getString("colUser_login_name");
            String user_Pass = loginNameSet.getString("colUser_password");
            if (user_LN.equals("") || user_LN.equals(NULL)) {
                System.out.println("User is not registered");
            }
            if (col_username.equals("admin") && col_password.equals(user_Pass)) {
                System.out.println("Hello, " + user_FN);
                user = "admin";
            }
            else if (col_username.equals("office") && col_password.equals(user_Pass)) {
                System.out.println("Hello, " + user_FN);
                user = "office";
            }
            else if (col_username.equals("lecturer") && col_password.equals(user_Pass)) {
                System.out.println("Hello, " + user_FN);
                user = "lecturer";
            }
            else {
                System.out.println("Login failed. Check if your username or password was correct.");
            }
            }
    }
    private static void displayConsole(){
        try {
        FileWriter CourseRep = new FileWriter("CourseReport.csv");
        FileWriter StudentsRep = new FileWriter("StudentReport.csv");
        FileWriter LecturersRep = new FileWriter("LecturersReport.csv");
        FileWriter moduleRepID = new FileWriter("module_report_by_id.csv");
        Connection displayConsole_connection = DriverManager.getConnection(MySQL_url, MySQL_user, MySQL_pass);
        System.out.println("Database Connected!");
        String CourseRepRequest = 
                "SELECT course.moduleName AS module_name, course.programName AS program_name, course.modulePopulation AS enrolled_students, lecturer.lecturerName AS lecturer_name, CASE WHEN course.roomLocation = '' "
                + "THEN 'Online'ELSE course.roomLocation END AS classroom_location FROM Courses course INNER JOIN Lecturers lecturer ON course.lecturerID = lecturer.lecturerID;";
        PreparedStatement CourseReportStat = displayConsole_connection.prepareStatement(CourseRepRequest);
        ResultSet CourseRep_output = CourseReportStat.executeQuery();
        String StudentRepRequest = 
                "SELECT student.studentName AS student_name, student.studentID AS student_number, course.programName AS taken_program, GROUP_CONCAT(DISTINCT enrolled.moduleID) AS enrolled_module,GROUP_CONCAT(DISTINCT CASE WHEN grades.passed_module_ID IS NOT NULL THEN CONCAT(grades.passed_module_ID, ': ', grades.grades_pass) ELSE NULL END) AS module_completed, GROUP_CONCAT(DISTINCT grades.failed_module_id) "
                + "AS module_repeat FROM Students student LEFT JOIN  Enrollments enrolled ON student.studentID = enrolled.studentID LEFT JOIN Courses course ON enrolled.programID = course.programID LEFT JOIN Grades grades ON student.studentID = grades.studentID AND enrolled.moduleID = grades.moduleID GROUP BY student.studentName, student.studentID, course.programName;";
        PreparedStatement StudentReportStat = displayConsole_connection.prepareStatement(StudentRepRequest);
        ResultSet StudentRep_output = StudentReportStat.executeQuery();
    }
}
