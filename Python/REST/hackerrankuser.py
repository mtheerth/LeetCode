import requests
import json

base_url = "https://jsonmock.hackerrank.com/api/article_users"

# Function to fetch all users
def fetch_all_users():
    page = 1
    all_users = []
    
    while True:
        response = requests.get(f"{base_url}?page={page}")
        
        if response.status_code == 200:
            data = response.json()
            users = data['data']
            all_users.extend(users)
            
            # Check if there are more pages
            if data['total_pages'] <= page:
                break
            page += 1
        else:
            print(f"Failed to retrieve data. Status code: {response.status_code}")
            break
    
    return all_users

# Fetch all users
all_users = fetch_all_users()

filtered_users = filter(lambda user: user.get('comment_count', 0) < 10, all_users)
sorted_users = sorted(filtered_users, key=lambda user: user['comment_count'])
    # Convert filter object to a list (for easier use)
filtered_users_list = list(sorted_users)
print(json.dumps(filtered_users_list, indent=4)) 
