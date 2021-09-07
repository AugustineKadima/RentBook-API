package modules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LandlordTest {

    @Test
    public void landlordObjectInstantiates(){
        Landlord landlord = new Landlord("Kadima", "kadima@gmail.com", "57678", "male", "New york");
        Assertions.assertEquals(true, landlord instanceof Landlord);
    }

    @Test
    public void landlordVariablesAreAssignable(){
        Landlord landlord = new Landlord("Kadima", "kadima@gmail.com", "57678", "male", "New york");
        landlord.setName("Samuel");
        landlord.setGender("female");
        landlord.setEmail("sam@yahoo.com");
        landlord.setPhone_number("3353");
        landlord.setLocation("England");
        Assertions.assertEquals("Samuel", landlord.getName());
        Assertions.assertEquals("female", landlord.getGender());
        Assertions.assertEquals("sam@yahoo.com", landlord.getEmail());
        Assertions.assertEquals("3353", landlord.getPhone_number());
        Assertions.assertEquals("England", landlord.getLocation());
    }
}
