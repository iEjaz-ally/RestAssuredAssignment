package PetServiceEndPointLayer;

import Operations.PetServices;
import SingleTonHelper.RequestSpecHelper;
import Utilities.PropertyUtils;
import builderPojo.PetBuilderPOJO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PetEndPoints {
	

	public  static Response postPet(PetServices services, PetBuilderPOJO body) {
		RequestSpecification specs= RequestSpecHelper.getInstance().getSpec(services);
		 
		 return RestAssured.given().spec(specs)
				 .body(body).post(services.getendPoint());
	
	}
	public static Response updatePet(PetServices services, PetBuilderPOJO body) {
		 
		RequestSpecification specs;	specs = RequestSpecHelper.getInstance().getSpec(services);
		
		return RestAssured.given().spec(specs).body(body).put(services.getendPoint());
	}
	public static Response getPetByStatus(PetServices services, String status) {
		RequestSpecification specs= RequestSpecHelper.getInstance().getSpec(services);
		return RestAssured.given().spec(specs).queryParam("status", status).get(services.getendPoint());
	}
	public static Response deletePeyByID(PetServices services, int Id) {
		RequestSpecification specs= RequestSpecHelper.getInstance().getSpec(services);
		
		return RestAssured.given().spec(specs).header("api_key", PropertyUtils.getProperties("api_key")).pathParam("petId", Id).when().delete(services.getendPoint());
	}
}
