package com.gl.app;


import com.gl.app.controller.AdminController;
import com.gl.app.controller.GuestController;
import com.gl.app.controller.MainController;
import com.gl.app.repository.GuestRepository;
import com.gl.app.repository.HotelRepository;
import com.gl.app.repository.ReservationRepository;
import com.gl.app.repository.RoomRepository;
import com.gl.app.service.GuestService;
import com.gl.app.service.HotelService;
import com.gl.app.service.ReservationService;
import com.gl.app.service.RoomService;


public class App {
    public static void main(String[] args) {
        GuestRepository guestRepository = new GuestRepository();
        HotelRepository hotelRepository = new HotelRepository();
        ReservationRepository reservationRepository = new ReservationRepository();
        RoomRepository roomRepository = new RoomRepository();

        GuestService guestService = new GuestService(guestRepository, hotelRepository);
        HotelService hotelService = new HotelService(hotelRepository, guestRepository, reservationRepository, roomRepository);
        ReservationService reservationService = new ReservationService(reservationRepository, guestRepository, hotelRepository);
        RoomService roomService = new RoomService(roomRepository, hotelRepository);

        AdminController adminController = new AdminController(guestService, hotelService, roomService, reservationService);
        GuestController guestController = new GuestController(reservationService);
        MainController mainController = new MainController(adminController, guestController);
        mainController.run();
    }
}
