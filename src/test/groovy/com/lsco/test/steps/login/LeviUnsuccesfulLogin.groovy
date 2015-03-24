package com.lsco.test.steps.login

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
class LeviUnsuccesfulLogin extends GebSpec {

	@GBLevisSmoke
	def "fillingUnsuccesfulLoginDetails SPRING-15579"()
	{
		when: "going to Levis Home Page and clicking on My account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Levis Login Page"
		at LevisLoginPage
		
		when: "user is at account registration page"
		at AccountRegistrationPage
		fillingRegInfoRandomEmail()
		clickAgeCheckBoxOption()
		submitRegistrationForm()
		clickNotTodayLink()
		unsuccessfulLoginFromProfilePage()
		
		then: "verifying the unsuccessful Login Error Message."
		verifyUnsuccessfulLoginErrorTxt()
		}

}
