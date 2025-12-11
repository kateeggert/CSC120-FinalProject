# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`

## Design Reflection:

 We organized the bulk of our code in the maze file, which intializes the maze by creating a 2d array. We made the desciion to include most of our code in this file because it made it easy to keep track of the positions of everything. We considered having individual classes keep track of their location; for instance, we were going to have a move() function within the player class. We decided to instead put the move() function in the maze class, because the player class would not have access to the entire maze to tell if a move is valid and to change location. To keep track of the cells, we created a mazeCell class, with two subclasses wall and emptyCell. This ensured that it was easy for the maze class to identify the type of each cell. For obstacles, we created an obstacle class with two subclasses, sphinx and Voldemort. Each obstacle had a nickname that could be translated to a cell in the maze, and then the subclasses each have loops that the user remains in until they defeat the obstacle or run out of heatlh. 
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project? 
 
    We mapped out our project ahead of time, deciding generally on the classes, their functions, and how they would interact. We worked on most of the coding at the same time, starting with the maze and player class and then moving on to the less critical classes. This allowed us to determine exactly how the classes would interact, even if we were working on different parts of the code. 

 - What **new thing(s)** did you learn / figure out in completing this project?

    We figured out how to create a maze that was able to keep track of all the classes and variables within this program. We also overall practiced mapping out classes and their relationships with one another. 

 - Is there anything that you wish you had **implemented differently**?

    We made some changes in the structure of our program as we developed our project. If we had mapped it out more clearly, we could have avoided having to make some changes. But I don't think there is anything that we would implement differently. 

 - If you had **unlimited time**, what additional features would you implement?

    In Harry Potter, the maze walls shifted. We considred implementing this, but it was difficult to ensure that there would always be a way to complete the maze and allow the reader to understand the shifting walls without making the game too hard. 

 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?

    During demo day, we were able to see how difficult the navigation of the maze was for someone who had no understanding of the maze. So, upon seeing this, we developed a hint command that allows the user to see the print out of the maze and their location within it. 

 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?

    I would advise planning out a bit more and determine exactly what we wanted each class to do. The project went well, but spending more time on the plan would have lessened the work later on. 

 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.

    We worked well together, and it was definitely a good choice to do all the coding together, as it reduced confusion and ensured that all aspects of the program functioned together. It was great to be able to bounce ideas off each other and think through difficulties. 
