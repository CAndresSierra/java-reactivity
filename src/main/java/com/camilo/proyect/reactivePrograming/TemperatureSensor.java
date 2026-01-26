package com.camilo.proyect.reactivePrograming;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class TemperatureSensor {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);

        Observable<Double> temperatureStream = interval.map(
                _ -> {
                    double temp = 20 + Math.random() * 15;
                    System.out.println("Current temp: " + temp);
                    return temp;
                }
        );

        temperatureStream
                .filter(temp -> temp > 30)
                .subscribe(
                item -> System.out.println("High temperature alert: " + item),
                throwable -> System.out.println(throwable.getMessage()),
                () -> System.out.println("End")

        );
        Thread.sleep(10000);

    }
}
