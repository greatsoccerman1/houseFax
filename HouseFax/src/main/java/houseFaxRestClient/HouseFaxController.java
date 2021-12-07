
package houseFaxRestClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import modals.LogInspectionRequest;
import modals.LogInspectionResponse;
import services.RegisterService;


@RestController
public class HouseFaxController {
	
	RestTemplate restTemplate; 
	
	@Autowired
	RegisterService registerService;
	
	@PostMapping("houseFax/InsertInspection")
	public LogInspectionResponse registerService(@RequestBody LogInspectionRequest req) throws ClassNotFoundException{
		return registerService.insertInspection(req);
	}
	

}
