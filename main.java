import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[][] grid = new String[11][11];
        String choice = "c";
        int wChoice = 1;
        int lChoice;
        int lvChoice;
        boolean UPw2 = true;
        boolean UPw3 = true;
        int trash = 0;
        int enemyCount = 0;
        int x = 5;
        int y = 10;
        int[] enemyPosX = new int[9];
        int[] enemyPosY = new int[9];
        int checkX;
        int checkY;
        boolean dupe;
        int level;

        // color
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String blue = "\u001b[0;38;2;135;206;235;49m";
        String dBlue = "\u001B[34m";
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
                grid[i][j] = dBlue + "~" + reset;
            }
        }

        grid[y][x] = "O";

        do {
            for (int i = 0; i < 25; i++) {
                System.out.println();
            }

            System.out.println("=========== Welcome to Clean The Ocean ===========");
            System.out.println("A. Clean!");
            System.out.println("B. Weapon selector");
            System.out.print("What do you want to do: ");
            choice = sc.next() + sc.nextLine();
            System.out.println();

            if (choice.equalsIgnoreCase("a")) {
                do {
                    for (int i = 0; i < 30; i++) {
                        System.out.println();
                    }

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
                        x = 5;
                        y = 10;

                        level = 1;
                        enemyCount = 7;
                        randomizeEnemyPosition(enemyCount, enemyPosX, enemyPosY, rand);

                        System.out.println("Level " + level + ": Clean " + enemyCount + " trash!");
                        trash = playMovementLoop(
                                enemyCount,
                                grid,
                                enemyPosX,
                                enemyPosY,
                                x,
                                y,
                                sc,
                                green,
                                blue,
                                reset,
                                trash);

                        if (enemyCount == 0) {
                            done1 = true;
                            l2 = green + "2" + reset;
                            for (int i = 0; i < 11; i++) {
                                for (int j = 0; j < 11; j++) {
                                    grid[i][j] = dBlue + "~" + reset;
                                }
                            }
                            x = 5;
                            y = 10;
                            grid[y][x] = "O";
                        }

                        System.out.println("" + green + "You did it!! The Ocean is now clean" + reset);
                    } else if (lvChoice == 2) {
                        if (!done1) {
                            System.out.println(red + "You need to complete previous level first!" + reset);
                        } else {
                            x = 5;
                            y = 10;

                            level = 2;
                            enemyCount = 6;
                            randomizeEnemyPosition(enemyCount, enemyPosX, enemyPosY, rand);

                            System.out.println("Level " + level + ": Clean " + enemyCount + " trash!");
                            trash = playMovementLoop(
                                    enemyCount,
                                    grid,
                                    enemyPosX,
                                    enemyPosY,
                                    x,
                                    y,
                                    sc,
                                    green,
                                    blue,
                                    reset,
                                    trash);

                            System.out.println("" + green + "You did it!! The Ocean is now clean" + reset);
                        }
                    } else if (lvChoice == 3) {
                        // level 3 code here
                    } else if (lvChoice == 4) {
                        // level 4 code here
                    } else if (lvChoice == 5) {
                        // level 5 code here
                    } else if (lvChoice == 6) {
                        // level 6 code here
                    } else if (lvChoice == 7) {
                        // level 7 code here
                    } else if (lvChoice == 8) {
                        // level 8 code here
                    } else if (lvChoice == 9) {
                        // level 9 code here
                    } else if (lvChoice == 10) {
                        // level 10 code here
                    }
                } while (lvChoice != 11);

            } else if (choice.equalsIgnoreCase("b")) {
                do {
                    for (int i = 0; i < 25; i++) {
                        System.out.println();
                    }
                    System.out.println("=========== Weapon Selector ===========");
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
                    } else if (lChoice == 67) {
                        trash = 676767;
                    }
                    System.out.println();
                } while (lChoice != 4);

            }
        } while (!choice.equalsIgnoreCase("c"));
    }

    public static int[] movePlayer(String[][] grid, int x, int y, String move, String blue, String reset) {

        grid[y][x] = blue + "~" + reset;

        if (move.equalsIgnoreCase("a")) {
            x -= 1;
        } else if (move.equalsIgnoreCase("d")) {
            x += 1;
        } else if (move.equalsIgnoreCase("w")) {
            y -= 1;
        } else if (move.equalsIgnoreCase("s")) {
            y += 1;
        }

        // batas grid
        if (x < 0)
            x = 0;
        if (x > 10)
            x = 10;
        if (y < 0)
            y = 0;
        if (y > 10)
            y = 10;

        grid[y][x] = "O";

        return new int[] { x, y };
    }

    public static void randomizeEnemyPosition(
            int enemyCount,
            int[] enemyPosX,
            int[] enemyPosY,
            Random rand) {
        for (int i = 0; i < enemyCount; i++) {
            boolean dupe;
            int checkX, checkY;

            do {
                dupe = false;
                checkX = rand.nextInt(10) + 1;
                checkY = rand.nextInt(10) + 1;

                for (int j = 0; j < i; j++) {
                    if (enemyPosX[j] == checkX && enemyPosY[j] == checkY) {
                        dupe = true;
                        break;
                    }
                }
            } while (dupe);

            enemyPosX[i] = checkX;
            enemyPosY[i] = checkY;
        }
    }

    public static int playMovementLoop(
            int enemyCount,
            String[][] grid,
            int[] enemyPosX,
            int[] enemyPosY,
            int x,
            int y,
            Scanner sc,
            String green,
            String blue,
            String reset,
            int trash) {
        do {
            System.out.println("trash remaining: " + enemyCount);

            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 11; j++) {
                    System.out.print(grid[i][j] + "\t");
                }
                System.out.println();
            }

            System.out.print("Move: ");
            String move = sc.next() + sc.nextLine();

            int[] pos = movePlayer(grid, x, y, move, blue, reset);
            x = pos[0];
            y = pos[1];

            if (move.equalsIgnoreCase("z")) {
                enemyCount = 0;
            }

            for (int i = 0; i < 25; i++)
                System.out.println();

            for (int i = 0; i < enemyCount; i++) {
                if (x == enemyPosX[i] && y == enemyPosY[i]) {
                    System.out.println(green + "You caught some trash!" + reset);

                    for (int j = i; j < enemyCount - 1; j++) {
                        enemyPosX[j] = enemyPosX[j + 1];
                        enemyPosY[j] = enemyPosY[j + 1];
                    }

                    enemyCount--;
                    trash++;
                    break;
                }
            }

        } while (enemyCount > 0);

        return trash;
    }

}