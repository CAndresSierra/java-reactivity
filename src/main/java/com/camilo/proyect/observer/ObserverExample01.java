package com.camilo.proyect.observer;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.Arrays;
import java.util.Objects;

public class ObserverExample01 {
    public static void main(String[] args) {
        Observable<String> courseStream = Observable.fromIterable(
                Arrays.asList("HTML", "CSS", null , "C")
                        .stream()
                        .filter(Objects::nonNull).toList()
        );

        Observer<String> observer = new Observer<>() {
            private Disposable disposable;
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                this.disposable = d;
                System.out.println("Im subscribe!!!!");
            }

            @Override
            public void onNext(@NonNull String s) {
                if(s.equalsIgnoreCase("c")) {
                    disposable.dispose();
                } else {
                    System.out.println("Received: " + s);
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Error: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("END...");
            }
        };

        Observer<String> observer2 = new Observer<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Im subscribe, im observer two!!!!");
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("Im observer two and Received: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Error: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("END observer two...");
            }
        };

        courseStream.subscribe(observer);
        courseStream.subscribe(observer2);


    }
}
