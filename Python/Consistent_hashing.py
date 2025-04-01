import hashlib
import bisect

class ConsistentHashingLoadBalancer:
    def __init__(self, servers=None, num_replicas=3):
        self.num_replicas = num_replicas
        self.ring = {}
        self.sorted_keys = []
        self.servers = set()
        if servers:
            for server in servers:
                self.add_server(server)

    def _hash(self, key):
        """Return a consistent hash value for the given key."""
        return int(hashlib.md5(key.encode()).hexdigest(), 16)

    def add_server(self, server):
        """Add a server to the hash ring."""
        self.servers.add(server)
        for i in range(self.num_replicas):
            hash_key = self._hash(f"{server}:{i}")
            self.ring[hash_key] = server
            bisect.insort(self.sorted_keys, hash_key)

    def remove_server(self, server):
        """Remove a server from the hash ring."""
        self.servers.discard(server)
        for i in range(self.num_replicas):
            hash_key = self._hash(f"{server}:{i}")
            if hash_key in self.ring:
                del self.ring[hash_key]
                self.sorted_keys.remove(hash_key)

    def get_server(self, key):
        """Get the closest server for the given key."""
        if not self.ring:
            return None
        hash_key = self._hash(key)
        index = bisect.bisect(self.sorted_keys, hash_key) % len(self.sorted_keys)
        return self.ring[self.sorted_keys[index]]

# Example usage
servers = ["192.168.1.1", "192.168.1.2", "192.168.1.3"]
lb = ConsistentHashingLoadBalancer(servers)

print(lb.get_server("request1"))
print(lb.get_server("request2"))

# Adding a new server
lb.add_server("192.168.1.4")
print(lb.get_server("request1"))

# Removing a server
lb.remove_server("192.168.1.2")
print(lb.get_server("request1"))

