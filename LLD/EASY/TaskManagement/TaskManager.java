package LLD.EASY.TaskManagement;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TaskManager implements TaskMangerInterface{

    private  static TaskManager instance;

    private ConcurrentHashMap<String,Task> tasks;

    private ConcurrentHashMap<String,List<Task>> userTaskHashMap;

    private List<USER> users = new ArrayList<>();

   private TaskManager(){
       tasks = new ConcurrentHashMap<>();
       userTaskHashMap = new ConcurrentHashMap<>();
   }

   public static synchronized TaskManager getinstance(){
       if(instance==null){
           return new TaskManager();
       }
       return instance;
   }

    @Override
    public void createTask(Task task) {
        tasks.put(task.getId(), task);
        assignTask(task.getAssignedUser(),task);
    }

    @Override
    public void updateTask(Task updatedTask) {
        Task existingTask = tasks.get(updatedTask.getId());
        if (existingTask != null) {
            synchronized (existingTask) {
                existingTask.setTitle(updatedTask.getTitle());
                existingTask.setDescription(updatedTask.getDescription());
                existingTask.setDuedate(updatedTask.getDuedate());
                existingTask.setPrioritys(updatedTask.getPrioritys());
                existingTask.setTaskStatus(updatedTask.getTaskStatus());
                USER previousUser = existingTask.getAssignedUser();
                USER newUser = updatedTask.getAssignedUser();
                if (!previousUser.equals(newUser)) {
                    unassignTaskFromUser(previousUser, existingTask);
                    assignTask(newUser, existingTask);
                }
            }

        }
    }

    @Override
    public void deleteTask(String taskId) {
        Task task = tasks.remove(taskId);
        if (task != null) {
            unassignTaskFromUser(task.getAssignedUser(), task);
        }
    }
    /*

      Based on username we are searching task
     */
    @Override
    public void searchTask(String username) {

    }

    @Override
    public List<Task> filtertaskbased(TaskStatus status, Date startDate, Date endDate, int priority) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getTaskStatus() == status &&
                    task.getDuedate().compareTo(startDate) >= 0 &&
                    task.getDuedate().compareTo(endDate) <= 0 &&
                    task.getPrioritys() == priority) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }




    @Override
    public void assignTask(USER user , Task task) {
      List<Task> taskofUser = userTaskHashMap.get(user.getId());
      if(taskofUser==null){
          taskofUser = new ArrayList<>(); // Using ArrayList for simplicity
      }
    }

    @Override
    public void unassignTaskFromUser(USER user, Task task) {
      List<Task> taskofUser  =  userTaskHashMap.get(user.getId());
      if(taskofUser!=null){
          taskofUser.remove(task);
      }
    }

    @Override
    public void markTaskAsCompleted(String taskId) {
        Task task = tasks.get(taskId);
        if (task != null) {
            synchronized (task) {
                task.setTaskStatus(TaskStatus.COMPLETED);
            }
        }
    }

    @Override
    public List<Task> searchTasks(String keyword) {
        List<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getTitle().contains(keyword) || task.getDescription().contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }

    public List<Task> getTaskHistory(USER user) {
        return new ArrayList<>(userTaskHashMap.getOrDefault(user.getId(), new ArrayList<>()));
    }

}
