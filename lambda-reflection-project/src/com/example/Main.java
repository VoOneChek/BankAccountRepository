package com.example;

import com.example.lambda.LambdaDemo;
import com.example.handler.*;
import com.example.model.*;

public class Main {

    public static void main(String[] args) {

        LambdaDemo.run();

        DeprecatedHandler.check(OldService.class);

        Person p = new Person("Vladimir", 23);
        System.out.println(JsonSerializer.toJson(p));
    }
}