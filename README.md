# ModelSA

Welcome to Model-SA.   

This project is a simple solution for the **K-Modem Illumination Problem**.<br>
We used the Monte Carlo technique alongside with Genetics Algorithm for solving the problem.<br>  
The code itself is written in __Java__ (Requirements are listed below) and it is heavily dependent on the JTS geometry library.   

This repository contains   
- The Projects Source   
- Documentation and Screenshots   
- Test Cases   
- A Randomly generated dataset of simple geometries   

**Warning!**<br>
The following readme file **Dose Not** contains detailed information about the problem.<br>
For further information on technical details of the problem, experiments, and their results, check out [Technical Details](TechincalDetails.md).

## Table of Contents
* [Problem Description](#problem-description)
* [Requirements](#requirements)
* [Installation and Setup](#installation_and_setup) 
* [A Tour of the Code](#a_tour_of_the_code) 
* [How to use?](#how_to_use?)
* [Credits](#credits)  

## Problem Description
### Original K-Modem Description
For the original description of the K-Modem problem, check out the [Technical Details](TechincalDetails.md#problem_description).

### This Variation of K-Modem Problem
_**Note**: This is a subset of the original K-Modem illumination problem and it is the actual problem that the code is written for. With little adjustments (check [Technical Details](TechincalDetails.md#problem_description)) the code can solve the original problem as well. The solution code for the original K-Modem Illumination problem will be included in future updates._  
  

Let **_P_** be a simple polygon consist of an outer shell (the outer walls) and zero or more holes (check the screenshot below). Given the number of k-modems available **_q_**, and the penetration rate **_k_**, what are the best coordinates to put the k-modems on, such that the maximum area of the given polygon is covered<br>
Another custom variation of the problem comes from the assumption that the k-modems can have signal confliction. If any point is covered by more than one k-modem, signal confliction happens and the point is not covered anymore.   
![sc1](/docs/screenshots/sc1.jpg)

### Practical Usage
The main practical usage of the problem comes from finding the optimal positions of a set of wireless modems with given signal strength in a given map for the maximum coverage of the signal (eg. Maximum WiFi coverage inside a given building).
Using the available code alongside JTS Testbuilder, you can create your own maps and find the optimal position for your modems inside the map (check out [How to Use?](#how_to_use?)).


## Requirements
_Having knowledge of Java for running and simple use of the code is not essential though recomended_  

1. **JDK 8 (Or Higher)**<br>
*Warning!* You need **JDK (Java Development Kit)** for building and running the project.<br>DO NOT INSTALL JRE (Java Runtime Environment).  
2. **Maven 3.6 (Or Higher)**  

3. **Git and Git Bash**  

4. **NetBeans 8 (Or Higher)** _Recomended_   

5. **Clone JTS Repository** _Recomended_  

## Installation and Setup
_**Note:** This installation and setup guide is for Windows operating system. Future updates may include support for Linux._<br><br>
If you are new to writing and building programs, make sure to follow every step of the installation and setup. It will cover **ALL** the things you need to do to run the code.<br>
**Setup the Project Section 4** is about building JTS and using its TestBuilder tool for creating your own test cases. You can skip it if you are not interested in that. 
### Installation Guide<br>  

1. **Installing Git**  
    Simply download and install Git from [here](https://git-scm.com/downloads). When you are installing git, in the *Select Component* window, make sure to check `Git Bash Here` under the *Windows Explorer integration* tab. Other than that, use the installation's recommended settings and you're good to go.<br><br>


2. **Installing Maven**  
    - Download Maven's **Binary zip archive** from [here](https://maven.apache.org/download.cgi). Extract the zip file in a secure location (for example your Program Files folder in Windows partition).
    
    - Now you need to add the Maven's bin folder to your windows path environment variables.
        * In the extracted Maven directory, copy the bin folder's path (ie. `C:\Program Files\apache-maven-3.8.1\bin`).
        * Press `WIN + R` to open up *Run* (`WIN` is the windows key on the keyboard) and type in `SystemPropertiesAdvanced`.
        * In *System Properties* window, click on *Environment Variable*.
        * From the _System Variable_ section, click on _Path_ and then click on _Edit_.
        * In the pop-up window, click on _New_ and paste the path that you just copied and click _OK_ to make the changes. 

    - Open up a command prompt and use `mvn --version`.
It must show something like this:<pre>
<code>Apache Maven 3.6.3 (--------------some code--------------)
Maven home: C:\Program Files (x86)\apache-maven-3.6.3\bin\..
Java version: 15.0.1, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-15.0.1
Default locale: en_US, platform encoding: ---- some code ----
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
</code></pre>Congratulations, you just installed Maven.<br><br> 


3. **Installing JDK**  

    - Head to [Oracles Website](https://www.oracle.com/java/technologies/javase-downloads.html) and download JDK.
    
    - Run the installation. Use the recommended settings for installation. Just remember the directory that you are installing JDK in.
    - When the installation is over, follow [these](https://javatutorial.net/set-java-home-windows-10) instructions to add **JAVA_HOME** to your environment variables.
    - Open a command-line prompt and type in `java -version`. It must show something like this:<pre>
<code>java version "1.8.0_261"
Java(TM) SE Runtime Environment (build 1.8.0_261-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.261-b12, mixed mode)
</code></pre>
    - If you encounter any errors, follow [these](https://www.javatpoint.com/how-to-set-path-in-java) instructions.<br><br>
    
    
4. **Installing NetBeans** _optional_  
Installing the NetBeans is optional but recommended. Download and install NetBeans using [this link](https://netbeans.apache.org/download/index.html).<br>

    **_Note:_** While installing the NetBeans, you will encounter a field in which you need to pass in the directory you installed JDK in. If you installed JDK correctly, this field should be filled automatically. If not, close the setup, follow the instructions provided in the last paragraph of _Installing JDK_ and run the setup again.
    <br><br>

### Setup the Project<br>  
Now that we installed all the requirements of the project, it's time to set them up.<br>
1. **Clone the Repository**  

    - Create an empty folder anywhere on your computer and navigate inside it.
    - Right Click and chose __Git Bash Here__.
    - In the opened-up Bash Prompt, type in `git clone https://github.com/ark1375/model_SA.git` and hit enter.<br>
    Git will clone the repository from the GitHub server to your local machine.<br>

2. **Using Maven to Install Dependencies**  _Skip this part if you are using NetBeans_    

    - Inside the cloned repository, you can find a **pom.xml** file. This is the Mavens pom file that specifies the details of the project including build options and most importantly, dependencies.
    - Open a command prompt (cmd) and navigate inside the cloned repository. 
    - Type in `mvn clean install`. Using this command, Maven will install all the dependencies you need to run the project.
    
3. **Configuring NetBeans**  _Skip this part if you are using Maven_ <br>
NetBeans should automatically recognize the repository as a _Project Direcotry_. Using __Open Project...__ from the file menu, open the project inside NetBeans.<br>
If you are using NetBeans 11 or higher, you simply can Build and Run the project. NetBeans uses Maven directly to install dependencies. __However__ it is recomended to update NetBeans Maven especially if you are using an older version of NetBeans.<br><br>
For updating NetBeans Maven:
    - Download the Maven's Bin files as explained in **Installing Maven** section one. 
    - Extract it and copy all the files inside the `apache-maven-version` folder.
    - Navigate inside NetBeans installation directory and open the `Java` folder.
    - Inside the `maven` folder, paste and replace everything that you copied.
    
4. **Clone and Build JTS** _optional_<br>
In order to use JTS TestBuilder to create your own polygons and geometries, you need to clone and build JTS libreary.<br>
    - Create another empty folder and open GitBash prompt as explained previously.
    - Type in `git clone https://github.com/locationtech/jts.git` and hit enter.
    - Navigate inside the cloned repository using `cd` command (`cd jts`).
    - Type `mvn clean install` to install dependencies and build JTS.
    - Use `java -jar modules/app/target/JTSTestBuilder.jar` to run JTS TestBuilder.<br><br>
    Head to [JTS Repository](https://github.com/locationtech/jts) for more information about JTS geometry library.<br>

## How to Use?<br>
Now that you setedup everything you need, it's time to learn how to run and how to properly use the code. A little tour of the code will be a great place to start.
### A Tour of the Code<br>
_**Note**: Reading this section is optional, skip to **How To Use** if not interestead._<br>
I won't go deep into details of the code (for that, refer to [Technical Details](TechincalDetails.md#problem_description)) but I will give you enough information to be able to understand the basic idea of it.<br>
I will begin with explaining the classes.<br>
* The Polygon Class  
    As the name implies, Using this class you can import your polygons into the program. Note that the programs design is based  on **Importing the Polygons** and not to create them on sight using code or GUI.<br><br>
You can create polygons in two ways.  
    - Using empty constructor to build an object and reading the poygon later.<pre>
<code class = "language-java">Polygon pl = new Polygon();
pl.readPolygonXML(path);
</code></pre>
<br>
    - Passing path directly to the constructor.<pre>
    <code class = "language-java">Polygon pl = new Polygon(path)</code><br>

 Polygon class can read XML files created by JTS TestBuilder. It is also compatible with WKT files. But in order to take advantage of WKT you need to create an empty object and use `readPolygonWKT` method to read WKT directly (check out the box bellow).
```java
Polygon pl = new Polygon();
pl.readPolygonWKT(path);
```


Future updates may include support for common CAD file formats like .DXF or .DWG.
## Credits

## Sources