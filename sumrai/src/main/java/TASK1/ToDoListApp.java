package TASK1;
import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String title;
    private String description;
    private String dueDate;
    private boolean isComplete;

    public Task(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = false; 
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void markAsComplete() {
        this.isComplete = true;
    }
    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description + 
               "\nDue Date: " + dueDate + "\nStatus: " + 
               (isComplete ? "Complete" : "Incomplete") + "\n";
    }
}

public class ToDoListApp {
    private static ArrayList<Task> taskList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getValidChoice(); 
            switch (choice) {
                case 1:
                    addTask(); 
                    break;
                case 2:
                    markTaskAsComplete(); 
                    break;
                case 3:
                    viewTasks();
                    break;
                case 4:
                    removeTask(); 
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0); 
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("To-Do List Application");
        System.out.println("1. Add Task");
        System.out.println("2. Mark Task as Complete");
        System.out.println("3. View Tasks");
        System.out.println("4. Remove Task");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getValidChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        return choice;
    }

    // Method to add a new task
    private static void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter task due date (e.g., 2024-08-31): ");
        String dueDate = scanner.nextLine();

        if (title.isEmpty() || description.isEmpty() || dueDate.isEmpty()) {
            System.out.println("Error: All fields are required.\n");
            return;
        }

        Task newTask = new Task(title, description, dueDate); 
        taskList.add(newTask); 
        System.out.println("Task added successfully.\n");
    }

    private static void markTaskAsComplete() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.\n");
            return;
        }

        System.out.print("Enter the task number to mark as complete: ");
        int index = getValidIndex();

        if (index >= 0 && index < taskList.size()) {
            taskList.get(index).markAsComplete(); 
            System.out.println("Task marked as complete.\n");
        } else {
            System.out.println("Invalid task number.\n");
        }
    }

    private static void viewTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.\n");
        } else {
            System.out.println("Your Tasks:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println("Task " + (i + 1) + ":\n" + taskList.get(i));
            }
        }
    }

    private static void removeTask() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.\n");
            return;
        }

        System.out.print("Enter the task number to remove: ");
        int index = getValidIndex();

        if (index >= 0 && index < taskList.size()) {
            taskList.remove(index); 
            System.out.println("Task removed successfully.\n");
        } else {
            System.out.println("Invalid task number.\n");
        }
    }

    private static int getValidIndex() {
        int index = -1;
        try {
            index = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid task number.");
        }
        return index;
    }
}
