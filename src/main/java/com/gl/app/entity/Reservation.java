package com.gl.app.entity;

import java.util.Date;

public class Reservation {
    private int reservation_id;
    private int guest_id;
    private int room_number;
    private Date checkInDate;
    private Date checkOutDate;
    private String status;
    private int hotel_id;

    public Reservation(int reservation_id, int guest_id, int room_number, Date checkInDate, Date checkOutDate, int hotel_id) {
        this.reservation_id = reservation_id;
        this.guest_id = guest_id;
        this.room_number = room_number;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = "CONFIRMED";
        this.hotel_id = hotel_id;
    }

    public int  getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void cancelReservation() {
        this.status = "CANCELLED";
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
        sb.append("guest id: ").append(guest_id);
        sb.append(", room number: ").append(room_number);
        sb.append(", check in: ").append(checkInDate);
        sb.append(", check out: ").append(checkOutDate);
        sb.append(", status: ").append(status);
        sb.append(", hotel id: ").append(hotel_id).append("\n");
        return sb.toString();
    }
}
