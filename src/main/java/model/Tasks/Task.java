package model.Tasks;

public class Task {
    private int id;
    private String description;
    private boolean completed;
    private int userId;

    public Task(String description, int userId) {
        this.description = description;
        this.completed = false;
        this.userId = userId;
    }

    public Task(int id, String description, boolean completed, int userId) {
        this.id = id;
        this.description = description;
        this.completed = completed;
        this.userId = userId;
    }

    @Override
    public String toString() {
        String estado = completed ? "[X]" : "[ ]";
        return String.format("%d. %s %s", id, estado, description);
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
