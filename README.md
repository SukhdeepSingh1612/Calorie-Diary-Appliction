# ***CALORIE DAIRY***
### CPSC 210 : Personal Project
##  **Project Proposal**

In these ***uncertain times of a Pandemic*** across the world, The best thing  
one can do is stay home and try to live a healthy life. Body's immunity  
is key in defeating Covid 19. This application targets good nutrition, which is an important component of 
leading a healthy lifestyle. This application aids the user in tracking 
and keeping a log of their eating habits with an intent of promoting overall health.  
 
#### Application's  **functionalities** include:
>- The application provides an easy to use graphical interface.
>- The application accepts users information to output the BMI (*Body  
 Mass Index*) of the user.
 >- The application suggests the user what their recommended **daily calorie intake** should be.
 >- The application lets the user **add their food and calorie intake** throughout the day 
   and keep logs of what all they have eaten with a sense of awareness of how many calories they can intake without 
   going over their recommended calorie intake.
 >- The application also lets the user **log their daily workout, and the 
number of calories burnt** daily.
>- The application lets the user save their data and allows the user to load it whenever entering
the program again. 

This application can potentially be used by **all those people stuck in their houses 
in a lockdown**, and many others **who target to live a healthier lifestyle**. 
I am studying remotely from home and get almost no time for exercising at home, so 
eating right is the only option for me to keep my body healthy and my immunity strong.
This project is of utmost importance to me because I think this application would be
a **great way** of helping me **track my progress**, and **my overall fitness journey**.   

## User Stories
**a)** As a user, I want to be able to check my BMI  
**b)** As a user, I want to be able to get my suggested daily calorie requirement  
**c)** As a user, I want to be able to add my food intake and workout routines to the logs  
**d)** As a user, I want to be able to review my food and workout logs   
**e)** As a user, I want to be able to save my data before quiting the program.  
**f)** As a user, I want to be able to load my previous session when I enter the program.  
**g)** As a user, I want to be able to use the graphical interface easily and efficiently  
**h)** As a user, I want to see my logs together, in the form of a scrolling list.




 ***Note:*** to use the program from scratch do not forget to click enter/re-enter  
 button to enter the data in the program before clicking any other functionality  
 get bmi or get daily calorie requirements.
 
 **Phase 4** Task 2: Added exception handling to Diary class to make it robust, BodyMassIndex
 , getBodyMassIndex,getMaintenanceCalories and maintenanceCalories throw DataNotFilled(Checked) Exception

**Phase 4 : Task 3**  
the program contains a main class which calls a new userInformation frame which in turns 
is the beginning of the program. My model class contains 3 classes, The most important class is 
Diary class, it holds lists for the food and workout and holds other data fields and contains methods for most of the functionality 
of the program. Food and Workout class both store information about themselves and contain some 
method to represent them in the Ui package. The Ui package consists of a CalorieDiary class which was a 
CUI class and is not in use after the project was made into a GUI project. UserInformation is the 
most important Gui class as it contains the frame which is responsible to read , write or take 
input from the user. AddToLogsGui class contains a frame which deals with user's food or 
workout activities, It collects that data and stores it into a list. CalorieDiaryGui class comprises 
a frame which displays the list made using the activities logged into the AddToLogsGui and 
userInformation class. Persistence package includes an interface which is implemented to 
the model classes, and it also contains a reader and writer classes used by userInformation to 
load or save the input added by the user. the diaryInitializer class in the Ui creates a Diary object 
which is then extended to all the other GUi classes to work with.      
****Refactoring****  
If I had more time I would do the following refactors:  
*1)* In my code, there are multiple methods which perform similar tasks and can be 
refactored into a compacter and more efficient design.  
*2)* In the Ui classes, instead of using multiple classes and creating multiple frames, 
we can create multiple panels ,add the functionality in the panels then call in and out of the
 panel as per our convenience all in one class.  
*3)* Simplify the type hierarchy to make future changes easier.  
*4)* Refactor food and workout class to a similar abstract class containing same methods and 
override the method in food and workout to avoid duplication.  
*5)* Make gui elements more comprehensible and easier to use for the user and use them more efficiently.  
*6)* Overall use of more abstraction to remove code redundancy.  




