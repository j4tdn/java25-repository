package dao;

import java.util.List;
import persistence.ItemGroup;

public interface ItemGroupDao {

    List<ItemGroup> getAll();

    List<ItemGroup> getItemGroups();

    ItemGroup get(int id);

    ItemGroup get(String name);

    boolean add(ItemGroup itemGroup);

    boolean update(ItemGroup itemGroup);

    int addAll(List<ItemGroup> itemGroups);
}
