package com.camilo.proyect.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Schedulers01 {
    public static void main(String[] args) throws InterruptedException {
        Observable.just("Hola")
                .subscribeOn(Schedulers.io())
                .doOnNext(s -> System.out.println(s + " Just: " + Thread.currentThread().getName()))
                .observeOn(Schedulers.computation())
                .doOnNext(s -> System.out.println(s + " Map: " + Thread.currentThread().getName()))
                .map(s -> s + "Mundo")
                .subscribe(
                        s -> System.out.println("🗿 Result: " + s + " " + Thread.currentThread().getName())
                );

        Thread.sleep(1000);
    }
}
