package view.list;

import java.util.List;

import bean.Item;
import model.DataModel;

import static utils.PrintUtils.*;
import static model.DataModel.*;

public class Ex03CustomeObjectType {
    public static void main(String[] args) {
        List<Item> items = DataModel.mockItems();
        
        System.out.println("items size: " + items.size());
        generateItems("1. Danh sách các ptu", items);
        
        // Tạo một đối tượng Item để kiểm tra
        Item itemA2 = new Item(2, "Item A2", bd("181"), toDate("12/12/2022"), 101);
        
        //Duyệt từng ptu trong items, nêu có ptu nào equals với itemA2 --> true else(false)
        //Hàm equals mặc định sử dụng từ class Object -->so sánh == địa chỉ
        //Muốn so sánh theo gtri bên trong các thuọc tính của class --> override hàm equals
        boolean isExists = items.contains(itemA2);
        System.out.println("2. Kiem tra itemA2 có tồn tại trong items không --> " + isExists);
        
      //Duyệt từng ptu trong items, nêu có ptu nào equals với itemB4 --> thực hiện
        Item itemB4 = new Item(2, "Item B4", bd("888"), toDate("16/12/2023"), 101);
        items.remove(itemB4);
        generateItems("3. Danh sách các ptu(sau khi xóa itemB4", items);
        
        
        //Best practice: khi tạo class làm object lưu trữ --> constructor, getter/setter, equals
        
        
    }
}