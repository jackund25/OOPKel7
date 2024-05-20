package gradlepvzkelompok7;

import java.util.Scanner;

public class GameMenu {
    private Scanner scanner;

    public GameMenu() {
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Start");
            System.out.println("2. Help");
            System.out.println("3. Plants List");
            System.out.println("4. Zombies List");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    startGame();
                    break;
                case "2":
                    showHelp();
                    break;
                case "3":
                    showPlantsList();
                    break;
                case "4":
                    showZombiesList();
                    break;
                case "5":
                    exitGame();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    private void startGame() {
        GameLoop gameLoop = new GameLoop();
        gameLoop.startGame();
    }

    private void showHelp() {

    }

    private void showPlantsList() {
        System.out.println("Plants List:");
    }

    private void showZombiesList() {
        System.out.println("Zombies List:");
    }

    private void exitGame() {
        System.out.println("Exiting the game...");
        scanner.close();
    }

    public static void main(String[] args) {
        GameMenu mainMenu = new GameMenu();
        mainMenu.showMenu();
    }
}

