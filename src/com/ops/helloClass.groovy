package com.ops

public class helloClass {
    public def whatIsForDinner(Map config) {
     sh "echo Dinner is ${config.meal}."
    }

    public def nope() {
      sh "echo NOPE!"
    }
}
