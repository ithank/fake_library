import com.ops

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

    user.name = context.BUILD_USER
    user.email = context.BUILD_USER_EMAIL
    return user
  }
  
}
