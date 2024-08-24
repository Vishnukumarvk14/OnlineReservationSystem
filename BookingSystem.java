package org.example;

import java.util.Scanner;

public class BookingSystem {

    private static boolean[] seats = new boolean[10];
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            // display menu
            System.out.println("\nPlease choose an option:");
            System.out.println("1. View Seating Arrangement");
            System.out.println("2. Book a Seat");
            System.out.println("3. Cancel a Booking");
            System.out.println("4. Exit");

            // get user input
            int option = scanner.nextInt();

            switch (option) {

                case 1:
                    viewSeatingArrangement();
                    break;

                case 2:
                    reserveSeat();
                    break;

                case 3:
                    cancelReservation();
                    break;

                case 4:
                    System.exit(0); // exit the program

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void viewSeatingArrangement() {
        System.out.println("\nCurrent Seating Arrangement:");
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                System.out.print("X "); // print an "X" if the seat is booked
            } else {
                System.out.print((i + 1) + " "); // print the seat number if it's available
            }
        }
        System.out.println();
    }

    private static void reserveSeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (seats[seatNumber - 1]) {
            System.out.println("Seat already booked!");
        } else {
            seats[seatNumber - 1] = true; // book the seat
            System.out.println("Seat booked successfully!");
        }
    }

    private static void cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (!seats[seatNumber - 1]) {
            System.out.println("Seat not booked yet!");
        } else {
            seats[seatNumber - 1] = false; // unbook the seat
            System.out.println("Booking canceled successfully!");
        }
    }
}
