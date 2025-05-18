package com.step2;

import java.util.LinkedList;
import java.util.Queue;

public class RoadToBiodome09 {
    static int[][] move = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        Queue<int[]> q = new LinkedList<>();
        int n = args.length, m = args[0].length();
        String[][] map = new String[n][m];

        for (int i = 0; i < args.length; i++) {
            map[i] = args[i].split("");
            for (String s : map[i]) {
                System.out.print(s+ " ");
            }
            System.out.println();
        }


        q.offer(new int[]{0, 0, 0, 4});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0], cy = current[1], count = current[2], direction = current[3];

            if (cx == n - 1 && cy == m -1) {
                System.out.println("answer = "+count);
                System.exit(0);
            }

            for (int i = 0; i <4 ; i++) {
                int nx = cx + move[i][0], ny = cy + move[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny].equals("0") || Math.abs(direction - i) == 1) continue;

                q.offer(new int[]{nx, ny, count +1, i});
            }

        }
    }
}
