package duke.tasks;

/**
 * Abstract base task created by Duke.
 */
abstract public class Task {
    String name;
    boolean isTaskDone = false;

    /**
     * Default constructor for a new task.
     *
     * @param name task name.
     */
    public Task(String name) {
        this(name, false);
    }

    /**
     * Full constructor with all fields exposed
     *
     * @param name task name
     * @param isTaskDone done state
     */
    public Task(String name, boolean isTaskDone) {
        this.name = name;
        this.isTaskDone = isTaskDone;
    }

    /**
     * Generates the message printed when this task is added.
     *
     * @return added: task name.
     */
    public String addMsg() {
        return "added: " + this.name;
    }

    /**
     * Sets this task status to done.
     */
    public void markDone() {
        this.isTaskDone = true;
    }

    /**
     * Gets the name for this task.
     *
     * @return task name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns json-like representation of object data.
     *
     * @return String representation of data.
     */
    public abstract String serialize();
    // newline is the only? reliable way to divide data without escape characters

    public String toString() {
        return (this.isTaskDone ? "[X] " : "[ ] ")
                + this.name;
    }
}

