def call(path) {
  def fileContents = readYaml(file: "${WORKSPACE}/resources/test.yaml")
  return fileContents
}
