package Dao;

import modules.Property;

import java.util.List;

public interface IPropertyDao {
//    Create
    void add(Property property);

//    Read
    List<Property> getAll();
    Property findById(int id);

//    Update


//    Delete
    void deleteById(int id);
    void clearAll();
}
