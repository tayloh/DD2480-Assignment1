# DD2480 Assignment 1: Launch Interceptor Program
This project is an implementation of the Launch Interceptor Program, as defined by J. C. Knight and N. G. Leveson. The purpose of the program is to be able to decide whether an interceptor should be launched or not based upon input radar tracking information. 

## Folder Structure 
```
.
├── pom.xml                 # maven project file
├── README.md
├── src
│   ├── main
│   │   └── java/org/labs/lab1
│   │        ├── CMV.java                # Conditions Met Vector
│   │        ├── FUV.java                # Final Unlocked Vector
│   │        ├── InputData.java          # Input data class to structure input data
│   │        ├── InputProvider.java      # Provides static input data 
│   │        ├── LaunchInterceptor.java  # Main program class, contains the DECIDE method
│   │        ├── LIC.java                # Launch Interceptor Conditions, main functionality
│   │        ├── Main.java               # Program entry point
│   │        └── PUM.java                # Preliminary Unlocking Matrix
│   └── test/java           # Test files                                      
│       ├── CMVTest.java    # Class-specific tests
│       ├── FUVTest.java
│       ├── InputProviderTest.java
│       ├── LaunchInterceptorTest.java
│       ├── LICTest.java
│       └── PUMTest.java
└── target                  # build files and other project files (target is not in remote repo)
    └── [...]
```

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

## Way-of-working

- In our first meeting, we went through our individual strengths and weaknesses and came to a gathered understanding of the task. We agreed on communication channels and what we expected from each other.
- In an early stage, the group collectively decided on a language, build tool, test framework and basic program structure. We sat up some naming conventions and outlined the git workflow. 
- Subtasks were tracked in the issue tracker on GitHub, outlining who was responsible for what. Something we realized a bit too lates was that some issues overlap more than others, wich we could have directed to the same person instead of splitting the work chronologically. For example, we realized that multiple people were wrestling with the same math problem on their respective ends.
- We are now at a state where all group members are comfortable with the workflow, we take turns reviewing PRs and have not yet run into any major issues with merge conflicts. We realize that we work a bit differently and will need to do some refactoring to make the code more consistent. We also had to make some re-structuring after the meeting with the TA.

We conclude that we are now in the "In Place" state, where if we just iron out some hassles we will be on track to be in a "Working Well" state. 


## Individual Contributions

Amanda: 
- LICs 0-3 and 13

Erik: 
- Structure 
- LIC 4-6
- FUV class (TODO)

Tobias: 
- LIC 7-8
- CMV (TODO)

Hannes: 
- LIC 9-12 and 14
- PUM 
- Unit tests for the above
