package com.lsco.test.steps.register

import com.lsco.test.GBLevisSmoke
import spock.lang.Specification
import geb.spock.GebReportingSpec
import gherkin.formatter.model.Feature
import junit.framework.Test
import geb.spock.GebReportingSpec;
import geb.spock.GebSpec;
import geb.Browser
import com.lsco.test.page.register.AccountRegistrationPage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.login.LevisMyAccountPage
import com.lsco.test.page.LevisHomePage

import org.openqa.selenium.WebDriver

import org.openqa.selenium.firefox.FirefoxDriver

public class LeviUnsuccessfulRegisterSteps extends GebSpec {
	@GBLevisSmoke
	def "fillingUnsuccessfulRegisterDetails SPRING-15576"()
	{
		when: "going to Levis Home Page and clicking on My account"
		to LevisHomePage
		at LevisHomePage
		dismissPopup()
		toMyAccountPage()
		
		
		then: "user is at Levis Login Page"
		at LevisLoginPage
		
		when: "user is at account registration page"
		at AccountRegistrationPage
		fillingRegistrationInformation()
		clickAgeCheckBoxOption()
		submitRegistrationForm()
		verifyInvalidEmailTxtForRegistration()
		
		then: "invalid email text for registration verified"
		println "success"
		}
}
