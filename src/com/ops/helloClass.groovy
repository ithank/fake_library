package com.ops;

public class helloClass implements Serializable {
    public def whatIsForDinner(Map config = [:]) {
     sh "echo Dinner is ${config.meal}."
    }

    public def sayNope() {
      sh "echo NOPE!"
    }
}
