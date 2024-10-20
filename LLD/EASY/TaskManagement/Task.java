package LLD.EASY.TaskManagement;

import java.util.Date;

public class Task {

    private String id;

    private String title;

    private String description;

    private int prioritys;

    private TaskStatus taskStatus;

    public int getPrioritys() {
        return prioritys;
    }

    private Date duedate;

   private final USER assignedUser;


    public Task(String id, String title, String description, int prioritys, Date duedate, USER assignedUser) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.prioritys = prioritys;
        this.duedate = duedate;
        this.assignedUser = assignedUser;
        this.taskStatus = TaskStatus.PENDING;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getId() {
        return id;
    }

    public void setPrioritys(int prioritys) {
        this.prioritys = prioritys;
    }

    public USER getAssignedUser() {
        return assignedUser;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }


    public void setId(String id) {
        this.id = id;
    }




    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", prioritys=" + prioritys +
                ", taskStatus=" + taskStatus +
                ", duedate=" + duedate +
                ", assignedUser=" + assignedUser +
                '}';
    }
}
