#  COMPUTER DATA BASE PROJECT EXERCISE

##### TOOLS AND EXPLANATIONS
>- The project has been prepared based on Cucumber BDD style.    
>- Maven build management tool is used in this project by Java language.
>- In the project created by using the Page Object Design Pattern, the data were collected under the pages package.
>- Dependencies have been prepared under the pom.xml file.
>- The project was tried to be controlled from the centre using config.properties and ConfigurationReader.
>- https://computer-database.gatling.io/computers address of the web page testing **Create, Update, Read, Delete and Checking** functionality

##### HOW TO RUN TESTS
 ```sh
  -> Under the runner package "Runner" right click and run Runner. "src > test > java > runner > Runner"
  -> mvn test --> in the IDE console or navigate project path in command line and run.
 ```

##### HOW TO CREATE TEST REPORTS

1-) When you run tests with the **"mvn test"** command from the console, you can see **Cucumber Html Report** under the target file.       
**-> target -> cucumber-html-reports > overview-steps.html** (open with chrome option)

2-) Second type of report, the project is run from **Runner** class, a **Cucumber Report link** is created in the IDE console automatically.       
 Sample link -> View your Cucumber Report at:   (Works 24 hours later than it will delete automatically)                                         
                 https://reports.cucumber.io/reports/9b75f3e9-7b17-472b-887c-bc2dcf512689 
                 
                                                                                                                                          
>- Under the resource file in the Description.text file, it is explained which tag and which test case works.              
>- The answer to the bonus question is explained in the BonusQuestion_All_Coverage.pdf file with a table.



**Adam Cigdem**    
QA Automation Engineer | SDET     
https://www.linkedin.com/in/adam-cigdem-2932931b4/
