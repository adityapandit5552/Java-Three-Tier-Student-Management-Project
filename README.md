# Java Three-Tier-Project Deployment - Student Management Application

## Project Overview

This project demonstrates the deployment of a Java-based Student Management web application using a three-tier infrastructure on AWS.

The application is deployed across separate servers so that the proxy layer, application layer, and database layer are isolated from each other.

The infrastructure consists of:

- 1 public Proxy Server
- 1 private App Server running the Java application
- 1 private Database Server
- A custom AWS VPC
- Public and private subnets
- Internet Gateway
- NAT Gateway
- Route Tables
- Security Groups
- Apache Tomcat
- MySQL

The Java application was provided as a WAR/application and deployed on the App Server. The main focus of this project is the infrastructure setup, server configuration, application deployment, and connectivity between the three tiers.

---

# AWS Three-Tier Architecture

The project uses a custom VPC named:

```text
three-tier-architecture
```

VPC CIDR:

```text
10.0.0.0/16
```

The VPC contains three subnets distributed across different Availability Zones.

```text
                         INTERNET
                             |
                             v
                    +----------------+
                    | Internet       |
                    | Gateway        |
                    | my-internet-   |
                    | gateway        |
                    +-------+--------+
                            |
                            v
                 +----------------------+
                 |   PUBLIC SUBNET      |
                 |   10.0.0.0/20        |
                 |   ap-south-1a        |
                 |                      |
                 |   Proxy Server       |
                 +----------+-----------+
                            |
                            | Application Traffic
                            v
                 +----------------------+
                 |   PRIVATE SUBNET 1   |
                 |   10.0.16.0/20       |
                 |   ap-south-1b        |
                 |                      |
                 |   App Server         |
                 |   Apache Tomcat      |
                 |   Java Application   |
                 +----------+-----------+
                            |
                            | Database Traffic
                            v
                 +----------------------+
                 |   PRIVATE SUBNET 2   |
                 |   10.0.32.0/20       |
                 |   ap-south-1c        |
                 |                      |
                 |   Database Server    |
                 |   MySQL              |
                 +----------------------+
```

---

# VPC Structure

The VPC was created with the CIDR block:

```text
10.0.0.0/16
```

The VPC contains three subnets.

| Subnet | CIDR | Availability Zone | Purpose |
|---|---|---|---|
| public-subnet | 10.0.0.0/20 | ap-south-1a | Proxy Server |
| private-subnet-1 | 10.0.16.0/20 | ap-south-1b | App Server |
| private-subnet-2 | 10.0.32.0/20 | ap-south-1c | Database Server |

---

# Three EC2 Instances

Three EC2 instances were created for the three-tier architecture.

## 1. Proxy Server

The Proxy Server is deployed in the public subnet.

```text
Instance Name: Proxy-Server
Instance Type: t3.micro
Subnet: public-subnet
Availability Zone: ap-south-1a
```

The Proxy Server is the public-facing tier.

Its purpose is to receive traffic from the internet and forward application traffic toward the App Server.

---

## 2. App Server

The App Server is deployed inside a private subnet.

```text
Instance Name: App-Server
Instance Type: t3.micro
Subnet: private-subnet-1
Availability Zone: ap-south-1b
```

This server contains the actual Java application.

The application is hosted using Apache Tomcat.

The deployment structure includes:

```text
/opt/tomcat/
```

and the application is deployed under:

```text
/opt/tomcat/webapps/students/
```

The App Server is not directly exposed as the public application tier.

---

## 3. Database Server

The Database Server is deployed inside a separate private subnet.

```text
Instance Name: DB-Server
Instance Type: t3.micro
Subnet: private-subnet-2
Availability Zone: ap-south-1c
```

The Database Server is responsible for storing the application's MySQL database.

The database tier is isolated from direct internet access.

---

# Network Structure

The VPC contains:

```text
VPC
│
├── Public Subnet
│   └── Proxy Server
│
├── Private Subnet 1
│   └── App Server
│
└── Private Subnet 2
    └── Database Server
```

The routing structure is:

```text
                    Internet
                       |
                       v
              Internet Gateway
                       |
                       v
                Public Route Table
                       |
                       v
                Public Subnet
                       |
                       v
                 Proxy Server
                       |
                       v
                Private Subnet 1
                       |
                       v
                  App Server
                       |
                       v
                Private Subnet 2
                       |
                       v
                Database Server
```

---

# Internet Gateway

An Internet Gateway named:

```text
my-internet-gateway
```

was attached to the VPC.

It provides internet connectivity for the public subnet.

The public route table uses the Internet Gateway for internet-bound traffic.

```text
Public Subnet
      |
      v
Public Route Table
      |
      v
Internet Gateway
      |
      v
Internet
```

---

# NAT Gateway

A public NAT Gateway named:

```text
my-NAT-GW
```

was configured for the private subnets.

The NAT Gateway allows resources in private subnets to initiate outbound internet connections without becoming directly reachable from the internet.

```text
Private Subnet
      |
      v
Private Route Table
      |
      v
NAT Gateway
      |
      v
Internet Gateway
      |
      v
Internet
```

This is useful for private servers that need outbound access for updates, package installation, or other required connections.

---

# Route Tables

Two route tables were created.

## Public Route Table

```text
public
```

The public route table is associated with the public subnet.

It provides a route toward the Internet Gateway.

```text
public-subnet
      |
      v
public route table
      |
      v
Internet Gateway
```

---

## Private Route Table

```text
private
```

The private route table is associated with the two private subnets.

```text
private-subnet-1
        |
        +------> private route table
        |
        v
      App Server


private-subnet-2
        |
        +------> private route table
        |
        v
   Database Server
```

Private subnet outbound traffic can use the NAT Gateway.

---

# Security Model

The three-tier design separates the network access between tiers.

```text
Internet
   |
   v
Proxy Server
   |
   v
App Server
   |
   v
Database Server
```

The intended traffic flow is:

- Internet traffic reaches the public Proxy Server.
- Proxy Server communicates with the private App Server.
- App Server communicates with the private Database Server.
- Database Server is not directly exposed to the internet.

Security Groups are used to control the allowed traffic between these components.

---

# Application Deployment

The Java Student Management application was deployed on the App Server.

The deployment process was:

```text
Java Application / WAR
          |
          v
      App Server
          |
          v
     Apache Tomcat
          |
          v
     students.war
          |
          v
Java Web Application
          |
          v
   Database Server
          |
          v
        MySQL
```

The application was deployed under:

```text
/opt/tomcat/webapps/students/
```

Tomcat extracts the WAR file into the application directory and serves the web application.

---

# Java and Apache Tomcat

Java was installed on the App Server.

Java was verified using:

```bash
java -version
```

The Java compiler was verified using:

```bash
javac -version
```

Apache Tomcat was installed under:

```text
/opt/tomcat/
```

The application was deployed into:

```text
/opt/tomcat/webapps/
```

---

# Application

The deployed application is a Student Management System.

It provides functionality such as:

- Student registration
- View student records
- Edit student records
- Delete student records

The application uses Java, JSP, Servlets, JDBC, and MySQL.

The Java application itself was provided as an existing application. This project focuses on deploying and running it within the three-tier AWS infrastructure.

---

# Database

The database tier runs MySQL on the private Database Server.

The application communicates with the database through the App Server.

```text
Browser
   |
   v
Proxy Server
   |
   v
App Server
   |
   | JDBC / MySQL
   v
Database Server
   |
   v
MySQL
```

The database contains the student records required by the application.

---

# Application Directory

The deployed application is located at:

```text
/opt/tomcat/webapps/students/
```

The structure includes:

```text
students/
├── META-INF/
├── WEB-INF/
├── index.jsp
├── home.jsp
└── ...
```

Compiled Java classes are located under:

```text
WEB-INF/classes/
```

Required libraries are located under:

```text
WEB-INF/lib/
```

---

# Git and GitHub

The project source and deployment-related project files were organized using Git.

The repository is hosted on GitHub.

Repository:

```text
https://github.com/adityapandit5552/Java-Three-Tier-Student-Management-Project
```

Git was used for:

- Repository initialization
- Source code management
- Commits
- Branch management
- Remote repository configuration
- GitHub push

SSH authentication was configured for GitHub.

---

# Maven

The project was also organized as a Maven project.

The project contains:

```text
pom.xml
```

The application can be packaged using:

```bash
mvn clean package
```

The generated WAR file can then be deployed to Apache Tomcat.

---

# Project Structure

```text
Java-Three-Tier-Student-Management-Project/
│
├── src/
│   ├── com/
│   │   └── srk/
│   │       ├── dao/
│   │       │   └── StudentDAO.java
│   │       │
│   │       └── servlet/
│   │           ├── RegistrationController.java
│   │           ├── ViewStudents.java
│   │           ├── EditStudent.java
│   │           ├── SaveEditedStudent.java
│   │           └── DeleteStudent.java
│   │
│   └── vo/
│       └── Student.java
│
├── WebContent/
│   ├── index.jsp
│   ├── home.jsp
│   └── WEB-INF/
│       └── web.xml
│
├── screenshots/
│
├── pom.xml
├── .gitignore
└── README.md
```

---

## EC2 Instances

The infrastructure contains three EC2 instances:

```text
Proxy-Server
App-Server
DB-Server
```

## VPC Resource Map

The VPC contains:

```text
three-tier-architecture
        |
        +-- public-subnet
        |
        +-- private-subnet-1
        |
        +-- private-subnet-2
        |
        +-- public route table
        |
        +-- private route table
        |
        +-- Internet Gateway
        |
        +-- NAT Gateway
```

---

# Deployment Result

The final infrastructure consists of three separate EC2 instances within a custom VPC.

```text
                         INTERNET
                            |
                            v
                    +---------------+
                    | Proxy Server  |
                    | Public Subnet |
                    +-------+-------+
                            |
                            v
                    +---------------+
                    |   App Server  |
                    | Private Subnet|
                    |               |
                    | Apache Tomcat |
                    | Java App      |
                    +-------+-------+
                            |
                            v
                    +---------------+
                    | Database      |
                    | Server        |
                    | Private Subnet|
                    |               |
                    | MySQL         |
                    +---------------+
```

The application is deployed on the App Server, while the Database Server is isolated in a separate private subnet.

The Proxy Server acts as the public-facing entry point for the application.

---

# Skills Demonstrated

This project provided practical experience with:

- AWS VPC
- Subnet design
- Public and private subnets
- Availability Zones
- Route Tables
- Internet Gateway
- NAT Gateway
- EC2
- Linux server administration
- SSH
- Security Groups
- Apache Tomcat
- Java deployment
- WAR deployment
- MySQL
- JDBC connectivity
- Three-tier application architecture
- Git
- GitHub
- Maven
- Application troubleshooting

---

# Author

## Aditya Pandit

# Screenshots

Screenshots of the AWS infrastructure and deployed application can be added to the `screenshots` directory.


GitHub:

```text
https://github.com/adityapandit5552
```
