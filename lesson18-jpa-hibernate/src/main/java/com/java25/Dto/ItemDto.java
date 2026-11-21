package com.java25.Dto;

import com.java25.common.Color;
import com.java25.common.Status;

import java.math.BigDecimal;

public class ItemDto {
    private Long id;
    private String name;
    private Color color;
    private BigDecimal buyPrice;
    private String material;
    private ItemGroupDto group;

    public ItemDto() {
    }

    public ItemDto(Long id, String name, Color color, BigDecimal buyPrice, String material,
                   Long groupId, String groupName, Status groupStatus) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.buyPrice = buyPrice;
        this.material = material;
        this.group = new ItemGroupDto(groupId, groupName, groupStatus);
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

    public ItemGroupDto getGroup() {
        return group;
    }

    public void setGroup(ItemGroupDto group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color=" + color +
                ", buyPrice=" + buyPrice +
                ", material='" + material + '\'' +
                ", group=" + group +
                '}';
    }
}
