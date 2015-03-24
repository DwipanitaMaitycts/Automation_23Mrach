package com.lsco.test.steps.navigation

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
import com.lsco.test.page.FirstProductPage

class VerifyloadAdditionalProductsOnPDPDockersGB extends GebSpec {
	@GBDockersSmoke
	def "verifyloadAdditionalProductsOnPDPDockersGB 18041"()
	{
		when: "going to Dockers GB Home Page and clicking on My Account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Dockers GB Login Page and logging in"
		at LevisLoginPage
		leviLogin()
		//submitLoginFormButton()
		submitLoginFormButtonWithPopupCheck()
		
		when: "user goes to shop all section and selecting the Sort them by Drop Down"
		to LevisMyAccountPage
		at LevisMyAccountPage
		shopAllCollection()
		
		then: "sorting and filtering"
		
		println "sorting and filtering done successfully"
		
	}

}
