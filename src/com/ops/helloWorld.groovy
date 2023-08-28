def call(Map config = [:]) {
    // you can call any valid step functions from your code, just like you can from Pipeline scripts
    sh "echo Why is it always 'Hello World, ${config.name}'?"
}

def louder(Map config = [:]) {
    def msg = "Hello world, ${config.name}"
    msg = msg.toUpperCase()
    sh "echo ${msg}"
}

def nope() {
    sh "echo NOPE!"
}
