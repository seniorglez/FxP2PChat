# FxP2PChat
An example of javaFX P2P chat using Service and ScheduledService.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

For this application you will need to run two clients to test it so make sure you switch the in and out port numbers on [Configuration.java](/src/main/java/org/openjfx/configuration/Configuration.java) before you compile the second client.

### Prerequisites

#### Mac OS X and iOS

* Download this version of Graal VM: https://download2.gluonhq.com/substrate/graalvm/graalvm-svm-darwin-20.1.0-ea+28.zip and unpack it like you would any other JDK. (e.g. in `/opt`)

* Configure the runtime environment. Set `GRAALVM_HOME` environment variable to the GraalVM installation directory.

For example:

    export GRAALVM_HOME=/opt/graalvm-svm-darwin-20.1.0-ea+28

* Set `JAVA_HOME` to point to the GraalVM installation directory

For example:

    export JAVA_HOME=$GRAALVM_HOME

#### Linux and Android

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

## Build and run the samples on iOS


* iOS can be built only on Mac OS X

* Install `Homebrew`, if you haven't already. Please refer to https://brew.sh/ for more information.

* Install `libusbmuxd`

Using `brew`:

    brew install --HEAD libusbmuxd

* Install `libimobiledevice`

Using `brew`:

    brew install --HEAD libimobiledevice

### Build using Maven


* Set the target to `ios` (for iOS devices) in the `pom.xml`:

```
<artifactId>client-maven-plugin</artifactId>
<configuration>
    <target>ios</target>
    <mainClass>${mainClassName}</mainClass>
</configuration>
```

* Build the native image:

```
mvn clean client:build
```

* Run the app on the connected iOS device:

```
mvn client:run
```

* Package and create an IPA file to submit to TestFlight or to the App Store:

```
mvn client:package
```

**Note**: In order to deploy apps to an iOS device, you need a valid iOS provisioning profile, as explained in the [documentation](https://docs.gluonhq.com/client/#_ios_deployment).

## Build and run the samples on Android

* Android can be built only on Linux OS

The client plugin will download the Android SDK and install the required packages. Alternatively, you can define a custom location to the Android SDK by setting the `ANDROID_SDK` environment variable, making sure that you have installed all the packages from the following list:

* platforms;android-27
* platform-tools
* build-tools;27.0.3
* ndk-bundle
* extras;android;m2repository
* extras;google;m2repository

### Build using Maven

* Set the target to `android` (for android devices) in `pom.xml`:

```
<artifactId>client-maven-plugin</artifactId>
<configuration>
    <target>android</target>
    <mainClass>${mainClassName}</mainClass>
</configuration>
```

* Build the native image:

```
mvn clean client:build
```

* Package and create an APK file:

```
mvn client:package
```

* Install the APK file on a connected Android device:

```
mvn client:install
```

* Run the installed app on the connected Android device:

```
mvn client:run
```


## Built With

* [Maven](https://maven.apache.org/) - The build automation tool
* [GraalVM](https://www.graalvm.org/) - The poliglot JVM
* [OpenJavaFX](https://openjfx.io/) - An open source, next generation client application platform for desktop, mobile and embedded systems built on Java.
* [javafx-maven-plugin](https://github.com/openjfx/javafx-maven-plugin) - The javaFX plugin for javaFX 11 or higher projets.
* [client-maven-plugin](https://github.com/gluonhq/client-maven-plugin) - Plugin that simplifies using Gluon Client for Java/JavaFX maven projects.
* [jackson-databind](https://github.com/FasterXML/jackson-databind) - The popular framework that allows us to map rest json responses as java objects.
* [chucknorris.io](https://api.chucknorris.io/) - A free JSON API for hand curated Chuck Norris facts.

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
