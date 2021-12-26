import java.util.ArrayList;
import java.util.Scanner;

public class Solver {

    public static void main(String[] args) {
        ArrayList<Integer> vet = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);

        while (true) {
            String line = scan.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            String cmd = ui[0];

            if (line.equals("end")) {
                break;
            } else if (cmd.equals("show")) {
                System.out.print("[ ");
                for (Integer value : vet)
                    System.out.print(value + " ");
                System.out.print("]\n");
            } else if (cmd.equals("rshow")) {
                System.out.print("[ ");
                for (int i = vet.size() - 1; i >= 0; i--) {
                    System.out.print(vet.get(i) + " ");
                }
                System.out.print("]\n");
            } else if (cmd.equals("add")) {
                for (int i = 1; i < ui.length; i++)
                    vet.add(Integer.parseInt(ui[i]));
            } else if (cmd.equals("find")) {
                System.out.print("[ ");
                for (int i = 1; i < ui.length; i++) {
                    if (vet.indexOf(Integer.parseInt(ui[i])) == -1) {
                        System.out.print(-1 + " ");
                    } else {
                        System.out.print(vet.indexOf(Integer.parseInt(ui[i])) + " ");
                    }
                }
                System.out.print("]\n");
            } else if (cmd.equals("get")) {
                System.out.print(vet.get(Integer.parseInt(ui[1])) + "\n");
            } else if (cmd.equals("set")) {
                vet.set(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            } else if (cmd.equals("ins")) {
                if (Integer.parseInt(ui[1]) < 0) {
                    continue;
                } else if (Integer.parseInt(ui[1]) > vet.size()) {
                    vet.add(vet.size(), Integer.parseInt(ui[2]));
                } else {
                    vet.add(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
                }
            } else if (cmd.equals("rmi")) {
                if (Integer.parseInt(ui[1]) < 0 || Integer.parseInt(ui[1]) > vet.size() - 1) {
                    System.out.print("fail\n");
                } else {
                    vet.remove(Integer.parseInt(ui[1]));
                }
            } else if (cmd.equals("rma")) {
                vet.removeIf(number -> number == Integer.parseInt(ui[1]));
            } else {
                System.out.print("fail: command not found\n");
            }
        }
        scan.close();
    }
}