<!--
The developers at AWS IAM are designing a new checksum logic for an authentication module. The checksum is calculated as an array hash where hash[i] = secretKey[i] % param[i]. There are n parameters for the checksum, where the ith parameter is represented by param[i]. The secret key consists of n values, with the ith value denoted as secretKey[i].

A good secret key is one that results in more distinct values in the hash array.

Given the array param of size n, determine the maximum number of possible distinct values in the hash array by selecting an appropriate secretKey.

Function Description

Complete the function findHash in the editor.

findHash has the following parameter:

int param[n]: the different parameters needed for the checksum logic
Returns

int: the maximum number of distinct elements possible in hash.

Example 1:

Input: param = [1, 2, 4]
Output: 3
Explanation:


You can choose secretKey = [1, 3, 2], resulting in the hash array [0, 1, 2], which consists of 3 distinct elements.
---->

import java.util.HashSet;
import java.util.Set;

public class HashFinder {

    // Method to find hash (unique element count)
    public int findHash(int[] param) {
        Set<Integer> uniqueParams = new HashSet<>();
        for (int p : param) {
            uniqueParams.add(p);
        }
        return uniqueParams.size();
    }

    // Main method to test the function
    public static void main(String[] args) {
        HashFinder finder = new HashFinder();

        int[] input = {1, 2, 3, 2, 4, 1, 5};
        int hash = finder.findHash(input);

        System.out.println("Unique element count (hash): " + hash);
    }
}

