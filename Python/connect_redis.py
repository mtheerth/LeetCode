# installed redis using "brew install redis" and python client access "pip install redis" 
# and started it using redis-server (background start "brew services start redis")
# Now as to check server started did "redis-cli ping" it gives "PONG" default localhost:6379
import redis

# Connect to Redis server (default is localhost:6379)
r = redis.Redis(host='localhost', port=6379, db=0)

# Set a key
r.set('foo', 'bar')

# Get the key
value = r.get('foo')

print(value.decode())  
