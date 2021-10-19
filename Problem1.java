import java.io.*;

public class Sorting {
    static int arrange_even_odd(int arr[], int n) {
        int j = -1, temp, count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {

                count++;
                j++;

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return count;
    }
    static void sort_descending(int arr[],int count,int n) {
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = count; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }


            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,9,8,10,5};
        int n = arr.length;

        int count = arrange_even_odd(arr, n);
        sort_descending(arr,count,n);


        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");

        }
    }
}