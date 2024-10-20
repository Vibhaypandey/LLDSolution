package LLD.EASY.TaskManagement;

import java.util.Date;
import java.util.List;

public interface TaskMangerInterface {

    void createTask(Task task);

    void updateTask(Task task );

    void deleteTask(String id);

    void searchTask(String name);

    List<Task> filtertaskbased(TaskStatus status, Date startDate, Date endDate, int priority);



    void assignTask(USER user ,Task task);

    void unassignTaskFromUser(USER user, Task task);

    void markTaskAsCompleted(String taskId);

    List<Task> searchTasks(String keyword);

}
