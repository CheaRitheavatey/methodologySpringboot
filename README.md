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
