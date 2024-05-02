Here's the content transformed into a complete Markdown (MD) format:

```markdown
# Distributed Voting Application README

## 1. Introduction
This voting system is a distributed application based on Java Remote Method Invocation (RMI). It enables clients to cast votes remotely and retrieve the results after voting. The system assigns a unique ID to each client, ensuring that each can only vote once. It specifically simulates a scenario where five clients (Client1 to Client5) vote for three candidates (choice1 to choice3).

## 2. Pre-Run Setup
Ensure that the Java Development Kit (JDK) is installed on your machine and that the JAVA_HOME environment variable is set properly.

- Download and unzip the project file `Li-Tianxiao-201769180.zip`.

## 3. Compilation Instructions
(if your project already contains the compiled “.class” files, you can skip the compilation steps.)

### Compile Server Folder Code
- Open the command-line interface.
- Navigate to the Server folder directory.
- Compile all the Java files in the Server folder using the following command:
```
javac *.java
```
Example path:
```
yibudeMacBook-Air:~ mac$ cd /Users/mac/Desktop/Li-Tianxiao-201769180/Sever
yibudeMacBook-Air:Sever mac$ javac *.java
```

### Compile Client Folder Code
- Open a new command-line interface window.
- Navigate to the Client folder directory.
- Compile all the Java files in the Client folder using the following command:
```
javac *.java
```
Example path:
```
yibudeMacBook-Air:~ mac$ cd /Users/mac/Desktop/Li-Tianxiao-201769180/Client
yibudeMacBook-Air:Client mac$ javac *.java
```

## 4. Running Instructions

### Start the Server
- Navigate to the directory containing the compiled Server class files.
- Start the server with the following command:
```
java Server
```
If "VoteServer is ready." appears, the server is set up and waiting for client connections. There is no need to start the RMI registry separately, as it is automatically initiated with the server.

Example command:
```
yibudeMacBook-Air:~ mac$ cd /Users/mac/Desktop/Li-Tianxiao-201769180/Sever
yibudeMacBook-Air:Sever mac$ java Server
VoteServer is ready.
```

### Run the Client
- In another new command-line interface window, navigate to the directory containing the compiled Client class files.
- Launch the client with the following command:
```
java Client
```
Follow the prompts to input the client ID you wish to run (e.g., Client1 - Client5) and your voting choice (e.g., choice1 to choice3). The client will register with the server, cast its vote, and then retrieve the current voting results.
- Once a client has voted and reviewed their voting results, the terminal session will complete. To start another client session, run the `java Client` command again.

## 5. Notes
- The system employs a HashMap data structure to keep track of each client's voting status.
- Each client ID is only allowed one vote. If an attempt is made to vote again using a client ID that has already voted, an error message will be displayed to ensure the uniqueness of each client's voting opportunity.
```

This Markdown code is ready to be used in any Markdown editor or renderer to provide a well-structured README document.
