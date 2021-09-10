package Dao;

import modules.Property;
import modules.Tenant;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oTenantDao implements ITenantDao{

    private final Sql2o sql2o;

    public Sql2oTenantDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Tenant tenant) {
        String sql = "INSERT INTO tenants (name, email, phone_number, id_number, age,  occupation, gender, has_family, paid_deposit, paid_rent, rent_balance, house_number, property_id) VALUES (:name, :email, :phone_number, :id_number, :age,  :occupation, :gender, :has_family, :paid_deposit, :paid_rent, :rent_balance, :house_number, :property_id)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(tenant)
                    .executeUpdate()
                    .getKey();
            tenant.setId(id);
        } catch (Sql2oException ex) {
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
    public Tenant findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM tenants WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Tenant.class);
        }
    }

    @Override
    public List<Tenant> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM tenants")
                    .executeAndFetch(Tenant.class);
        }
    }

    @Override
    public List<Tenant> getAllTenantsByProperty(int property_id) {
        try (Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM tenants WHERE property_id = :property_id")
                    .addParameter("property_id",property_id)
                    .executeAndFetch(Tenant.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from tenants WHERE id = :id";
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
        String sql = "DELETE from tenants";
        String resetSql = "ALTER SEQUENCE tenant_id_seq RESTART WITH 1;";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            con.createQuery(resetSql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}
