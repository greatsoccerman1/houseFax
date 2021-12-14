package modals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @ToString @AllArgsConstructor @NoArgsConstructor

public class InspectionReports {
//TODO: need to change to pdfs
	private String inspectionsReports;
	private String inspectorId;
	private String dateOfInsepection;
}
