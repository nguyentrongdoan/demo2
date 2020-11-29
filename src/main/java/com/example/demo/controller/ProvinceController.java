package com.example.demo.controller;

import com.example.demo.config.ConfigRestTemplate;
import com.example.demo.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class ProvinceController {
    @Autowired
//    private RestTemplate restTemplate;
    private ConfigRestTemplate restTemplate;

    @GetMapping("/users")
//    public List<Object> getUsers() {
//        String url = "http://localhost:8080/users";
//        Object[] objects = restTemplate.getForObject(url, Object[].class);
//        return Arrays.asList(objects);
//    }

    // Su dung Linked Hashmap, kq hien thi tren temiral
//    public void getUsers(){
//        String url = "http://localhost:8080/users";
//        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getRestTemplate().getForObject(url, List.class);
//        if(usersMap!=null){
//            for(LinkedHashMap<String, Object> map : usersMap){
//                System.out.println("User : id="+map.get("id")+", Name="+map.get("name")+", Email="+map.get("email"));;
//            }
//        }else{
//            System.out.println("No user exist----------");
//        }
//    }
    public List<UserDTO> getUsers(){
        String url = "http://localhost:8080/users";
        List<UserDTO> userDTOS = restTemplate.getRestTemplate().getForObject(url, List.class);
        return userDTOS;
    }
    @GetMapping("/user")
    public UserDTO getUserById(){
        String uri = "http://localhost:8080/users/{id}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "1");

        UserDTO result = restTemplate.getRestTemplate().getForObject(uri, UserDTO.class, params);
        return result;
    }
}
