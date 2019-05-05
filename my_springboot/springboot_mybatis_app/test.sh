curl -v -X POST -d "username=test1&password=123456" http://localhost:8080/user
curl  http://localhost:8080/user
curl -v -X PUT -d "username=TEST1&password=test" http://localhost:8080/user/1
curl  http://localhost:8080/user/1
curl -v -X DELETE http://localhost:8080/user/1
curl  http://localhost:8080/user