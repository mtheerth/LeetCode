package my.test;

import java.util.*;

public class LoadBal {
    
    // Helper class to store the server load and index
    static class Server {
        int load;
        int index;
        
        Server(int load, int index) {
            this.load = load;
            this.index = index;
        }
    }
    
    // Comparator for the min-heap to prioritize the server with the least load
    static class ServerComparator implements Comparator<Server> {
        public int compare(Server a, Server b) {
            return a.load == b.load ? Integer.compare(a.index, b.index) : Integer.compare(a.load, b.load);
        }
    }

    // Method to assign requests to the least-loaded server using min-heap
    public static int[] assignRequestsToServers(int numServers, int[] requests) {
        int[] serverAssignments = new int[requests.length];  // Store the server assignments
        int[] serverLoad = new int[numServers];
        // Initialize the priority queue (min-heap)
        PriorityQueue<Server> pq = new PriorityQueue<>(new ServerComparator());
        
        // Initialize all servers with load 0 and add them to the min-heap
        for (int i = 0; i < numServers; i++) {
            pq.add(new Server(0, i));  // Each server starts with a load of 0
        }
        
        // Iterate through each request
        for (int i = 0; i < requests.length; i++) {
            Server leastLoadedServer = pq.poll();
            serverAssignments[i] = leastLoadedServer.index;
            leastLoadedServer.load++;
            pq.add(leastLoadedServer);
        }
        
        return serverAssignments;
    }

    public static void main(String[] args) {
        int numServers = 2;  
        int[] requests = {4,0,2,2}; 

        int[] serverAssignments = assignRequestsToServers(numServers, requests);
        
        System.out.println("Request assignments to servers:");
        for (int i = 0; i < serverAssignments.length; i++) {
            System.out.println("Request " + requests[i] + " → Server " + (serverAssignments[i]));
        }
    }
}

