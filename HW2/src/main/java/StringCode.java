package main.java;

import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int res = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			int j = i;
			while (j < str.length() && str.charAt(i) == str.charAt(j)) {
				j++;
			}
			res = Math.max(res, j - i);
			i = j - 1;
		}
		return res;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				if (i + 1 < str.length()) {
					for (int j = 0; j < c - '0'; j++) {
						res.append(str.charAt(i + 1));
					}
				}
			}
			else res.append(c);
		}
		return res.toString();
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		int [][] dp = new int[a.length()][b.length()];
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) {
					if (i > 0 && j > 0) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} else dp[i][j] = 1;
				}
				else dp[i][j] = 0;
				if (dp[i][j] >= len) return true;
			}
		}
		return false; // YOUR CODE HERE
	}
}
