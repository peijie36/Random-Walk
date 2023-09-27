import java.util.*;
import java.awt.*;

public class RandomWalk {
    public static boolean debug = false;
    public static int walks = 0;
    public static int steps = 0;
    public static int bestWalk = Integer.MAX_VALUE;

    public static void main(String[] args) {
        introduction();
        DrawingPanel background = new DrawingPanel(500, 500);
        Graphics g = background.getGraphics();
        Scanner scanner = new Scanner(System.in);
        String again = "y";
        while(again.toLowerCase().startsWith("y")) {
            int radius = askRadius(scanner);
            walks++;
            g.clearRect(0, 0, 500, 500);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 500, 500);
            g.setColor(Color.BLACK);
            g.drawOval(0, 0, 2 * radius, 2 * radius);
            walk(radius, g, background);
            System.out.print("Walk again (yes/no)? ");
            again = scanner.next();
        };
        results();
        scanner.close();
        System.exit(0);
    }

    public static void introduction() {
        System.out.println("Welcome to the game of RandomWalk.");
        System.out.println("You will be asked to give a radius");
        System.out.println("for the circle and the program will");
        System.out.println("draw a cool pattern for you");
    }

    public static int askRadius(Scanner scanner) {
        System.out.println();
        System.out.print("Radius: ");
        int radius = scanner.nextInt();
        return radius;
    }

    public static void walk(int r, Graphics g, DrawingPanel p) {
        int walkX = r;
        int walkY = r;
        int direction = 0;
        int moves = 0;
        Random rand = new Random();
        do {
            p.sleep(1);
            direction = rand.nextInt(4);
            moves++;
            steps++;
            if((int) Math.sqrt(Math.pow(walkX - r, 2) + Math.pow(walkY - r, 2)) != r) {
                debug = true;
            } else {
                debug = false;
            }
            if(direction == 0) {
                walkX++;
                g.drawRect(walkX, walkY, 1, 1);
            } else if (direction == 1) {
                walkX--;
                g.drawRect(walkX, walkY, 1, 1);
            } else if (direction == 2) {
                walkY++;
                g.drawRect(walkX, walkY, 1, 1);
            } else {
                walkY--;
                g.drawRect(walkX, walkY, 1, 1);
            }
            /*
             * if(debug == true)
             * {
             * System.out.println("x = " + walkX + ", y = " + walkY + ", moves = " + move);
             * }
             */
        } while ((int) Math.sqrt(Math.pow(walkX - r, 2) + Math.pow(walkY - r, 2)) != r);
        if (moves < bestWalk) {
            bestWalk = moves;
        }
        System.out.println("Escaped in " + moves + " move(s)");
    }

    public static void results() {
        System.out.println();
        System.out.println("Total walks = " + walks);
        System.out.println("Total steps = " + steps);
        System.out.println("Average steps = " + (double)(steps / walks));
        System.out.println("Best walk = " + bestWalk);
    }
}
