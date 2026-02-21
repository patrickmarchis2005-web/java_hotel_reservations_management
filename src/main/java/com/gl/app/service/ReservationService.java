package com.gl.app.service;

import com.gl.app.entity.Guest;
import com.gl.app.entity.Hotel;
import com.gl.app.entity.Reservation;
import com.gl.app.repository.GuestRepository;
import com.gl.app.repository.HotelRepository;
import com.gl.app.repository.ReservationRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationService {
    private ReservationRepository reservationRepo;
    private GuestRepository guestRepo;
    private HotelRepository hotelRepo;

    public ReservationService(ReservationRepository reservationRepo, GuestRepository guestRepo, HotelRepository hotelRepo) {
        this.reservationRepo = reservationRepo;
        this.guestRepo = guestRepo;
        this.hotelRepo = hotelRepo;
    }

    public boolean addReservation(int reservation_id, int guest_id, int room_number, Date checkInDate, Date checkOutDate, int hotel_id) {
        boolean guestWasFound = false;
        boolean hotelWasFound = false;
        for (Guest guest : guestRepo.getAllGuests()) {
            if (guest.getGuest_id() == guest_id) {
                guestWasFound = true;
            }
        }
        for (Hotel hotel : hotelRepo.getAllHotels()) {
            if (hotel.getHotel_id() == hotel_id) {
                hotelWasFound = true;
            }
        }
        if (!guestWasFound || !hotelWasFound) {
            return false;
        }

        Reservation newReservation = new Reservation(reservation_id, guest_id, room_number, checkInDate, checkOutDate, hotel_id);
        reservationRepo.addReservation(newReservation);
        return true;
    }

    public boolean cancelReservation(int reservation_id) {
        Reservation reservation = reservationRepo.getReservation(reservation_id);
        if (reservation == null) {
            return false;
        }

        // if I arrive here, it means that the reservation_id is valid
        reservationRepo.deleteReservation(reservation_id);
        return true;
    }

    public List<Reservation> getReservationsForHotel(int hotel_id) {
        List<Reservation> reservations = new ArrayList<>();
        for (Reservation reservation : reservationRepo.getAllReservations()) {
            if (reservation.getHotel_id() == hotel_id) {
                reservations.add(reservation);
            }
        }
        return reservations;
    }
}
