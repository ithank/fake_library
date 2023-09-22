package com.ops

public deployPipeline()
{
  def args = [:]
  println("calling deployStandardDialog")

  args=deployStandardDialog(args)

  println("calling deployHelmRelease")
  args=deployHelmRelease(args)
}

public deployStandardDialog(Map args)
{
  def mapm = new mapMerge()
  def image_list = []
  def branches = []
  def chartVersions = []

  stage("gather")
  {
    image_list = ["one", "two"]
    branches = ["dev","st"]
    chartVersions = ["1.1.1", "1.1.2", "1.1.3"]
  }

  stage('Prompt for selection')
  {
    try {
      timeout(time: 1, unit: 'MINUTES')
      {

        selection = input message: 'Select image to deploy and environment', ok: 'Select',
          parameters: [
            choice(name: 'Tag', choices: image_list, description: 'Choose an image'),
            choice(name: 'Environment', choices: branches, description: 'Choose an environment'),
            choice(name: 'ChartVersion', choices: chartVersions, description: 'Choose a chart'),
            booleanParam(name: 'Predeploy', defaultValue: false, description: 'Check/Create AWS Parameter Store keys only'),
            booleanParam(name: 'EnableNewRelic', defaultValue: true, description: 'Enable New Relic, assumes global is on'),
            booleanParam(name: 'EnableSwagger', defaultValue: false, description: 'Enable Swagger'),
            booleanParam(name: 'EnableHealthProbes', defaultValue: true, description: 'Enable Health Checks')
        ]

      } // timeout
      println "User selection: ${selection}"
      args = mapm.merge(args, selection)
    }
    catch(e)
    {
      println("in error handler")
      println("error: \n ${e}")
      currentBuild.result = 'FAILURE'
      throw e
    }
    println("returning")
  } //stage
}

public deployHelmRelease(Map args)
{
  stage("deployHelmRelease")
  {
    println("in deployHelmRelease")
    println("current settings: ${args}")
  }
}