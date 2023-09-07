package com.ops

public class buildUser
{
  def context
  public buildUser(context)
  {
    this.context = context
  }

  public Map getBuildUserData()
  {
    def user = [:]
    context.wrap([$class: 'BuildUser']) {
      user.name = env.BUILD_USER
      user.email = env.BUILD_USER_EMAIL
    }
    return user
  }
  
}
