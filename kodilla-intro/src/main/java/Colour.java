import java.util.Scanner;

public class Colour {

    public static String getColourSelection() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select colour symbol to check the meaning in our app (you can chose B, F, N, R or Z):");
            String colour = scanner.nextLine().trim().toUpperCase();
            switch (colour) {
                case "B":
                    return "biały";
                case "F":
                    return "fioletowy";
                case "N":
                    return "niebieski";
                case "R":
                    return "różowy";
                case "Z":
                    return "zielony";
                default:
                    System.out.println("Wrong symbol. Chose one from given list. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getColourSelection());
    }
}

