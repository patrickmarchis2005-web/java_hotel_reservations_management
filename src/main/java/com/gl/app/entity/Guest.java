package com.gl.app.entity;

public class Guest {
    private int guest_id;
    private String email;
    private String name;
    private String phone;
    private int hotel_id;

    public Guest(int guest_id, String email, String name, String phone, int hotel_id) {
        this.guest_id = guest_id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.hotel_id = hotel_id;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("guest_id: ").append(guest_id);
        sb.append(", email: ").append(email);
        sb.append(", name: ").append(name);
        sb.append(", phone: ").append(phone);
        sb.append(", hotel_id: ").append(hotel_id).append("\n");
        return sb.toString();
    }

}
