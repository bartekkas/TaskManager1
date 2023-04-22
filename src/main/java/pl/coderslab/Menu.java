package pl.coderslab;

import java.util.Scanner;

public class Menu {
    public static void menu(){
        boolean loopIsWorking = true;
        while(loopIsWorking) {
            System.out.println(ConsoleColors.BLUE + "Please select an option");
            String[] menuOptions = {"add", "remove", "list", "exit"};
            for (String item : menuOptions) {
                System.out.println(ConsoleColors.WHITE + item);
            }
            Scanner scan = new Scanner(System.in);
            String option = scan.next().toLowerCase();

            switch (option) {
                case "add":
                    AddTask.task();
                    break;
                case "remove":
                    RemoveTask.remove();
                    break;
                case "list":
                    TaskList.tasks();
                    break;
                case "exit":
                    System.out.println(ConsoleColors.RED + "Bye, bye");
                    loopIsWorking = false;
                    break;
                default:
                    System.out.println(ConsoleColors.RED + "You have given wrong option, please try again");
            }
        }
    }
}
