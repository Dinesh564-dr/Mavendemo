package day14;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extentreportclass {
	@Test
	public void generatereport() {
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter("./report/extentreport.html");
		ExtentReports report = new ExtentReports();
		report.attachReporter(htmlreporter);
		ExtentTest test =report.createTest("verify homepage");
		test.info("landing on homepage");
		test.pass("homepage verified");
		report.flush();
		
		ExtentTest test1 =report.createTest("verify loginpage");
		test1.info("landing on login page");
		test1.fail("login failed");
		report.flush();
		
	}
}
