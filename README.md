# sleipnir-sample
A sample project for [sleipnir](https://github.com/dmitriy-yefremov/sleipnir) that consists of a server with an items resource. We use Pegasus schemas to define the response structure of the server, and generate Scala bindings for the schemas with the sleipnir sbt plugin.

To run, just execute `sbt run` in the sleipnir-sample folder. The server will start by default on `http://localhost:9000`.

Note: This project depends on sleipnir, which is not yet published. Before running the project, you should checkout sleipnir, publish it locally, and depend on the locally published sleipnir sbt plugin.
