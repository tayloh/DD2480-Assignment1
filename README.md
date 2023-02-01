# DD2480 Assignment 1: Launch Interceptor Program
This project is an implementation of the Launch Interceptor Program, as defined by J. C. Knight and N. G. Leveson. The purpose of the program is to be able to decide whether an interceptor should be launched or not based upon input radar tracking information. 

## How to build & run
For this project, Maven (version 3.8.1) and IntelliJ (version 2022.3.2) have been used. The project has been made with java using JDK version 19.0.2. In order to build the project, there are two main options we recommend: 1) Open the project with IntelliJ, or 2) Use the command line to compile/run the program. 

To use IntelliJ for this purpose (as we have done), it is merely required to start it up and open the project (which can either be cloned or downloaded directly). You can build the project by clicking on the green hammer at the top, or by pressing Ctrl+F9. If you want to run all tests, right click on the folder src/test/java and select “Run all tests”. The main program can be run by e.g. right clicking on Main.java in the project and selecting “Run Main.main()”.

In order to build the project via command line (or equivalent), you will have to install the aforementioned version of Maven to your computer. If you are on a Windows machine, you will have to add the /bin of Maven to your PATH environment variable. When this is done, navigate to the project folder via command line. The following command can be used to build and run all tests:<br/>
*mvn test*

To build and run the main program, execute the following command:<br/>
*mvn compile exec:java -Dexec.mainClass="org.labs.lab1.Main*

There is no guarantee that the project will be able to compile and run with alternative versions of the tools mentioned. 

Maven can be downloaded from here: https://maven.apache.org/download.cgi <br/>
IntelliJ (community version) can be found here: https://community.chocolatey.org/packages/intellijidea-community/2022.2.3.

## Contributions

Amanda: 
- LIC 0-3

Erik: 
- Structure 
- LIC 4-6
- FUV class (TODO)

Tobias: 
- LIC 7-8
- CMV (TODO)

Hannes: 
- LIC 9-10 
- LIC 11-12 (TODO)
