package com.camilo.proyect.flowCombination;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Merge {
    public static void main(String[] args) throws InterruptedException {
//        Observable<String> students = Observable.just("Mario", "Ana", "Camilo", "Ancizar")
//                .delay(1, TimeUnit.SECONDS);
//
//        Observable<String> teachers = Observable.just("Prof.Carlos", "Prof.Ana", "Prof.Camilo", "Prof.Ricardo");
//
//        Observable.merge(students, teachers).subscribe(System.out::println);
//
//        Thread.sleep(2000);

//        Observable<String> students = Observable.just("Mario", "Ana", "Camilo", "Ancizar")
//                .delay(1, TimeUnit.SECONDS);
//
//        Observable<String> teachers = Observable.just("Prof.Carlos", "Prof.Ana", "Prof.Camilo", "Prof.Ricardo");
//
//        Observable.concat(students, teachers).subscribe(System.out::println);
//
//        Thread.sleep(2000);


        Observable<String> students = Observable.just("Mario", "Ana", "Camilo", "Ancizar");
        Observable<Integer> ages = Observable.just(20, 30, 40, 50);

        Observable.zip(students, ages, Student::new)
                .subscribe(System.out::println);


    }
}
