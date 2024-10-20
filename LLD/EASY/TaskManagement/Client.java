package LLD.EASY.TaskManagement;

import java.util.*;

/*
What things need to learn
1. concurrent hasMap
2. Synchronized keyword : how to use it
3. Singleton design pattern implementation
4. final keyword use
*/

public class Client {

    public static void main(String[] args) {

      TakManager takManager = TakManager.getinstance();
        // Create USERs
        USER user1 = new USER("1", "John Doe", "john@example.com");
        USER user2 = new USER("2", "Jane Smith", "jane@example.com");

        // Create tasks
        Task task1 = new Task("1", "Task 1", "Description 1",1, new Date(), user1);
        Task task2 = new Task("2", "Task 2", "Description 2",2, new Date(),  user2);
        Task task3 = new Task("3", "Task 3", "Description 3",1, new Date(), user1);
        takManager.createTask(task1);
        takManager.createTask(task2);
        takManager.createTask(task3);
        //update task
        task1.setTaskStatus(TaskStatus.COMPLETED);
        takManager.updateTask(task1);
        takManager.unassignTaskFromUser(user1,task1);


      // Search tasks
      List<Task> searchResults = takManager.searchTasks("Task");
      System.out.println("Search Results:");
      for (Task task : searchResults) {
        System.out.println(task.getTitle());
      }

      // Filter tasks
      List<Task> filteredTasks = takManager.filtertaskbased(TaskStatus.PENDING, new Date(0), new Date(), 1);
      System.out.println("Filtered Tasks:");
      for (Task task : filteredTasks) {
        System.out.println(task.getTitle());
      }

      // Mark a task as completed
      takManager.markTaskAsCompleted("1");

      // Get task history for a user
      List<Task> taskHistory = takManager.getTaskHistory(user1);
      System.out.println("Task History for " + user1.getName() + ":");
      for (Task task : taskHistory) {
        System.out.println(task.getTitle());
      }

      // Delete a task
      takManager.deleteTask("3");


    }
}
