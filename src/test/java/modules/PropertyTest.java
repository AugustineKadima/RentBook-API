package modules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PropertyTest {

    @Test
    public void propertyObjectInstantiatesSuccessfully(){
        Property property = new Property("Ten Flats", "Nairobi", 25, 13566, true, true, true, "Erick", "475449", 1);
        Assertions.assertEquals(true, property instanceof Property);
    }

    @Test
    public void allVariablesAreAssignable(){
        Property property = new Property("Ten Flats", "Nairobi", 25, 13566, true, true, true, "Erick", "475449", 1);
        property.setName("Queens park");
        property.setCaretaker_name("John");
        property.setCaretaker_phone_number("667548");
        property.setHas_internet(false);
        property.setHas_electricity(true);
        property.setHas_water(false);
        property.setLandlord_id(2);
        property.setLocation("Kiambu");
        property.setNumber_of_house_units(20);
        property.setRent_per_unit(3000);
        Assertions.assertEquals("Queens park", property.getName());
        Assertions.assertEquals("John", property.getCaretaker_name());
        Assertions.assertEquals("667548", property.getCaretaker_phone_number());
        Assertions.assertEquals(true, property.isHas_electricity());
        Assertions.assertEquals(false, property.isHas_internet());
        Assertions.assertEquals(false, property.isHas_water());
        Assertions.assertEquals(2, property.getLandlord_id());
        Assertions.assertEquals("Kiambu", property.getLocation());
        Assertions.assertEquals(20, property.getNumber_of_house_units());
        Assertions.assertEquals(3000, property.getRent_per_unit());
    }
}
