# sw-modeling-example

- Microservices version of this example - https://github.com/jinyoung/sw-modeling-example-msa

## Prerequiste installations

- https://github.com/TheOpenCloudEngine/uEngine-cloud-server/wiki/Tutorial

## Cloning the repo.

1. download the git client:   https://git-for-windows.github.io/
1. lauch a terminal and enter 
```
git clone https://github.com/jinyoung/sw-modeling-example.git
```

## Build and run
### Backend server (Runs on 8080)
```
mvn spring-boot:run
```
### For different port (Runs on 8001)
```
mvn spring-boot:run -Dserver.port=8001
```

if you don't have Apache Maven, download and intall Maven: https://zetawiki.com/wiki/%EC%9C%88%EB%8F%84%EC%9A%B0_%EB%A9%94%EC%9D%B4%EB%B8%90_%EC%84%A4%EC%B9%98

and go to http://localhost:8080 then you will see:
```
{
  "_links" : {
    "vehicle" : {
      "href" : "http://localhost:8080/vehicle{?page,size,sort}",
      "templated" : true
    },
    "customer" : {
      "href" : "http://localhost:8080/customer{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/profile"
    }
  }
}
```
### Adding a customer through HTTPie:

Install Httpie:  https://github.com/TheOpenCloudEngine/uEngine-cloud/wiki/Httpie-%EC%84%A4%EC%B9%98

```
http localhost:8080/customer firstName="rick" lastName="jang"
http localhost:8080/vehicle modelName="BMW" customer="http://localhost:8009/customer/1" 
```

- Adding a customer through POSTMAN
Turn the METHOD as: POST
and set the body as "raw" and "JSON(application/json)"
and finally enter the body json value as:
```
{
  "firstName": "장진영"
}
```
Test service through POSTMAN

```
var jsonData = JSON.parse(responseBody);
tests["첫번째 고객은 장진영이어야 합니다"] = jsonData._embedded.customer[0].firstName === "장진영";

tests["Response time is less than 100ms"] = responseTime < 100;
```

### Front-end server (Runs on 8081 or any other port)
```
cd src/main/resources/static
npm install
npm run dev
```

### Go to http://localhost:8081/alltabs.html

### To mashup components, go to http://rawgit.com/TheOpenCloudEngine/metaworks4/master/src/main/resources/static/mashup/test.html

and drag form or grid component to the canvas, and enter the name of class - com.autoinsurance.Customer

## Documentation
- https://github.com/TheOpenCloudEngine/micro-service-architecture-vuejs/wiki
- https://www.slideshare.net/pongsor/building-multi-tenancy-enterprise-applications


## Metaworks Metadata Service
- login firstly and launch the Java Script console,
- get the value of 'localStorage["access_token"]' just type it in the console,
- you may get some string value from the console, copy it.
- paste the access_token value to the POSTMAN's header tab as key - 'access_token' 


## Frequenctly Asked Questions

### intelli-j
- 붉은색 오류:  Setup SDK 상단 메뉴 클릭해서 jdk1.8잡아줌

- maven import Changes -> yes
- maven menu toolbar --> reimport 버튼

### server configuration / setting
- pom.xml
- WebConfig.java 를 다시 받아 수정.

- 8080 충돌시 -> services.msc 실행 > 오라클 에이젠트 중지
### maven 
- Class Not Found -> remove all the files under .m2/repository/**
- Repository Not Found -> remove the .m2/setting.xml
