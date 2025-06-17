import java.util.HashMap;
import java.util.Map;

class AuthenticationManager {
    private int timeToLive; // duration for which the tokens are valid
    private Map<String, Integer> tokenExpiryMap; // holds token IDs and their corresponding expiration times

    // Constructor initializes the AuthenticationManager with a specific time to live for tokens
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokenExpiryMap = new HashMap<>();
    }

    // Generates a new token with an expiration time based on the current time
    public void generate(String tokenId, int currentTime) {
        // Put the token and its expiration time into the map
        tokenExpiryMap.put(tokenId, currentTime + timeToLive);
    }

    // Renews an existing token if it hasn't expired yet
    public void renew(String tokenId, int currentTime) {
        // Retrieve the current expiration time for the token
        Integer expirationTime = tokenExpiryMap.getOrDefault(tokenId, 0);
      
        // If the token is still valid (hasn't expired), renew it by updating its expiration time
        if (expirationTime > currentTime) {
            generate(tokenId, currentTime + timeToLive);
        }
    }

    // Counts the number of unexpired tokens at a given current time
    public int countUnexpiredTokens(int currentTime) {
        // Initialize a counter to keep track of valid tokens
        int count = 0;
      
        // Iterate through all tokens and increment the count if they're not expired
        for (int expirationTime : tokenExpiryMap.values()) {
            if (expirationTime > currentTime) {
                count++;
            }
        }
      
        // Return the total number of unexpired tokens
        return count;
    }
}
