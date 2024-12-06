package se.distansakademin;

import se.distansakademin.tasks.PriorityTask;
import se.distansakademin.tasks.RegularTask;
import se.distansakademin.tasks.Task;

import java.io.*;
import java.util.ArrayList;

public class TaskManager {

    private final ArrayList<Task> tasks;
    private final String fileName;

    public TaskManager(String fileName){
        tasks = new ArrayList<>();
        this.fileName = fileName;

        loadTasksFromFile();
    }

    public void addTask(String name){
        Task task = new RegularTask(name);
        tasks.add(task);
        System.out.println("Regular task added");
        saveTasksToFile();
    }

    public void addTask(String name, int priority){
        Task task = new PriorityTask(name, priority);
        tasks.add(task);
        System.out.println("Priority task added");
        saveTasksToFile();
    }

    public void showTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks in your todo");
            return;
        }

        System.out.println("Tasks:");
        for(Task task : tasks){
            System.out.println(task);
        }
    }

    public void markTaskAsCompleted(String name){
        for(Task task : tasks){
            if(task.getName().equalsIgnoreCase(name)){
                task.markAsCompleted();
                System.out.println("Task '" + task.getName() + "' completed");
                saveTasksToFile();
                return;
            }
        }

        System.out.println("Task not found: " + name);
    }

    private void saveTasksToFile(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){

            for(Task task : tasks){
                String taskTypeString = (task instanceof RegularTask ? "REGULAR - " : "PRIORITY - ");
                bw.write(taskTypeString);

                bw.write(task.getName() + " - ");

                if(task instanceof PriorityTask){
                    int priority = ((PriorityTask)task).getPriority();
                    bw.write(priority + " - ");
                }

                String isCompletedString = (task.getIsCompleted() ? "COMPLETED" : "NOT_COMPLETED");
                bw.write(isCompletedString);

                bw.newLine();
            }

            System.out.println("Tasks saved to file");
        } catch (IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private void loadTasksFromFile(){
        File file = new File(fileName);

        if (!file.exists()){
            System.out.println("No tasks file found, starting from scratch");
            return;
        }

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;

            while((line = br.readLine()) != null){
                String[] parts = line.split(" - ");

                String taskType = parts[0];
                String taskName = parts[1];

                Task task;

                if(taskType.equals("REGULAR")){
                    task = new RegularTask(taskName);
                }else{
                    int priority = Integer.parseInt(parts[2]);
                    task = new PriorityTask(taskName, priority);
                }

                String completedString = parts[parts.length -1];

                if(completedString.equals("COMPLETED")){
                    task.markAsCompleted();
                }

                tasks.add(task);
            }
        }catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
