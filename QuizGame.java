import java.util.Scanner;

public class QuizGame {

    static String[] questions = {
        "What is the full form of Java?",
        "Which keyword is used to create a class in Java?",
        "What is the size of int in Java?",
        "Which method is the entry point of a Java program?",
        "What does OOP stand for?"
    };
    static String[][] options = {
        {"A. Just Another Virtual Accelerator", "B. Just Another Vague Acronym", "C. Java is not an acronym", "D. Joint Automated Virtual Application"},
        {"A. Class", "B. class", "C. CLASS", "D. klass"},
        {"A. 2 bytes", "B. 8 bytes", "C. 4 bytes", "D. 16 bytes"},
        {"A. start()", "B. run()", "C. init()", "D. main()"},
        {"A. Object Oriented Programming", "B. Out Of Place", "C. Oriented Object Process", "D. Online Object Programming"}
    };
    static String[] answers = {"C", "B", "C", "D", "A"};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("==============================");
        System.out.println("      Welcome to Quiz Game    ");
        System.out.println("==============================\n");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Q" + (i + 1) + ": " + questions[i]);
            for (int j = 0; j < options[i].length; j++) {
                System.out.println("  " + options[i][j]);
            }
            System.out.print("Your answer (A/B/C/D): ");
            String userAnswer = scanner.nextLine().toUpperCase().trim();

            if (userAnswer.equals(answers[i])) {
                System.out.println("✔ Correct!\n");
                score++;
            } else {
                System.out.println("✘ Wrong! Correct answer is: " + answers[i] + "\n");
            }
        }
        System.out.println("==============================");
        System.out.println("Quiz Finished!");
        System.out.println("Your Score: " + score + " / " + questions.length);
        if (score == questions.length) {
            System.out.println("Result: Excellent! Perfect Score! 🎉");
        } else if (score >= 3) {
            System.out.println("Result: Good Job! Keep it up! 👍");
        } else {
            System.out.println("Result: Keep Practicing! 💪");
        }
        System.out.println("==============================");
       
    }
}