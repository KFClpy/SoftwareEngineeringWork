import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Questioner questioner = new Questioner();
        for (int i = 0; i < 100; i++) {
            String str = questioner.questionWithParentheses(true, 100);
            System.out.println(str);
            double result = calculator.getFormulaResult(str);
            System.out.println(result);
        }
    }
}
