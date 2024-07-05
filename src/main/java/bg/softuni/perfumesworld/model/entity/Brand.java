package bg.softuni.perfumesworld.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String creatorName;
    private String information;

    @OneToMany(mappedBy = "brand")
    private Set<Perfume> perfumes;

    public Brand() {
        this.perfumes = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Set<Perfume> getPerfumes() {
        return perfumes;
    }

    public void setPerfumes(Set<Perfume> perfumes) {
        this.perfumes = perfumes;
    }
}

