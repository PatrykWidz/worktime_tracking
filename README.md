# Worktime tracking
This project is a maven based web app I have started developing as my final project for Coders Lab's course for java web developers.
The main puprose of this app is to keep record of worktime spent on particular projects by particular workers in a company

A user selects a project and inputs the time range (in hh:mm format) that they spent working on a given project.
All data is stored in a MySQL database and later can be used to develop worktime reports that can be useful to asses profitability of a project.

Each partial report registered by a user is contained in a user's daily report and then there are weekly reports that contain daily reports. The entities has been prepared this way to enable reporting flexibility - all data can be easily accesed and future custom reports will be easy to develop having relational database system.

So far I have managed to create crucial entities with views to register partial daily reports which are calculated into man-hours spent on a given project. Working with Java's 8 LocalDate and LocalTime was a big challange for me and I have learned a lot about time based Java classes.

Tools, languages and technology I have used so far in the project:
- Maven
- Eclipse IDE with Spring Tool Suite
- Java
- JavaScript
- HTML, CSS
- Spring and Hibernate frameworks
- MySQL database

My goal is to constantly develop this app, make it business friendly and develop new features.
Here is a list of features I'm planning to add:

- full Spring validation
- login system using Spring Security
- different kind of users with different access permissions
- automated weekly, monthy, yearly reports (of a project, worker etc.)
- a comprehensive profitablity report after project's closure
