# **Ten-pin Bowling Score Calculator**

Welcome to an example of Ten-pin Bowling Score Calculator with Java, you can download the binary distribution from release section or download the source code to build the program. 

The Bowling Score Calculator program is distribute in a zip file called "bowlingsc.zip".

## Running the Ten-pin Bowling Score Calculator program
### Pre-requisites to execute
1. JRE 1.8 or higher.

### Execution
To execute the program use the following command:
`$ java -jar bowlingsc-full.jar fileName`

Where fileName is the file name with bowling data. For you convenience, the zip file includes two test files (sample1.txt & sample2.txt).

### Distribution Contents
1. bowlingsc-full.jar, executable jar file.
2. sample1.txt & sample2.txt, which are test files.
3. "docs" folder, includes javadoc documentation.
4. "site" folder, includes maven site information.

## Build

### Pre-requisites
1. JDK 1.8 or higher.
2. Maven 3.3.9 or higher.

In order to build the project, execute the following steps:

### Clone project
`$ git clone https://github.com/hendrixc/bowlingsc.git`

### Build the project
`$ cd bowlingsc`

`$ mvn install`

### Generate a jar file with dependencies
`$ mvn assembly:single` 

## Other commands to check

### Run unit test cases
`$ mvn test`

### Run unit test cases and integration tests.
`$ mvn verify`

## Features checklist 
#### Mandatory

- [x] The program should run from the command-line and take a text file as input
- [x] The program should read the input text file and parse its content
    -  [X] Each line represents a player and a chance with the subsequent number of pins knocked down.
    -  [X] An 'F' indicates a foul on that chance and no pins knocked down (identical for scoring to a roll of 0).
    -  [X] The rows are tab-separated
- [x] The program should handle bad input
    - [X] Negative numbers
    - [X] More than 10 pins knocked down
    - [X] Inssuficient number of frames for each player.
    - [X] More than 10 frames by player.
    - [X] The sum of first and second throws exceed the max pines number.
- [x] The program should output the scoring for the associated game
    -  [X] For each player, print their name on a separate line before printing that player'spinfalls and score.
    -  [X] All values are tab-separated
    -  [X] The output should calculate if a player scores a strike ('X'), a spare ('/') and allow for extra chances in the tenth frame
- [x] Unit test: Tests should cover at least the non-trivial classes and methods
- [x] Integration test: At least cover the three main cases: Sample input (2 players), perfect score, zero score


#### Bonus Listed (Optional)
- [X] Use Java 8 streams and lambdas

#### Bonus Not Listed (Optional)
- [X] Program supports from 1 to 6 players.
- [X] If file name is not provided in command line, the program request for a file name. 
- [x] Use CI/CD Tool to run  tests [Travis](https://travis-ci.com/github/hendrixc/bowlingsc)
- [X] Additionals unit test cases and integration tests
- [X] Generation of documentation javadoc
- [X] Generation of maven site
