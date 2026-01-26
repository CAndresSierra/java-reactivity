package com.camilo.proyect.reactivePrograming;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

import java.util.Scanner;

public class ReactiveIntro {
    public static void main(String[] args) {
//        Observable<String> courseStream = Observable.just("HTML", "CSS", "JAVA", "C");
//
//        courseStream.subscribe(
//                item -> System.out.println("Received: " + item),
//                error -> System.out.println(error.getMessage()),
//                () -> System.out.println("Finished")
//        );

        ObservableOnSubscribe subscribe = emitter -> {
            Scanner sc = new Scanner(System.in);
            String input;
            while(true) {
                System.out.println("Type a name.... or 'exit' to leave the app");
                 input = sc.nextLine();
                if(input.equalsIgnoreCase("exit")){
                    break;
                }
                emitter.onNext(input);
            }
        };

        Observable<String> names = Observable.create(subscribe);

        names.subscribe(
                item -> System.out.println("Name: " + item),
                (error) -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("Finished...")
        );
    }
}
