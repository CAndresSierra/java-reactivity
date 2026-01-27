package com.camilo.proyect.filterAndCondition;

import io.reactivex.rxjava3.core.Observable;

public class FilterAndCondition {
    public static void main(String[] args) {
        Observable<Integer> ages = Observable.just(10, 20, 30, 12, 14, 18, 60, 70);

        //Filter
        //ages.filter(age -> age >= 21).subscribe(System.out::println);

        //Distinct
        //ages.distinct().subscribe(System.out::println);

        //Take
        //ages.take(2).subscribe(System.out::println);

        //Take while
        ages.takeWhile(age -> age < 21)
                .subscribe(System.out::println);

    }
}
