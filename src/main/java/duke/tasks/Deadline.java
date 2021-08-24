package duke.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

/**
 * Deadline task for tasks that have an end date.
 */
public class Deadline extends Task{
    public static final String USAGE_TEXT = "Usage: deadline <task name> /by <deadline> ";

    String by;
    LocalDate byDate;



    /**
     * Default constructor for a new task.
     *
     * @param name task name.
     * @param by   deadline for deadline task.
     */
    public Deadline(String name,String by){
        this(name, false, by);
    }

    /**
     * Full constructor with all fields exposed.
     *
     * @param name task name.
     * @param done boolean state of task done.
     * @param by   deadline for deadline task.
     */
    public Deadline(String name, boolean done, String by) {
        super(name);
        this.by = by;
        try{
            this.byDate = LocalDate.parse(by.strip());
        } catch (DateTimeParseException e){
            this.byDate = null;
        }
    }

    @Override
    public String serialize() {
        return "Task:deadline\n" +
                String.format("\tName:%s\n", this.name) +
                String.format("\tDone:%s\n", this.done) +
                String.format("\tBy:%s\n", this.by);
    }

    @Override
    public String toString() {
        String out =  "[D]" + (this.done? "[X] " : "[ ] ")
                + this.name;
        if (this.byDate == null){
            out += String.format("(by: %s)",this.by);
        } else{
            out += String.format(" by: %d days left",LocalDate.now().until(this.byDate,ChronoUnit.DAYS));
        }
        return out;
    }
}
