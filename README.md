# ModelSA

Welcome to Model-SA.   

This project is a simple solution for the **K-Modem Illumination Problem**.<br>
It is using [Monte Carlo method](https://en.wikipedia.org/wiki/Monte_Carlo_method) alongside with [Genetics Algorithm](https://en.wikipedia.org/wiki/Genetic_algorithm) for solving the problem.<br>
The code itself is written in __Java__ (Requirements are listed below) and it is heavily dependent on the JTS geometry library.   

This repository contains   
- The Projects Source   
- Documentations and Screenshots   
- Test Cases   
- A Randomly generated dataset of simple geometries  (_will be included in future updates_)<br>

:loudspeaker:  __Note that this project is still in development.__ Stay tuned for further updates.<br>

__Under Development:__
- Technical Detaild
- ~~Solve for the original K-Modem Problem~~
- ~~Changing signal confliction to a removable option~~

[Code Documentation](/docs/code_documentation.md)
  
  
**Warning!**  _The following readme file **Dose Not** contains detailed information about the problem.<br>
For further information on technical details of the problem, experiments, and their results, check out [Technical Details](TechincalDetails.md)_.

## Table of Contents   

* [Problem Description](#problem-description)
* [Requirements](#requirements)
* [Installation and Setup](#installation-and-setup)
* [How to use?](#how-to-use)
* [Credits](#credits)  

## Problem Description
### Original K-Modem Description
The K-Modem problem is actually not a stand-alone problem itself. It is a variation of an old, computational geometry problem called **Art Gallery Illumination Probelm** that consists of _finding the minimum number of light sources needed to illuminate a simple polygon (eg. map of a gallery)_<sup>[1](#credits)</sup>.    
One of the famous variations of the problem is **K-Modem Illumination Problem**.<br>  
  
**Techinical Description:** For a non-negative number _k_, a _k-modem_ is a wireless device that can penetrate _k_ **walls**.<br>Let _L_ be a set of _n_ line segments (or lines) in the plane. A k-modem __illuminates all__ points _p_ of the plane such that the interior of the line segment joining _p_ and the k-modem intersects at most _k_ elements of _L_. In general, k-modem illumination problems consist on finding the minimum number of k-modems necessary to illuminate a certain subset of the plane, for a given L.  

### This Variation of K-Modem Problem
_**Note**: This problem is a subset of the original K-Modem illumination problem and the current code is the solution to this problem. With some little alteration of the code (check [Technical Details](TechincalDetails.md#problem_description)) it can solve the original problem as well. The solution code for the original K-Modem Illumination problem will be included in future updates._  
  

Let **_P_** be a simple polygon consist of an outer shell (the outer walls) and zero or more holes (check the screenshot below). Given the number of k-modems available **_q_**, and the penetration rate **_k_**, what are the best coordinates to put the k-modems on, such that the maximum area of the given polygon is covered.<br>
Another custom variation of the problem comes from the assumption that the k-modems can have signal confliction. If any point is covered by more than one k-modem, signal confliction happens and the point is not covered anymore.<br>
>:warning: &nbsp; _The current code takes __Signal Confliction__ into consideration. Future updates will make this an optional choice._

![sc1](/docs/screenshots/sc1.jpg)

### Practical Usage
The main practical usage of the problem comes from finding the optimal positions of a set of wireless modems with given signal strength in a given map for the maximum coverage of the signal (eg. Maximum WiFi coverage inside a given building).
Using the available code alongside JTS Testbuilder, you can create your own maps and find the optimal position of your modems inside the map (check out [How to Use?](#how_to_use)).  

## Requirements
_Having knowledge of Java for running and simple use of the code is not essential though recomended_  

1. **JDK 8 (Or Higher)**<br>
  
2. **Maven 3.6 (Or Higher)**  

3. **Git and Git Bash**  

4. **NetBeans 8 (Or Higher)** _Recomended_   

5. **Clone JTS Repository** _Recomended_  

>:warning: &nbsp; _Do not Install JRE (Java Runtime Environment) instead of JDK._  

## Installation and Setup
_**Note:** This guide is for Windows operating system. Future updates may include support for Linux._<br><br>
If you are new to writing and building programs, make sure to follow every step of the installation and setup. It will cover all the things you need to do to run the code.<br>
**Setup the Project, Section 4** is about building JTS and using its TestBuilder tool for creating your own test cases. You can skip it if you are not interested. 
### Installation Guide<br>  

1. **Installing Git**  
    Download and install Git from [here](https://git-scm.com/downloads). When in installation, from *Select Component* window, make sure to check `Git Bash Here` under the *Windows Explorer integration* tab. Other than that, use the installation's recommended settings.<br>


2. **Installing Maven**  
    - Download Maven's **Binary zip archive** from [here](https://maven.apache.org/download.cgi). Extract the zip file in an arbiturary directory (for example your Program Files folder in Windows partition).
    
    - Now you need to add the Maven's bin folder to your windows path environment variables.
        * From the extracted Maven directory, copy the bin folder's path (ie. `C:\Program Files\apache-maven-3.8.1\bin`).
        * Press `WIN + R` to open Run, type in `powershell` and press `Ctrl + Shift + Enter`. This will open Powershell as administrator.
        * Type `[Environment]::SetEnvironmentVariable("Path", $env:Path + ";--path--", "User")`, replace `--path--` with the location that you just copied and execute.  


    - Executer `mvn --version` command in Powershell.
Something like this should be displayed:<pre>
<code>Apache Maven 3.6.3 (--------------some code--------------)
Maven home: C:\Program Files (x86)\apache-maven-3.6.3\bin\..
Java version: 15.0.1, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-15.0.1
Default locale: en_US, platform encoding: ---- some code ----
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
</code></pre><br> 


3. **Installing JDK**  

    - Download JDK installation from [Oracles Website](https://www.oracle.com/java/technologies/javase-downloads.html).
    
    - Start the installation and use the recommended settings to do so. Just remember the directory that you are installing JDK in.
    - When the installation is over, follow [these](https://javatutorial.net/set-java-home-windows-10) instructions to add **JAVA_HOME** to your environment variables.
    - Open a command-line prompt and type in `java -version`. Something like this should be displayed:<pre>
<code>java version "1.8.0_261"
Java(TM) SE Runtime Environment (build 1.8.0_261-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.261-b12, mixed mode)
</code></pre>
    - If you encounter any errors, follow [these](https://www.javatpoint.com/how-to-set-path-in-java) instructions.<br><br>
    
    
4. **Installing NetBeans** _optional_  
Installing Apache NetBeans is optional but recommended. Download and install NetBeans using [this link](https://netbeans.apache.org/download/index.html).<br>

    **_Note:_** While installing NetBeans, you will encounter a field in which you need to pass in the directory you installed JDK in. If you installed JDK correctly, this field should be filled automatically. If not, cancel the installation, follow the instructions provided in the last paragraph of _Installing JDK_ and run the installation again.
    <br><br>

### Setup the Project<br>  
After installing all the requirements, you can begin setting up the project.<br>
1. **Clone the Repository**  

    - Create an empty folder on your computer and open it.
    - Right Click and chose __Git Bash Here__.
    - Execute `git clone https://github.com/ark1375/model_SA.git` in the Bash Prompt.<br>
    Git will create a clone of the repository in your machine.<br>

2. **Using Maven to Install Dependencies**  _Skip this part if you are using NetBeans_    

    - Inside the local repository, you can find a **pom.xml** file. This is the Maven's pom file which specifies details of the project including build options and most importantly, dependencies.
    - Open a command prompt (cmd) and change directory to the local repository. 
    - Type in `mvn clean install`. Using this command, Maven handels all the dependencies you need to run the project.
    
3. **Configuring NetBeans**  _Skip this part if you are using Maven_ <br>
NetBeans should automatically recognize the repository as a _Project Directory_. Using `Ctrl + Shift + O` you can open the repository directly inside NetBeans.
    > :warning: &nbsp; _If you are using an older version of NetBeans (version 9 or bellow) you need to update NetBeans Maven._  

    For updating NetBeans Maven:  
    - Download the Maven's Bin files as explained in **Installing Maven**, section one. 
    - Extract it and copy all the files inside the `apache-maven-version` folder.
    - Navigate inside NetBeans installation directory and open the `Java` folder.
    - Open the `maven` folder, paste and replace everything that you copied inside it.
<br><br>
4. **Clone and Build JTS** _optional_<br>
In order to use JTS TestBuilder to create your own polygons and geometries, you need to clone and build the JTS library.<br>
    - Create another empty folder and open Git Prompt as explained previously.
    - Execute `git clone https://github.com/locationtech/jts.git` command.
    - Navigate inside the cloned repository using `cd` command (`cd jts`).
    - Type `mvn clean install` to install dependencies and build JTS.
    - Use `java -jar modules/app/target/JTSTestBuilder.jar` to run JTS TestBuilder.<br>
    
    You can find  more information on JTS geometry library in [JTS Repository](https://github.com/locationtech/jts).<br>

## How to Use?<br>
Now that you are finished setting up the project, it's time to learn how to run and properly use the code. Let's begin with a little tour of the code.
### A Tour of the Code<br>
> _**Note:** Reading this section is optional, skip to [How to use](#how-to-use-1) if not interestead._<br>

Getting into the detail of the code is beyond the scope of this text (for that, refer to [Technical Details](TechincalDetails.md#problem_description)). However, some basic explanation about the available classes and their important methods seems necessary.<br>
* __The Polygon Class__  
    As the name implies, this class represents the main geometry structure that the program handles. Using this class you can import your polygons inside the program. Note that the design pattern of this code is based on **_Importing the Polygons_**, not creating them inside the program using code or GUI.<br>
You can import the polygons in two ways.  

    - Using the empty constructor to build an object and importing the poygon using `obj.readPolygonXML(path)` or `obj.readPolygonWKT(path)` methods.<br>
    
        Using XML file:
        ```java
        Polygon pl = new Polygon();
        pl.readPolygonXML(path);
        ```
        Using WKT file:
        ```java
        Polygon pl = new Polygon();
        pl.readPolygonWKT(path);
        ```
    - Passing the polygon's XML file path directly to the constructor.
        ```java
        Polygon pl = new Polygon(path);
        ```
        > :warning:  This method only works for XML files created by JTS TestBuilder. The program won't accept a WKT file path in the constructor.
         
    Future updates may include support for common CAD file formats like .DXF or .DWG.

    Because this class uses JTS Polygon structure to handle the geometry, you can retrive a JTS Polygon directly from the class using `obj.getPoly();` method.<br> In addition, if you are not satesifed with the provided methods of importing the polygons, you can use `obj.setPoly(poly);` method for directly setting the polygon. You need to pass a JTS Polygon object as the parameter. 
    
    > _**Note:** The XML files that are mentioned in this text is the geometry file format created by JTS TestBuilder._  
    
    <br>
* **The Moedem Class**  
This is the K-Modem class. Every modem will have a Peneteration Rate _k_ and a 2D cordinate _x_ and _y_. Because the `obj.toString();` method of this class is over writen, you can directly print the objects. The `toString()` method only prints the cordinate of the modem and the peneteration rate k, is left out. For the most part, you will not use this class directly.  
<br>  

* **VPCalculator Class**  
This static class contains algorithms for calculating the visiblity areas of modems (aka Visiblity Polygon, aka Signal coverage).<br>
Three important public methods of this class includes, `monteCarloVP()` , `monteCarloVP_SavePoints()` and `monteCarloVP_MT()`.
    - **monteCarloVP**<br>
    This method is for calculating the Signal coverage.<br> The method takes in three parameters. First, a number of iterations, second the polygon, and third an array of modems.<br>After calculation, it'll return a double that indicates the ratio of **coverage area** to **total area**. This value will always be in the range of 0 to 1.<br>
    Higher numbers of iterations in the algorithm will lead to more accurate results. However, this accuracy comes at the price of time.<br>
    
    - **monteCarloVP_SavePoints**<br>
    This method works exactly like `monteCarloVP()` with two additional functionality. Saving all the calculated points in a WKT file and showing how long it took the algorithm to finish. You need to pass in two more variables to this function. A string that is the path for saving the WKT file, and a boolean that if true, prints out the spent time.
    
    - **monteCarloVP_MT**<br>
    Basicaly, this method is `monteCarloVP()` that uses Multi Threading for faster calculations. 
        > :warning: Because in the current updates this method is unstable, it is not recomend to use it.
    
<br>  

* **GeneticsAlgorithm Class**  
This is the heart of the project. GeneticAlgorithm is the class that handles everything about optimization.<br>
You can use this class and pass in your desiered parameters to find the optimal solution. It will do so by creating a population of arbitary size and run **Genetics Algorithm** on them.<br>
The parameters that you'll need to pass to the constructor in order to create an object are listed in order bellow:
    - The Polygon
    
    - Number of Modems
    
    - Default K Value<br>   An integer with the minimum value of 0 that represents the Penetration Rate of the Signals (_how many walls signals can pass thorugh_).
    
    - Monte Carlo Itterations<br>   Because the program is using a method called Monte Carlo Method to estimate the signal coverage of the modems, you need to determain a number of itterations for it. Obviously, higher number of itterations will lead to higher precisions but at the cost of your system's resources.<br> **Set this number somewhere between 1000 and 10000 based on your CPU power.**
    
    - Size of Population<br>
    This is the population that you'll be running genetics algorithm on. Higher values will lead to faster convergance and higher precissions. But proceed with caution. Setting this number too high will consume an enormous amount of your system's resources.<br> **Set this number somewhere between 100 and 1000 based on your CPU power.**
    
    - Mutation Rate<br>
    This value will determain how many indiviuals in the population will Mutate in every generation. You have to pass in a double Ranging from 0 to 1.
    For example if you pass a mutation rate of 0.1, in every generation, 10% of the population will be mutated randomly.
    
    - Generations<br>
    This parameter will detrmin the number of itterations for genetics algorihthim. Obviously, higher number of itterations will lead to more acurate results but at the cost of time.<br> **Set this number between 25 and 100 based on your system power and your own patiance.**<br>  
    
        _**Note**:  An automatic method of detecing convergence will be included in the future updates._<br>  
    <br>  
    
    Now that you are familiar with the constructor's parameters, you can create objects like this:
    ```java
    GeneticsAlgorithm gna;
    gna = new GeneticsAlgorithm( poly, numOfModems, k , MCItter, popSize, mutRate, numOfGens );
    ```
    After creating your object, use `runGenetics` method to run the algorithim.
    ```java
    GeneticsAlgorithm gna;
    gna = new GeneticsAlgorithm( poly, numOfModems, k , MCItter, popSize, mutRate, numOfGens );
    gna.runGenetics();
    ```
    There are several `get` methods provided for getting the output of the algorithm.<br>
    First is `gna.getPopulation()` which returns an ArrayList of the population. Each element of the ArrayList is a *Chromosome* which itself, contains an array of K-Modems (can be accessed using `chromosome.modmList`).<br>
    The second option is `gna.getBestGene()`. It returns the best gene availabe as an array of K-Modems.<br>
    And the last option is `gna.getTopTenResults()` which returns an ArrayList of 10 best K-Modem Arrays.<br><br>
    
### How to Use<br>

There are two main ways you can use the code.<br> First, you can run the code with given test cases and some arbitary parameters for confirming the concluded results; Two, you can create your own test case using **JTS TestBuilder**, passing it to the program with your parameters of choice for finding the optimal positions of the modems. Either way, the process of minipulating and running the code shoud be simple and straight forward.  
<br>  

#### How to Build and Run Using Maven
Open cmd or powershell and change directory (using `cd`) to the local repository. Use `mvn package` command to build the project. After building it, a folder with the name __target__ should appear in the local repository folder.<br> Use `java -cp ./target/Model-SA-1.0-SNAPSHOT.jar ku.cs.model.sa.Main` to run the program.  
<br>  

#### Create and Import a Polygon  
From `src/main/java/ku/cs/model/sa/` open the _**Main.java**_ file with a text editor. This is the main class of the program. Some pre written code is already avilable inside it. Reading it should give you a basic idea of how to use the code.<br> For now, lets start with something simple. Creating a polygon from one of the files availabe in the *test_cases* folder (like _obiouscase.xml_).<br>
Begin with creating a **Polygon** object and determining the path of the local repository.
```java
String repositoryPath = ".\\"; 
Polygon pl = new Polygon();
```
Now, you may import the polygon inside the program. Simply use `readPolygonXML(path)` method to do so.
```java
String repositoryPath = ".\\"; 
Polygon pl = new Polygon();
pl.readPolygonXML(repoPath + "test_cases\\obviouscase.xml");
```
>_Note:_ You can use `plotPolygon()` method to plot the Polygon and get an idea of what you'r working on.  
<br>  

#### Run the Optimization
After Importing the polygon, you may use **GeneticsAlgorithm** class to start the optimization process. Begin with creating an instence of __GeneticsAlgorithm__ and pass some arbitary parameters to the constructor (for detail information about parameters, check out [here](#a-tour-of-the-code)).<br>Let's asume you have __3 k-modems__ with __0 penetration rate__ and you want to use __1000 Monte Carlo itterations__ with __200 initial population__ and __25% mutation rate__. Last, let's run the algorithm for **20 generations** and see the results.<br>  
```java
String repositoryPath = ".\\"; 
Polygon pl = new Polygon();
pl.readPolygonXML(repoPath + "test_cases\\obviouscase.xml");

GeneticsAlgorithm gna = new GeneticsAlgorithm(pl, 3, 0, 1000, 200, 0.25, 20);
gna.runGenetics();
```
The program will begin running the optimization.<br>
For each itteration of the optimization, you will have something printed out in your console.
```
Itteration: 1
Crossover Started
Crossover Done 
Mutation Started
Mutation Done 
Selection Started
Selection Done 
BCF: 0.996000
```
BCF stands for Best Chromosome Fitness which is the score of the best indiviual of the population in the current run. The score is between 0 and 1 and shows the percentage of signal coverage inside the polygon.<br> For example, in the previous print box, BCF is 0.996. That means the best indivual of the population (which is just a set of cordinates for the modems) has 99.6% signal coverage. In another words, if you put your modems acording to the best indivual, you will have 99.6% coverage.<br><br>  

#### Retrive the Results  
After the optimization is over, there are several _get_ methods included in the GeneticsAlgorithm class that you can use to retrive the result.<br>
One such example is the `getPopulation()` method which returns the population as an ArrayList of the chromosoms. This ArrayList will always be in order of best to worst, meaning the 0 index is the best chromosome of all.<br>
```java
String repositoryPath = ".\\"; 
Polygon pl = new Polygon();
pl.readPolygonXML(repoPath + "test_cases\\obviouscase.xml");

GeneticsAlgorithm gna = new GeneticsAlgorithm(pl, 3, 0, 1000, 200, 0.25, 20);
gna.runGenetics();
System.out.println(gna.getPopulation().get(0));
```
<br>  

Because Monte Carlo is a hurestic method and thus the results are in a margin of error, it is a better practice to retrive more than one result from the algorithm.<br> For that you may use `getTopTenResults();` method which retrives the Top Ten results. This method returns a size 10 ArrayList of Arrays of Modems. (`ArrayList<Modem[]>`)<br>  

It was stated that running the Monte Carlo with higher values of itterations will result in more acurate results.<br>
If you use too many Monte Carlo itterations for running the optimization, the algorithim will take a long time to finish. But now that the optimization is over, it might be a good idea to see what happens if you use more itterations on Monte Carlo.<br>  
You can call the Monte Carlo method directly from VPCalculator class using `VPCalculator.monteCarloVP(itter , poly , modems);`.<br>The method takes in three values. First, the number of itterations, second, the polygon and third, an **Array of Modems**.<br>It will return a double with values ranging from 0 to 1. This value indicates the percentag of signal coverage inside the polygon.<br>  

You can use `getTopTenResults();` to run MonteCarlo manulay with as much itterations as you want.
```java
for ( int i = 0 ; i < 10 ; i++){
    double coverage = VPCalculator.monteCarloVP(1000000 , pl , gna.getTopTenResults().get(i));
    System.out.printf("Acurate Coverage Chromosome %d: %f \n", i , coverage);
        
}
```
<br>  

The last get method that you may use is `getBestGene();`. It returns only the best result as an **Array of Modems**. Bottom sample code is using this method alongside with some string minipulation to create a WKT text that you can copy and paste directly inside JTS TestBuilder.

```java
String bestGene  = Arrays.toString(gna.getBestGene());
System.out.println("\nMULTIPOINT("+ bestGene.substring(1 , bestGene.length() -2) +")");
```
<br>  

### One Last Neat Trick <br>
This trick involves working with a method called `VPCalculator.monteCarloVP_SavePoints();` alongside JTS TestBuilder.<br>The _**monteCarloVP_SavePoints**_ method works exactly like _**monteCarloVP**_ with one additional difference. After calculating the signal coverage, it will save the random points it created for estimation inside a WKT file which you can use directly inside JTS TestBuilder.<br> You just need to pass in two additional parameters. First the path to which it saves the points in, and second a boolean value that if passed __true__ shows _How long it took the algorithm to finish_.
```java
VPCalculator.monteCarloVP_SavePoints(100000 , pl , gna.getBestGene() , repoPath + "test_cases" , true);
```
This will create a **montecarlo_out.wkt** file inside the **test_cases** folder which you can drag and drop inside JTS TestBuilder to get an idea of the covered area.
<br><br>




## Credits
