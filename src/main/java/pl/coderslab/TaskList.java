package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskList {

    public static void tasks(){

        File file = new File("tasks.csv");
        StringBuilder reading = new StringBuilder();
        try (Scanner scan = new Scanner(file)){
            while (scan.hasNextLine()){
                reading.append(scan.nextLine() + "\n");
            }

            String[] tasks = reading.toString().split("\n");
            int counter = 1;
            for(String item : tasks){
                System.out.println(counter++ + " : " + item);
            }
        } catch (FileNotFoundException e) {
            System.out.println("There is no such file " + file);

        }
    }
}
