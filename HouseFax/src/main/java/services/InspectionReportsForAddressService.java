package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mysql.cj.protocol.Resultset;

import modals.InspectionReports;
import modals.InspectionsForAddressRequest;
import modals.InspectionsForAddressResponse;

@Service
public class InspectionReportsForAddressService {
	private String getInspectionsQuery = "select * from inspector_report_table where street = ? AND state = ? AND city = ?, AND zip = ?";
	String ip = "localhost";
	String port = "3306";
	String databaseName = "sys";
	String userDataBaseName = "root";
	String pass = "";
	
	public InspectionsForAddressResponse inspectionReportsForAddressService (InspectionsForAddressRequest req) {
		InspectionsForAddressResponse resp = new InspectionsForAddressResponse();
		List<InspectionReports> reports = null;
		Connection connection = dbConnection();
		if (connection != null) {
			try {
				PreparedStatement ps = connection.prepareStatement(getInspectionsQuery);
				ps.setString(1, req.getStreet());
				ps.setString(2, req.getState());
				ps.setString(3, req.getCity());
				ps.setString(4, req.getZip());
				ResultSet results = ps.executeQuery();
				reports = new ArrayList<>();
				while (results.next()) {
					reports.add(InspectionReports.builder()
					 .inspectionsReports(results.getString("inspectionReport"))
					 .inspectorId(results.getString("inspector_id")).build());
				}				
				connection.close();
				resp.setInsepctionReports(reports);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return resp;
	}
	
	//TODO: priority URGENT create a common DB connection instead of one in every class
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
