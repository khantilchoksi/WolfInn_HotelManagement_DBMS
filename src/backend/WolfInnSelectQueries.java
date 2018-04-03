package backend;

//WolfInn CSC 540 
// Relpace all $USER$ with your unity id and $PASSWORD$ with your 9 digit student id or updated password (if changed)

import java.sql.*;

public class WolfInnSelectQueries {
    // Update your user and password info here!

    private static final String user = "khchoksi";
    private static final String password = "choksi";

    // URL
    private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/"+user; // Using SERVICE_NAME


    public static void main(String[] args) {
        System.out.println("\n Hello:");
        try {
            /*Loading the driver. This creates an instance of the driver 
            and calls the registerDriver method to make MySql(MariaDB) Thin available to clients.*/
            Class.forName("org.mariadb.jdbc.Driver");

            Connection connection = null;
            Statement statement = null;
            ResultSet result = null;

            try {
                // Get a connection instance from the first driver in the
                // DriverManager list that recognizes the URL jdbcURL
                connection = DriverManager.getConnection(jdbcURL, user, password);

                // Create a statement instance that will be sending
                // your SQL statements to the DBMS
                statement = connection.createStatement();

                // 1. Drop Table Statements
				statement.executeUpdate("SELECT * FROM Serves");
				
				statement.executeUpdate("SELECT * FROM PresidentialCatering");
				
				statement.executeUpdate("SELECT * FROM PresidentialRoomServing");
				
				statement.executeUpdate("SELECT * FROM ServiceRecords");
				
				statement.executeUpdate("SELECT * FROM Bills");
				
				statement.executeUpdate("SELECT * FROM PaymentMethods");
				
				statement.executeUpdate("SELECT * FROM ServiceProvides");
				
				statement.executeUpdate("SELECT * FROM Services");
				
				statement.executeUpdate("SELECT * FROM CheckIns");
				
				statement.executeUpdate("SELECT * FROM Customers");
				
				statement.executeUpdate("SELECT * FROM Staffs");
				
				statement.executeUpdate("SELECT * FROM StaffTypes");
				
				statement.executeUpdate("SELECT * FROM Rooms");
				
				statement.executeUpdate("SELECT * FROM RoomTypes");
				
                statement.executeUpdate("SELECT * FROM Hotels");
				
				statement.executeUpdate("SELECT * FROM Cities");

                statement.executeUpdate("SELECT * FROM States");
            } finally {
                close(result);
                close(statement);
                close(connection);
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