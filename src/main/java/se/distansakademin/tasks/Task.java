package se.distansakademin.tasks;

public abstract class Task {

    protected String name;
    protected boolean isCompleted = false;

    public Task(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public boolean getIsCompleted(){
        return isCompleted;
    }

    public void markAsCompleted(){
        isCompleted = true;
    }

    // Virtual method to override in subclasses
    public abstract String taskInfo();

    @Override
    public String toString(){
        String isCompletedString = (isCompleted ? "Completed" : "Not completed");
        return taskInfo() + " - " + isCompletedString;
    }

}
