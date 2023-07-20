package dayFour;

public class shellSort {
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for(int i = 0; i < args.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }
        int n = arr.length;
        int gap = (int)Math.pow(n, 2) - 1;
        int temp;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            gap /= 2;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
