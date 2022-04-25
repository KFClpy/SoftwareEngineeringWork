import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Questioner questioner = new Questioner();
        Scanner scanner=new Scanner(System.in);
        for (int i = 0; i < 100; i++) {
            String str = questioner.questionWithParentheses(true, 100);
            System.out.println(str);
            double result = calculator.getFormulaResult(str);
            double input=scanner.nextDouble();
            System.out.println(result);
            System.out.println(calculator.isEqual(result,input)?"正确":"错误");
        }
    }
}
