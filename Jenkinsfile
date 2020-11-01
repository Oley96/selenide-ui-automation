node {

    stage("checkout repository") {
        git branch: 'main',
        url: 'https://github.com/Oley96/selenide-ui-automation.git'
    }

    stage("build") {
        sh './gradlew clean assemble'
    }

    stage("run test") {
        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
            sh './gradlew clean testRemoteChrome'
        }
    }

    stage("Create report") {
        script {
            allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'allure-results']]
            ])
    }
    }

}