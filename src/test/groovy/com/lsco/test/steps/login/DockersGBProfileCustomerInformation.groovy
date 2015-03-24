package com.lsco.test.steps.login

import com.lsco.test.GBDockersSmoke
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

class DockersGBProfileCustomerInformation extends GebSpec {
	@GBDockersSmoke
	def "profileCustomerInformationDockersGB SPRING-15870"()
	{
		when: "going to DockersGB Home page and clicking on My Account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Dockers GB Login Page"
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
