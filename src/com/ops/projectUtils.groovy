#!groovy
package com.ops

import org.yaml.snakeyaml.Yaml
import hudson.AbortException


public class projectUtils implements Serializable {
  def context

  public projectUtils(context) {
    this.context = context
  }

  public readProject(String repo) {
    def project = this.libraryResource 'test.yaml'
    return project
  }

  
}
