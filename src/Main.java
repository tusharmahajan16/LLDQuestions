import java.util.*;

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
        //UserSystem.out.println(andreaPoints+" "+mariaPoints);
        if (andreaPoints > mariaPoints) {
            return "Andrea";
        }
        return "Maria";
    }

    static class Pair implements Comparable<Pair> {
        int d;
        int v;

        Pair(int d, int v) {
            this.d = d;
            this.v = v;
        }

        @Override
        public int compareTo(Pair p) {
            return this.d - p.d;
        }
    }

    public static int minimumEdgeReversal(int[][] edges, int n, int m, int src, int dst) {
        // code here
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {

            adj.get(edges[i][0]).add(new ArrayList<>(List.of(edges[i][1], 0)));
            adj.get(edges[i][1]).add(new ArrayList<>(List.of(edges[i][0], 1)));
        }
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        distance[src] = 0;
        pq.add(new Pair(0, src));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            for (List<Integer> nbr : adj.get(curr.v)) {
                if (curr.d + nbr.get(1) < distance[nbr.get(0)]) {
                    distance[nbr.get(0)] = curr.d + nbr.get(1);
                    pq.add(new Pair(distance[nbr.get(0)], nbr.get(0)));
                }
            }
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

    public String decodeString(String s) {
        Stack<StringBuilder> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ']') {
                StringBuilder curr = new StringBuilder();
                while (!st1.peek().toString().equals("[")) {
                    curr.append(st1.pop());
                }
                st1.pop();
                int num = st2.pop();
                curr.repeat(curr.toString(), num - 1);
                st1.push(curr);

            } else if (Character.isDigit(c)) {
                int num = 0;
                while (Character.isDigit(s.charAt(i))) {
                    num = (s.charAt(i) - '0') + num * 10;
                    i++;
                }
                i--;
                st2.push(num);
            } else {
                st1.push(new StringBuilder().append(c));
            }
        }
        StringBuilder res = new StringBuilder();
        while (!st1.isEmpty()) {
            res.append(st1.pop());
        }
        return res.reverse().toString();
    }

  

    public static void main(String[] args) {
//        List<Integer> andrea = Arrays.asList(3, 5, 6);
//        List<Integer> maria = Arrays.asList(4, 5, 7);
//        System.out.print(winner(andrea, maria, "Even"));// Example usage
//
//        int[][] edges = {{1, 3},{3,2},{2,1}};
//        System.out.println(minimumEdgeReversal(edges, 3, 3, 3, 1));

        Main main = new Main();
        System.out.println(main.decodeString("2[abc]3[cd]ef"));
        String str = "";

    }
}
