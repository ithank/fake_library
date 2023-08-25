def call(Map config) {
    // you can call any valid step functions from your code, just like you can from Pipeline scripts
    sh "echo Hello world, ${config.name}"
}

def louder(Map config) {
    def msg = "Hello world, ${config.name}"
    msg = msg.toUpperCase()
    sh "echo ${msg}"
}