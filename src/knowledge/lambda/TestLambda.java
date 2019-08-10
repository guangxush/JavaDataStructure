package knowledge.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

/**
 * @author: guangxush
 * @create: 2019/08/10
 */
public class TestLambda {


    public static void main(String[] args) {
        // 用lambda表达式实现Runnable
        // Java 8之前：
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();

        //Java 8方式：
        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();

        // 基本语法
        // (params) -> expression
        // (params) -> statement
        // (params) -> { statements }
//        () -> System.out.println("Hello Lambda Expressions");
//        (int even, int odd) -> even + odd;

        //使用Java 8 lambda表达式进行事件处理
        // Java 8之前：
        JButton show = new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });

        // Java 8方式：
        show.addActionListener((e) -> {
            System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
        });


        // 使用lambda表达式对列表进行迭代

        // Java 8之前：
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (Object feature : features) {
            System.out.println(feature);
        }

        // Java 8之后：
        features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));

        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
        features.forEach(System.out::println);


    }


}
