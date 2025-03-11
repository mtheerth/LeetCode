import java.util.*;

class Task {
    String id;
    int execution;
    List<String> dependencies;

    public Task(String id, int execution, List<String> dependencies) {
        this.id = id;
        this.execution = execution;
        this.dependencies = dependencies;
    }
}

class TaskScheduler {
    private Map<String, Task> tasks = new HashMap<>();
    private Map<String, Integer> completionTimes = new HashMap<>();

    public void addTask(Task task) {
        tasks.put(task.id, task);
    }

    public int getCompletionTime(String taskId) {
        if (completionTimes.containsKey(taskId)) {
            return completionTimes.get(taskId);
        }
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task not found: " + taskId);
        }

        Task task = tasks.get(taskId);
        int maxDependencyTime = 0;

        for (String depId : task.dependencies) {
            maxDependencyTime = Math.max(maxDependencyTime, getCompletionTime(depId));
        }

        int totalTime = maxDependencyTime + task.execution;
        completionTimes.put(taskId, totalTime);
        return totalTime;
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTask(new Task("A", 3, Arrays.asList()));
        scheduler.addTask(new Task("B", 5, Arrays.asList("A")));
        scheduler.addTask(new Task("C", 2, Arrays.asList("A")));
        scheduler.addTask(new Task("D", 4, Arrays.asList("B", "C")));
        scheduler.addTask(new Task("E", 6, Arrays.asList("D")));

        System.out.println("Completion Time for E: " + scheduler.getCompletionTime("E")); // Output: 18
    }
}

