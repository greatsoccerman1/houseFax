package modals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @ToString @AllArgsConstructor @NoArgsConstructor
public class InspectionsForAddressRequest {
	private String street;
	private String city;
	private String state;
	private String zip;
}