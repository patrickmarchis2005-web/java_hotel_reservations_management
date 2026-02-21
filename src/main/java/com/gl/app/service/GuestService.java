package com.gl.app.service;

import com.gl.app.entity.Guest;
import com.gl.app.entity.Hotel;
import com.gl.app.repository.GuestRepository;
import com.gl.app.repository.HotelRepository;

public class GuestService {
    private GuestRepository guestRepo;
    private HotelRepository hotelRepo;

    public GuestService(GuestRepository guestRepo, HotelRepository hotelRepo) {
        this.guestRepo = guestRepo;
        this.hotelRepo = hotelRepo;
    }

    public boolean addGuest(int guest_id, String email, String name, String phone, int hotel_id) {
        Guest newGuest = new Guest(guest_id, email, name, phone, hotel_id);
        for (Hotel hotel : hotelRepo.getAllHotels()) {
            if (hotel.getHotel_id() == hotel_id) {
                guestRepo.addGuest(newGuest);
                return true;
            }
        }
        return false;
    }
}
