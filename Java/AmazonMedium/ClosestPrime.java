class Solution {
    public int[] closestPrimes(int left, int right) {
       boolean[] isPrime = sieveOfEratosthenes(right);

        int[] result = {-1, -1}; // Initialize result with no primes found
        int prev = -1; // Track the previous prime number
        int minDiff = Integer.MAX_VALUE; // Track the minimum difference between consecutive primes
System.out.println(isPrime[6]);
        // Iterate through the range [left, right]
        for (int num = left; num <= right; num++) {
            if (isPrime[num]) {
                if (prev != -1) { // If a previous prime exists
                    int currentDiff = num - prev; // Calculate the difference
                    if (currentDiff < minDiff) { // Update if this is the smallest difference
                        minDiff = currentDiff;
                        result[0] = prev;
                        result[1] = num;
                    }
                }
                prev = num; // Update the previous prime
            }
        }

        return result; // Return the closest primes (or [-1, -1] if no pair is found)
    }

    // Helper method to generate all primes up to `n` using the Sieve of Eratosthenes
    private boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true); // Assume all numbers are prime initially
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) { // If `i` is prime, mark its multiples as non-prime
                for (int j = i * i; j <= n; j += i) {
                    System.out.println(j + "b "+i);
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }
}
