package me.jrmensah.internetbank.entities;



import javax.management.relation.Role;
import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name="USER_DATA")
public class UserData {
    public UserData() {
        this.roles= new HashSet<UserRole>();

    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="enabled")
    private boolean enabled;

    @Column(name="username")
    private String username;

    //The relationship many users can have, which can be one, more than one or zero roles.
    @ManyToMany(fetch = FetchType.EAGER)
    //Join Column will save from the table for relationship to role in database
    @JoinTable(joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
    private Collection<UserRole> roles;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public Collection<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<UserRole> roles)
    {
        this.roles = roles;
    }

    public void addRole(UserRole role)
    {
        roles.add(role);
    }


}

