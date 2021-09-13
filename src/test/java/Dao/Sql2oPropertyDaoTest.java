package Dao;

import modules.Landlord;
import modules.Property;
import org.junit.jupiter.api.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Arrays;

public class Sql2oPropertyDaoTest {
    private static Connection conn;
    private static Sql2oLandlordDao landlordDao;
    private static Sql2oPropertyDao propertyDao;


    @BeforeEach
    void setUp() {
        Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/rentbook_test",  "sirkadima", "kadima123");
        landlordDao = new Sql2oLandlordDao(sql2o);
        propertyDao = new Sql2oPropertyDao(sql2o);
        conn = sql2o.open();
    }
    @AfterEach
    void tearDown() {
        System.out.println("Clearing database");
        propertyDao.clearAll();
    }
    @AfterAll
    public static void shutDown() throws Exception {
        conn.close();
        System.out.println("Connection closed");
    }

    @Test
    public void addPropertyToDatabase(){
        Property property = new Property("Ten Flats", "Nairobi", 25, 13566, true, true, true, "Erick", "475449", 1);
        propertyDao.add(property);
        Assertions.assertEquals("Ten Flats", propertyDao.getAll().get(0).getName());
    }

    @Test
    public void findPropertyById(){
        Property property = new Property("Ten Flats", "Nairobi", 25, 13566, true, true, true, "Erick", "475449", 1);
        propertyDao.add(property);
        Assertions.assertEquals(property, propertyDao.findById(property.getId()));
    }

    @Test
    public void deletePropertyById(){
        Property property = new Property("Ten Flats", "Nairobi", 25, 13566, true, true, true, "Erick", "475449", 1);
        propertyDao.add(property);
        propertyDao.deleteById(property.getId());
        Assertions.assertEquals(0, propertyDao.getAll().size());
    }

    @Test
    public void clearAllPropertyFromDataBase(){
        Property property1 = new Property("Ten Flats", "Nairobi", 25, 13566, true, true, true, "Erick", "475449", 1);
        Property property2 = new Property("Ben Flats", "Nairobi", 50, 13566, true, true, true, "Erick", "475449", 1);

        propertyDao.add(property1);
        propertyDao.add(property2);

        propertyDao.clearAll();

        Assertions.assertEquals(0, propertyDao.getAll().size());
    }

    @Test
    public void findPropertyByLandlordId(){
        Property property1 = new Property("Ten Flats", "Nairobi", 25, 13566, true, true, true, "Erick", "475449", 1);
        Property property2 = new Property("Ben Flats", "Nairobi", 50, 13566, true, true, true, "Erick", "475449", 1);

        propertyDao.add(property1);
        propertyDao.add(property2);

        Assertions.assertEquals(2, propertyDao.getAllPropertyByLandlord(1).size());
    }

    @Test
    public void addPropertyToLandlord(){
        Property property1 = new Property("Ten Flats", "Nairobi", 25, 13566, true, true, true, "Erick", "475449", 1);
        Property property2 = new Property("Ben Flats", "Nairobi", 50, 13566, true, true, true, "Erick", "475449", 1);

        propertyDao.add(property1);
        propertyDao.add(property2);

        Landlord landlord = new Landlord("Kadima", "kadima@gmail.com", "57678", "male", "New york");
        landlordDao.add(landlord);

        propertyDao.addPropertyToLandlord(property1, landlord);
        landlordDao.addLandlordToProperty(landlord, property2);

        Property[] properties = {property1, property2};

        Assertions.assertEquals(Arrays.asList(properties), propertyDao.getAllPropertyByLandlord(1));
    }
}
