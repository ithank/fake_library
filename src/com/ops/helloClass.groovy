package com.ops;

public class helloClass implements Serializable {
    def context

    public helloClass(context) {
        this.context = context
    }
    
    public def whatIsForDinner(Map config = [:]) {
     context.sh "echo Dinner is ${config.meal}."
    }

    public def sayNope() {
      //context.sh "echo NOPE!"
        return "No way!"
    }
}
