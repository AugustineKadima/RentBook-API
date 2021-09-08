package Dao;

import modules.Tenant;

import java.util.List;

public interface ITenantDao {
//    Create
    void add(Tenant tenant);

//    Read
    Tenant findById(int id);
    List<Tenant> getAll();
    List<Tenant> getAllTenantsByProperty(int property_id);

//    Update


//    Delete
    void deleteById(int id);
    void clearAll();
}
