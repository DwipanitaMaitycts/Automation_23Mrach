package com.lsco.test.steps.navigation

import com.lsco.test.GBDockersSmoke
import spock.lang.Specification
import geb.spock.GebReportingSpec
import junit.framework.Test
import com.lsco.test.page.navigation.ClothingSweatersCategoryPage
import com.lsco.test.page.LevisHomePage
import geb.spock.GebReportingSpec
import geb.spock.GebSpec
import spock.lang.Unroll
import geb.Browser

import org.openqa.selenium.WebDriver

import org.openqa.selenium.firefox.FirefoxDriver
//Dockers-GB [SPRING-15719]
class ClothingSweatersCategoryPageSpec extends GebSpec{
	@GBDockersSmoke
	def "Verify Navigation to Clothing-Sweaters Category Page [SPRING-15719]"()
	{
		when: "Clicking on Link to Clothing Sweaters Category Page"
		to LevisHomePage
		at LevisHomePage
		toClothingSweatersCategoryPage()

		then: "Navigate to Clothing Category Sweaters Page and click on All Collections Link"
		//to ClothingCategoryPage
		at ClothingSweatersCategoryPage
		//toAllCollectionsPage()
		selectSweaterItemTypeFilter()
		validateProductAfterItemTypeFilters()

	}
}
