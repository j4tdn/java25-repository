package com.java25.persistence;


import com.java25.common.Status;
import com.java25.converter.StatusConverter;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T02_ITEM_GROUP")
public class ItemGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C02_ITEM_GROUP_ID")
    private Long id;

    @Column(name = "C02_ITEM_GROUP_NAME")
    private String name;

    @Convert(converter = StatusConverter.class)
    @Column(name = "C02_STATUS")
    private Status status;

    @OneToMany
    private List<Item> items = new ArrayList<>();



    public ItemGroup() {
    }

    public ItemGroup(Long id, String name, Status status) {
        this.id = id;
        this.name = name;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ItemGroup that)) {
            return false;
        }
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ItemGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}