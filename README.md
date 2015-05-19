# sleipnir-sample
A sample project for [Sleipnir](https://github.com/dmitriy-yefremov/sleipnir) that consists of a server with an items resource. We use Pegasus schemas to define the response structure of the server, and generate Scala bindings for the schemas with the Sleipnir sbt plugin.

To run, just execute `sbt run` in the sleipnir-sample folder. The server will start by default on `http://localhost:9000`.