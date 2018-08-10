# Web services testing

In this respository you'll find an INtellij IDEA complete project with all necessary tools to develop and try your self a testing rest microservice program. The project use free web services which are accessible to all internet. The WS are: [Petstore](https://petstore.swagger.io/#/). Other free WS are: [Reqres](https://reqres.in/).

### Tools used in the project

Tools used: 
- Intellij IDEA: is a whole Intellij IDEA project, build with gradle. An idea it's a very helpfull tool for big projects.  
- Gradle: for build the project and make all the folders and settings to the project. Combined with intellij for download dependencies, they are so powerfull. 
- REST Assured: libraries to testing and validate rest web services in Java. 
- Github: to have a control version and share knowledge with rest of the world.
- Postman: tool for external testing of the service. Petstore and reqres have their own example to test their own services but if you want to test some external services which doesn't provide their own example or test services [Postman](https://www.getpostman.com/) solve this problem.

### Test cases implemented and tested

Due to the large list of servicies offered by [Petstore](https://petstore.swagger.io/#/) it's a good idea to have some control of which services and test cases we have already coded:
- [ ] **Pet services**:
    - [x] POST /pet: insert a new pet into the store.
    - [x] PUT /pet: update the information about an existing pet into the store.
    - [x] GET /pet/findByStatus: retrieve information from the server filtered by the status.
    - [x] GET /pet/{petId}: retrieve information from the server filtered by the id.
    - [ ] POST /pet/{petId}: updates name and status information of the given pet's id into the server.
    - [x] DELETE /pet/{petId}: deletes a pet by its id.
    - [ ] POST /pet/{petId}/uploadImage: updates name, status and image information of the given pet's id into the server.

- [x] **Store services**:
    - [x] GET /store/inventory: returns pet inventories by status.
    - [x] POST /store/order: place an order for a pet.
    - [x] GET /store/order/{orderId}: finds purchased orders by id.
    - [x] DELETE /store/order/{orderId}: delete purchased order by id.


- [ ] **User services**:
    - [x] POST /user: create a user.
    - [x] POST /user/createWithArray: creates list of user with given input array.
    - [ ] POST /user/createWithList: creates list of user with given input list.
    - [x] GET /user/login: log user into the system.
    - [x] GET /user/logout: logout current logged in user session.
    - [x] GET /user/{username}: get user by username.
    - [x] PUT /user/{username}: update user.
    - [x] DELETE /user/{username}: delete user.
