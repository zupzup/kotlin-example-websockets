# kotlin-example-websockets
Example of using Kotlin to create a WebSockets API

Start with `./gradlew bootRun`

Then, open `index.html` multiple times.

Each site guesses numbers and sends them to the server, which, if a guessed number is a prime number, broadcasts that to alle clients. 