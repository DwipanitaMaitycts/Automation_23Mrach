package com.lsco.test.steps.search

import com.lsco.test.GBDockersSmoke
import spock.lang.Specification
import geb.spock.GebReportingSpec
import gherkin.formatter.model.Feature
import junit.framework.Test
import com.lsco.test.page.login.LevisMyAccountPage
import com.lsco.test.page.register.AccountRegistrationPage
import com.lsco.test.page.LevisHomePage
import geb.spock.GebReportingSpec
import geb.spock.GebSpec
import geb.Browser
import com.lsco.test.page.search.SearchResultPage

import com.lsco.test.PropertyProvider
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver


class IndecaSearchSpec_Dockers_GB_15991 extends GebSpec{

	@GBDockersSmoke
	def "SearchForIndeca"()
	{		
		when: "We are Home page & places a search using perticular keyword"
		to LevisHomePage
		at LevisHomePage
		SearchProductIndeca()
				
		then: "User is redirected to a pre-defined search page in Indeca only"
		//to SearchResultPage
		at SearchResultPage
		Results_Indeca()
		
	}
}
