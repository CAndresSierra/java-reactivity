package com.camilo.proyect.advancedChaining;

import com.camilo.proyect.flowCombination.Student;
import io.reactivex.rxjava3.core.Observable;

public class ChainingExample {
    public static void main(String[] args) {
        Observable<Student> studentObservable = Observable.just(
                new Student("Mario", 13),
                new Student("Juan", 33),
                new Student("Camilo", 43)
        );


//        studentObservable
//                .filter(student -> student.getAge() > 21)
//                .map(student -> student.getName().toUpperCase())
//                .subscribe(System.out::println);

        studentObservable
                .filter(student -> student.getAge() > 21)
                .flatMap(student -> getSubjectPerStudent(student.getName()))
                .subscribe(
                        s -> System.out.println("Materia: " + s),
                        error -> System.out.println(error.getMessage()),
                        () -> System.out.println("Finished")
                );


    }

    public static Observable<String> getSubjectPerStudent(String name) {
      if(name.equalsIgnoreCase("Juan")){
          return Observable.just("Programcion 3", "Algoritmos");
      }

      return Observable.empty();
    }
}
