package Resrv;

import java.util.Scanner;

public class Main
{

    private static boolean[] seats = new boolean[10];

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Online Reservation system");
        System.out.print("Enter your ID: ");
        String a = scanner.nextLine();
        System.out.print("Enter your Password (Hint: count from 1to4): ");
        String b = scanner.nextLine();
        String pin = "1234";

        if (b.equals(pin)) {
            System.out.println("Hello " + a);
            while (true) {
                System.out.println("1. For View Seat Map");
                System.out.println("2. For Reserve Seat");
                System.out.println("3. For Cancel Reservation");
                System.out.println("4. For Exit");
                System.out.println("Please select an option:");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        viewSeatMap();
                        break;

                    case 2:
                        reserveSeat();
                        break;

                    case 3:
                        cancelReservation();
                        break;

                    case 4:
                        System.out.println("Have a nice day!!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid option!");
                }
            }
        }
    }
        private static void viewSeatMap () {
            System.out.println("Current Seat Map:");
            for (int i = 0; i < seats.length; i++) {
                if (seats[i]) {
                    System.out.print("X ");
                } else {
                    System.out.print((i + 1) + " ");
                }
            }
            System.out.println();
        }

        private static void reserveSeat () {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter seat number (1-10): ");
            int seatNumber = scanner.nextInt();
            if (seatNumber < 1 || seatNumber > 10) {
                System.out.println("Invalid seat number!");
            } else if (seats[seatNumber - 1]) {
                System.out.println("Seat already reserved!");
            } else {
                seats[seatNumber - 1] = true;
                System.out.println("Seat reserved!");
            }
        }

        private static void cancelReservation () {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter seat number (1-10): ");
            int seatNumber = scanner.nextInt();
            if (seatNumber < 1 || seatNumber > 10) {
                System.out.println("Invalid seat number!");
            } else if (!seats[seatNumber - 1]) {
                System.out.println("Seat not reserved!");
            } else {
                seats[seatNumber - 1] = false;
                System.out.println("Reservation canceled!");
            }
        }
}

