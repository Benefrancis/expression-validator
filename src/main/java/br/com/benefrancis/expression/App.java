package br.com.benefrancis.expression;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class App {
	private static HashMap<Character, Character> tags = new HashMap<>();

	static {
		tags.put('}', '{');
		tags.put(')', '(');
		tags.put(']', '[');
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String expression = in.next();

		Stack<Character> open = new Stack<>();

		boolean resposta = true;

		for (Character c : expression.toCharArray()) {

			if (tags.values().contains(c)) {
				open.add(c);
			}

			if (tags.keySet().contains(c)) {
				if (open.isEmpty() || open.pop() != tags.get(c)) {
					resposta = false;
					break;
				}
			}
		}

		resposta &= open.isEmpty();

		System.out.println(resposta);

		in.close();
	}

}
