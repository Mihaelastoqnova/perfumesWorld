package bg.softuni.perfumesworld.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "having_perfumes_id"))
    private Set<Perfume> havingPerfumes;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "for_test_perfumes_id"))
    private Set<Perfume> forTestPerfumes;

    public User() {
        this.havingPerfumes = new HashSet<>();
        this.forTestPerfumes = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Perfume> getHavingPerfumes() {
        return havingPerfumes;
    }

    public void setHavingPerfumes(Set<Perfume> havingPerfumes) {
        this.havingPerfumes = havingPerfumes;
    }

    public Set<Perfume> getForTestPerfumes() {
        return forTestPerfumes;
    }

    public void setForTestPerfumes(Set<Perfume> forTestPerfumes) {
        this.forTestPerfumes = forTestPerfumes;
    }
}
