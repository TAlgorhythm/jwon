package jwon.programmers;

import java.util.Arrays;

public class P_240422_이진변환반복하기 {
  public static int[] solution(String s) {
    int[] answer = new int[2];
    int zeroCount = 0;
    int count = 0;
    int num = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      num |= Integer.valueOf(s.charAt(i));
    }
    while (num != 1) {
      count++;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '1') {
          sb.append("1");
        } else {
          zeroCount++;
        }
      }
      Integer len = sb.length();
      sb = new StringBuilder();
      while (len > 0) {
        sb.append(len % 2);
        len /= 2;
      }
      s = sb.toString();
      num = 0;
      for (int i = s.length() - 1; i >= 0; i--) {
        num |= Integer.valueOf(s.charAt(i));
      }
    }
    answer[0] = count;
    answer[1] = zeroCount;
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution("110010101001")));

  }
}
