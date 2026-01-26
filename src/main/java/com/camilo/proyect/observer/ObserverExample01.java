package com.camilo.proyect.observer;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class ObserverExample01 {
    public static void main(String[] args) {
        Observable<String> courseStream = Observable.fromIterable(
                Arrays.asList("HTML", "CSS", null , "C")
                        .stream()
                        .filter(course -> course != null).toList()
        );

        courseStream
                .subscribe(
                item -> System.out.println("Received: " + item),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("END")
        );


    }
}
