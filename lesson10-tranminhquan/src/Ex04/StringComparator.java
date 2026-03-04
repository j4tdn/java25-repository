package Ex04;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {

    private SortOrder order;

    public StringComparator(SortOrder order) {
        this.order = order;
    }

    @Override
    public int compare(String a, String b) {

        // Xử lý null trước
        if (a == null && b == null) return 0;
        if (a == null) return order == SortOrder.ASC ? 1 : -1;
        if (b == null) return order == SortOrder.ASC ? -1 : 1;

        int groupA = (order == SortOrder.ASC)
                ? StringGroupUtil.getGroupAsc(a)
                : StringGroupUtil.getGroupDesc(a);

        int groupB = (order == SortOrder.ASC)
                ? StringGroupUtil.getGroupAsc(b)
                : StringGroupUtil.getGroupDesc(b);

        // Khác nhóm
        if (groupA != groupB) {
            return groupA - groupB;
        }

        // Cùng nhóm → so giá trị
        switch (groupA) {
            case 1: // chuỗi
                return order == SortOrder.ASC
                        ? a.compareTo(b)
                        : b.compareTo(a);

            case 2: // số dương
            case 3: // số âm
                int x = Integer.parseInt(a);
                int y = Integer.parseInt(b);
                return order == SortOrder.ASC ? x - y : y - x;

            default: // Special hoặc null
                return 0;
        }
    }
}