import java.util.*;
public class SingularpairCount {
    public static void main(String[] args) {
        int totalcount=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter the elements: ");
        for(int i=0;i<n;i++) 
            arr[i] = sc.nextInt();
        sc.close();

        HashSet<Integer> s = new HashSet<Integer>();
        for(int i:arr)  s.add(i);

        for(int i:s) {
            int temp = i;
           int  count = 0;
        for(int j=0;j<arr.length;j++) {
                if(temp == arr[j]) count++;
        }
        if( count%2 != 0 ) totalcount++;
        }

        System.out.print("The count of singular socks is: "+ totalcount);

    }
}

