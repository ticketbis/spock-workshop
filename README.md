# spock-workshop
This workshop is aimed to all those who want to learn and understand the basics of [Spock Framework](http://spockframework.github.io/spock/docs/1.0/) using Groovy.

If you want to follow this workshop by your own, we strongly recommend you to check [Spock basics](http://spockframework.github.io/spock/docs/1.0/spock_primer.html) before start coding.

## How to start
You can find three different exercises in [/src/test/](https://github.com/ticketbis/spock-workshop/tree/master/src/test/groovy) in the **master** branch:
* **Workshop01Spec.groovy**: Basic testing [handling exceptions](http://spockframework.github.io/spock/docs/1.0/spock_primer.html#_exception_conditions) and [Data Driven Testing](http://spockframework.github.io/spock/docs/1.0/data_driven_testing.html).
* **Workshop02Spec.groovy**: Usage of [fixture methods](http://spockframework.github.io/spock/docs/1.0/spock_primer.html#_fixture_methods).
* **Workshop03Spec.groovy**: Usage of [Mocks and Stubs](http://spockframework.github.io/spock/docs/1.0/interaction_based_testing.html).

Each of the files is a Spock test, and you will find there some comments that explain what to do.

There already is working code in [/src/main/](https://github.com/ticketbis/spock-workshop/tree/master/src/main/groovy/com/ticketbis/workshop) that **you should not change**. It works as it is, and **you should only change the Spec files**, creating everything you need in order to complete all the *TODO* tasks.

Each *TODO* task should be solved using only one feature method, but feel free to do it your way.

### Run the tests with Gradle
```./gradlew test```

### Run the tests with IntelliJ IDEA
First of all, import the project in IntelliJ:
* File > New > Project from Existing Sources...
* Select the **build.gradle** file.
* Select *Use default gradle wrapper* in the import process and an existing java version.

Finally, you can select a specific test file or a package and **Secondary click > Run [file|Tests in package]**.

## Solutions
You will find our solutions proposal in the [Solutions](https://github.com/ticketbis/spock-workshop/tree/solutions) branch.

We tried to solve the tasks using different approaches in order to show different Spock features.

If you don't understand something in the solved exercises, we recommend you to search for it in the [Spock Framework Reference Documentation](http://spockframework.github.io/spock/docs/1.0/). You will find there everything we used.
