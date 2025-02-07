import requests
import json 


url = "https://jsonmock.hackerrank.com/api/article_users?page=2"

response = requests.get(url)

if response.status_code == 200:
    
    data = response.json()
    
    users = data['data']
    
    print(json.dumps(users, indent=4)) 
else:
    print(f"Failed to retrieve data. Status code: {response.status_code}")
