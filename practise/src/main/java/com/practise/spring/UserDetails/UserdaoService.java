package com.practise.spring.UserDetails;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserdaoService {
    Map<Integer,User> map = new HashMap<>();

    UserdaoService(){
        map.put(1,new User(1,"Sai Akash","Kuthuru"));
    }


    public Collection<User> getUsers() throws Exception {
        return map.values();
    }

    public User getUser(Integer id) throws Exception {
        try{
            return map.get(id);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public User saveUser(User user){
        if(map.containsKey(user.getId()))
            map.replace(user.getId(),user);
        else
            map.put(user.getId(),user);
        return user;
    }

    public User deleteUser(Integer id){
        User deletedUser = null;
        if(map.containsKey(id)){
            deletedUser = map.remove(id);
        }
        return deletedUser;
    }

}
