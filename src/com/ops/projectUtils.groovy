#!groovy
package com.ops

import org.yaml.snakeyaml.Yaml
import hudson.AbortException


public class projectUtils implements Serializable {
  def context

  public projectUtils(context) {
    this.context = context
    println("in projectUtils constructor")
  }

  public readProject(String repo) {
    println("in projectUtils.readProject")
    //def project = this.libraryResource 'test.yaml'
    def project = readYaml file: repo
    return project
  }

  public testFile(path) {
    context.sh("ls -la ${path}")
  }

  public readFile(path) {
    def stringContents = readYaml file: path
    return stringContents
  }
  
}
