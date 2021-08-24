package duke.tasks;

/**
 * Event task for tasks that have a start and end time.
 */
public class Event extends Task{
    public static final String USAGE_TEXT = "Usage: event <task name> /at <deadline> ";
    String at;



    /**
     * Default constructor for a new task.
     *
     * @param name task name.
     * @param at time of event.
     */
    public Event(String name, String at){
        this(name, false, at);
    }

    /**
     * Full constructor with all fields exposed.
     *
     * @param name task name.
     * @param done boolean state of task done.
     * @param at time of event.
     */
    public Event(String name, boolean done, String at) {
        super(name);
        this.at = at;
    }

    @Override
    public String serialize() {
        return "Task:event\n" +
                String.format("\tName:%s\n", this.name) +
                String.format("\tDone:%s\n", this.done) +
                String.format("\tAt:%s\n", this.at);
    }

    @Override
    public String toString() {
        return "[E]" + (this.done? "[X] " : "[ ] ")
                + this.name
                +String.format("(at:%s)",this.at);
    }
}