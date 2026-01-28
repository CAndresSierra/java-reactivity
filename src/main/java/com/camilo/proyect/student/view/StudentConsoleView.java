package com.camilo.proyect.student.view;

import com.camilo.proyect.student.controller.StudentController;

import java.util.Scanner;

public class StudentConsoleView {
    private final StudentController studentController;
    private final Scanner scanner;

    public StudentConsoleView(StudentController studentController) {
        this.studentController = studentController;
        this.scanner = new Scanner(System.in);
    }

    public void start(){

        System.out.println("If you want to finish the app type 'exit'");
        while(true){
            System.out.println("Type the name");
            String name = scanner.nextLine().trim();
            if(name.equalsIgnoreCase("exit")) break;

            System.out.println("Type the age");
            String age = scanner.nextLine();
            boolean ok = studentController.processInput(name, age);

            if (!ok){
                System.out.println("Invalid age....");
            }

            studentController.finishInput();
            System.out.println("End....");
        }
    }

}
