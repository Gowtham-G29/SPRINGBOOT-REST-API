package com.g_29.restWebservice.restful_web_service.versioning;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPerson {

    @GetMapping("/v1/person")
    public ResponseEntity<PersonV1>getFirstVersionOfPerson(){

        PersonV1 person=new PersonV1("Bob charlie");
        return ResponseEntity.status(200).body(person);
    }

    @GetMapping("/v2/person")
    public ResponseEntity<PersonV2>fgetSecondVersionOfPerson(){
        PersonV2 person=new PersonV2(new Name("Gowtham","Guru"));

        return ResponseEntity.status(200).body(person);
    }

    @GetMapping(path = "/person",params = "version=1")
    public ResponseEntity<PersonV1>getFirstVersionOfPersonRequestParam(){
        PersonV1 person=new PersonV1("Bob charlie");
        return ResponseEntity.status(200).body(person);
    }

    @GetMapping(path = "person",params = "version=2")
    public ResponseEntity<PersonV2>getSecondVersionOfPersonRequestParam(){
        PersonV2 person=new PersonV2(new Name("Gowtham","Guru"));

        return ResponseEntity.status(200).body(person);
    }


    @GetMapping(path = "/person/header",headers = "x-api-key=1")
    public ResponseEntity<PersonV1>getFirstVersionOfPersonRequestHeaders(){
        PersonV1 person=new PersonV1("Bob charlie");
        return ResponseEntity.status(200).body(person);
    }

    @GetMapping(path = "person/header",headers = "x-api-key=2")
    public ResponseEntity<PersonV2>getSecondVersionOfPersonHeaders(){
        PersonV2 person=new PersonV2(new Name("Gowtham","Guru"));
        return ResponseEntity.status(200).body(person);
    }

    @GetMapping(path = "/person/accept",produces = "application/vnd.company.app-v1+json")
    public ResponseEntity<PersonV1>getFirstVersionOfPersonRequestContent(){
        PersonV1 person=new PersonV1("Bob charlie");
        return ResponseEntity.status(200).body(person);
    }

    @GetMapping(path = "/person/accept", produces= "application/vnd.company.app-v2+json")
    public ResponseEntity<PersonV2>getSecondVersionOfPersonContent(){
        PersonV2 person=new PersonV2(new Name("Gowtham","Guru"));
        return ResponseEntity.status(200).body(person);
    }



}
