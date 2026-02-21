package com.gl.app.controller;

import java.util.Scanner;

public class MainController {
    private AdminController adminController;
    private GuestController guestController;

    public MainController(AdminController adminController, GuestController guestController) {
        this.adminController = adminController;
        this.guestController = guestController;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("0. Exit");
            System.out.println("1. Admin Menu");
            System.out.println("2. Guest Menu");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Good Bye!");
                    scanner.close();
                    return;
                case 1:
                    adminController.run(scanner);
                    break;
                case 2:
                    guestController.run(scanner);
                    break;
                default:
                    System.out.println("Invalid Choice! Try again!");
                    break;
            }
        }
    }
}
