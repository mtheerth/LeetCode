import java.util.*;

public class ConsistentHashingLoadBalancer {

    // Represents a server in the system
    private static class Server {
        String name;

        Server(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    // Ring to store server and request mappings
    private final TreeMap<Integer, Server> ring = new TreeMap<>();
    private final int numberOfReplicas; // Number of virtual nodes per server

    public ConsistentHashingLoadBalancer(int numberOfReplicas) {
        this.numberOfReplicas = numberOfReplicas;
    }

    // Add a server to the ring
    public void addServer(Server server) {
        for (int i = 0; i < numberOfReplicas; i++) {
            int hash = getHash(server.name + i); // Create a virtual node
            ring.put(hash, server);
        }
    }

    // Remove a server from the ring
    public void removeServer(Server server) {
        for (int i = 0; i < numberOfReplicas; i++) {
            int hash = getHash(server.name + i);
            ring.remove(hash);
        }
    }

    // Get the server for a given request
    public Server getServer(String request) {
        if (ring.isEmpty()) {
            throw new IllegalStateException("No servers available");
        }
        int hash = getHash(request);
        // Find the closest server in the ring
        Map.Entry<Integer, Server> entry = ring.ceilingEntry(hash);
        if (entry == null) {
            // Wrap around to the first server in the ring
            entry = ring.firstEntry();
        }
        return entry.getValue();
    }

    // Hash function to map keys to the ring
    private int getHash(String key) {
        return key.hashCode(); // Simple hash function for demonstration
    }

    public static void main(String[] args) {
        ConsistentHashingLoadBalancer loadBalancer = new ConsistentHashingLoadBalancer(3);

        // Add servers
        Server server1 = new Server("Server1");
        Server server2 = new Server("Server2");
        Server server3 = new Server("Server3");

        loadBalancer.addServer(server1);
        loadBalancer.addServer(server2);
        loadBalancer.addServer(server3);

        // Simulate requests
        String[] requests = {"Request1", "Request2", "Request3", "Request4", "Request5"};
        for (String request : requests) {
            Server server = loadBalancer.getServer(request);
            System.out.println("Request " + request + " is handled by " + server);
        }

        // Remove a server and see how requests are redistributed
        System.out.println("\nRemoving Server2...");
        loadBalancer.removeServer(server2);

        for (String request : requests) {
            Server server = loadBalancer.getServer(request);
            System.out.println("Request " + request + " is now handled by " + server);
        }
    }
}
