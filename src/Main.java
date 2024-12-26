import java.util.Arrays;
import java.util.List;

public class Main {

//        public static int countValidSubstrings(String s, int minLen, int maxLen) {
//            int count = 0;
//            int n = s.length();
//            boolean[] isValid = new boolean[n - 1];
//            for (int i = 0; i < n - 1; i++) {
//                isValid[i] = s.charAt(i) != s.charAt(i + 1);
//            }
//            for (int length = minLen; length <= maxLen; length++) {
//                for (int start = 0; start <= n - length; start++) {
//                    boolean valid = true;
//                    for (int i = start; i < start + length-1; i++) {
//                        if (!isValid[i]) { // If there's an invalid adjacent pair
//                            valid = false;
//                            break;
//                        }
//                    }
//                    if (valid) {
//                        count++;
//                    }
//                }
//            }
//
//            return count;
//        }

    public static String winner(List<Integer> andrea, List<Integer> maria, String s) {
        int andreaPoints = 0;
        int mariaPoints = 0;
        for (int i = 0; i < andrea.size(); i++) {
            if (s.equalsIgnoreCase("even")) {
                if (i % 2 == 0) {
                    andreaPoints += andrea.get(i) - maria.get(i);
                    mariaPoints += maria.get(i) - andrea.get(i);
                }
            } else {
                if (i % 2 != 0) {
                    andreaPoints += andrea.get(i) - maria.get(i);
                    mariaPoints += maria.get(i) - andrea.get(i);
                }
            }
        }
        //System.out.println(andreaPoints+" "+mariaPoints);
        if (andreaPoints > mariaPoints) {
            return "Andrea";
        }
        return "Maria";
    }

    public static void main(String[] args) {
        List<Integer> andrea = Arrays.asList(3, 5, 6);
        List<Integer> maria = Arrays.asList(4, 5, 7);
        System.out.print(winner(andrea, maria, "Even"));// Example usage

    }
}
