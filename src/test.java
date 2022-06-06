import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
//        quickSort(nums, 0, n - 1);
        for(int i = 0; i < n; i++){
            System.out.print(nums[i] + " ");
        }
    }
    public static void quickSort(int[] nums, int L, int R){
        if(L < R){
            int index = quickIndex(nums, L , R);
            quickIndex(nums, L , index);
            quickIndex(nums, index + 1, R);
        }
    }
    public static int quickIndex(int[] nums, int L, int R){
        int random = new Random().nextInt(R - L) + L;
        int flag = nums[random];
        swap(nums, L , random);
        int index = L + 1;
        for(int i = L + 1; i <= R; i++){
            if(nums[i] < flag){
                swap(nums, i, index++);
            }
        }
        index--;
        swap(nums, L, index);
        return index;
    }

    public static void swap(int[] nums, int i, int j){
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }
}