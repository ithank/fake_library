package com.ops

public class helloClass inmplements Serializable {
    public def whatIsForDinner(Map config = [:]) {
     sh "echo Dinner is ${config.meal}."
    }

    public def sayNope() {
      sh "echo NOPE!"
    }
}
