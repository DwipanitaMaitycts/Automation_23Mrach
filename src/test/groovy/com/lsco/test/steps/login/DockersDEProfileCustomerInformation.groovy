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

class DockersDEProfileCustomerInformation extends GebSpec {
	@DEDockersSmoke
	def "dockersDEProfileCustomerInformation 15874"()
	{
		when: "going to dockers DE Home page and clicking on My Account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at dockers DE Login Page"
		at LevisLoginPage
		
		when: "user is at Account Registration Page"
		at AccountRegistrationPage
		fillingRegInfoRandomEmail()
		clickAgeCheckBoxOption()
		submitRegistrationForm()
		clickNotTodayLink()
		
		
		then: "verifying the update Profile functionality"
		updateProfileInfo()
		}

}
