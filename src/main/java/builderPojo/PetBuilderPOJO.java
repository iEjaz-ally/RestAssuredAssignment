package builderPojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PetBuilderPOJO {
	
	private int id;
	
	private HashMap<String, Object> category = new HashMap<String, Object>();
	
	private String name;
	
	private List<Object> photoUrls	= new ArrayList<Object>();
	
	private List<Object> tags = new ArrayList<Object>();
	
	private String status;
}
