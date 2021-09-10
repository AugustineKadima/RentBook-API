package Dao;

import modules.Landlord;
import modules.Property;
import modules.Tenant;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oPropertyDao implements IPropertyDao{

    private final Sql2o sql2o;

    public Sql2oPropertyDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Property property) {
        String sql = "INSERT INTO properties (name,location, number_of_units, rent_per_unit, has_electricity, has_water, has_internet, caretaker_name, caretaker_phone_number, landlord_id ) VALUES (:name, :location, :number_of_units, :rent_per_unit, :has_electricity, :has_water, :has_internet, :caretaker_name, :caretaker_phone_number, :landlord_id)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(property)
                    .executeUpdate()
                    .getKey();
            property.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void addPropertyToLandlord(Property property, Landlord landlord) {
        String sql = "INSERT INTO landlords_properties (landlord_id, property_id) VALUES (:landlord_id, :property_id);";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("property_id", property.getId())
                    .addParameter("landlord_id", landlord.getId())
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void addTenantToProperty(Property property, Tenant tenant) {
        String sql = "INSERT INTO properties_tenants(tenant_id, property_id) VALUES (:tenant_id, :property_id);";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("tenant_id", tenant.getId())
                    .addParameter("property_id", property.getId())
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Property> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM properties")
                    .executeAndFetch(Property.class);
        }
    }

    @Override
    public Property findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM properties WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Property.class);
        }
    }

    @Override
    public List<Property> getAllPropertyByLandlord(int landlord_id) {
        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM properties WHERE landlord_id = :landlord_id")
                    .addParameter("landlord_id",landlord_id)
                    .executeAndFetch(Property.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from properties WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from properties";
        String resetSql = "ALTER SEQUENCE property_id_seq RESTART WITH 1;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            con.createQuery(resetSql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }
}
