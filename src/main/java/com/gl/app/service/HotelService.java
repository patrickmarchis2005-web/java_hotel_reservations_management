package com.gl.app.service;

import com.gl.app.entity.Guest;
import com.gl.app.entity.Hotel;
import com.gl.app.entity.Reservation;
import com.gl.app.entity.Room;
import com.gl.app.repository.GuestRepository;
import com.gl.app.repository.HotelRepository;
import com.gl.app.repository.ReservationRepository;
import com.gl.app.repository.RoomRepository;

public class HotelService {
    private HotelRepository hotelRepo;
    private GuestRepository guestRepo;
    private ReservationRepository reservationRepo;
    private RoomRepository roomRepo;

    public HotelService(HotelRepository hotelRepo, GuestRepository guestRepo, ReservationRepository reservationRepo, RoomRepository roomRepo) {
        this.hotelRepo = hotelRepo;
        this.guestRepo = guestRepo;
        this.reservationRepo = reservationRepo;
        this.roomRepo = roomRepo;
    }

    public Hotel addHotel(String name, String location) {
        Hotel newHotel = new Hotel(name, location);
        return hotelRepo.addHotel(newHotel);
    }

    public Hotel viewHotel(int hotel_id) {
        Hotel hotel = hotelRepo.getHotel(hotel_id);
        if (hotel == null) {
            return null;
        }

        for (Guest guest : guestRepo.getAllGuests()) {
            if (guest.getHotel_id() == hotel_id) {
                hotel.addGuest(guest);
            }
        }
        for (Room room : roomRepo.getAllRooms()) {
            if (room.getHotel_id() == hotel_id) {
                hotel.addRoom(room);
            }
        }
        for (Reservation reservation : reservationRepo.getAllReservations()) {
            if (reservation.getHotel_id() == hotel_id) {
                hotel.addReservation(reservation);
            }
        }
        return hotel;
    }
}
