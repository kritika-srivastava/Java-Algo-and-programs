
/**
 * C:\Users\kriti\Desktop\DS\Target 450\q7.java
 * @author Kritika Srivastava
 * @since February 03, 2021
 *
 * Link - https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1
 */

import java.io.*;

class q7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int) (n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }

            Compute obj = new Compute();
            obj.rotate(a, n);

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < n; i++)
                output.append(a[i] + " ");
            System.out.println(output);

        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Compute {

    public void rotate(long arr[], long n) {
        long temp = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;

    }
}