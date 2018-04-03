package backend;

//WolfInn CSC 540 
// Relpace all $USER$ with your unity id and $PASSWORD$ with your 9 digit student id or updated password (if changed)

import backend.Connect;
import java.sql.*;

public class WolfInn {
    // Update your user and password info here!

//    private static final String user = "khchoksi";
//    private static final String password = "choksi";
//	private static final String initial = "k";
//	private static final String remoteUser = "khchoksi";
//
//    // URL
//    private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/"+user; // Using SERVICE_NAME


    //public static void main(String[] args) {
    public static void populateData() {
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
				
				// Use Database
				//statement.executeUpdate("use khchoksi;");

                // 1. Create the States table
                statement.executeUpdate("CREATE TABLE States ("+
                                        "stateID INTEGER PRIMARY KEY AUTO_INCREMENT,"+
                                        "stateName VARCHAR(100) NOT NULL"+
                                        ");"
                );

                // 2. Create the Cities table
                statement.executeUpdate("CREATE TABLE Cities ("+
                                        "cityID INTEGER PRIMARY KEY AUTO_INCREMENT,"+
                                        "cityName VARCHAR(100) NOT NULL,"+
                                        "stateID INTEGER NOT NULL,"+
                                        "CONSTRAINT state_id_fk FOREIGN KEY(stateID) REFERENCES States(stateID) ON DELETE CASCADE"+
                                        ");"
                );
                
                // 3. Create the Hotels table
                statement.executeUpdate("CREATE TABLE Hotels ("+
                                        "hotelID INTEGER PRIMARY KEY AUTO_INCREMENT,"+
                                        "hotelName VARCHAR(100) NOT NULL,"+
                                        "hotelStreetAddress TEXT NOT NULL,"+
                                        "cityID INTEGER NOT NULL,"+
                                        "zipCode INTEGER NOT NULL,"+
                                        "phoneNumber VARCHAR(20),"+
                                        "CONSTRAINT hotel_city_fk FOREIGN KEY(cityID) REFERENCES Cities(cityID)"+
                                        ");"
                );

                // 4. Create the RoomTypes table
                statement.executeUpdate("CREATE TABLE RoomTypes ("+
                                        "roomTypeID INTEGER PRIMARY KEY AUTO_INCREMENT,"+
                                        "roomTypeName VARCHAR(100) NOT NULL"+
                                        ");"
                );

                // 5. Create the Rooms table
                statement.executeUpdate("CREATE TABLE Rooms ("+
										"roomNo INTEGER,"+
										"roomTypeID INTEGER,"+
										"hotelID INTEGER,"+
										"roomRates DOUBLE NOT NULL,"+
										"maxAllowedOccupancy SMALLINT NOT NULL,"+
										"CONSTRAINT rooms_pk PRIMARY KEY(roomNo, hotelID),"+
										"CONSTRAINT room_hotel_fk FOREIGN KEY(hotelID) REFERENCES Hotels(hotelID) ON DELETE CASCADE,"+
										"CONSTRAINT room_roomtype_fk FOREIGN KEY(roomTypeID) REFERENCES RoomTypes(roomTypeID)"+
										");"
				);
				
				// 6. Create Staff Types Table
				statement.executeUpdate("CREATE TABLE StaffTypes ("+
										"staffTypeID INTEGER PRIMARY KEY AUTO_INCREMENT,"+
										"staffTypeName VARCHAR(100) NOT NULL"+
										");"
				);

				// 7. Create Staff Table
				statement.executeUpdate("CREATE TABLE Staffs ("+
										"staffID INTEGER PRIMARY KEY AUTO_INCREMENT,"+
										"hotelID INTEGER NOT NULL,"+
										"staffTypeID INTEGER NOT NULL,"+
										"staffFirstName VARCHAR(100) NOT NULL,"+
										"staffLastName VARCHAR(100),"+
										"birthDate DATE,"+
										"phoneNumber VARCHAR(20),"+
										"streetAddress TEXT NOT NULL,"+
										"cityID INTEGER NOT NULL,"+
										"zipCode INTEGER NOT NULL,"+
										"CONSTRAINT staffs_hotel_fk FOREIGN KEY(hotelID) REFERENCES Hotels(hotelID),"+
										"CONSTRAINT staffs_stafftype_fk FOREIGN KEY(staffTypeID) REFERENCES StaffTypes(staffTypeID),"+
										"CONSTRAINT staffs_city_fk FOREIGN KEY(cityID) REFERENCES Cities(cityID)"+
										");"
				);
				
				// 8. Create Customers Table
				statement.executeUpdate("CREATE TABLE Customers ("+
										"customerID INTEGER PRIMARY KEY AUTO_INCREMENT,"+
										"customerFirstName VARCHAR(100) NOT NULL,"+
										"customerLastName VARCHAR(100),"+
										"birthDate DATE,"+
										"phoneNumber VARCHAR(20),"+
										"emailAddress VARCHAR(100) UNIQUE"+
										");"
				);
				
				// 9. Create CheckIns Table
				statement.executeUpdate("CREATE TABLE CheckIns ("+
										"checkInID INTEGER PRIMARY KEY AUTO_INCREMENT,"+
										"customerID INTEGER NOT NULL,"+
										"roomNo INTEGER NOT NULL,"+
										"hotelID INTEGER NOT NULL,"+
										"staffID INTEGER,"+
										"checkInDateTime DATETIME NOT NULL,"+
										"checkOutDateTime DATETIME,"+
										"numberOfGuests INTEGER NOT NULL,"+
										"CONSTRAINT checkin_customer_fk FOREIGN KEY(customerID) REFERENCES Customers(customerID),"+
										"CONSTRAINT checkin_room_fk FOREIGN KEY(roomNo, hotelID) REFERENCES Rooms(roomNo, hotelID),"+
										"CONSTRAINT checkin_staff_fk FOREIGN KEY(staffID) REFERENCES Staffs(staffID)"+
										");"
				);
				
				// 10. Create Services Table
				statement.executeUpdate("CREATE TABLE Services ("+
										"serviceID INTEGER PRIMARY KEY AUTO_INCREMENT,"+
										"serviceName VARCHAR(100) NOT NULL"+
										");"
				);
				
				// 11. Create ServiceProvides Table
				statement.executeUpdate("CREATE TABLE ServiceProvides ("+
										"hotelID INTEGER NOT NULL,"+
										"roomTypeID INTEGER NOT NULL,"+
										"serviceID INTEGER NOT NULL,"+
										"ratePerService DOUBLE NOT NULL,"+
										"CONSTRAINT service_provides_pk PRIMARY KEY(hotelID, roomTypeID, serviceID),"+
										"CONSTRAINT service_provides_hotel_fk FOREIGN KEY(hotelID) REFERENCES Hotels(hotelID),"+
										"CONSTRAINT service_provides_roomtype_fk FOREIGN KEY(roomTypeID) REFERENCES RoomTypes(roomTypeID),"+
										"CONSTRAINT service_provides_services_fk FOREIGN KEY(serviceID) REFERENCES Services(serviceID)"+
										");"
				);
				
				// 12. Create PaymentMethods Table
				statement.executeUpdate("CREATE TABLE PaymentMethods ("+
										"paymentMethodID INTEGER PRIMARY KEY AUTO_INCREMENT,"+
										"paymentMethodName VARCHAR(100) NOT NULL,"+
										"discountPercent DOUBLE"+
										");"
				);
				
				// 13. Create Bills Table
				statement.executeUpdate("CREATE TABLE Bills ("+
										"billID INTEGER PRIMARY KEY AUTO_INCREMENT,"+
										"checkInID INTEGER NOT NULL,"+
										"paymentMethodID INTEGER NOT NULL,"+
										"totalAmount DOUBLE,"+
										"payerFirstName VARCHAR(100) NOT NULL,"+
										"payerLastName VARCHAR(100),"+
										"cardNumber VARCHAR(20) NOT NULL,"+
										"SSN VARCHAR(11) NOT NULL,"+
										"payerBillingAddress TEXT,"+
										"cityID INTEGER,"+
										"payerZipcode INTEGER,"+
										"CONSTRAINT bill_checkin_fk FOREIGN KEY(checkInID) REFERENCES CheckIns(checkInID),"+
										"CONSTRAINT bill_paymentmethod_fk FOREIGN KEY(paymentMethodID) REFERENCES PaymentMethods(paymentMethodID),"+
										"CONSTRAINT bill_payer_city_fk FOREIGN KEY(cityID) REFERENCES Cities(cityID)"+
										");"
				);
				
				// 14. Create Service Records Table
				statement.executeUpdate("CREATE TABLE ServiceRecords ("+
										"recordID INTEGER PRIMARY KEY AUTO_INCREMENT,"+
										"checkInID INTEGER NOT NULL,"+
                                        "serviceID INTEGER NOT NULL,"+
                                        "staffID INTEGER,"+
										"quantity INTEGER NOT NULL,"+
										"dateTime DATETIME NOT NULL,"+
										"CONSTRAINT service_record_checkin_fk FOREIGN KEY(checkInID) REFERENCES CheckIns(checkInID),"+
                                        "CONSTRAINT service_record_services_fk FOREIGN KEY(serviceID) REFERENCES Services(serviceID),"+
                                        "CONSTRAINT service_record_staffs_fk FOREIGN KEY(staffID) REFERENCES Staffs(staffID)"+
										");"
				);
				
				// 15. Create PresidentialRoomServing
				statement.executeUpdate("CREATE TABLE PresidentialRoomServing ("+
										"checkInID INTEGER NOT NULL,"+
										"staffID INTEGER NOT NULL,"+
										"CONSTRAINT pres_room_serv_checkin_fk FOREIGN KEY(checkInID) REFERENCES CheckIns(checkInID),"+
										"CONSTRAINT pres_room_serv_staff_fk FOREIGN KEY(staffID) REFERENCES Staffs(staffID),"+
										"CONSTRAINT pres_room_serv_pk PRIMARY KEY(checkInID, staffID)"+
										");"
				);
				
				// 16. Create PresidentialCatering
				statement.executeUpdate("CREATE TABLE PresidentialCatering ("+
										"checkInID INTEGER NOT NULL,"+
										"staffID INTEGER NOT NULL,"+
										"CONSTRAINT pres_cater_checkin_fk FOREIGN KEY(checkInID) REFERENCES CheckIns(checkInID),"+
										"CONSTRAINT pres_cater_staff_fk FOREIGN KEY(staffID) REFERENCES Staffs(staffID),"+
										"CONSTRAINT pres_cater_pk PRIMARY KEY(checkInID, staffID)"+
										");"
				);
				
				// // 17. Create Serves Table
				// statement.executeUpdate("CREATE TABLE Serves ("+
				// 						"serviceRecordID INTEGER NOT NULL,"+
				// 						"staffID INTEGER NOT NULL,"+
				// 						"CONSTRAINT serves_record_fk FOREIGN KEY(serviceRecordID) REFERENCES ServiceRecords(recordID),"+
				// 						"CONSTRAINT pres_service_staff_fk FOREIGN KEY(staffID) REFERENCES Staffs(staffID),"+
				// 						"CONSTRAINT serves_pk PRIMARY KEY(serviceRecordID, staffID)"+
				// 						");"
				// );
				
                // Populate the CATS table
                statement.executeUpdate("LOAD DATA LOCAL INFILE \'./src/Data/States.csv\'"+
                                        " INTO TABLE States FIELDS TERMINATED BY \',\' LINES TERMINATED BY \'\n\' (stateName);"
                );

                statement.executeUpdate("LOAD DATA LOCAL INFILE \'./src/Data/Cities.csv\' "+
                                        " INTO TABLE Cities FIELDS TERMINATED BY \',\' LINES TERMINATED BY \'\n\' (cityName, stateID);"
                );
				
				statement.executeUpdate("LOAD DATA LOCAL INFILE \'./src/Data/Hotels.csv\'"+
                                        " INTO TABLE Hotels FIELDS TERMINATED BY \',\' LINES TERMINATED BY \'\n\' (hotelName, hotelStreetAddress, cityID, zipCode, phoneNumber);"
                );
				
				statement.executeUpdate("LOAD DATA LOCAL INFILE \'./src/Data/RoomTypes.csv\'"+
                                        " INTO TABLE RoomTypes FIELDS TERMINATED BY \',\' LINES TERMINATED BY \'\n\' (roomTypeName);"
                );
				
				statement.executeUpdate("LOAD DATA LOCAL INFILE \'./src/Data/Rooms.csv\'"+
                                        " INTO TABLE Rooms FIELDS TERMINATED BY \',\' LINES TERMINATED BY \'\n\' (roomNo, hotelID, roomTypeID, roomRates, maxAllowedOccupancy);"
                );
				
				statement.executeUpdate("LOAD DATA LOCAL INFILE \'./src/Data/StaffTypes.csv\'"+
                                        " INTO TABLE StaffTypes FIELDS TERMINATED BY \',\' LINES TERMINATED BY \'\n\' (staffTypeName);"
                );
				
				statement.executeUpdate("LOAD DATA LOCAL INFILE \'./src/Data/Staffs.csv\'"+
                                        " INTO TABLE Staffs FIELDS TERMINATED BY \',\' LINES TERMINATED BY \'\n\' (hotelID, staffTypeID, staffFirstName, staffLastName, birthDate, phoneNumber, streetAddress, cityID, zipCode);"
                );
				
				statement.executeUpdate("LOAD DATA LOCAL INFILE \'./src/Data/Customers.csv\'"+
                                        " INTO TABLE Customers FIELDS TERMINATED BY \',\' LINES TERMINATED BY \'\n\' (customerFirstName, customerLastName, birthDate, phoneNumber, emailAddress);"
                );
				
				statement.executeUpdate("LOAD DATA LOCAL INFILE \'./src/Data/CheckIns.csv\'"+
                                        " INTO TABLE CheckIns FIELDS TERMINATED BY \',\' LINES TERMINATED BY \'\n\' (customerID, roomNo, hotelID, staffID, checkInDateTime, checkOutDateTime, numberOfGuests);"
                );
				
				statement.executeUpdate("LOAD DATA LOCAL INFILE \'./src/Data/Services.csv\'"+
                                        " INTO TABLE Services FIELDS TERMINATED BY \',\' LINES TERMINATED BY \'\n\' (serviceName);"
                );
				
				statement.executeUpdate("LOAD DATA LOCAL INFILE \'./src/Data/ServicesProvides.csv\'"+
                                        " INTO TABLE ServiceProvides FIELDS TERMINATED BY \',\' LINES TERMINATED BY \'\n\' (hotelID, roomTypeID, serviceID, ratePerService);"
                );
				
				statement.executeUpdate("LOAD DATA LOCAL INFILE \'./src/Data/PaymentMethods.csv\'"+
                                        " INTO TABLE PaymentMethods FIELDS TERMINATED BY \',\' LINES TERMINATED BY \'\n\' (paymentMethodName, discountPercent);"
                );
				
				statement.executeUpdate("LOAD DATA LOCAL INFILE \'./src/Data/Bills.csv\'"+
                                        " INTO TABLE Bills FIELDS TERMINATED BY \',\' LINES TERMINATED BY \'\n\' (checkInID, paymentMethodID, totalAmount, payerFirstName, payerLastName, cardNumber, SSN, payerBillingAddress, cityID, payerZipcode);"
                );
			
				statement.executeUpdate("LOAD DATA LOCAL INFILE \'./src/Data/ServicesRecords.csv\'"+
                                        " INTO TABLE ServiceRecords FIELDS TERMINATED BY \',\' LINES TERMINATED BY \'\n\' (checkInID, serviceID, staffID, quantity, dateTime);"
                );
				
				statement.executeUpdate("LOAD DATA LOCAL INFILE \'./src/Data/PresidentialRoomServing.csv\'"+
                                        " INTO TABLE PresidentialRoomServing FIELDS TERMINATED BY \',\' LINES TERMINATED BY \'\n\' (checkInID, staffID);"
                );
				
				statement.executeUpdate("LOAD DATA LOCAL INFILE \'./src/Data/PresidentialCatering.csv\'"+
                                        " INTO TABLE PresidentialCatering FIELDS TERMINATED BY \',\' LINES TERMINATED BY \'\n\' (checkInID, staffID);"
                );
				
				// statement.executeUpdate("LOAD DATA LOCAL INFILE \'/afs/unity.ncsu.edu/users/"+initial+"/"+remoteUser+"/dbms/project/WolfInn-DatabaseProject-CSC540/Serves.csv\'"+
                //                         " INTO TABLE Serves FIELDS TERMINATED BY \',\' LINES TERMINATED BY \'\n\' (serviceRecordID, staffID);"
                // );
                
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
