node('linux') {
  stage ('Poll') {
    checkout([
      $class: 'GitSCM', branches: [[name: '*/main']], extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/p7zipport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [
      string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/p7zipport.git'),
      string(name: 'PORT_DESCRIPTION', value: '7-Zip (high compression file archiver) implementation'),
      string(name: 'BUILD_LINE', value: 'DEV')
    ]
  }
}
