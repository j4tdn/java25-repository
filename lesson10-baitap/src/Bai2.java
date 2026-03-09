public class Bai2 {

    public static void main(String[] args) {

        int[][] maTran = {
                {1, 2, 3, 4},
                {5, 0, 8, 7},
                {1, 9, 0, 9},
                {2, 0, 6, 5},
                {1, 2, 4, 5}
        };

        int soDong = maTran.length;
        int soCot = maTran[0].length;

        boolean[] dongCo0 = new boolean[soDong];
        boolean[] cotCo0 = new boolean[soCot];

        for (int i = 0; i < soDong; i++)
            for (int j = 0; j < soCot; j++)
                if (maTran[i][j] == 0) {
                    dongCo0[i] = true;
                    cotCo0[j] = true;
                }

        for (int i = 0; i < soDong; i++)
            for (int j = 0; j < soCot; j++)
                if (dongCo0[i] || cotCo0[j])
                    maTran[i][j] = 0;

        for (int[] hang : maTran) {
            for (int x : hang)
                System.out.print(x + "\t");
            System.out.println();
        }
    }
}