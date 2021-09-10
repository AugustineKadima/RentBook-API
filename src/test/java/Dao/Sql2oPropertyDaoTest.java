package Dao;

import modules.Property;
import org.junit.jupiter.api.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

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

//    @Test
//    public void addPropertyToDatabase(){
//        Property property = new Property("Ten Flats", "Nairobi", 25, 13566, true, true, true, "Erick", "475449", 1);
//        propertyDao.add(property);
//        Assertions.assertEquals("Ten Flats", propertyDao.getAll().get(0).getName());
//    }

    @Test
    public void findPropertyById(){
        Property property = new Property("Ten Flats", "Nairobi", 25, 13566, true, true, true, "Erick", "475449", 1);
        propertyDao.add(property);
        Assertions.assertEquals(property, propertyDao.findById(property.getId()));
    }
}
