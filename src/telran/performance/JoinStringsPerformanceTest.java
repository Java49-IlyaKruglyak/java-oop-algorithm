package telran.performance;

import telran.strings.JoinStrings;

public class JoinStringsPerformanceTest extends PerformanceTest {
	
	private String[] strings;
	private JoinStrings joinStrings;
	private String delimiter = "#";

	public JoinStringsPerformanceTest(String testName, int nRuns, String[] strings, JoinStrings joinStrings, String delimiter) {
		super(testName, nRuns);
		this.joinStrings = joinStrings;
		this.strings = strings;
		this.delimiter = delimiter;

	}

	@Override
	protected void runTest() {
		joinStrings.join(strings, delimiter);

	}

}
