# Lectors-Department
This application is a university system that allows students to find out information about departments and lecturers through a console interface.
## Table of contents
- [Intro](#introduction)
- [Tech stack](#technologies-used)
- [Controllers](#api-functionalities)
- [Required downloads](#a-list-of-what-needs-to-be-installed-to-run-this-application)
- [Start app](#how-to-start-this-app)
## Introduction
This application is a spring boot application designed for managing information about university departments and lectors through a console-based interface.
This project includes many different technologies for fast and reliable operation of the application.
Next, we will familiarize ourselves with each part of this application in more detail.
## Technologies used
This application includes the following list of technologies:
- Spring Data JPA: Ensuring streamlined and effective data retrieval and persistence.
- Liquibase: Employed for the management and versioning of database schemas, simplifying schema modifications and ensuring uniform data structure across diverse environments.
- Lombok: Automatically generates the necessary code to avoid writing boilerplate code.
## API Functionalities
This application contains one controller - the University controller, which is responsible for providing information about departments and lectors. More details about each of its functions can be found in the Controllers functionalities section.
## Controllers functionalities
- ### University Controller:
1) Get the head of department by department name.
   - User Input: 
   ``` 
   Who is head of department {department_name}
   ```
   - Answer: 
   ```
   Head of {department_name} department is {head_of_department_name}
   ```
   **Example** :
   - User Input: 
   ```
   Who is head of department FICT
   ```
   - Answer: 
   ```
   Head of FICT department is Ivan Petrenko
   ```
2) Get statistics by department name.

   - User Input: 
   ```
   Show {department_name} statistics
   ```
   - Answer: 
   ```
   assistants - {assistants_count}
   associate professors - {associate_professors_count}
   professors -{professors_count}
   ```
   **Example** :
   - User Input: 
   ```
   Show FICT statistics
   ```
   - Answer:
   ```
   assistants - 2
   associate professors - 4
   professors - 1 
   ```
3) Get the average salary for the department by department name
   - User Input: 
   ```
   Show the average salary for the department {department_name}
   ```
   - Answer: 
   ```
   The average salary of {department_name} is {average_salary}
   ```
   **Example** :
   - User Input:
   ```
   Show the average salary for the department FICT
   ```
   - Answer:
   ```
   The average salary of FICT is 15000
   ```
4) Get count of employee by department name
   - User Input: 
   ```
   Show count of employee for {department_name}
   ```
   - Answer:
   ```
   {employee_count}
   ```
    **Example** :
   - User Input:
   ```
   Show count of employee for FICT
   ```
   - Answer:
   ```
   7
   ```
5) Get all employees by template
   - User Input: 
   ```
   Global search by {template}.   
   ```
   - Answer:
   ```
   {a list of employees whose first or last name matches the template}
   ```
    **Example** :
   - User Input:
   ```
   Global search by van
   ```
   - Answer: 
   ```
   Ivan Petrenko, Petro Ivanov
   ```
## A list of what needs to be installed to run this application:
- Java 17 (https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- MySQL (https://dev.mysql.com/downloads/mysql/)
- Maven (https://maven.apache.org/download.cgi)
## How to start this app:
Download git repository by git command:
 ```bash
 git clone https://github.com/JeniaSan/botscrew_test.git
 ```
Build a project using **Maven**:
 ```bash
 mvn clean install
 ```
But before run, you need to configure the connection to your local database in the application properties. Run this command after that:
```bash
 mvn spring-boot:run
```

