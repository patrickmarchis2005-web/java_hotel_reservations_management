package com.gl.app.entity;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private int hotel_id;
    private String name;
    private String location;
    private List<Room> rooms;
    private List<Guest> guests;
    private List<Reservation> reservations;

    public Hotel(String name, String location) {
        this.hotel_id = 0;
        this.name = name;
        this.location = location;
        this.rooms = new ArrayList<>();
        this.guests = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public int  getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
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

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void removeRoom(Room room) {
        this.rooms.remove(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addGuest(Guest guest) {
        this.guests.add(guest);
    }

    public void removeGuest(Guest guest) {
        this.guests.remove(guest);
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        this.reservations.remove(reservation);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("hotel_id: ").append(hotel_id).append("\n");
        sb.append("name: ").append(name).append("\n");
        sb.append("location: ").append(location).append("\n");
        if (!rooms.isEmpty()) {
            sb.append("rooms: \n");
            for (Room room : rooms) {
                sb.append("\t").append(room.toString());
            }
        }
        if (!guests.isEmpty()) {
            sb.append("guests: \n");
            for (Guest guest : guests) {
                sb.append("\t").append(guest.toString());
            }
        }
        if (!reservations.isEmpty()) {
            sb.append("reservations: \n");
            for (Reservation reservation : reservations) {
                sb.append("\t").append(reservation.toString());
            }
        }
        return sb.toString();
    }
}
