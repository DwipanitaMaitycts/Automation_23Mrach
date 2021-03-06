package com.lsco.test.steps.navigation

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
import com.lsco.test.page.FirstProductPage

class VerifyHoveringOverSwatches extends GebSpec {
	@GBLevisSmoke
	def "verifyHoveringOverSwatchesLeviGB 15732"()
	{
		when: "going to Levi GB Home Page and clicking on My Account"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()
		
		
		then: "user is at Levi GB Login Page and logging in"
		at LevisLoginPage
		leviLogin()
		//submitLoginFormButton()
		submitLoginFormButtonWithPopupCheck()
		
		when: "user goes to My account page and selecting the product"
		to LevisMyAccountPage
		at LevisMyAccountPage
		searchProductWithMultipleSwatches()
		clickOnTheSearchedItem()
		
		then: "User goes to First Product Page and checking for the colour or swatch updation"
		at FirstProductPage
		verifyHoveringOverSwatches()
		
	}
}
