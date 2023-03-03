package com.azamat_komaev.crudapp.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity @Table(name = "skills")
public class Skill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column @Enumerated(value = EnumType.ORDINAL)
    private Status status = Status.ACTIVE;

    public Skill() {}

    public Skill(Integer id, String name, Status status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Skill{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", status=" + status +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill skill)) return false;
        return id.equals(skill.id) && Objects.equals(name, skill.name) && status == skill.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
