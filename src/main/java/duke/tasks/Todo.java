package duke.tasks;

/**
 * Todo class for tasks that have no time element.
 */
public class Todo extends Task{

    public static final String USAGE_TEXT = "Usage : todo <task name>";

    /**
     * Default constructor for a new task.
     *
     * @param name task name.
     */
    public Todo(String name){
        this(name, false);
    }

    /**
     * Full constructor with all fields exposed.
     *
     * @param name task name.
     * @param done state of task done.
     */
    public Todo(String name, boolean done) {
        super(name, done);
    }

    @Override
    public String serialize() {
        return "Task:todo\n" +
                String.format("\tName:%s\n", this.name) +
                String.format("\tDone:%s\n", this.done);
    }

    @Override
    public String toString() {
        return "[T]" + (this.done? "[X] " : "[ ] ")
                + this.name;
    }
}
