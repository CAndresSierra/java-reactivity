package com.camilo.proyect.student.stream;

import com.camilo.proyect.student.model.Student;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class StudentStream {
    private final Subject<Student> studentSubject = PublishSubject.<Student>create().toSerialized();

    public void publish(Student student){
        this.studentSubject.onNext(student);
    }

    public Subject<Student> getStream(){
        return this.studentSubject;
    }

    public void complete(){
        this.studentSubject.onComplete();
    }

    public void error(Throwable throwable){
        this.studentSubject.onError(throwable);
    }

}
