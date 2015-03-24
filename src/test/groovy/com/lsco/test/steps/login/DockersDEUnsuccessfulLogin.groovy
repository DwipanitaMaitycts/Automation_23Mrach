package com.lsco.test.steps.login

import com.lsco.test.DEDockersSmoke
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

class DockersDEUnsuccessfulLogin extends GebSpec {
	@DEDockersSmoke
	def "fillingUnsuccesfulLoginDetailsDockersDE SPRING-15637"()
	{
		when: "going to Dockers DE Home Page and clicking on My Account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Dockers DE Login Page"
		at LevisLoginPage
		
		when: "user is at Account Registration page"
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
