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

class EmailaddressformarketingEmailOptOutLeviGB extends GebSpec {
	@GBLevisSmoke
	def "emailaddressformarketingEmailOptOutLeviGB 15942"()
	{
		when: "going to Levis GB Home page and clicking on My Account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Levis GB Login Page and doing the Opt Out Flow"
		at LevisLoginPage
		leviLogin()
		submitLoginFormButtonWithPopupCheck()
		selectEmailOptions()
		marketingEmailOptOutLevisGB()
		

		}
	
}
