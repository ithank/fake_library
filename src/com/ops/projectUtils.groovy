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
    def mm = new mapMerge()
    def project =[:]
    project["key1"]="value1"
    project["key2"]=99
    def newMap = ["anotherKey":"anotherValue"]

    return mm.merge(project, newMap)

    
    
  }
}
