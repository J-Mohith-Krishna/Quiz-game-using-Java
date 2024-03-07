import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String question;
    private List<String> options;
    private int correctOption;

    public Question(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

public class QuizApp {
    private List<Question> questions;
    private int score;

    public QuizApp() {
        this.questions = new ArrayList<>();
        this.score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void displayQuestions() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestion());
            List<String> options = currentQuestion.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();
            if (userAnswer == currentQuestion.getCorrectOption()) {
                score++;
            }
        }
        System.out.println("Quiz completed! Your score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        QuizApp quizApp = new QuizApp();

        // Adding questions to the quiz
        List<String> options1 = new ArrayList<>();
        options1.add("A. Option 1");
        options1.add("B. Option 2");
        options1.add("C. Option 3");
        options1.add("D. Option 4");
        quizApp.addQuestion(new Question("What is 2 + 2?", options1, 4));

        List<String> options2 = new ArrayList<>();
        options2.add("A. Option 1");
        options2.add("B. Option 2");
        options2.add("C. Option 3");
        options2.add("D. Option 4");
        quizApp.addQuestion(new Question("What is the capital of France?", options2, 3));

        List<String> options3 = new ArrayList<>();
        options3.add("A. Option 1");
        options3.add("B. Option 2");
        options3.add("C. Option 3");
        options3.add("D. Option 4");
        quizApp.addQuestion(new Question("What is the largest planet in our solar system?", options3, 1));

        // Displaying questions and calculating the final score
        quizApp.displayQuestions();
    }
}
