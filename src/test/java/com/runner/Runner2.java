package com.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import org.testng.TestNG;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Runner2 {

	// Your runner class that takes runtime parameters
	static class YourRunnerClass {
		private String env;
		private String testType;
		private String component;

		public YourRunnerClass(String env, String testType, String component) {
			this.env = env;
			this.testType = testType;
			this.component = component;
		}

		public void runTest() {
			// Implement the logic for running your test
			System.out
					.println("Running test for env: " + env + ", test type: " + testType + ", component: " + component);

			String name = component + "-" + testType;

			System.out.println(component);
			System.out.println(testType);

			TestNG testNG = new TestNG();

			XmlSuite suite = new XmlSuite();
			suite.setName("Amazon Test Suite"); // <suite name="Suite1" verbose="1">
			suite.setVerbose(1);

			XmlTest myTest = new XmlTest(suite);
			myTest.setName(name + "_MyTest"); // <test name="API-Sanity_MyTest">

			// <package name = "com.ui.tests">
			XmlPackage xmlPackage1 = new XmlPackage("com." + component + ".tests");
			List<XmlPackage> packageList = new ArrayList<XmlPackage>();
			packageList.add(xmlPackage1);
			myTest.setPackages(packageList);
			; // *************

			/*
			 * 
			 * <test name="API Tests">
			 * 
			 * <packages> <package name="com.ui.tests"></package> </packages> </test>
			 */

			myTest.addIncludedGroup(testType); //
		// myTest.setParallel(ParallelMode.METHODS);

			List<XmlTest> myListTests = new ArrayList<XmlTest>();
			myListTests.add(myTest);
			suite.setTests(myListTests);

			List<XmlSuite> suiteList = new ArrayList<XmlSuite>();
			suiteList.add(suite);
			testNG.setXmlSuites(suiteList);

			testNG.run(); // Start the execution of your tests...Fs
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Define your list of test parameters
		List<TestParams> testParameters = new ArrayList<>();
		testParameters.add(new TestParams("dev", "sanity", "ui"));
		testParameters.add(new TestParams("qa", "sanity", "ui"));
		// Add more test parameters as needed

		// Use ExecutorService to run tests in parallel
		ExecutorService executorService = Executors.newFixedThreadPool(testParameters.size());
		List<Future<?>> futures = new ArrayList<>();

		for (TestParams params : testParameters) {
			// Submit the runTest task for each set of parameters
			Future<?> future = executorService.submit(() -> {
				YourRunnerClass runner = new YourRunnerClass(params.env, params.testType, params.component);
				runner.runTest();
			});
			futures.add(future);
		}

		// Wait for all tests to complete
		for (Future<?> future : futures) {
			future.get(); // This will block until the task is completed
		}

		// Shut down the executor service
		executorService.shutdown();
	}

	// Class to hold test parameters
	static class TestParams {
		private String env;
		private String testType;
		private String component;

		public TestParams(String env, String testType, String component) {
			this.env = env;
			this.testType = testType;
			this.component = component;
		}
	}
}
