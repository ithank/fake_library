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
      user.name = context.env.BUILD_USER
      user.email = context.env.BUILD_USER_EMAIL
    }
    //return user
    return [name:user.name, email:user.email] //alternate building a map at return
  }
  
}
