import Dao.Sql2oLandlordDao;
import Dao.Sql2oPropertyDao;
import Dao.Sql2oTenantDao;
import com.google.gson.Gson;
import modules.Landlord;
import modules.Property;
import modules.Tenant;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Connection conn;
        Sql2oTenantDao tenantDao;
        Sql2oLandlordDao landlordDao;
        Sql2oPropertyDao propertyDao;
        Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/rentbook",  "sirkadima", "kadima123");

        tenantDao = new Sql2oTenantDao(sql2o);
        landlordDao = new Sql2oLandlordDao(sql2o);
        propertyDao = new Sql2oPropertyDao(sql2o);

        conn = sql2o.open();
        Gson gson = new Gson();


        //CREATE LANDLORD
        post("/landlords/new", "application/json", (req, res) -> {
            Landlord landlord = gson.fromJson(req.body(), Landlord.class);
            landlordDao.add(landlord);
            res.status(201);
            return gson.toJson(landlord);
        });

        //GET ALL LANDLORDS
        get("/landlords", "application/json", (req, res) -> {
            return gson.toJson(landlordDao.getAll());
        });

        //GET LANDLORD BY ID
        get("/landlords/:id", "application/json", (req, res) -> {
            int landlordId = Integer.parseInt(req.params("id"));
            Landlord landlordToFind = landlordDao.findById(landlordId);
            return gson.toJson(landlordToFind);
        });

        //DELETE LANDLORD BY ID
        delete("/landlords/:landlord_id", (req, res) -> {
            int landlord_id = Integer.parseInt(req.params("landlord_id"));
            Landlord landlordToDelete = landlordDao.findById(landlord_id);
            landlordDao.deleteById(landlord_id);
            return gson.toJson(landlordToDelete);
        });

        //CREATE TENANT
        post("/tenants/new", "application/json", (req, res) -> {
            Tenant tenant = gson.fromJson(req.body(), Tenant.class);
            tenantDao.add(tenant);
            res.status(201);
            return gson.toJson(tenant);
        });

        //GET ALL TENANTS
        get("/tenants", "application/json", (req, res) -> {
            return gson.toJson(tenantDao.getAll());
        });

        //GET TENANT BY ID
        get("/tenants/:id", "application/json", (req, res) -> {
            int tenantId = Integer.parseInt(req.params("id"));
            Tenant tenantToFind = tenantDao.findById(tenantId);
            return gson.toJson(tenantToFind);
        });

        //DELETE TENANT BY ID
        delete("tenants/:tenant_id", (req, res) -> {
            int tenant_id = Integer.parseInt(req.params("tenant_id"));
            Tenant tenantToDelete = tenantDao.findById(tenant_id);
            tenantDao.deleteById(tenant_id);
            return gson.toJson(tenantToDelete);
        });

        //CREATE PROPERTY
        post("/properties/new", "application/json", (req, res) -> {
            Property property = gson.fromJson(req.body(), Property.class);
            propertyDao.add(property);
            res.status(201);
            return gson.toJson(property);
        });

        //GET ALL PROPERTIES
        get("/properties", "application/json", (req, res) -> {
            return gson.toJson(propertyDao.getAll());
        });

        //GET PROPERTY BY ID
        get("/properties/:id", "application/json", (req, res) -> {
            int propertyId = Integer.parseInt(req.params("id"));
            Property propertyToFind = propertyDao.findById(propertyId);
            return gson.toJson(propertyToFind);
        });

        //DELETE PROPERTY BY ID
        delete("properties/:property_id", (req, res) -> {
            int property_id = Integer.parseInt(req.params("user_id"));
            Property propertyToDelete = propertyDao.findById(property_id);
            propertyDao.deleteById(property_id);
            return gson.toJson(propertyToDelete);
        });


        //ALL PROPERTY PER LANDLORD
        get("/landlords/:landlord_id/properties", "application/json", (req, res) -> {
            int landlord_id = Integer.parseInt(req.params("landlord_id"));
            Landlord landlordToFind = landlordDao.findById(landlord_id);
            if (landlordToFind == null) {
                throw new Exception();
            }
            List<Property> allProperty = propertyDao.getAllPropertyByLandlord(landlord_id);
            return gson.toJson(allProperty);
        });

//        CREATE NEW TENANTS WITH PROPERTY ID
        post("/properties/:property_id/tenants/new", "application/json", (req, res) -> {
            int property_id = Integer.parseInt(req.params("property_id"));
            Tenant tenant = gson.fromJson(req.body(), Tenant.class);
            tenant.setProperty_id(property_id);
            tenantDao.add(tenant);
            res.status(201);
            return gson.toJson(tenant);
        });

        //ALL TENANTS PER PROPERTY
        get("/properties/:property_id/tenants", "application/json", (req, res) -> {
            int property_id = Integer.parseInt(req.params("property_id"));
            Property propertyToFind = propertyDao.findById(property_id);
            if (propertyToFind == null) {
                throw new Exception();
            }
            List<Tenant> allTenants = tenantDao.getAllTenantsByProperty(property_id);
            return gson.toJson(allTenants);
        });

        //    CREATE NEW PROPERTY WITH LANDLORD ID
        post("/landlords/:landlord_id/properties/new", "application/json", (req, res) -> {
            int landlord_id = Integer.parseInt(req.params("landlord_id"));
            Property property = gson.fromJson(req.body(), Property.class);
            property.setLandlord_id(landlord_id);
            propertyDao.add(property);
            res.status(201);
            return gson.toJson(property);
        });

        //ALL PROPERTY PER LANDLORD
        get("/landlords/:landlord_id/properties", "application/json", (req, res) -> {
            int landlord_id = Integer.parseInt(req.params("landlord_id"));
            Landlord landlordToFind = landlordDao.findById(landlord_id);
            if (landlordToFind == null) {
                throw new Exception();
            }
            List<Property> allProperty = propertyDao.getAllPropertyByLandlord(landlord_id);
            return gson.toJson(allProperty);
        });

    }
}
