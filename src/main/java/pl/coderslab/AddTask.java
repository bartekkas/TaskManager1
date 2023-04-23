package pl.coderslab;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddTask {
    public static void task() {

        Scanner scanner = new Scanner(System.in);
        StringBuilder writing = new StringBuilder();
        String[] taskDescription = {"Please add task description", "Please add task due date", "Is your task is important: true/false"};
        for(String item : taskDescription){
            System.out.println(item);
            writing.append(scanner.nextLine() + ", ");
        }
        try(FileWriter fileWriter = new FileWriter("tasks.csv", true)){

            fileWriter.append("\n").append(writing.toString().substring(0, writing.length()-2));

        }catch (IOException e){
            System.out.println("Problem with write to file");
        }

    }
}
