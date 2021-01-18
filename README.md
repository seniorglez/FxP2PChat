# FxP2PChat
An example of javaFX P2P chat using Service and ScheduledService.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

For this application you will need to run two clients to test it so make sure you switch the in and out port numbers on [Configuration.java](/src/main/java/org/openjfx/configuration/Configuration.java) before you compile the second client.

### Prerequisites

#### Mac OS

* Download this version of Graal VM: https://download2.gluonhq.com/substrate/graalvm/graalvm-svm-darwin-20.1.0-ea+28.zip and unpack it like you would any other JDK. (e.g. in `/opt`)

* Configure the runtime environment. Set `GRAALVM_HOME` environment variable to the GraalVM installation directory.

For example:

    export GRAALVM_HOME=/opt/graalvm-svm-darwin-20.1.0-ea+28

* Set `JAVA_HOME` to point to the GraalVM installation directory

For example:

    export JAVA_HOME=$GRAALVM_HOME

#### Linux 

* Download this version of Graal VM: https://download2.gluonhq.com/substrate/graalvm/graalvm-svm-linux-20.1.0-ea+28.zip and unpack it like you would any other JDK. (e.g. in `/opt`)

* Configure the runtime environment. Set `GRAALVM_HOME` environment variable to the GraalVM installation directory.

For example:

    export GRAALVM_HOME=/opt/graalvm-svm-linux-20.1.0-ea+28

* Set `JAVA_HOME` to point to the GraalVM installation directory

For example:

    export JAVA_HOME=$GRAALVM_HOME

### Build using Maven

The following goals apply to Linux and Mac OS X.

To build the native image:

    mvn clean client:build

To run the native image:

    mvn client:run

or simply run the native executable found in `target/client`.

## Built With

* [Maven](https://maven.apache.org/) - The build automation tool
* [GraalVM](https://www.graalvm.org/) - The poliglot JVM
* [OpenJavaFX](https://openjfx.io/) - An open source, next generation client application platform for desktop, mobile and embedded systems built on Java.
* [javafx-maven-plugin](https://github.com/openjfx/javafx-maven-plugin) - The javaFX plugin for javaFX 11 or higher projets.
* [client-maven-plugin](https://github.com/gluonhq/client-maven-plugin) - Plugin that simplifies using Gluon Client for Java/JavaFX maven projects.

## Contributing

Feel free to fork it and made pull request.


## Authors

* **Diego Dominguez**   <a href="https://twitter.com/DGlez1111" target="_blank">
    <img alt="Twitter: DGlez1111" src="https://img.shields.io/twitter/follow/DGlez1111.svg?style=social" />
  </a>

## License

FxP2PChat is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or any later version.

FxP2PChat is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the [GNU General Public License](LICENSE)
along with FxP2PChat. If not, see [https://www.gnu.org/licenses/](https://www.gnu.org/licenses/)

![GPL3 or later](https://www.gnu.org/graphics/gplv3-or-later.png)
