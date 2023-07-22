import java.util.*;
public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++) 
            arr[i] = sc.nextInt();
        sc.close();
        System.out.println("The missing elements are: ");

        HashSet<Integer> s = new HashSet<Integer>();
        int  max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        for(int i:arr)
            s.add(i);

        for(int i=min;i<=max;i++) {
            if(!s.contains(i))
                System.out.print(i+" ");
        }
    }
}
