package com.ssafy.ATS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1991 {
	public static class Node{
		String data;
		Node left;
		Node right;
		public Node (String data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	public static String dfsByPreOrder(Node current) {
		if (current == null) {
			return "";
		}
		String left = current.data;
		String mid = dfsByPreOrder(current.left);
		String right = dfsByPreOrder(current.right);
		
		return left + mid + right;
	}
	public static String dfsByInOrder(Node current) {
		if (current == null) {
			return "";
		}
		String left = dfsByInOrder(current.left);
		String mid = current.data;
		String right = dfsByInOrder(current.right);
		
		return left + mid + right;
	}
	public static String dfsByPostOrder(Node current) {
		if (current == null) {
			return "";
		}
		String left = dfsByPostOrder(current.left);
		String mid = dfsByPostOrder(current.right);
		String right = current.data;
		
		return left + mid + right;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		// 노드를 관리할 배열 선언
		Node[] nodes = new Node[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String parent = st.nextToken();
			// 인덱싱을 통해 문자에 맞게 노드 저장
			if (nodes[parent.charAt(0) - 'A'] == null) {
				nodes[parent.charAt(0) - 'A'] = new Node(parent);
			}
			String child1 = st.nextToken();
			if (!child1.equals(".")) {
				if (nodes[child1.charAt(0) - 'A'] == null) {
					nodes[child1.charAt(0) - 'A'] = new Node(child1);
					 
				}
				nodes[parent.charAt(0) - 'A'].left = nodes[child1.charAt(0) - 'A'];
			}
			String child2 = st.nextToken();
			if (!child2.equals(".")) {
				if (nodes[child2.charAt(0) - 'A'] == null) {
					nodes[child2.charAt(0) - 'A'] = new Node(child2);
					 
				}
				nodes[parent.charAt(0) - 'A'].right = nodes[child2.charAt(0) - 'A'];
			}
		}
		sb.append(dfsByPreOrder(nodes[0])).append("\n").append(dfsByInOrder(nodes[0])).append("\n").append(dfsByPostOrder(nodes[0])).append("\n");
		System.out.println(sb.toString());
	}
}