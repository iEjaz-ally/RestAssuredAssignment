package Operations;

public enum PetServices {

	POSTPET("v2/pet"), UPDATEPET("v2/pet"), GETPETBYSTATUS("v2/pet/findByStatus"), DELETEPET("v2/pet/{petId}");

	private String endpoint;

	private PetServices(String endPoint) {
		this.endpoint = endPoint;
	}
	public  String getendPoint() {

		return this.endpoint;
	}
}
