package com.ops

public class helloClass {
    def whatIsForDinner(Map config) {
      sh "echo Dinner is ${config.meal}."
    }
    def nope(){
      sh "echo NOPE!"
    }
}
