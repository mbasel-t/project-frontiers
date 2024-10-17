//package project_frontiers;
import java.util.Scanner;

public class GameInterface {

    private static final Scanner scanner = new Scanner(System.in);

    public static void delay() {
        delay(600);
    }

    public static void delay(int millis) {
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void output(String output) {
        System.out.println(output);
    }

    public static int query(String query, String[] options, String[] inputs) {
        int result = -1;

        if (options.length == inputs.length && options.length > 0) {

            // ask the question
            output(query);
            delay();
            int i = 0;
            while (i < options.length) {
                output(String.format("OPTION %1$x: %2$s [%3$s]", i+1, options[i], inputs[i++]));
                delay(300);
            }
            System.out.print("SELECT: ");
            String playerInput = scanner.nextLine();

            // verify that the question was answered correctly
            int j = 0;
            while (result < 0 && j < inputs.length) {
                if (playerInput.equalsIgnoreCase(inputs[j])) {
                    result = j;
                }
                j++;
            }

            // repeat if the question was answered incorrectly
            while (result == -1) {
                // scold them
                System.out.println("INVALID INPUT");
                delay();

                // ask the question again
                output(query);
                delay();
                i = 0;
                while (i < options.length) {
                    output(String.format("OPTION %1$x: %2$s [%3$s]", i+1, options[i], inputs[i++]));
                    delay(300);
                }
                System.out.print("SELECT: ");
                playerInput = scanner.nextLine();

                // verify that the question was answered correctly
                j = 0;
                while (result < 0 && j < inputs.length) {
                if (playerInput.equalsIgnoreCase(inputs[j++])) {
                    result = j-1;
                }
            }
            }

        } else {
            output("QUERY FAILED - INVALID ARGUMENTS");
            delay();
        }

        System.out.println();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(GameInterface.query("TEST", new String[] {"One", "Two", "Three"}, new String[] {"z", "x", "c"}));
    }
}