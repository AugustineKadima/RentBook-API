package Dao;

import modules.Property;
import modules.Tenant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Arrays;


public class Sql2oTenantDaoTest {
    private static Connection conn;
    private static Sql2oTenantDao tenantDao;
    private static Sql2oPropertyDao propertyDao;


    @BeforeEach
    void setUp() {
        Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/rentbook_test",  "sirkadima", "kadima123");
        tenantDao = new Sql2oTenantDao(sql2o);
        propertyDao = new Sql2oPropertyDao(sql2o);
        conn = sql2o.open();
    }
    @AfterEach
    void tearDown() {
        System.out.println("Clearing database");
        tenantDao.clearAll();
    }
    @AfterAll
    public static void shutDown() throws Exception {
        conn.close();
        System.out.println("Connection closed");
    }

    @Test
    public void tenantIsAddedToDatabase(){
        Tenant tenant = new Tenant("John","jon@gmail.com", "46578", "97676", 54, "Developer", "male", true, 5454, 575, 5777,"q2", 5);
        tenantDao.add(tenant);
        System.out.println(tenant);
        Assertions.assertEquals("John", tenantDao.getAll().get(0).getName());
    }

    @Test
    public void getAllTenantsInTheDataBase(){
        Tenant tenant1 = new Tenant("John","jon@gmail.com", "46578", "97676", 54, "Developer", "male", true, 5454, 575, 5777,"q2", 5);
        Tenant tenant2 = new Tenant("Kev","kev@gmail.com", "46578", "97676", 54, "Developer", "male", true, 5454, 575, 5777,"q2", 5);
        Tenant tenant3 = new Tenant("Don","don@gmail.com", "46578", "97676", 54, "Developer", "male", true, 5454, 575, 5777,"q2", 5);

        tenantDao.add(tenant1);
        tenantDao.add(tenant2);
        tenantDao.add(tenant3);

        Assertions.assertEquals(3, tenantDao.getAll().size());
    }

    @Test
    public void tenantCanBeDeletedFromDatabase(){
        Tenant tenant1 = new Tenant("John","jon@gmail.com", "46578", "97676", 54, "Developer", "male", true, 5454, 575, 5777,"q2", 5);
        Tenant tenant2 = new Tenant("Kev","kev@gmail.com", "46578", "97676", 54, "Developer", "male", true, 5454, 575, 5777,"q2", 5);
        Tenant tenant3 = new Tenant("Don","don@gmail.com", "46578", "97676", 54, "Developer", "male", true, 5454, 575, 5777,"q2", 5);

        tenantDao.add(tenant1);
        tenantDao.add(tenant2);
        tenantDao.add(tenant3);

        tenantDao.deleteById(tenant1.getId());

        Assertions.assertEquals(2, tenantDao.getAll().size());
    }

    @Test
    public void allTenantsCanBeClearedFromTeDataBase(){
        Tenant tenant1 = new Tenant("John","jon@gmail.com", "46578", "97676", 54, "Developer", "male", true, 5454, 575, 5777,"q2", 5);
        Tenant tenant2 = new Tenant("Kev","kev@gmail.com", "46578", "97676", 54, "Developer", "male", true, 5454, 575, 5777,"q2", 5);
        Tenant tenant3 = new Tenant("Don","don@gmail.com", "46578", "97676", 54, "Developer", "male", true, 5454, 575, 5777,"q2", 5);

        tenantDao.add(tenant1);
        tenantDao.add(tenant2);
        tenantDao.add(tenant3);

        tenantDao.clearAll();
        Assertions.assertEquals(0, tenantDao.getAll().size());

    }

    @Test
    public void findTenantsByPropertyId(){
        Tenant tenant1 = new Tenant("John","jon@gmail.com", "46578", "97676", 54, "Developer", "male", true, 5454, 575, 5777,"q2", 5);
        Tenant tenant2 = new Tenant("Kev","kev@gmail.com", "46578", "97676", 54, "Developer", "male", true, 5454, 575, 5777,"q2", 5);

        tenantDao.add(tenant1);
        tenantDao.add(tenant2);

        Assertions.assertEquals(2, tenantDao.getAllTenantsByProperty(5).size());
    }

    @Test
    public void tenantIsAddedToProperty(){
        Property property = new Property("Ten Flats", "Nairobi", 25, 13566, true, true, true, "Erick", "475449", 1);
        propertyDao.add(property);

        Tenant tenant1 = new Tenant("John","jon@gmail.com", "46578", "97676", 54, "Developer", "male", true, 5454, 575, 5777,"q2", 5);
        tenantDao.add(tenant1);
        Tenant tenant2 = new Tenant("Kev","kev@gmail.com", "46578", "97676", 54, "Developer", "male", true, 5454, 575, 5777,"q2", 5);
        tenantDao.add(tenant2);

        tenantDao.addTenantToProperty(property,tenant1);
        propertyDao.addTenantToProperty(property, tenant2);

        Tenant[] tenants = {tenant1, tenant2};

        Assertions.assertEquals(Arrays.asList(tenants), tenantDao.getAllTenantsByProperty(5));
    }
}
