package com.camilo.proyect.reactivePrograming;

import io.reactivex.rxjava3.subjects.PublishSubject;

import java.util.Scanner;

public class ReactiveScanner {
    public static void main(String[] args) {
        PublishSubject<String> inputStream = PublishSubject.create();


        inputStream.subscribe(
                item -> System.out.println("Received: " + item.toUpperCase()),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Finished....")
        );

        Scanner sc = new Scanner(System.in);

        System.out.println("Type a text or 'exit' to finish the app");

        while(true){
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("exit")){
                inputStream.onComplete();
                break;
            }
            inputStream.onNext(input);
        }

        sc.close();



    }
}
