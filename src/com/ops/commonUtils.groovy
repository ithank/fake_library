package com.ops

public class commonUtils
{
  def context
  public commonUtils(context)
  {
    this.context = context
  }

  
  @NonCPS
  public sortVersionList(list)
  {
    def versionComparator = { a, b ->
      def VALID_TOKENS = /._/
      a = a.tokenize(VALID_TOKENS)
      b = b.tokenize(VALID_TOKENS)

      for (i in 0..<Math.max(a.size(), b.size())) {
        if (i == a.size()) {
          return b[i].isInteger() ? -1 : 1
        } else if (i == b.size()) {
          return a[i].isInteger() ? 1 : -1
        }

        if (a[i].isInteger() && b[i].isInteger()) {
          int c = (a[i] as int) <=> (b[i] as int)
          if (c != 0) {
            return c
          }
        } else if (a[i].isInteger()) {
          return 1
        } else if (b[i].isInteger()) {
          return -1
        } else {
          int c = a[i] <=> b[i]
          if (c != 0) {
            return c
          }
        }
      }
      return 0
    }

    return list.sort(versionComparator)
  }

  public createChartList(chart_repo, project, version_prefix="1.3")
  {
    def charts_prefix="https://${chart_repo}/api/chartrepo/pv/charts"
    def response = context.httpRequest "${charts_prefix}/${project}"
    def props = context.readJSON text: response.content

    def versions=props.version.findAll { it.startsWith(version_prefix) }
    def sortedVersions = sortVersionList(versions).reverse()

    return sortedVersions
  }  

  public getEnvironmentList()
  {
    context.wrap([$class: 'BuildUser'])
    {
      //context.println "Retrieving User AD Groups for user: ${context.env.BUILD_USER_ID}"
      //def auths = Jenkins.instance.securityRealm.loadUserByUsername(context.env.BUILD_USER_ID)
      //  .authorities.collect{a -> a.authority}
      context.println "Retrieving User AD Groups for user: test_user"
      def auths = Jenkins.instance.securityRealm.loadUserByUsername("test_user")
      .authorities.collect{a -> a.authority}

      context.println "AD Groups: ${auths}"
    }
  }
}
