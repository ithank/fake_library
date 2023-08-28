def call() {
  def fileContents = libraryResource 'test.yaml'
  return fileContents
}
