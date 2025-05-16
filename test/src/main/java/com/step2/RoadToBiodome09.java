package com.step2;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
    ex1)
    input = 101111 101010 101011 111011 111111
    result = 9

    ex2)
    input = 101 110 011
    result = 4

    ex3)
    input = 11011 01100 00111 10010 11110 10111
    result = 9
→ 4
*/
public class RoadToBiodome09 {
    static int[][] move = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        Queue<int[]> q = new LinkedList<>();
        int n = args.length, m = args[0].length();
        String[][] map = new String[n][m];

        for (int i = 0; i < args.length; i++) {
            map[i] = args[i].split("");
        }

        q.offer(new int[]{0, 0, 0, 4});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0], cy = current[1], count = current[2], direction = current[3];

            if (cx == n - 1 && cy == m -1) {
                System.out.println(count);
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
