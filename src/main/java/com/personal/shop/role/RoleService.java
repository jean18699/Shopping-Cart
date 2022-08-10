package com.personal.shop.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public Role addRole(String name){
        Role role = new Role(name.toUpperCase());
        repository.save(role);
        return role;
    }

    public Optional<Role> getRole(String name){
        if(repository.existsById(name)){
            return repository.findById(name);
        }
        return null;
    }

    public String removeRole(String name){
        if(repository.existsById(name.toUpperCase())){
            repository.deleteById(name.toUpperCase());
            return name;
        }else
        {
            return null;
        }
    }

}
