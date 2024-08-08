package Day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class fakeDatagenerator {

	@Test
	void testGenerateDummyData() {
		
		Faker faker=new Faker();
		String Fullname=faker.name().fullName();
		System.out.println(Fullname);
		
	}
}
