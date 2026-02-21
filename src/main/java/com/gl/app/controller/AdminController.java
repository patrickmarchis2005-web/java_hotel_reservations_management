package com.gl.app.controller;

import com.gl.app.entity.Hotel;
import com.gl.app.entity.Reservation;
import com.gl.app.entity.Room;
import com.gl.app.service.GuestService;
import com.gl.app.service.HotelService;
import com.gl.app.service.ReservationService;
import com.gl.app.service.RoomService;

import java.util.List;
import java.util.Scanner;

public class AdminController {
    private GuestService guestService;
    private HotelService hotelService;
    private RoomService roomService;
    private ReservationService reservationService;

    public AdminController(GuestService guestService, HotelService hotelService, RoomService roomService, ReservationService reservationService) {
        this.guestService = guestService;
        this.hotelService = hotelService;
        this.roomService = roomService;
        this.reservationService = reservationService;
    }

    public void printMenu() {
        System.out.println("0. Exit");
        System.out.println("1. Add a hotel");
        System.out.println("2. See a hotel by ID");
        System.out.println("3. Add a room to a hotel");
        System.out.println("4. See all the rooms of a hotel");
        System.out.println("5. See a room by number");
        System.out.println("6. Add a guest to a hotel");
        System.out.println("7. See all reservations of a hotel");
    }

    public void addHotel(Scanner scanner) {
        System.out.println("Enter hotel name: ");
        String hotelName = scanner.nextLine();
        System.out.println("Enter hotel location: ");
        String hotelLocation = scanner.nextLine();
        Hotel hotel = hotelService.addHotel(hotelName, hotelLocation);

        if (hotel != null) {
            System.out.println("Hotel added successfully: " + hotel.toString());
        } else {
            System.out.println("Hotel could not be added");
        }
    }

    public void seeHotelById(Scanner scanner) {
        System.out.println("Enter hotel ID: ");
        int hotelId = scanner.nextInt();
        scanner.nextLine();
        Hotel hotel = hotelService.viewHotel(hotelId);

        if (hotel != null) {
            System.out.println(hotel.toString());
        } else {
            System.out.println("Hotel could not be found");
        }
    }

    public void addRoom(Scanner scanner) {
        System.out.println("Enter room number: ");
        int room_number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter room type (SINGLE/ DOUBLE): ");
        String type = scanner.nextLine();
        System.out.println("Enter room availability (true/ false): ");
        boolean available = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Enter hotel ID: ");
        int hotel_id = scanner.nextInt();
        scanner.nextLine();

        if (roomService.addRoom(room_number, type, available, hotel_id)) {
            System.out.println("Room added successfully");
        } else {
            System.out.println("Room could not be added");
        }
    }

    public void seeAllRoomsByHotel_id(Scanner scanner) {
        System.out.println("Enter hotel ID: ");
        int hotel_id = scanner.nextInt();
        scanner.nextLine();

        List<Room> rooms = roomService.getAllRoomsByHotel_id(hotel_id);
        if (rooms != null) {
            System.out.println("Rooms found successfully:");
            for (Room room : rooms) {
                System.out.println(room.toString());
            }
        } else {
            System.out.println("Rooms could not be found");
        }
    }

    public void seeRoomByNumber(Scanner scanner) {
        System.out.println("Enter room number: ");
        int room_number = scanner.nextInt();
        scanner.nextLine();

        Room room = roomService.getRoomByNumber(room_number);
        if (room != null) {
            System.out.println("Room found: " + room.toString());
        } else {
            System.out.println("Room could not be found");
        }
    }

    public void addGuest(Scanner scanner) {
        System.out.println("Enter guest ID: ");
        int guest_id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter guest name: ");
        String name = scanner.nextLine();
        System.out.println("Enter guest email: ");
        String email = scanner.nextLine();
        System.out.println("Enter guest phone: ");
        String phone = scanner.nextLine();
        System.out.println("Enter hotel ID: ");
        int hotel_id = scanner.nextInt();
        scanner.nextLine();

        if (guestService.addGuest(guest_id, name, email, phone, hotel_id)) {
            System.out.println("Guest added successfully");
        } else {
            System.out.println("Guest could not be added");
        }
    }

    public void getReservationsById(Scanner scanner) {
        System.out.println("Enter hotel ID: ");
        int hotel_id = scanner.nextInt();
        scanner.nextLine();

        List<Reservation> reservations = reservationService.getReservationsForHotel(hotel_id);
        if (reservations != null) {
            System.out.println("Reservations found successfully: ");
            for (Reservation reservation : reservations) {
                System.out.println(reservation.toString());
            }
        }
    }

    public void run(Scanner scanner) {
        System.out.println("Welcome to Admin Controller");
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    return;
                case 1:
                    addHotel(scanner);
                    break;
                case 2:
                    seeHotelById(scanner);
                    break;
                case 3:
                    addRoom(scanner);
                    break;
                case 4:
                    seeAllRoomsByHotel_id(scanner);
                    break;
                case 5:
                    seeRoomByNumber(scanner);
                    break;
                case 6:
                    addGuest(scanner);
                    break;
                case 7:
                    getReservationsById(scanner);
                    break;
                default:
                    System.out.println("Invalid Choice! Try again!");
                    break;
            }
        }
    }
}
