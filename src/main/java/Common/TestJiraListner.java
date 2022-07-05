package Common;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestJiraListner implements ITestListener {

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		JiraPolicy jirapolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
		boolean isTiscketReady = jirapolicy.logTicketReady();
		if(isTiscketReady) {
			//Raise a ticket
			System.out.println("Bug is raised in Jira");
			JiraServiceProvider sp = new JiraServiceProvider("https://vvsxilligence.atlassian.net/", "vishnu.vs@xilligence.com", "yqOtTDWreO4grg9DVkGR0B86", "DEM");
			String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName()+" got failed";
			String issueDesc = result.getThrowable().getMessage()+"\n";
			issueDesc.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
			try {
				sp.createJiraTicket("Bug", issueSummary, issueDesc, "Report");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	



}
