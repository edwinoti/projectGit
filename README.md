# Assessment answers

1. The project is for java selenium 

**How to Run the Tests**

   a. Replace "home/edwin/chromedriver" with the actual path to your ChromeDriver executable.
   b.  Replace "your_username" and "your_password" with your GitHub credentials.
    
   c. Run the tests using your IDE or via Maven from your terminal using command " mvn test"
    
  **Code structure**
    
    The main code is on path /home/edwino/eclipse-workspace/projectGit/src/main/java/com/test/app/App.java

    The test code is on path /home/edwino/eclipse-workspace/projectGit/src/test/java/com/test/app/AppTest.java
    
2.    **Jenkins** code is on path  /home/edwino/eclipse-workspace/projectGit/jenkins/Jenkinsfile


3. **Jmeter** 
   Response Time: Measure average response time for one API request, aiming for under 500 milliseconds.
   Throughput: Achieve a throughput of at least 100 requests per minute.  
   Get endpoint api used https://api.github.com/repos/REPO/pulls/PULL_NUMBER
   
   Jmeter code file path on git   Postman_api_automation/git_api_performance.jmx
   
   
4. POSTMAN API Automation

**Create API**
HTTP method to POST.
URL to https://api.github.com/user/repos.

payload
{
  "name": "test-repo",
  "description": "This is your first repository",
  "private": false
}

**create api test**
pm.test("Status code is 201", function () {
  pm.response.to.have.status(201);
});

pm.test("Repository name is correct", function () {
  var jsonData = pm.response.json();
  pm.expect(jsonData.name).to.eql("test-repo");
});

**GET API**

HTTP method to GET.
URL to https://api.github.com/repos/repo.

**GET api test**
pm.test("Status code is 200", function () {
  pm.response.to.have.status(200);
});

pm.test("Repository description is correct", function () {
  var jsonData = pm.response.json();
  pm.expect(jsonData.description).to.eql("This is your first repository");
});


**UPDATE API**
HTTP method to PATCH.
URL to https://api.github.com/repos/repo.

payload
{
  "name": "test-repo",
  "description": "Updated description",
  "private": false
}


**update api test**
pm.test("Status code is 200", function () {
  pm.response.to.have.status(200);
});

pm.test("Repository description is updated", function () {
  var jsonData = pm.response.json();
  pm.expect(jsonData.description).to.eql("Updated description");
});
   

