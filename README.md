# Project_Portfolio

Project portfolio implementation using spring-boot hibernate CRUD

Project Structure:
 

Scenario 1: Save Project details with valid data.
URL : http://localhost:8080/project/save
 
Screen shot of data being saved in DB:
 



Scenario 2: Save Project details with estimates not in between 1 and 21.
URL : http://localhost:8080/project/save

 
 
Scenario 3:  Save project details with estimates  not  in Fibonacci series 
URL : http://localhost:8080/project/save

 
  
Scenario 4: Save Project details with  Project Type not in " DOCSMANAGE" 
or "SECURITIES"
URL : http://localhost:8080/project/save

 
 
Scenario 5 : Save Project details with  Project Type not in " DOCSMANAGE" or  "SECURITIES " as well as estimates not in fibonacci series.
URL : http://localhost:8080/project/save



 
 
 

Scenario 6: Fetch all project Details
URL: http://localhost:8080/projects

 
   
Corresponding DB entries:
 
Scenario 7: Fetch project by its Id.
URL : http://localhost:8080/projects/2
 
Scenario 8: Fetch project by Id that is not found.
 
Corresponding DB entries :
 
Scenario 9 : Delete project
URL : http://localhost:8080/projects/2
DB entries before deleting:


 
 
 
DB entries after deletion:
 
Scenario 10 : Delete project with an ID that is not found
URL: http://localhost:8080/projects/3
 
DB entries :
 

Scenario 11 : Update Project :Update Parent
URL: http://localhost:8080/projects/1
(ProjectType  updated from DOCSMANAGE TO SECURITIES)
 
DB entries before updation:
 
DB entries after updation:
 

Scenario 12: Update Project : Update Child
URL: http://localhost:8080/projects/1
(Project Contacts  updated  firstname from Amulya to Tejaswi)
 
DB entries before updation:
 
DB entries after updation:
 
Scenario 13: Update Project : Invalid Project ID
http://localhost:8080/projects/3
 

Scenario 14: Update Project : Invalid estimates
URL: http://localhost:8080/projects/1
 
 

Code Coverage:
 



