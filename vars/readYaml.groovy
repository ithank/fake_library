def call(path) {
  def fileContents = readYaml file: path
  return fileContents
}
