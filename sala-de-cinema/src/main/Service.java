package main;

import java.util.Scanner;

public class Service {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Room room = new Room(0);
        while (true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" "); // ui user input eh um vetor de strings
            System.out.println("$" + line);
            if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("init")) { // power
                room = new Room(Integer.parseInt(ui[1]));
            } else if (ui[0].equals("reservar")) { // in id phone num
                String id = ui[1];
                String phone = ui[2];
                int numChair = Integer.parseInt(ui[3]);
                room.reserve(id, phone, numChair);
            } else if (ui[0].equals("cancelar")) { // in id phone num
                String id = ui[1];
                room.cancel(id);
            } else if (ui[0].equals("show")) {
                System.out.println(room);
            } else {
                System.out.println("Comando invalido");
            }
        }
        scanner.close();
    }
}
