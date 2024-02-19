package jwon.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_240220_리모컨_1107 {
    static boolean[] arr;
    static int min;
    static ArrayList<Integer> list;
    static int n;
    static int maxSize;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new boolean[10];
        Arrays.fill(arr, true);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int channel = Integer.parseInt(st.nextToken());
            arr[channel] = false;
        }
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (arr[i]) {
                list.add(i);
            }
        }
        min = Integer.MAX_VALUE;
        int num = 100;
        int count = 0;
        while (num != n) {
            if (num > n) {
                count++;
                num--;
            } else if (num < n) {
                count++;
                num++;
            }
        }
        min = Math.min(min, count);
        StringBuilder sb = new StringBuilder();
        maxSize = String.valueOf(n).length();
        permu(sb);
        System.out.println(min);
    }

    private static void permu(StringBuilder sb) {
        if (!sb.toString().isEmpty() && sb.length() <= maxSize + 1 && sb.length() >= maxSize - 1) {
            int num = Integer.parseInt(sb.toString());
            int count = sb.length();

            while(num != n){
                if(num > n){
                    num--;
                    count++;
                }else if(num < n){
                    num++;
                    count++;
                }
            }
            min = Math.min(min, count);
        }
        if(sb.length() == maxSize + 1){
            return ;
        }
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            permu(sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
