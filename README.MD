# Serenity BE Archetype

Serenity archetype using Gradle to automate tests for BE projects.

## Getting Started

### Prerequisites

Any software to clone this repository (e.g. SourceTree, Git installed locally...)

**NOTE:** Gradle local installation is not needed because is integrated in the project with the Wrapper.

### Installing

Clone this repository

## Running the tests

1.Use below command to execute the tests:

```
gradlew clean test aggregate
```

2.If all works fine you will find an index.html file inside **target/site/serenity** folder with the results of the tests.

**NOTE:** If you are connected behind a proxy use -DuseProxy parameter:

```
gradlew clean test aggregate -DuseProxy
```

This will work behind Alten's proxy and Adidas externals one.
If you are connected to a different proxy, you will need to modify setProxy method inside TestRunner class.