package modules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TenantTest {

    @Test
    public void tenantObjectInstantiates(){
        Tenant tenant = new Tenant("John","jon@gmail.com", "46578", "97676", 54, "Developer", "male", true, 5454, 575, 5777,"q2", 5);
        Assertions.assertEquals(true, tenant instanceof Tenant);
    }

    @Test
    public void tenantVariablesAreAssignable(){
        Tenant tenant = new Tenant("John","jon@gmail.com", "46578", "97676", 54, "Developer", "male", true, 5454, 575, 5777,"q2", 5);
        tenant.setAge(2);
        tenant.setEmail("kkk@gmail.com");
        tenant.setHas_family(true);
        tenant.setHouse_number("f45");
        tenant.setId_number("h556");
        tenant.setOccupation("Teacher");
        tenant.setGender("male");
        tenant.setPaid_deposit(678);
        tenant.setPaid_rent(764);
        tenant.setRent_balance(754);
        tenant.setPhone_number("7675876");
        Assertions.assertEquals(2, tenant.getAge());
        Assertions.assertEquals("kkk@gmail.com", tenant.getEmail());
        Assertions.assertEquals(true, tenant.isHas_family());
        Assertions.assertEquals("f45", tenant.getHouse_number());
        Assertions.assertEquals("h556", tenant.getId_number());
        Assertions.assertEquals("Teacher", tenant.getOccupation());
        Assertions.assertEquals("male", tenant.getGender());
        Assertions.assertEquals(678, tenant.getPaid_deposit());
        Assertions.assertEquals(764, tenant.getPaid_rent());
        Assertions.assertEquals(754, tenant.getRent_balance());
        Assertions.assertEquals("7675876", tenant.getPhone_number());
    }
}
