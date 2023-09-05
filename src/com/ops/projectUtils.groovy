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
    return [project: project]
  }
  
  public readProject2(String repo) {
    println("in projectUtils.readProject")
    def project =[:]
    project["key1"]="value1"
    project["key2"]=99
    
    //def project = context.readYaml file: repo
    return [project: project]
  }


  public dirPath(path) {
    context.sh("ls -la ${path}")
  }

  public readWriteFile(filePath, fileContents) {
    println("in projectUtils.writeFile")
    context.writeYaml file: "${filePath}", data: fileContents
    def read = context.readYaml file: "${filePath}"
    return read
  }

  public fixup(project) {
    def mm = new mapMerge()
    
    def newMap = ["anotherKey":"anotherValue"]

    return mm.merge(project, newMap)
  }
  public mergeTest() {
    def msg = "Into mergeTest"
    println(">> ${msg}")
    context.println(">>> ${msg}")
    context.sh("echo ${msg}")
    
    def mm = new mapMerge()
    def project =[:]
    project["key1"]="value1"
    project["key2"]=99
    def newMap = ["anotherKey":"anotherValue"]

    return mm.merge(project, newMap)    
  }

  public readFile(filePath) {
    File file = new File(filePath)
    String fileContent = file.text
    return fileContent 
  }
  
  public readFileSubDir(filePath) {
    context.dir('mySubDir'){
      File file = new File(filePath)
      String fileContent = file.text
      return fileContent 
    }
  }

  public writeAFile(filePath, fileContents) {
    //File file = new File(filePath)
    //file.write(fileContents)
    context.writeFile(file: filePath, text: fileContents)
  }
  
  public writeAFileSubDir(filePath, fileContents) {
    context.dir('mySubDir'){
      context.writeFile(file: filePath, text: fileContents)
    }
  }
  
}
