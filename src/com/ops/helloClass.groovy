package com.ops;

public class helloClass implements Serializable {
    def steps

    public helloClass(steps) {
        this.steps = steps
    }
    
    public def whatIsForDinner(Map config = [:]) {
     steps.sh "echo Dinner is ${config.meal}."
    }

    public def sayNope() {
      //steps.sh "echo NOPE!"
        return "No way!"
    }
}
