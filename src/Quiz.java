import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void addQuestionInteractively() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the question text: ");
        String questionText = scanner.nextLine();

        System.out.print("Enter the number of options: ");
        int numOptions = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        String[] options = new String[numOptions];
        for (int i = 0; i < numOptions; i++) {
            System.out.print("Enter option " + (char)('A' + i) + ": ");
            options[i] = scanner.nextLine();
        }

        System.out.print("Enter the correct answer (A, B, C, ...): ");
        char correctAnswer = scanner.next().toUpperCase().charAt(0);

        Question newQuestion = new Question(questionText, options, correctAnswer);
        addQuestion(newQuestion);
        System.out.println("Question added successfully!\n");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((char)('A' + i) + ": " + options[i]);
            }

            System.out.print("Your answer: ");
            char answer = scanner.next().toUpperCase().charAt(0);

            if (question.checkAnswer(answer)) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Wrong! The correct answer is: " + question.getCorrectAnswer() + "\n");
            }
        }

        System.out.println("Quiz over! Your score is: " + score + "/" + questions.size());
    }
}
