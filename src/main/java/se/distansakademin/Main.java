package se.distansakademin;

import se.distansakademin.tasks.PriorityTask;
import se.distansakademin.tasks.RegularTask;
import se.distansakademin.tasks.Task;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskManager taskManager = new TaskManager("tasks.txt");

    public static void main(String[] args) {


        while(true){

            int choice = mainMenu();

            boolean shouldExitProgram = handleChoice(choice);

            if (shouldExitProgram) break;
            
        }
    }

    private static boolean handleChoice(int choice) {
        if(choice == 0){
            System.out.println("Exiting...");
            return true;
        }else if(choice == 1){
            taskManager.showTasks();
        }else if(choice == 2){
            System.out.print("Enter task name: ");
            String name = scanner.nextLine();
            taskManager.addTask(name);
        }else if(choice == 3){
            System.out.print("Enter task name: ");
            String name = scanner.nextLine();
            System.out.print("Priority: ");
            int priority = scanner.nextInt();
            taskManager.addTask(name, priority);
        }else if(choice == 4){
            System.out.print("Enter name of task to complete: ");
            String name = scanner.nextLine();
            taskManager.markTaskAsCompleted(name);
        }
        else{
            System.out.println("Invalid choice");
        }

        return false;
    }

    private static int mainMenu() {
        System.out.println("\nMain menu:");
        System.out.println("0. Exit");
        System.out.println("1. Show tasks");
        System.out.println("2. Add regular task");
        System.out.println("3. Add priority task");
        System.out.println("4. Mark task as completed");
        System.out.print("Choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume new line

        return choice;
    }
}