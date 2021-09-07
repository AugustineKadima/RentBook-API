package modules;

import java.util.Objects;

public class Tenant {
    private String name;
    private String email;
    private String phone_number;
    private String id_number;
    private int age;
    private String occupation;
    private String gender;
    private boolean has_family;
    private long paid_deposit;
    private long paid_rent;
    private long rent_balance;
    private String house_number;
    private int property_id;

    public Tenant(String name, String email, String phone_number, String id_number, int age, String occupation, String gender, boolean has_family, long paid_deposit, long paid_rent, long rent_balance, String house_number, int property_id) {
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.id_number = id_number;
        this.age = age;
        this.occupation = occupation;
        this.gender = gender;
        this.has_family = has_family;
        this.paid_deposit = paid_deposit;
        this.paid_rent = paid_rent;
        this.rent_balance = rent_balance;
        this.house_number = house_number;
        this.property_id = property_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isHas_family() {
        return has_family;
    }

    public void setHas_family(boolean has_family) {
        this.has_family = has_family;
    }

    public long getPaid_deposit() {
        return paid_deposit;
    }

    public void setPaid_deposit(long paid_deposit) {
        this.paid_deposit = paid_deposit;
    }

    public long getPaid_rent() {
        return paid_rent;
    }

    public void setPaid_rent(long paid_rent) {
        this.paid_rent = paid_rent;
    }

    public long getRent_balance() {
        return rent_balance;
    }

    public void setRent_balance(long rent_balance) {
        this.rent_balance = rent_balance;
    }

    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tenant tenant = (Tenant) o;
        return age == tenant.age && has_family == tenant.has_family && paid_deposit == tenant.paid_deposit && paid_rent == tenant.paid_rent && rent_balance == tenant.rent_balance && property_id == tenant.property_id && name.equals(tenant.name) && email.equals(tenant.email) && phone_number.equals(tenant.phone_number) && id_number.equals(tenant.id_number) && occupation.equals(tenant.occupation) && gender.equals(tenant.gender) && house_number.equals(tenant.house_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phone_number, id_number, age, occupation, gender, has_family, paid_deposit, paid_rent, rent_balance, house_number, property_id);
    }
}
