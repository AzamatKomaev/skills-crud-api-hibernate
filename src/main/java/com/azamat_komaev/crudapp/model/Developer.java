package com.azamat_komaev.crudapp.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity @Table(name = "developers")
public class Developer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
        name = "developers_skills",
        joinColumns = {@JoinColumn(name = "developer_id")},
        inverseJoinColumns = {@JoinColumn(name = "skill_id")}
    )
    private List<Skill> skills = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;
    @Column @Enumerated(value = EnumType.ORDINAL)
    private Status status = Status.ACTIVE;

    public Developer() {}

    public Developer(Integer id, String firstName, String lastName, Status status,
                     List<Skill> skills, Specialty specialty) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.specialty = specialty;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Developer developer)) return false;
        return id.equals(developer.id) && firstName.equals(developer.firstName) &&
               lastName.equals(developer.lastName) && skills.equals(developer.skills) &&
               specialty.equals(developer.specialty) && status == developer.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, skills, specialty, status);
    }

    @Override
    public String toString() {
        return "Developer{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", skills=" + skills +
            ", specialty=" + specialty +
            ", status=" + status +
            '}';
    }
}
