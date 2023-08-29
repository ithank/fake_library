def call(path) {
  def fileContents = readYaml file: 'resources/test.yaml'
  return fileContents
}
