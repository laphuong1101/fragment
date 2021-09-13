package com.example.fragment;

public class ContactEntity {
    private String name, phone;

    public ContactEntity(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ContactEntity) {
            ContactEntity contactEntity = (ContactEntity) obj;
            return contactEntity.getPhone().equals(this.phone);
        }

        return super.equals(obj);
    }

}
