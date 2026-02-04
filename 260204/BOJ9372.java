package com.ssafy.ATS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                st.nextToken();
            }

            // 문제에서 연결 그래프가 보장되므로, 모든 나라를 방문하기 위한 최소 비행기 종류 = 스패닝 트리 간선 수 = N - 1
            sb.append(N - 1).append("\n");
        }
        System.out.println(sb.toString());
    }
}