#!groovy
import org.yaml.snakeyaml.Yaml
import hudson.AbortException

package com.ops

public class projectUtils implements Serializable {
  def context

  public projectUtils(context) {
    this.context = context
  }

  public readProject(String repo) {
    def project = libraryResource('test.yaml')
    return project
  }

  
}
