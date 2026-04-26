package com.example.lambda;

import java.util.function.*;

public class LambdaDemo {

    public static void run() {

        Printable printable = () -> System.out.println("Hello Lambda");
        printable.print();

        Predicate<String> notNull = s -> s != null;
        Predicate<String> notEmpty = s -> !s.isEmpty();
        Predicate<String> valid = notNull.and(notEmpty);

        System.out.println(valid.test("Test"));

        Predicate<String> check = s ->
                s != null &&
                (s.startsWith("J") || s.startsWith("N")) && s.endsWith("A");

        System.out.println(check.test("JAVA"));

        Consumer<HeavyBox> ship = b ->
                System.out.println("Отгрузили ящик c весом " + b.getWeight());

        Consumer<HeavyBox> send = b ->
                System.out.println("Отправляем ящик c весом " + b.getWeight());

        ship.andThen(send).accept(new HeavyBox(10));

        Function<Integer, String> func = n -> {
            if (n > 0) return "Положительное";
            if (n < 0) return "Отрицательное";
            return "Ноль";
        };

        System.out.println(func.apply(5));

        Supplier<Integer> random = () -> (int)(Math.random() * 11);
        System.out.println("Random: " + random.get());
    }
}