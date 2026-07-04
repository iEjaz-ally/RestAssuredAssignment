package SingleTonHelper;

import java.util.HashMap;
import Operations.PetServices;
import Utilities.PropertyUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecHelper {
	
	private RequestSpecHelper() {}

	private static RequestSpecHelper instance;
	
	public static RequestSpecHelper getInstance() {
		
		if(instance==null) {
			instance = new RequestSpecHelper();
		}
		
		return instance;
	}
	
	public RequestSpecification getSpec(PetServices services) {
		
		return buildSpec(services);
	}
	
	private RequestSpecification buildSpec(PetServices services) {
		
		HashMap<String, String> specs = new HashMap();
	
		String baseURL="";
		
		switch (services) {
		case POSTPET:
		case GETPETBYSTATUS:
		case UPDATEPET:
			baseURL = PropertyUtils.getProperties("baseURL");
			specs.put("Content-Type", "application/json");
			specs.put("accept", "application/json");
			break;
		case DELETEPET:
			baseURL = PropertyUtils.getProperties("baseURL");
			specs.put("accept", "application/json");
			break;	
		}
		return new RequestSpecBuilder().setBaseUri(baseURL)
				.addHeaders(specs).build();
		
	}
}
