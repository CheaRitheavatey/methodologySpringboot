# methodologySpringboot

**REST APIs (types)**
- stateless: communication method that server completes every client request independently of all previous requests
- layered system: clident can connect to other authorized intermediate between the client server, and it will still receive responses from the server
- cacheability: storing some response on clident side to improve server response time
- code on demand: server can tempt extend or customized clident functionality by transferring software programming code to the client.

**BENEFITS**
- scalabity
- flexibility
- independance

**HOW IT WORK**
- client request
- server authenticate
- do business logic (internal process)
- server send response back

**METHOD**
- GET
- POST
- PUT
- DELETE
  (and more but these are the most used most important)

**AUTHENTICATION**
- HTTP authentication: basic and bearer authentication
- API keys
- OAuth

  **API endpoint**
  - is a point of entry
  example: base url: localhost:8080 and the endpoint: /student

01.10.2025
**interface:**
- hide the detail
- sth that can be shared among classes
- reference type
- can be constants, method signature, default method, static method, nested type
- interface cannot be instatiated, other class can implement the interface and then provide the implementation by the class
- interface extend another interface need to add other function
- interface have no constructor cuz u cannot use to make an object
- for constant it by default: public, static , final
- for method by default: public, abstract
- for default method, you can add body inside interface java 8 onward.
- why default method?
- can have somesort of implementation, if we dont have nothing to do with it. especially for big project.
- java 8 also add static method inside interface
- marker or tagg interface: interface that has no member
- interface can be nested

-    ** interface           vs             abstract**
- no constructor                     - have constructor
- final/constant                     - attribute
- creating connection
between non related class            - connecting related class

