package com.ops

public class helloClass {
    def whatIsForDinner(Map config) {
     sh "echo Dinner is ${config.meal}."
    }

    //def nope(Map config) {
    //  sh "echo NOPE!"
    //}
}
