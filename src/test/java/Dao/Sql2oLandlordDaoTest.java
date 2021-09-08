package Dao;

import modules.Landlord;
import org.junit.jupiter.api.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Sql2oLandlordDaoTest {
    private static Connection conn;
    private static Sql2oLandlordDao landlordDao;



    @BeforeEach
    void setUp() {
        Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/rentbook_test",  "sirkadima", "kadima123");
        landlordDao = new Sql2oLandlordDao(sql2o);

        conn = sql2o.open();
    }
    @AfterEach
    void tearDown() {
        System.out.println("Clearing database");
        landlordDao.clearAll();
    }
    @AfterAll
    public static void shutDown() throws Exception {
        conn.close();
        System.out.println("Connection closed");
    }

//    @Test
//    public void findById() {
//        Landlord landlord = new Landlord("Kadima", "kadima@gmail.com", "57678", "male", "New york");
//        landlordDao.add(landlord);
//        landlordDao.getAll();
//        Assertions.assertEquals(landlord, landlordDao.findById(landlord.getId()));
//    }

}
