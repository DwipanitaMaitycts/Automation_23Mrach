package com.lsco.test.steps.navigation

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

import com.lsco.test.PropertyProvider

import org.openqa.selenium.WebDriver

import org.openqa.selenium.firefox.FirefoxDriver


class FilterByColorSpec_DOCKERS_GB_16637 extends GebSpec{

	@GBDockersSmoke
	def "FilterByColor"()
	{		
		when: "We are Home page & click ClothingCategory from top-nav"
		to LevisHomePage
		at LevisHomePage
		ClothingCategoryPage()
		
		then: "Filtering By Color"
	    filterbyColor_LEVI()
		clickOnTheFilteredItem()
		
	}
}
