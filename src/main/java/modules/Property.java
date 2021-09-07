package modules;

import java.util.Objects;

public class Property {

    private int id;
    private String name;
    private String location;
    private int number_of_house_units;
    private long rent_per_unit;
    private boolean has_electricity;
    private boolean has_water;
    private boolean has_internet;
    private String caretaker_name;
    private String caretaker_phone_number;
    private int landlord_id;

    public Property(String name, String location, int number_of_house_units, long rent_per_unit, boolean has_electricity, boolean has_water, boolean has_internet, String caretaker_name, String caretaker_phone_number, int landlord_id) {
        this.name = name;
        this.location = location;
        this.number_of_house_units = number_of_house_units;
        this.rent_per_unit = rent_per_unit;
        this.has_electricity = has_electricity;
        this.has_water = has_water;
        this.has_internet = has_internet;
        this.caretaker_name = caretaker_name;
        this.caretaker_phone_number = caretaker_phone_number;
        this.landlord_id = landlord_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumber_of_house_units() {
        return number_of_house_units;
    }

    public void setNumber_of_house_units(int number_of_house_units) {
        this.number_of_house_units = number_of_house_units;
    }

    public long getRent_per_unit() {
        return rent_per_unit;
    }

    public void setRent_per_unit(long rent_per_unit) {
        this.rent_per_unit = rent_per_unit;
    }

    public boolean isHas_electricity() {
        return has_electricity;
    }

    public void setHas_electricity(boolean has_electricity) {
        this.has_electricity = has_electricity;
    }

    public boolean isHas_water() {
        return has_water;
    }

    public void setHas_water(boolean has_water) {
        this.has_water = has_water;
    }

    public boolean isHas_internet() {
        return has_internet;
    }

    public void setHas_internet(boolean has_internet) {
        this.has_internet = has_internet;
    }

    public String getCaretaker_name() {
        return caretaker_name;
    }

    public void setCaretaker_name(String caretaker_name) {
        this.caretaker_name = caretaker_name;
    }

    public String getCaretaker_phone_number() {
        return caretaker_phone_number;
    }

    public void setCaretaker_phone_number(String caretaker_phone_number) {
        this.caretaker_phone_number = caretaker_phone_number;
    }

    public int getLandlord_id() {
        return landlord_id;
    }

    public void setLandlord_id(int landlord_id) {
        this.landlord_id = landlord_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return number_of_house_units == property.number_of_house_units && rent_per_unit == property.rent_per_unit && has_electricity == property.has_electricity && has_water == property.has_water && has_internet == property.has_internet && landlord_id == property.landlord_id && name.equals(property.name) && location.equals(property.location) && caretaker_name.equals(property.caretaker_name) && caretaker_phone_number.equals(property.caretaker_phone_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, number_of_house_units, rent_per_unit, has_electricity, has_water, has_internet, caretaker_name, caretaker_phone_number, landlord_id);
    }
}
