package com.personal.shop.role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "roles")
@Getter @Setter
@NoArgsConstructor
public class Role {

    @Id
    @Column(name = "role_name")
    private String name;

    public Role(String name){
        this.name = name;
    }


}
