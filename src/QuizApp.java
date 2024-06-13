import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Quiz Application Menu:");
            System.out.println("1. Add Question");
            System.out.println("2. Start Quiz");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    quiz.addQuestionInteractively();
                    break;
                case 2:
                    quiz.start();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        scanner.close();
    }
}
