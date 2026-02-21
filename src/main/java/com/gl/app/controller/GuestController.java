package com.gl.app.controller;

import com.gl.app.service.ReservationService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class GuestController {
    private ReservationService reservationService;

    public GuestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public void printMenu() {
        System.out.println("0. Exit");
        System.out.println("1. Create Reservation");
        System.out.println("2. Cancel Reservation by ID");
    }

    public void createReservation(Scanner scanner) {
        System.out.println("Enter reservation ID: ");
        int reservation_id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter guest ID: ");
        int guest_id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter room number: ");
        int room_number = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter check in date (YYYY-MM-DD): ");
        String stringCheckInDate = scanner.next();
        scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localCheckInDate = LocalDate.parse(stringCheckInDate, formatter);
        Date checkInDate = Date.from(localCheckInDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        System.out.println("Enter check out date (YYYY-MM-DD): ");
        String stringCheckOutDate = scanner.next();
        scanner.nextLine();
        LocalDate localCheckOutDate = LocalDate.parse(stringCheckOutDate, formatter);
        Date checkOutDate = Date.from(localCheckOutDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        System.out.println("Enter hotel ID: ");
        int hotel_id = scanner.nextInt();
        scanner.nextLine();

        if (reservationService.addReservation(reservation_id, guest_id, room_number, checkInDate, checkOutDate, hotel_id)) {
            System.out.println("Reservation has been created and added");
        } else {
            System.out.println("Reservation not added");
        }
    }

    public void cancelReservation(Scanner scanner) {
        System.out.println("Enter reservation ID: ");
        int reservation_id = scanner.nextInt();
        scanner.nextLine();

        if (reservationService.cancelReservation(reservation_id)) {
            System.out.println("Reservation has been cancelled");
        } else {
            System.out.println("Reservation not cancelled");
        }
    }

    public void run(Scanner scanner) {
        System.out.println("Welcome to Guest Controller");
        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    return;
                case 1:
                    createReservation(scanner);
                    break;
                case 2:
                    cancelReservation(scanner);
                    break;
                default:
                    System.out.println("Invalid Choice! Try again!");
                    break;
            }
        }
    }
}
