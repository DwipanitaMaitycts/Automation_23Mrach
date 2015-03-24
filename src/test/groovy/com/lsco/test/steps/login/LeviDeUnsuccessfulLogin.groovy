package com.lsco.test.steps.login

import com.lsco.test.DELevisSmoke
import spock.lang.Specification
import geb.spock.GebReportingSpec
import gherkin.formatter.model.Feature
import junit.framework.Test
import geb.spock.GebReportingSpec
import geb.spock.GebSpec
import geb.Browser
import com.lsco.test.page.register.AccountRegistrationPage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.login.LevisMyAccountPage
import com.lsco.test.page.LevisHomePage

class LeviDeUnsuccessfulLogin extends GebSpec {
	@DELevisSmoke
	def "fillingUnsuccesfulLoginDetailsLevisDE SPRING-15612"()
	{
		when: "going to Levis De Home Page and clicking on My account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Levis De Login Page"
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
