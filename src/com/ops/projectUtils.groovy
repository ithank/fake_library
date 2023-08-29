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
    def project = context.libraryResource("${repo}")
    //def project = context.readYaml file: repo
    return project
  }

  public dirPath(path) {
    context.sh("ls -la ${path}")
  }

  public writeFile(filePath, fileContents) {
    println("in projectUtils.writeFile")
    context.writeYaml file: "${filePath}", data: fileContents
        def read = context.readYaml file: "${filePath}"
  
}
