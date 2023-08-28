import com.ops.helloClass

def call(){
    def myClass =  new helloClass(this)
    //myClass.nope()
    return myClass.sayNope()
}
