import java.util.HashSet;


// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int n = str.length();
		if(n == 0 ) return 0;
		int [] dp = new int[n];
		dp[0] = 1;

		for(int i=1; i<n; i++){
			if(str.charAt(i) == str.charAt(i-1)) {
				dp[i] = dp[i-1] + 1;
			}else{
				dp[i] = 1;
			}
		}

		int max = dp[0];
		for (int i = 1; i < dp.length; i++) {
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		int n = str.length();
		StringBuilder s = new StringBuilder();
		for(int i=0; i<n - 1; i++){
			if (Character.isDigit(str.charAt(i))) {
				int x = str.charAt(i) - '0';
				while (x-- > 0) {
					s.append(str.charAt(i + 1));
				}
			} else {
				s.append(str.charAt(i));
			}
		}
		if(!Character.isDigit(str.charAt(n - 1))) {
			s.append(str.charAt(n-1));
		}
		return s.toString();
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		if(a == null || b == null || len <= 0) return false;
		if(len > a.length() || len > b.length()) return false;

		HashSet<String> set = new HashSet<>();

		for(int i=0; i <= a.length() - len; i++){
			set.add(a.substring(i, i + len));
		}

		for(int i=0; i < b.length(); i++){
			if (set.contains(b.substring(i, i+len))) {
				return true;
			}
		}

		return false;
	}
}
