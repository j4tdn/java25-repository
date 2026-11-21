package com.java25.persistence;

import com.java25.common.Color;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "T01_ITEM")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C01_ITEM_ID")
    private Long id;

    @Column(name = "C01_ITEM_NAME")
    private String name;

    @Column(name = "C01_BUY_PRICE")
    private BigDecimal buyPrice;

    @Column(name = "C01_MATERIAL")
    private String material;

    @Enumerated(EnumType.STRING)
    @Column(name = "C01_COLOR")
    private Color color;

    @Column(name = "C01_ITEM_GROUP_ID")
    private Long groupId;

//    @ManyToOne
//    @JoinColumn()

    /**
     * Default Constructor
     */
    public Item() {
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

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(!(o instanceof Item that)) {
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
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", buyPrice=" + buyPrice +
                ", material='" + material + '\'' +
                ", color=" + color +
                '}';
    }
}
