package Day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//pojo ---serialize ---- JSON OBject ---dserialize--- pojo

public class SerializationDeserialization {

	
	@Test
	void convertPojo2Json() throws JsonProcessingException {
		
		Student stupojo=new Student();
		
		stupojo.setName("Scott");
		stupojo.setLocation("France");
		stupojo.setPhone("123456");
		String courseArr[]= {"C","C++"};
		stupojo.setCourses(courseArr);
		
		//convert java object ----> json object (Serialization)
		
		ObjectMapper mapper=new ObjectMapper();
		String jsonData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
		System.out.println(jsonData);
		
	}
	//convert json data ----->pojo Object
	@Test
	void convertJSON2Pojo() throws JsonMappingException, JsonProcessingException {
		String jsonData="{\r\n"
				+ "  \"name\" : \"Scott\",\r\n"
				+ "  \"location\" : \"France\",\r\n"
				+ "  \"phone\" : \"123456\",\r\n"
				+ "  \"courses\" : [ \"C\", \"C++\" ]\r\n"
				+ "}";
		
		//convert jsonData to Pojo Object
		
		ObjectMapper mapper=new ObjectMapper();
		Student stupojo=mapper.readValue(jsonData, Student.class);
		System.out.println(stupojo.getName());
		System.out.println(stupojo.getLocation());
		System.out.println(stupojo.getPhone());
		System.out.println(stupojo.getCourses()[0]);
		System.out.println(stupojo.getCourses()[1]);
		
		
	}
	
	
	
	
	
	
}
