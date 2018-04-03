package backend;

//WolfInn CSC 540 
// Relpace all $USER$ with your unity id and $PASSWORD$ with your 9 digit student id or updated password (if changed)

import java.sql.*;

public class DropWolfInn {
    // Update your user and password info here!

//    private static final String user = "khchoksi";
//    private static final String password = "choksi";
//
//    // URL
//    private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/"+user; // Using SERVICE_NAME


    public static void droptTables() {
        //System.out.println("\n Hello:");
        try {
            /*Loading the driver. This creates an instance of the driver 
            and calls the registerDriver method to make MySql(MariaDB) Thin available to clients.*/
            //Class.forName("org.mariadb.jdbc.Driver");

            //Connection connection = null;
            Statement statement = null;
            ResultSet result = null;

            try {
                // Get a connection instance from the first driver in the
                // DriverManager list that recognizes the URL jdbcURL
                //connection = DriverManager.getConnection(jdbcURL, user, password);

                // Create a statement instance that will be sending
                // your SQL statements to the DBMS
                statement = Connect.connection.createStatement();

                // 1. Drop Table Statements
				
				statement.executeUpdate("DROP TABLE IF EXISTS PresidentialCatering;");
				
				statement.executeUpdate("DROP TABLE IF EXISTS PresidentialRoomServing;");
				
				statement.executeUpdate("DROP TABLE IF EXISTS ServiceRecords;");
				
				statement.executeUpdate("DROP TABLE IF EXISTS Bills;");
				
				statement.executeUpdate("DROP TABLE IF EXISTS PaymentMethods;");
				
				statement.executeUpdate("DROP TABLE IF EXISTS ServiceProvides;");
				
				statement.executeUpdate("DROP TABLE IF EXISTS Services;");
				
				statement.executeUpdate("DROP TABLE IF EXISTS CheckIns;");
				
				statement.executeUpdate("DROP TABLE IF EXISTS Customers;");
				
				statement.executeUpdate("DROP TABLE IF EXISTS Staffs");
				
				statement.executeUpdate("DROP TABLE IF EXISTS StaffTypes;");
				
				statement.executeUpdate("DROP TABLE IF EXISTS Rooms;");
				
				statement.executeUpdate("DROP TABLE IF EXISTS RoomTypes;");
				
                statement.executeUpdate("DROP TABLE IF EXISTS Hotels;");
				
				statement.executeUpdate("DROP TABLE IF EXISTS Cities;");

                statement.executeUpdate("DROP TABLE IF EXISTS States;");
            } finally {
                close(result);
                close(statement);
                //close(connection);
            }
        } catch(Throwable oops) {
                    oops.printStackTrace();
            }
    }

    static void close(Connection connection) {
            if(connection != null) {
                try {
                connection.close();
                } catch(Throwable whatever) {}
            }
    }

    static void close(Statement statement) {
            if(statement != null) {
                try {
                statement.close();
                } catch(Throwable whatever) {}
            }
    }
    
    static void close(ResultSet result) {
            if(result != null) {
                try {
                result.close();
                } catch(Throwable whatever) {}
            }
    }

}
