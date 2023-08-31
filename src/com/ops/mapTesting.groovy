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
    //outMap = mm.merge(outMap, [selections: tmpMap])
    outMap = [selections: tmpMap]
    
    tmpMap = getHelmMap()
    outMap = mm.merge(outMap, tmpMap)
  }
  
  def getHelmMap() {
      def mm = new mapMerge()
      def project =[:]
      project["key1"]="value1"
      project["key2"]=99

      def helm =[:]
      helm["myKey1"]="some value"
      helm["myKey2"]=123456
  
    
      def tempMap = [projectTemplateDeployment: project]
      tempMap = mm.merge(tempMap, [helmTemplate: helm])
    
      //def project = context.readYaml file: repo
      //return [helm: project]  
    return tempMap
  }
}
