package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RemoveTask {

    public static void remove() {

        System.out.println("Enter the task number you wish to delete: ");
        Scanner scanner = new Scanner(System.in);
        String taskId = scanner.nextLine();
        if(NumberUtils.isParsable(taskId)){
            System.out.println(taskId);
            File file = new File("tasks.csv");
            StringBuilder reading = new StringBuilder();

            try (Scanner scanFile = new Scanner(file)) {
                while (scanFile.hasNextLine()) {
                    reading.append(scanFile.nextLine() + "\n");
                }
                String[] tasks = reading.toString().split("\n");
                tasks = ArrayUtils.remove(tasks, Integer.parseInt(taskId)-1);

                try(FileWriter fileWriter = new FileWriter("tasks.csv", false)){
                    for(String item : tasks){
                        fileWriter.append(item).append("\n");
                    }
                }catch (IOException e){
                    System.out.println("Problem with write to file " + file);
                }
            } catch (FileNotFoundException e){
                System.out.println("There is no such file " + file);
            }
        } else {
                System.out.println("You have given a wrong number");
            }



    }
}
