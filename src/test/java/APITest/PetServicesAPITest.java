package APITest;

import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.HashMap;
import Operations.PetServices;
import PetServiceEndPointLayer.PetEndPoints;
import Utilities.DataProviders;
import builderPojo.PetBuilderPOJO;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class PetServicesAPITest {

	
	@Test(dataProvider = "dataProviderForPets", dataProviderClass = DataProviders.class)
	public void postPet(HashMap<String, Object> dataMap) {
		
		HashMap<String, Object> categoryMap = new HashMap<String, Object>();
		
		categoryMap.put("id", dataMap.get("categoryId"));
		
		categoryMap.put("name",dataMap.get("categoryName"));
		
		HashMap<String, Object> tagsHashMap  = new HashMap<String, Object>();
		
		tagsHashMap.put("id", dataMap.get("tagId"));
		
		tagsHashMap.put("name", dataMap.get("tagName"));
		
		PetBuilderPOJO	 builderPOJO = PetBuilderPOJO.builder()
				.id(Integer.valueOf(dataMap.get("id")
				.toString())).name(dataMap.get("name")
				.toString()).category(categoryMap).
				photoUrls(Arrays.asList(dataMap.get("photoUrl"))).
				tags(Arrays.asList(tagsHashMap)).
				status(dataMap.get("status").
				toString()).build();
		 
		Response response = PetEndPoints.postPet(PetServices.POSTPET, builderPOJO);
		
		response.then().body("name", equalTo(dataMap.get("name"))).body("id", equalTo( Integer.valueOf( dataMap.get("id").toString()))).statusCode(200);
	}
	@Test(dependsOnMethods = "postPet")
	public void updatePet() {
		
		PetBuilderPOJO	 builderPOJO = PetBuilderPOJO.builder().name("Apollo").id(1003).build();
		
		Response response = PetEndPoints.updatePet(PetServices.UPDATEPET, builderPOJO);
		
		response.then().body("name", equalTo("Apollo")).body("id", equalTo(1003)).statusCode(200);
	}
	@Test(dependsOnMethods = "updatePet")
	public void getPet() {
		
		Response response  = PetEndPoints.getPetByStatus(PetServices.GETPETBYSTATUS, "available");

		response.then().statusCode(200).body("id", hasItem(768307));
	}
	@Test(dependsOnMethods = "getPet")
	public void deletePet() {
	
		Response response = PetEndPoints.deletePeyByID(PetServices.DELETEPET, 101);	
		
		response.then().statusCode(200).log().all();
	}	
}
