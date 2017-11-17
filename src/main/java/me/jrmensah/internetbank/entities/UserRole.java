package me.jrmensah.internetbank.entities;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class UserRole {
    public UserRole() {
    }

    public UserRole(String role){
        this.role=role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //Can only have one role or use Unique mean the string should not replicate inside database in other rows
    @Column(unique=true)
    private String role;

    //Tells you what is mapped by in the entity of USERNAME
    @ManyToMany(mappedBy = "roles",fetch=FetchType.LAZY)
    private Collection<UserData> users;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public Collection<UserData> getUsers()
    {
        return users;
    }

    public void setUsers(Collection<UserData> users)
    {
        this.users = users;
    }


}

