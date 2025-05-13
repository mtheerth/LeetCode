/*At a birthday party, N kids (IDs from 1 to N) sit in a circle. The host has T toys to distribute, starting from kid with ID D and giving one toy at a time in ascending order. After reaching kid N, the count continues from kid 1.

Input

Three integers:

N: Number of kids
T: Number of toys
D: Starting kid's ID
Output

Print the ID of the kid who receives the damaged (last) toy.*/


public int findDamagedToy(int N, int T, int D) {
    // write your code here
  int lastKid = ((D - 1 + T - 1) % N) + 1;
        return lastKid;
}

