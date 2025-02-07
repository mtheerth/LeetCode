import requests
import json 


# Step 1: Define the API endpoint
url = "https://jsonmock.hackerrank.com/api/article_users?page=2"

# Step 2: Make a GET request to the API
response = requests.get(url)

# Step 3: Check if the request was successful (status code 200)
if response.status_code == 200:
    # Step 4: Parse the JSON response
    data = response.json()
    
    # Step 5: Access the 'data' field from the JSON response
    users = data['data']
    
    # Step 6: Print or process the data
    print(json.dumps(users, indent=4)) 
else:
    print(f"Failed to retrieve data. Status code: {response.status_code}")
