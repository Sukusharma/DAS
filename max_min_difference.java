import java.util.Scanner;

public class max_min_difference {
    public static int smallestMaxDifference(int[] arr, int k) {
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i <= n-k ; i++){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int j = i;j < i+k ; j++){
                 max = Math.max(max, arr[j]);
                 min = Math.min(min, arr[j]);
            }
            int diff = max-min;
            minDiff = Math.min(diff,minDiff);


        }
        return minDiff;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        
        int result = smallestMaxDifference(arr, k);
        System.out.println(result);
    }
}