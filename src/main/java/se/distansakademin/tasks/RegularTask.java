package se.distansakademin.tasks;

public class RegularTask extends Task{


    public RegularTask(String name){
        super(name);
    }

    @Override
    public String taskInfo(){
        return "Regular task: " + name;
    }
}
