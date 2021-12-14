 	
package houseFaxRestClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import modals.InspectionsForAddressRequest;
import modals.InspectionsForAddressResponse;
import modals.LogInspectionRequest;
import modals.LogInspectionResponse;
import services.InspectionReportsForAddressService;
import services.RegisterService;


@RestController
public class HouseFaxController {
	
	RestTemplate restTemplate; 
	
	@Autowired
	RegisterService registerService;
	@Autowired
	InspectionReportsForAddressService inspectionReportsForAddressService;
	
	@PostMapping("houseFax/InsertInspection")
	public LogInspectionResponse registerService(@RequestBody LogInspectionRequest req) throws ClassNotFoundException{
		return registerService.insertInspection(req);
	}
	
	@PostMapping("houseFax/GetInspections")
	public InspectionsForAddressResponse inspectionReportsForAddressService(@RequestBody InspectionsForAddressRequest req) throws ClassNotFoundException{
		return inspectionReportsForAddressService.inspectionReportsForAddressService(req);
	}
}
