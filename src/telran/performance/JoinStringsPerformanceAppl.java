package telran.performance;

import telran.strings.JoinStringsBuilderImpl;
import telran.strings.JoinStringsImpl;

public class JoinStringsPerformanceAppl {
	private static final int N_STRINGS = 1000;
	private static final int N_RUNS = 1000;

	public static void main(String[] args) {
		String[] strings = getStrings();
		new JoinStringsPerformanceTest("Regular String", N_RUNS, strings, new JoinStringsImpl(), "#").run();;
		new JoinStringsPerformanceTest("StringBuilder", N_RUNS, strings, new JoinStringsBuilderImpl(),"#").run();
		
		


	}
	private static String[] getStrings() {
		String[] res = new String[N_STRINGS];
		for(int i = 0; i < N_STRINGS; i++) {
			res[i] = "letter";
		}
		return res;
	}

}
