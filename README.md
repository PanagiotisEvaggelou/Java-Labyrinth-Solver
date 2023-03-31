# Java-Labyrinth-Solver
A java program that reads a labyrinth from a txt file in 0s and 1s and solves it

First we read the file containing the data of the maze, simultaneously storing them in a 
two-dimensional array. Then, we call the stack constructor, in which we assign the entrance 
of the maze as the first element, and follow the following logic: We assign to the stack 
the 4 possible next positions we will need to follow (up, down, left and right), checking 
first if they are available (if they are 0) and choosing for the next possible path to the 
exit the first available one, making sure that only the position we finally choose for our 
next step is in the stack, marking it with 2. In case none of the 4 positions are available 
(i.e. they are not 0), we choose the first available position we had previously stepped on 
(a position that is already marked with 2) and move backwards, repeating the checks for each 
position, looking for the first available position of a new path (0), while also removing 
from the stack the positions we are forced to step on again. This process is repeated, 
performing the necessary checks through the corresponding Check0 and Check2 functions, 
until we reach the end of the maze, if there is one.
In case more than 600 checks are performed, the program terminates as it indicates that 
for a logical size labyrinth, there is probably an issue with the algorithm.

Overall, this text describes the implementation of a part of a program that solves a maze. 
The text discusses the steps involved in reading the data, creating a stack, and determining 
the logic that needs to be followed to find the exit of the maze. The text also mentions the 
checks that need to be performed to ensure the algorithm works as intended.
