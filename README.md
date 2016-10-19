# simple-jersey-service

[ ![Codeship Status for cbdr/TSEMemberServices](https://codeship.com/projects/ce4c1cb0-7799-0134-3b11-426e7deb1a75/status?branch=master)](https://codeship.com/projects/179955)

**To run:**

1. Setup Tomcat: https://wolfpaulus.com/journal/mac/tomcat8/

2. Clone repo

3. Run the following command (or remove the "mvn" and make a Maven run/debug configuration in Intellij): 
  ```
  mvn clean tomcat7:run-war -Dmaven.test.skip=true
  ```

**Endpoints:**
  ```
  GET http://localhost:8080/activities
  ```
  ```
  GET http://localhost:8080/activities/{activityId}
  ```
  ```
  GET http://localhost:8080/activities/{activityId}/user
  ```
  ```
  GET http://localhost:8080/search/activities?description={activityDescription}
  ```
  ```
  POST http://localhost:8080/activities/activity
  Content-Type: application/json
  
  Sample request:
  {
  "desc": "Swimming",
  "duration": "55",
  "id": "1234",
  "user": {
    "id": "5678",
    "name": "Kate"
   }
  }
  ```
  ```
  POST http://localhost:8080/activities/activity
  Content-Type: application/x-www-form-urlencoded
  
  Sample request:
  description: Swimming
  duration: 55
  ```
  ```
  PUT http://localhost:8080/activities/activity
  Content-Type: application/json
  
  Sample request:
  {
  "desc": "Swimming",
  "duration": "55",
  "id": "1234",
  "user": {
    "id": "5678",
    "name": "Kate"
   }
  }
  ```
  ```
  DELETE http://localhost:8080/activities/{activityId}
  ```
