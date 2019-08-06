Spring Boot Example Project
-----------------------------

Spring Boot, JPA, Sring MVC, H2 Database 

Step by Step
---------------------------
Initial steps:
- Create a Spring Boot project. Choose: Web, JPA and H2.
- Create Alien.java under .model package
- Create home.jsp under folder main/webapp and add <form action="addAlien"> to input data
- Make a test: Right click project name > Run as > Spring Boot App
  - Browser: localhost:8080  >> "Whitelabel Error Page" : means that Spring Boot App Started but could not find the page
    Try: http://localhost:8080/home.jpa >> Again "Whitelabel Error Page" because Spring needs a controller and we have not created yet.
- Create AlienController.java under .controller package. Add @Controller and @RequestMapping annotations.
- Go to https://mvnrepository.com/  Search For: "Tomcat Jasper". Copy maven text and past in Pom.xml in the project. 
- Relaunch project. 
- Open browser > http://localhost:8080 >> You should see input form.

Connecting to H2 In memory database:
- Resources > Application.properties >> Write database related text
- Relaunch project. 
- Accessing H2 database: http://localhost:8080/h2-console
  - Check JDBC-url. Don't change username and password
  - Click "Test Connection"
  - Click on "Connect"
  - There is no table. 
  
- To create table we first need to enable JPA
    - In the Alien class, add @Entity and @Id annotations (Import javax.persistance (JPA))
    - Relaunch project
    - Refresh http://localhost:8080/h2-console >> Table automatically created by Spring Boot autoconfiguration
    - select * from alien >> Table is empty
    
- To add data to the table
    - If we insert data from H2-console data will ve lost after relaunch. To insert data after each relaunch apply the following steps.
    - Create a file called "data.sql" under resources directory
    - "data.sql" > Open with > Text editor
    - Write insert statements.
    - Relaunch and check if data exist in http://localhost:8080/h2-console
    
- To add data from the input page
    - AlienController > Add "addAlien" method. Parameter: (Alien alien) Model Object automatically assines value coming from the form  @RequestParam("/addAlien")
    - Create Interface "AlienRepo" under .dao package add extends > "CRUDRepository". Make <Alien, Integer>
    - Since the method in the CRUDReposiry are enough for this simple project we don't create a class to implement AlienRepo. 
    - Instead we directly insert dependency of this interface into the Controller class. And add repo.save(alien). Spring DataRest will automatically perform necessary operations.
    - Relaunch project. Refresh http://localhost:8080/h2-console . Check table (select * from alien). Insert new data from the input form on the page. Check table again.
    
    
Source: 

https://www.youtube.com/watch?v=YywLS8XdxLQ

https://www.youtube.com/watch?v=dVTh--j1suI
