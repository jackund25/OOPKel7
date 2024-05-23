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
        String asciiArt1 =
        "   .___  ___.  __    ______  __    __       ___       _______  __             \n" +
        "   |   \\/   | |  |  /      ||  |  |  |     /   \\     |   ____||  |            \n" +
        "   |  \\  /  | |  | |  ,----'|  |__|  |    /  ^  \\    |  |__   |  |            \n" +
        "   |  |\\/|  | |  | |  |     |   __   |   /  /_\\  \\   |   __|  |  |            \n" +
        "   |  |  |  | |  | |  `----.|  |  |  |  /  _____  \\  |  |____ |  `----.       \n" +
        "   |__|  |__| |__|  \\______||__|  |__| /__/     \\__\\ |_______||_______|       \n" +
        reset;

        String asciiArt2 =
                "                                          \n" +
                "                           __   _____    \n" +
                "                           \\ \\ / / __|   \n" +
                "                            \\ V /\\__ \\_  \n" +
                "                             \\_/ |___(_) \n" +
                "                                          \n" +
                reset;

        String lightGreen = "\033[92m";
        String asciiArt3 =
        "    __          ___       __          ___      .______      ___      .__   __.\n" +
        "   |  |        /   \\     |  |        /   \\     |   _  \\    /   \\     |  \\ |  |\n" +
        "   |  |       /  ^  \\    |  |       /  ^  \\    |  |_)  |  /  ^  \\    |   \\|  |\n" +
        "   |  |      /  /_\\  \\   |  |      /  /_\\  \\   |   ___/  /  /_\\  \\   |  . `  |\n" +
        "   |  `----./  _____  \\  |  `----./  _____  \\  |  |     /  _____  \\  |  |\\   |\n" +
        "   |_______/__/     \\__\\ |_______/__/     \\__\\ | _|    /__/     \\__\\ |__| \\__|\n" +
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

    private void showPlantsList() throws InterruptedException {
        String reset = "\033[0m";
        String lightGreen = "\033[92m";
        // ANSI escape codes for bold and italic text
        String bold = "\033[1m";
        String italic = "\033[3m";
        // Combining bold and italic for the "Plants List:" heading
        String boldItalic = "\033[1;3m";

        System.out.println(boldItalic + "Our Available Plants!");
        String asciiArt = lightGreen +
            "  ____  _             _     _     _     _   \n"
            + " |  _ \\| | __ _ _ __ | |_  | |   (_)___| |_ \n"
            + " | |_) | |/ _` | '_ \\| __| | |   | / __| __|\n"
            + " |  __/| | (_| | | | | |_  | |___| \\__ \\ |_ \n"
            + " |_|   |_|\\__,_|_| |_|\\__| |_____|_|___/\\__|\n"
            + "                                            ";

        printSlowly(asciiArt, 1);
        System.out.println(boldItalic + "Plants List:" + reset);
        System.out.println(bold + "Sunflower: " + reset + italic + "Generates sun, which is essential for planting other plants." + reset);
        System.out.println(bold + "Peashooter: " + reset + italic + "Fires peas at zombies to deal damage." + reset);
        System.out.println(bold + "Repeater: " + reset + italic + "Shoots two peas at a time for increased damage." + reset);
        System.out.println(bold + "Snowpea: " + reset + italic + "Fires frozen peas that slow down zombies." + reset);
        System.out.println(bold + "Jalapeno: " + reset + italic + "Explodes to destroy all zombies in a single row." + reset);
        System.out.println(bold + "Squash: " + reset + italic + "Smashes the first zombie it encounters." + reset);
        System.out.println(bold + "Tangle Kelp: " + reset + italic + "Pulls the first zombie that steps into the water down to the depths, instantly vanishing it." + reset);
        System.out.println(bold + "Chomper: " + reset + italic + "Devours zombies whole but takes time to chew." + reset);
        System.out.println(bold + "Wallnut: " + reset + italic + "Provides a sturdy defense to block zombies." + reset);
        System.out.println(bold + "Lilypad: " + reset + italic + "Allows plants to be placed on water." + reset);
    }

    private void showZombiesList() throws InterruptedException{
        // ANSI escape code to reset text formatting
        String reset = "\033[0m";
        // ANSI escape codes for blue text
        String blue = "\033[94m";

        String asciiArt = blue +
              "  _____               _     _        _     _     _   \n" +
              " |__  /___  _ __ ___ | |__ (_) ___  | |   (_)___| |_ \n" +
              "   / // _ \\| '_ ` _ \\| '_ \\| |/ _ \\ | |   | / __| __|\n" +
              "  / /| (_) | | | | | | |_) | |  __/ | |___| \\__ \\ |_ \n" +
              " /____\\___/|_| |_| |_|_.__/|_|\\___| |_____|_|___/\\__|\n" +
              "                                                     " + 
              reset;
        printSlowly(asciiArt, 1);
        String bold = "\033[1m";
        String italic = "\033[3m";
        String boldItalic = "\033[1;3m";
        System.out.println(boldItalic + "Zombies List:" + reset);
        System.out.println(bold + "Normal Zombie: " + reset + italic + "Just a regular zombie..." + reset);
        System.out.println(bold + "Conehead Zombie: " + reset + italic + "A regular zombie with a bit more health." + reset);
        System.out.println(bold + "Buckethead Zombie: " + reset + italic + "A regular zombie with a LOT of health." + reset);
        System.out.println(bold + "Football Zombie: " + reset + italic + "A regular zombie with a TON of health." + reset);
        System.out.println(bold + "Newspaper Zombie: " + reset + italic + "A zombie enjoying a newspaper. Don't destroy it or he'll get angry." + reset);
        System.out.println(bold + "Jack-In-A-Box Zombie: " + reset + italic + "Will explode upon the first sight of a lalapan." + reset);
        System.out.println(bold + "Gargantuar Zombie: " + reset + italic + "A slow-attacking zombie with an ability to throw a javelin when its HP is low." + reset);
        System.out.println(bold + "Pole Vaulting Zombie: " + reset + italic + "Jumps over the first lalapan and killing the plant on it's landing site" + reset);
        System.out.println(bold + "Duckytube Zombie: " + reset + italic + "Just a regular zombie with a floaty..." + reset);
        System.out.println(bold + "Dolphin Rider Zombie: " + reset + italic + "The water version of Pole Vaulting Zombie." + reset);
    }

    private void exitGame() throws InterruptedException {
        // Combining bold and italic for the "Plants List:" heading
        String boldItalic = "\033[1;3m";
        System.out.println(boldItalic + "Exiting the game...");
        // ANSI escape code to reset text formatting
        String reset = "\033[0m";

        String asciiArt = 
              "   ____                         ___                 \n"
            + "  / ___| __ _ _ __ ___   ___   / _ \\__   _____ _ __ \n"
            + " | |  _ / _` | '_ ` _ \\ / _ \\ | | | \\ \\ / / _ \\ '__|\n"
            + " | |_| | (_| | | | | | |  __/ | |_| |\\ V /  __/ |   \n"
            + "  \\____|\\__,_|_| |_| |_|\\___|  \\___/  \\_/ \\___|_|   \n"
            + "                                                    " 
            + reset;
        printSlowly(asciiArt,10);
        System.out.println(boldItalic + "See you in the NEXT GAME!");
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

