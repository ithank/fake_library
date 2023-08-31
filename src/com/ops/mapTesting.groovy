#!groovy
package com.ops

import org.yaml.snakeyaml.Yaml
import hudson.AbortException

public class mapTesting implements Serializable {
  def context

  public mapTesting(context) {
    this.context = context
  }
  public makeAndMerge() {
    def mm = new mapMerge()
    def outMap = [:]
    def tmpMap = [:]
    
    tmpMap["Tag"] = 'version'
    tmpMap["Environment"] = 'environment'
    tmpMap["EnableNewRelic"] = false
    tmpMap["EnableSwagger"] = false
    tmpMap["EnableHealthProbes"] = true
    tmpMap["Predeploy"] = false
    outMap = mm.merge(outMap, [selections: tmpMap])
    tmpMap = getOtherMap()
    outMap = mm.merge(outMap, tmpMap)
  }
  
  def getHemlMap() {
      def project =[:]
      project["key1"]="value1"
      project["key2"]=99
      
      //def project = context.readYaml file: repo
      return [helm: project]  
  }
}
