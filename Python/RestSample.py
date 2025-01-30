import requests
import json

url="https://jsonmock.hackerrank.com/api/football_competitions"
name="UEFA Champions League"
year= 2011

response = requests.get(f"{url}?name={name}&year={year}")
data = response.json()['data']

winner = data[0].get("winner")

page =1
total_pages=1
url1 = "https://jsonmock.hackerrank.com/api/football_matches"
while page<=total_pages:
    response1 = requests.get(f"{url1}?competition={name}&year=2011&team1={winner}&page={page}")
    response2 = requests.get(f"{url1}?competition={name}&year=2011&team2={winner}&page={page}")
    data1 = response1.json()['data']
    data2 = response2.json()['data']
    team1_total = sum(map(lambda match: int(match['team1goals']), data1))
    team2_total = sum(map(lambda match: int(match['team2goals']), data2))


    if page ==1 :
        total_pages = response1.json()['total_pages']
    page +=1

print (team1_total+team2_total)
