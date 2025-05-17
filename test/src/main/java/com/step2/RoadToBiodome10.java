package com.step2;

import java.util.Stack;

public class RoadToBiodome10 {
    static boolean[] visited = new boolean[100];
    static boolean[][] graph = new boolean[100][100];
    static boolean[] exists = new boolean[100];

    public static void main(String[] args) {
        for (String arg : args) {
            String[] info = arg.split(",");
            int relation1 = Integer.parseInt(info[0]),
                    relation2 = Integer.parseInt(info[1]);

            graph[relation1 - 1][relation2 - 1] = true;
            graph[relation2 - 1][relation1 - 1] = true;

            exists[relation1 - 1] = true;
            exists[relation2 - 1] = true;

        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            if (exists[i] && !visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int start) {
        Stack<Integer> s = new Stack<>();
        s.push(start);
        visited[start] = true;

        while (!s.isEmpty()) {
            int current = s.pop();

            for (int i = 0; i < 100; i++) {
                if (graph[current][i] && !visited[i]) {
                    s.push(i);
                    visited[i] = true;
                }
            }
        }
    }
}
