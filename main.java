import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] grid = new String[11][11];
        String choice = "c";
        int wChoice = 1;
        int lChoice;
        int lvChoice;
        boolean UPw2 = true;
        boolean UPw3 = true;
        int trash = 0;

        // color
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String blue = "\u001b[0;38;2;135;206;235;49m";
        String reset = "\u001B[0m";

        // level
        String l1 = green + "1" + reset;
        String l2 = red + "2" + reset;
        String l3 = red + "3" + reset;
        String l4 = red + "4" + reset;
        String l5 = red + "5" + reset;
        String l6 = red + "6" + reset;
        String l7 = red + "7" + reset;
        String l8 = red + "8" + reset;
        String l9 = red + "9" + reset;
        String l10 = red + "10" + reset;

        boolean done1 = false;
        boolean done2 = false;
        boolean done3 = false;
        boolean done4 = false;
        boolean done5 = false;
        boolean done6 = false;
        boolean done7 = false;
        boolean done8 = false;
        boolean done9 = false;

        // weapon list
        String w1 = green + "Original Net" + reset;
        String w2 = red + "Medium Net" + reset;
        String w3 = red + "Giganto Netto" + reset;

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                grid[i][j] = blue + "~" + reset;
            }
        }

        grid[10][5] = "p";

        do {
            System.out.println("=========== Welcome to Clean The Ocean ===========");
            System.out.println("A. Clean!");
            System.out.println("B. Weapon selector");
            System.out.print("What do you want to do: ");
            choice = sc.next() + sc.nextLine();
            System.out.println();

            if (choice.equalsIgnoreCase("z")) {
                trash = 99999;
            }

            if (choice.equalsIgnoreCase("a")) {
                do {
                    System.out.println("=========== Level Selector ===========");
                    System.out.print(l1 + "\t");
                    System.out.print(l2 + "\t");
                    System.out.print(l3 + "\t");
                    System.out.print(l4 + "\t");
                    System.out.print(l5 + "\t");
                    System.out.println();
                    System.out.print(l6 + "\t");
                    System.out.print(l7 + "\t");
                    System.out.print(l8 + "\t");
                    System.out.print(l9 + "\t");
                    System.out.print(l10 + "\t");
                    System.out.println();
                    System.out.println("11 = exit");
                    System.out.print("what level you want to play (1-10): ");
                    lvChoice = sc.nextInt();
                    System.out.println();

                    if (lvChoice == 1) {
                        System.out.println("trash remaining: ");

                        for (int i = 0; i < 11; i++) {
                            for (int j = 0; j < 11; j++) {
                                System.out.print(grid[i][j] + "\t");
                            }
                            System.out.println();
                        }
                    }
                } while (lvChoice != 11);

            } else if (choice.equalsIgnoreCase("b")) {
                do {
                    System.out.println("trash: " + trash);
                    System.out.println("1. " + w1);
                    System.out.println("2. " + w2);
                    System.out.println("3. " + w3);
                    System.out.println("4. exit");
                    System.out.print("choose your weapon: ");
                    lChoice = sc.nextInt();

                    if (lChoice == 1) {
                        wChoice = 1;
                    } else if (lChoice == 2) {
                        if (UPw2) {
                            System.out.println("Want to buy this weapon?" + green + "(20 trash)" + reset);
                            System.out.println("1. yes");
                            System.out.println("2. no");
                            int buy = sc.nextInt();

                            if (buy == 1) {
                                if (trash > 20) {
                                    wChoice = 2;
                                    UPw2 = false;
                                    w2 = green + "Medium Net" + reset;
                                    System.out.println("weapon purchased");
                                    trash -= 20;
                                } else {
                                    System.out.println(red + "you dont have enough trash!!" + reset);
                                }
                            }
                        } else {
                            wChoice = 2;
                            System.out.println("weapon equipped");
                        }
                    } else if (lChoice == 3) {
                        if (UPw3) {
                            System.out.println("Want to buy this weapon?" + green + "(40 trash)" + reset);
                            System.out.println("1. yes");
                            System.out.println("2. no");
                            int buy = sc.nextInt();

                            if (buy == 1) {
                                if (trash > 40) {
                                    wChoice = 3;
                                    UPw3 = false;
                                    w3 = green + "Giganto Net" + reset;
                                    System.out.println("weapon purchased");
                                    trash -= 40;
                                } else {
                                    System.out.println(red + "you dont have enough trash!!" + reset);
                                }
                            }
                        } else {
                            wChoice = 2;
                            System.out.println("weapon equipped");
                        }
                    }
                    System.out.println();
                } while (lChoice != 4);

            }
        } while (!choice.equalsIgnoreCase("c"));
    }
}
