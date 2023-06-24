package telran.performance;

public abstract class PerformanceTest {
	private String testName;
	private int nRuns;
	
	public PerformanceTest(String testName, int nRuns) {
		this.testName = testName;
		this.nRuns = nRuns;
	}
	
	protected abstract void runTest();
	
	public void run() {
		long start = System.currentTimeMillis();
		for(int i = 0; i < nRuns; i++) {
			runTest();
		}
		long finish = System.currentTimeMillis();
		System.out.println("Value of nRuns = " + nRuns + " Test Name: " + testName + " Run Time: " +  (finish - start) + " ms");
	}

}
