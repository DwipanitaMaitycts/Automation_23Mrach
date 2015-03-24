package com.lsco.test.steps.register

import com.lsco.test.GBDockersSmoke
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

class DockersGBUnsuccessfulRegisterSteps extends GebSpec{
	@GBDockersSmoke
	def "dockersGBfillingUnsuccessfulRegisterDetails SPRING-15582"()
	{
		when: "going to Dockers Home Page and clicking on My account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Dockers Login Page"
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
