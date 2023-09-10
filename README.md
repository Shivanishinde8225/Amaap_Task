# Amaap_Task
problem statement :
Search for the Lost Puppy Game
A puppy is lost in one of the rooms in a multi-floor building that contains the same number of rooms on each floor. 2 players start searching the building for the puppy by randomly searching rooms turn by turn. The player to find the puppy wins the game.

Write a command line program to accept values of number of rooms, number of floors from the user and simulate the game mentioned above and print position of all players and puppy after each turn.

Solution : Recursion

Intuition:
The best way to solve such problems is using recursion.

Approach:
Step1:Start at the initial position of an players and ask to try every possible path i.e upwards(U), downwards(D), leftwards(L) and rightwards(R).

step 2:If a cell is in path, mark it in the visited array.

step 3:Also keep a check of the “out of bound” conditions while going in a particular direction in the matrix.

step 4:Whenever you reach the destination(puppy) it’s very important to get back in the recursion tree and While getting back, keep on unmarking the visited array for the respective direction.

###Test cases 1:

Enter floor: 4
Enter room: 4

Turn 1:
 --- --- --- ---
| 0 | 1 | 0 | 0 |
 --- --- --- ---
| 2 | 0 | 0 | * |
 --- --- --- ---
| 0 | 0 | 0 | 0 |
 --- --- --- ---
| 0 | 0 | 0 | 0 |
 --- --- --- ---
Player 1's turn :
Enter your choice: 1.Left 2.Right 3.Down 4.Up
2

Turn 2:
 --- --- --- ---
| 0 | 0 | 1 | 0 |
 --- --- --- ---
| 2 | 0 | 0 | * |
 --- --- --- ---
| 0 | 0 | 0 | 0 |
 --- --- --- ---
| 0 | 0 | 0 | 0 |
 --- --- --- ---
Player 2's turn :
Enter your choice: 1.Left 2.Right 3.Down 4.Up
2

Turn 3:
 --- --- --- ---
| 0 | 0 | 1 | 0 |
 --- --- --- ---
| 0 | 2 | 0 | * |
 --- --- --- ---
| 0 | 0 | 0 | 0 |
 --- --- --- ---
| 0 | 0 | 0 | 0 |
 --- --- --- ---
Player 1's turn :
Enter your choice: 1.Left 2.Right 3.Down 4.Up
2

Turn 4:
 --- --- --- ---
| 0 | 0 | 0 | 1 |
 --- --- --- ---
| 0 | 2 | 0 | * |
 --- --- --- ---
| 0 | 0 | 0 | 0 |
 --- --- --- ---
| 0 | 0 | 0 | 0 |
 --- --- --- ---
Player 2's turn :
Enter your choice: 1.Left 2.Right 3.Down 4.Up
2

Turn 5:
 --- --- --- ---
| 0 | 0 | 0 | 1 |
 --- --- --- ---
| 0 | 0 | 2 | * |
 --- --- --- ---
| 0 | 0 | 0 | 0 |
 --- --- --- ---
| 0 | 0 | 0 | 0 |
 --- --- --- ---
Player 1's turn :
Enter your choice: 1.Left 2.Right 3.Down 4.Up
3

Turn 6:
 --- --- --- ---
| 0 | 0 | 0 | 0 |
 --- --- --- ---
| 0 | 0 | 2 | 1* |
 --- --- --- ---
| 0 | 0 | 0 | 0 |
 --- --- --- ---
| 0 | 0 | 0 | 0 |
 --- --- --- ---
Player 1 found the puppy and wins!

###Test case 2:
Enter floor: 4
Enter room: 4

Turn 1:
 --- --- --- ---
| 0 | 1 | 0 | 2 |
 --- --- --- ---
| 0 | 0 | 0 | 0 |
 --- --- --- ---
| 0 | 0 | 0 | 0 |
 --- --- --- ---
| 0 | 0 | * | 0 |
 --- --- --- ---
Player 1's turn :
Enter your choice: 1.Left 2.Right 3.Down 4.Up
3

Turn 2:
 --- --- --- ---
| 0 | 0 | 0 | 2 |
 --- --- --- ---
| 0 | 1 | 0 | 0 |
 --- --- --- ---
| 0 | 0 | 0 | 0 |
 --- --- --- ---
| 0 | 0 | * | 0 |
 --- --- --- ---
Player 2's turn :
Enter your choice: 1.Left 2.Right 3.Down 4.Up
2
Can't go there

