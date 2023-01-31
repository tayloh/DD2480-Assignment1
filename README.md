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
└── target                  # build files and other project files
    └── [...]
```

## Way-of-working

- In our first meeting, we went through our individual strengths and weaknesses and came to a gathered understanding of the task. We agreed on communication channels and what we expected from each other.
- In an early stage, the group collectively decided on a language, build tool, test framework and basic program structure. We sat up some naming conventions and outlined the git workflow. 
- Subtasks were tracked in the issue tracker on GitHub, outlining who was responsible for what. Something we realized a bit too lates was that some issues overlap more than others, wich we could have directed to the same person instead of splitting the work chronologically. For example, we realized that multiple people were wrestling with the same math problem on their respective ends.
- We are now at a state where all group members are comfortable with the workflow, we take turns reviewing PRs and have not yet run into any major issues with merge conflicts. We realize that we work a bit differently and will need to do some refactoring to make the code more consistent. We also had to make some re-structuring after the meeting with the TA.

We conclude that we are now in the "In Place" state, where if we just iron out some hassles we will be on track to be in a "Working Well" state. 


## Individual Contributions

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
- LIC 9-13 and 15
- PUM 
- Unit tests for the above
