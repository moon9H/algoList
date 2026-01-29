package APC;
import java.util.Scanner;
import java.util.Stack;

public class BOJ9012 {
	static boolean isVPS(String paren){
		Stack<Character> stack = new Stack<>();
		for (char c : paren.toCharArray()){
			if (c == '('){
				stack.push(c);
			} else {
				if (stack.isEmpty()){
					return false;
				} else {
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++){
			String parenthesis = sc.next();
			if (isVPS(parenthesis)){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
