package utils

import org.testng.ITestListener
import org.influxdb.dto.Point
import org.testng.ITestContext
import org.testng.ITestResult
import java.util.concurrent.TimeUnit

import helpers.Utils


class InfluxDBListener extends ITestListener {

  final val startTime = new Utils().getCurrentDateTime
  var failedMethods: Int = 0

  def onTestStart(iTestResult: ITestResult): Unit = {
  }

  def onTestSuccess(iTestResult: ITestResult): Unit = {

    this.postTestMethodStatus(iTestResult, "PASS")
  }

  def onTestFailure(iTestResult: ITestResult): Unit = {

    this.postTestMethodStatus(iTestResult, "FAIL")
    this.failedMethods+=1
  }

  def onTestSkipped(iTestResult: ITestResult): Unit = {

    this.postTestMethodStatus(iTestResult, "SKIPPED")
  }

  def onTestFailedButWithinSuccessPercentage(iTestResult: ITestResult): Unit = {
  }

  def onStart(iTestContext: ITestContext): Unit = {
  }

  def onFinish(iTestContext: ITestContext): Unit = {
    this.postTestClassStatus(iTestContext)
    this.postTestRunStatus
  }

  private def postTestMethodStatus(iTestResult: ITestResult, status: String): Unit = {
    val point = Point.measurement("testmethod")
                .time(System.currentTimeMillis, TimeUnit.MILLISECONDS)
                .tag("testRun",startTime)
                .tag("testclass", iTestResult.getTestClass.getName)
                .tag("name", iTestResult.getName)
                .tag("description", iTestResult.getMethod.getDescription)
                .tag("result", status)
                .addField("duration", iTestResult.getEndMillis - iTestResult.getStartMillis)
                .build
    UpdateResults.post(point)
  }

  private def postTestClassStatus(iTestContext: ITestContext): Unit = {
    var testClassStatus = "Pass"
    if (this.failedMethods>0)
      testClassStatus = "Fail"

    val point = Point.measurement("testclass")
                .time(System.currentTimeMillis, TimeUnit.MILLISECONDS)
                .tag("testRun",startTime)
                .tag("name", iTestContext.getAllTestMethods()(0).getTestClass.getName)
                .tag("status", testClassStatus)
                .addField("duration", iTestContext.getEndDate.getTime - iTestContext.getStartDate.getTime)
                .build
    UpdateResults.post(point)
  }

  private def postTestRunStatus : Unit = {
    var testRunStatus = "Pass"
    if (this.failedMethods>0)
      testRunStatus = "Fail"

    val point = Point.measurement("testrun")
      .time(System.currentTimeMillis, TimeUnit.MILLISECONDS)
      .addField("name",startTime)
      .tag("status", testRunStatus)
      .build
    UpdateResults.post(point)
  }
}
