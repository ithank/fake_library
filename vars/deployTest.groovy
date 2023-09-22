import com.ops.timeoutClass

def call() 
{
  try
  {
    def tc = new com.ops.timeoutClass()
    tc.deployPipeline()
  }
  catch(e)
  {
    println("in deployTest error handler")
    println("error: \n ${e}")
    currentBuild.result = 'FAILURE'
    throw e
  }
}