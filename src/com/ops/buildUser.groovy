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

    user.name = context.env.BUILD_USER
    user.email = context.env.BUILD_USER_EMAIL
    return user
  }
  
}
