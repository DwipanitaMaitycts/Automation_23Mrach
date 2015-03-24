package com.lsco.test.steps.search

import com.lsco.test.GBDockersSmoke
import spock.lang.Specification
import geb.spock.GebReportingSpec
import gherkin.formatter.model.Feature
import junit.framework.Test
import com.lsco.test.page.search.SearchResultPage
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.FirstProductPage
import geb.spock.GebReportingSpec
import geb.spock.GebSpec
import spock.lang.Unroll
import geb.Browser
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

//import groovy.util.logging.Slf4j

//Dockers-GB [SPRING-15818]
//@Slf4j
class AddToBagErrorSpec extends GebSpec{
	//Dockers [GB]-[SPRING-15818] Verify error message when trying to add a product to the bag without selecting attributes. 
	@GBDockersSmoke
	@Unroll("Search and Add product #Item to Bag without selecting attributes[SPRING-15818]")
		def "Add to Bag without selecting attributes"()
		{
			//given: "opened the dockers login url "
			when: "Entering #Item to be Searched"
			to LevisHomePage
			at LevisHomePage
			searchTerm(Item)
			//Log.info("Item Searched Successfully")
			
			then: "Verifing Searched Item #Item"
			//to SearchResultPage
			at SearchResultPage
			verifySearchedItem(Item)
			clickSearchedItem()
	
			then: "adding Item #Item to bag"
			//to FirstProductPage
			at FirstProductPage
			addProductToBagInPDPSection()
			checkProductQuantityInBag("0")
			CheckErrorsOnAddingToBag()
	
			where:
			Item<<["447150300"] //Dockers [GB]
	
		}
}
