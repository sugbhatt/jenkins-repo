node {
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/sugbhatt/jenkins-repo.git'
   }
   stage('Build') {

        withMaven(
            // Maven installation declared in the Jenkins "Global Tool Configuration"
            maven: 'mvn-3.5.4',
            // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
            // Maven settings and global settings can also be defined in Jenkins Global Tools Configuration
            mavenLocalRepo: '.repository') {
     
              // Run the maven build
              if (isUnix()) {
                 sh "mvn -Dmaven.test.failure.ignore clean package"
              } else {
                 bat(/mvn -Dmaven.test.failure.ignore clean package/)
              }
     
        } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe & FindBugs reports...       

   }
   stage('Deploy') {

        withMaven(
            // Maven installation declared in the Jenkins "Global Tool Configuration"
            maven: 'mvn-3.5.4',
            // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
            // Maven settings and global settings can also be defined in Jenkins Global Tools Configuration
            mavenLocalRepo: '.repository') {
     
              // Run the maven build
              if (isUnix()) {
                 sh "mvn -Dmaven.test.failure.ignore fabric8:deploy"
              } else {
                 bat(/mvn -Dmaven.test.failure.ignore fabric8:deploy/)
              }
     
        } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe & FindBugs reports...       

   }
}
