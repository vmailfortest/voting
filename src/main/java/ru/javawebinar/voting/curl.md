# curl samples (application deployed in application context `voting_war_exploded`).

## RESTAURANTS

### create Restaurants
curl -s -X POST -H 'Content-Type:application/json' -d '{"name":"McPizza"}' http://localhost:8080/voting_war_exploded/rest/admin/restaurants --user admin@gmail.com:admin

### get All Restaurants
curl -s http://localhost:8080/voting_war_exploded/rest/admin/restaurants/ --user admin@gmail.com:admin

### get Restaurants 100002
curl -s http://localhost:8080/voting_war_exploded/rest/admin/restaurants/100002 --user admin@gmail.com:admin

### update Restaurants 100003
curl -s -X PUT -H 'Content-Type: application/json' -d '{"name":"McPizza-2"}' http://localhost:8080/voting_war_exploded/rest/admin/restaurants/100003 --user admin@gmail.com:admin

## DISHES

### create Dishes
curl -s -X POST -H 'Content-Type:application/json;charset=UTF-8' -d '{"name":"Krabovaya Palochka", "datetime":"2020-01-12", "restaurantId":100002}' http://localhost:8080/voting_war_exploded/rest/admin/dishes --user admin@gmail.com:admin

### get All Dishes
curl -s http://localhost:8080/voting_war_exploded/rest/admin/dishes/ --user admin@gmail.com:admin

### get Dishes 100004
curl -s http://localhost:8080/voting_war_exploded/rest/admin/dishes/100004 --user admin@gmail.com:admin

### update Dishes 100004
curl -s -X PUT -H 'Content-Type: application/json' -d '{"name":"Krabovaya Palochka-2", "datetime":"2020-01-12", "restaurantId":100003}' http://localhost:8080/voting_war_exploded/rest/admin/dishes/100004 --user admin@gmail.com:admin

## VOTES

### create Votes
curl -s -X POST -d '{"datetime":"2020-01-12T10:00", "restaurantId":100002}' -H 'Content-Type:application/json' http://localhost:8080/voting_war_exploded/rest/profile/votes --user user@yandex.ru:password

### get All Votes
curl -s http://localhost:8080/voting_war_exploded/rest/profile/votes/ --user user@yandex.ru:password

### get Votes 100012
curl -s http://localhost:8080/voting_war_exploded/rest/profile/votes/100012 --user user@yandex.ru:password

### update Votes 100014
curl -s -X PUT -H 'Content-Type: application/json' -d '{"datetime":"2020-01-11T10:00", "restaurantId":100002}' http://localhost:8080/voting_war_exploded/rest/profile/votes/100014 --user user@yandex.ru:password

## MENUS

### get Menus 2020-01-11
curl -s http://localhost:8080/voting_war_exploded/rest/profile/menus/2020-01-11 --user user@yandex.ru:password
