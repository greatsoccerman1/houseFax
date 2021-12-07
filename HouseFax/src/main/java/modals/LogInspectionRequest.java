package modals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @ToString @AllArgsConstructor @NoArgsConstructor
public class LogInspectionRequest {
	private String inspectorId;
	//TODO:change to PDF
	private String inspectionReport;
	private String dateOfInspection;
	private String country;
	private String city;
	private String state;
	private String street;
	private String zip;
	private String firstName;
	private String lastName;
	private String email;
}

