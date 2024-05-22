package gradlepvzkelompok7;

import java.util.Scanner;


public class GameMenu {
    private Scanner scanner;
    public static final String RESET = "\033[0m";  // Reset ke warna asli
    public static final String GREEN = "\033[0;32m";  // Green
    public static final String RED = "\033[0;31m";  // Red

    public GameMenu() {
        scanner = new Scanner(System.in);
    }

    public void showMenu() throws InterruptedException {
            String yellow = "\033[33m";
            String reset = "\033[0m";

        String asciiArt = yellow +
                    "       __        __   _                            _         \n" +
                    "       \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___   \n" +
                    "        \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  \n" +
                    "         \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) | \n" +
                    "          \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/  \n" +
                    "                                                              \n" +
                    reset;

            String lightGray = "\033[37m";
            String asciiArt1 = lightGray +
            "   .___  ___.  __    ______  __    __       ___       _______  __             \n" +
            "   |   \\/   | |  |  /      ||  |  |  |     /   \\     |   ____||  |            \n" +
            "   |  \\  /  | |  | |  ,----'|  |__|  |    /  ^  \\    |  |__   |  |            \n" +
            "   |  |\\/|  | |  | |  |     |   __   |   /  /_\\  \\   |   __|  |  |            \n" +
            "   |  |  |  | |  | |  `----.|  |  |  |  /  _____  \\  |  |____ |  `----.       \n" +
            "   |__|  |__| |__|  \\______||__|  |__| /__/     \\__\\ |_______||_______|       \n" +
            reset;

            String asciiArt2 = yellow +
                    "                                          \n" +
                    "                           __   _____    \n" +
                    "                           \\ \\ / / __|   \n" +
                    "                            \\ V /\\__ \\_  \n" +
                    "                             \\_/ |___(_) \n" +
                    "                                          \n" +
                    reset;

            String lightGreen = "\033[92m";
            String asciiArt3 = lightGreen +
            "    __          ___        __           ___      .______      ___      .__   __.\n" +
            "   |  |        /   \\     |  |        /   \\     |   _  \\    /   \\     |  \\ |  |\n" +
            "   |  |       /  ^  \\    |  |       /  ^  \\    |  |_)  |  /  ^  \\    |   \\|  |\n" +
            "   |  |      /  /_\\  \\  |  |      /  /_\\  \\  |   ___/  /  /_\\  \\   |  . `  |\n" +
            "   |  `----./  _____  \\  |  `----./  _____  \\  |  |     /  _____  \\  |  |\\   |\n" +
            "   |_______/__/     \\__\\ |_______/__/     \\__\\ | _|  /__/     \\__\\ |__| \\__|\n" +
            reset;

            String asciiArt4 = yellow +
            "                      ____                      \n" +
            "                     / ___| __ _ _ __ ___   ___ \n" +
            "                    | |  _ / _` | '_ ` _ \\ / _ \\\n" +
            "                    | |_| | (_| | | | | | |  __/\n" +
            "                     \\____|\\__,_|_| |_| |_|\\___|\n" +
            "                                                \n" +
            reset;

            String asciiArt5 = lightGreen +
                    "                                                                            .=*###*-      \n" +
                    "                                    :-=+**********+=-:                     +%*===-=*%-    \n" +
                    "                               :=*##*+==---------==++*##*=:              :#*--==-=-==#*   \n" +
                    "                            -*#*+-----------------------=+*#*-         -*#=--====*##+=#*  \n" +
                    "                         .+%*=------------------------------=*#+----=*#**:---===%%%%%*=%= \n" +
                    "                        +%+-:....::------------------------=:*%%*------- :---==+%%%%%%%#=%-\n" +
                    "      .-=++***++=:    -%*-:.    .:------------------------=:*%%*------- :---==+%%%%%%%#=%-\n" +
                    "    =***++++==+**##= *%+--.    .:----------------+*#%#+---=#%%%#------: ---==-#%%%%%%%#=#+\n" +
                    "  =#+==++++++*****+#%#=---:::::-----------------+-  *%%#---=*##=------:.---===%%%%%%%%#+##\n" +
                    " **====+++++++++**##%=--------------------------+#+*%%%%=-------------::---===%%%%%%%%#+*#\n" +
                    "=#-======+++++++++*%*---------------------------=*%%%%%#=--------------:-----=%%%%%%%%#+##\n" +
                    "#**##%##*+=+++++++#%+-----------------------------+*##*=------------------===-%%%%%%%%#=#*\n" +
                    "+%#*%=  :=*#****#+=%===---------------------------------------------------+===*%%%%%%%#=%-\n" +
                    " *###        ...   %+====---------------------------------------------===-+====%%%%%%#+*%\n" +
                    "  :=+              *#-======---------------------------------------=====*====--+%%%%%*=%=\n" +
                    "                   .%+=========--------------------------------=========+%=+===-=###+=#*\n" +
                    "                    -%+=============-----------------------==========++***%*++=-=--==##   \n" +
                    "                     -%*======================---=================*##+=--=+#%*++===*%+    \n" +
                    "                      .*%+======================================*%+.        :+####*=.     \n" +
                    "                        :*#+==================================*%*.                        \n" +
                    "                          :+%#+============================+##+.                          \n" +
                    "                             -+##*++==================+**##+:                             \n" +
                    "                                .-+*%##***++++++***###*=-.                                \n" +
                    "                                     *#*###########-                                      \n" +
                    "                                      :*#*****###-                                        \n" +
                    "                                        =+*******                                         \n" +
                    "                                         +=++++*+                                         \n" +
                    "                                          *=+++*+                                         \n" +
                    "                                          -+=++**                                         \n" +
                    "                              .:-======-   +=++*#    :-=+*******+=                        \n" +
                    "                           .=#*==+++++++#*=-+=+*#-.=+++++++++***##=======--.              \n" +
                    "                          .#*#+++++++++++++*#==+*##*+++++++++#**++++++++++++*+:           \n" +
                    "                           *#-*==++++++++++++*=+*#+++++++++**++++++++++++++++++*:         \n" +
                    "                            .:**==++++++++++***=+**++++++**+*++++++++++++++++++=#:        \n" +
                    "                             .**+++++++****+++**++***+++#*++=++++++++++++++++++==#        \n" +
                    "                         -=+++=============++*+*#++*#++#*+=+++++++++++===========*=       \n" +
                    "                      .=+================+++++++**+***#*=++++++++++++============+*       \n" +
                    "                     -*+============================++*+++++++++++=======+++++===++       \n" +
                    "                     -*+=============================++*==============+*=.   .=+=*-       \n" +
                    "                     +===============================++*=============*=        +=*        \n" +
                    "                    -+===============================++#===========+*.     :   **.        \n" +
                    "                    =================================+*=*===+====++:       :==+-          \n" +
                    "                    :+====+=-----=+++=============+=+*-  -++*#++=.                        \n" +
                    "                     =+=+*          :-+++++======***=.     .--                            \n" +
                    reset;

            // Print the ASCII art slowly
            printSlowly(asciiArt, 1);
            printSlowly(asciiArt1, 1);
            printSlowly(asciiArt2, 1);
            printSlowly(asciiArt3, 1);
            printSlowly(asciiArt4, 1);
            printSlowly(asciiArt5, 1);

            System.out.println("");
            String[] words = {GREEN + "\nWelcome to the World of Michael vs Lalapan", GREEN + "In a time when the world is at its most peaceful, suddenly " + RED + "a group of zombies" + GREEN + " attacks your backyard.", GREEN + "You must survive the onslaught of " + RED + "zombies" + GREEN + " attacking your backyard.", GREEN + "Therefore, the main objective of this game is to defeat " + RED + "the zombies" + GREEN + " who are trying to eat your brains by harnessing the power of Lalapan.\n" + RESET};
            int interval = 1500; // Interval waktu dalam milidetik (1.5 detik)
        
            for (String word : words) {
                System.out.println(word);
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    System.err.println("Thread interrupted: " + e.getMessage());
                }
            }

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Start");
            System.out.println("2. Help");
            System.out.println("3. Plants List");
            System.out.println("4. Zombies List");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (numbers): ");

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
    
            System.out.println("");
            System.out.println("What help do you need?");
            System.out.println("Type 1 for General Instructions");
            System.out.println("Type 2 for Command");
            System.out.println("Enter your Choice: ");
            String chc = scanner.nextLine();
                switch (chc) {
                    case "1":
                        petunjukUmum();
                        break;
                    case "2":
                        command();
                        break;
                }
    }
    private void petunjukUmum() {
        //Arahan bermain
        System.out.println("");
        String asciiArtPU = 
            " ____                                          ___       ______                   __                           __                                  \n" +
            "/\\  _`\\                                       /\\_ \\     /\\__  _\\                 /\\ \\__                       /\\ \\__  __                            \n" +
            "\\ \\ \\L\\_\\     __    ___      __   _ __    __  \\//\\ \\    \\/_/\\ \\/     ___     ____\\ \\ ,_\\  _ __   __  __    ___\\ \\ ,_\\/\\_\\    ___     ___     ____  \n" +
            " \\ \\ \\L_L   /'__`\\/\\' _ `\\  /'__`\\/\\`'__\\/\'__`\\  \\ \\ \\      \\ \\ \\   /' _ `\\  /',__\\\\ \\ \\/ /\\`'__\\/\\ \\/\\ \\  /'___\\ \\ \\/\\/\\ \\  / __`\\ /' _ `\\  /',__\\ \n" +
            "  \\ \\ \\/, \\/\\  __//\\ \\/\\ \\/\\  __/\\ \\ \\//\\ \\L\\.\\_ \\_\\ \\_     \\_\\ \\__ /\\ \\/\\ \\/\\__, `\\\\ \\ \\_\\ \\ \\ \\ \\ \\ \\ \\__/\\ \\ \\_\\ \\ \\/\\ \\L\\ \\/\\ \\/\\ \\/\\__, `\\\n" +
            "   \\ \\____/\\ \\____\\ \\_\\ \\_\\ \\____\\ \\_\\\\ \\__/.\\_/\\____\\    /\\____\\\\ \\_\\ \\_\\/\\____/ \\ \\__\\\\ \\_\\ \\ \\____/\\ \\____\\\\ \\__\\\\ \\_\\ \\____/\\ \\_\\ \\_\\/\\____/\n" +
            "    \\/___/  \\/____/\\/_/\\/_/\\/____/ \\/_/ \\/__/\\/_/\\/____/    \\/____/ \\/_/\\/_/\\/___/   \\/__/ \\/_/  \\/___/  \\/____/ \\/__/ \\/_/\\/___/  \\/_/\\/_/\\/___/ \n" +
            "                                                                                                                                                           \n" +
            "                                                                                                                                                           ";

        System.out.println(GREEN + asciiArtPU + RESET);
        System.out.println("You will defend against the onslaught of zombies entering your backyard.");
        System.out.println("You will defend during the day for 100 seconds and during the night for 100 seconds until no zombies are left.");
        System.out.println("During that time, you can plant Lalapan in your backyard using solar energy.");
        System.out.println("Solar energy is obtained randomly from the sky during the day or through Sunflower Lalapan.");
        System.out.println("At night, solar energy will not be obtained from the sky.");
        System.out.println("Each Lalapan has unique characteristics and attack methods, so make sure to use the right Lalapan when defending.");
        System.out.println(GREEN + "You can choose 6 Lalapan to fight against the zombies." + RESET + "The chosen Lalapan can be placed on the deck");

        System.out.println("The backyard consists of a garden and a pond. Various plants can be planted in the garden, while in the pond, plants can also be planted");
        System.out.println("when there are lily pads, and the plants are placed on top of the lily pads.");
        System.out.println("You win if there are no more zombies left in your backyard.");
        System.out.println("If zombies successfully breach your Lalapan barricade and enter your house, then your brains have become zombie food.");
        System.out.println("Be careful and may you survive until the next day, " + RED + "BRAINZZZZZZ."+ RESET);
    }

    private void command(){
        //Command
        System.out.println("");
        String asciiArtCom = 
            " ____                                                         __     \n" +
            "/\\  _`\\                                                      /\\ \\    \n" +
            "\\ \\ \\/\\_\\    ___     ___ ___     ___ ___      __      ___    \\_\\ \\   \n" +
            " \\ \\ \\/_/_  / __`\\ /' __` __`\\ /' __` __`\\  /'__`\\  /' _ `\\  /'_` \\  \n" +
            "  \\ \\ \\L\\ \\/\\ \\L\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\/\\ \\L\\./_/\\ \\/\\ \\/\\ \\L\\ \\ \n" +
            "   \\ \\____/\\ \\____/\\ \\_\\ \\_\\ \\_\\ \\_\\ \\_\\ \\_\\ \\__/\\.\\_\\ \\_\\ \\_\\ \\___,_\\\n" +
            "    \\/___/  \\/___/  \\/_/\\/_/\\/_/\\/_/\\/_/\\/_/\\/__/\\/_/\\/_/\\/_/\\/__,_ / \n" +
            "                                                                     \n" +
            "                                                                     ";

        System.out.println(GREEN + asciiArtCom + RESET);
        System.out.println("-> To start the game type 1 in main menu");
        System.out.println("-> To view the help consisting of general instructions and commands, type 2 on the main menu");
        System.out.println("-> To view the available plants and their descriptions in Plant List, type 3 on the main menu.");
        System.out.println("-> To view the available zombie and their descriptions in Plant List, type 4 on the main menu.");
        System.out.println("-> Type 5 for exit the game in main menu");
        System.out.println("-> Type PLANT for plant the Lalapan in the tile");
        System.out.println("-> Type DIG to remove Lalapan from the tile");
        System.out.println("-> Type DECK to view deck and Lalapan cooldown time");
        System.out.println("");
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

    public static void main(String[] args) throws InterruptedException {
        GameMenu mainMenu = new GameMenu();
        mainMenu.showMenu();
    }

    private static void printSlowly(String text, long millisPerChar) throws InterruptedException {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(millisPerChar);
        }
        System.out.println();
    }
}

