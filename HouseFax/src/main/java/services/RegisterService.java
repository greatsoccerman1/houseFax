package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import modals.LogInspectionRequest;
import modals.LogInspectionResponse;

@Service
public class RegisterService {
	
	String ip = "localhost";
	String port = "3306";
	String databaseName = "sys";
	String userDataBaseName = "root";
	String pass = "DaBezt_123";

    private String insertInspection = "insert into inspector_report_table (inspectorId, inspectionReport, dateOfInspection, country, city, state, street, "
    		+ "zip, firstName, LastName, email) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    	
	public LogInspectionResponse insertInspection (LogInspectionRequest req) {
		LogInspectionResponse resp = new LogInspectionResponse();
		Connection connection = dbConnection();
		if (connection != null) {
			try {
				PreparedStatement ps = connection.prepareStatement(insertInspection);
				ps.setString(1, req.getInspectorId());
				ps.setString(2, req.getInspectionReport());
				ps.setString(3, req.getDateOfInspection());
				ps.setString(4, req.getCountry());
				ps.setString(5, req.getCity());
				ps.setString(6, req.getState());
				ps.setString(7, req.getStreet());
				ps.setString(8, req.getZip());
				ps.setString(9, req.getFirstName());
				ps.setString(10, req.getLastName());
				ps.setString(11, req.getEmail());
				ps.execute();

				connection.close();
			    resp.setStatus("success");
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
	}
		
    private Connection dbConnection() {
  		Connection dbConnection = null;
		String connectionUrl = "jdbc:mysql://" + ip + ":" + port + "/" + databaseName;
		System.out.print("DriverManager.getConnection(\"" + connectionUrl + "\")");
		try {
			dbConnection = DriverManager.getConnection(connectionUrl, userDataBaseName, pass);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbConnection;
    }
}
 