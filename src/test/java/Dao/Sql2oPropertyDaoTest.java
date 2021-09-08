package Dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
}
