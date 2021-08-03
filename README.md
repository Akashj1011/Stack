# Stack

- To run the project:
Go inside Dockerfile directory.
Run below two commands:

docker build --tag=stack:latest . 
docker run -p8887:8080 stack:latest

- It will run the application on port: 8887 of localhost.


Things done in this project:

- All necessary Apis created for Stack.
- Stack is implemented using array.
- Stack class is an interface with all the necessary methods to be implemented.
- StackUsingArray implements Stack class interface and implements all stack methods usong array.
- Similary in future some other class can implement stack to implement stack functionality with different data structure.
- Unit Tests and Integration Test is written.
- Dockerfile is created

