package com.gl.app.service;

import com.gl.app.entity.Hotel;
import com.gl.app.entity.Room;
import com.gl.app.repository.HotelRepository;
import com.gl.app.repository.RoomRepository;

import java.util.List;

public class RoomService {
    private RoomRepository roomRepo;
    private HotelRepository hotelRepo;

    public RoomService(RoomRepository roomRepo, HotelRepository hotelRepo) {
        this.roomRepo = roomRepo;
        this.hotelRepo = hotelRepo;
    }

    public boolean addRoom(int room_number, String type, boolean available, int hotel_id) {
        Room newRoom = new Room(room_number, type, available, hotel_id);
        for (Hotel hotel : hotelRepo.getAllHotels()) {
            if (hotel.getHotel_id() == hotel_id) {
                roomRepo.addRoom(newRoom);
                return true;
            }
        }
        return false;
    }

    public List<Room> getAllRoomsByHotel_id(int hotel_id) {
        boolean hotelWasFound = false;
        for (Hotel hotel : hotelRepo.getAllHotels()) {
            if (hotel.getHotel_id() == hotel_id) {
                hotelWasFound = true;
            }
        }

        if (!hotelWasFound) {
            return null;
        }

        return roomRepo.getRoomsByHotel(hotel_id);
    }

    public Room getRoomByNumber(int room_number) {
        return roomRepo.getRoom(room_number);
    }
}
