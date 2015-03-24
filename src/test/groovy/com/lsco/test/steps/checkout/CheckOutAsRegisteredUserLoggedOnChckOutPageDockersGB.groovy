package com.lsco.test.steps.checkout

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
import com.lsco.test.page.CartPage
import com.lsco.test.page.OrderConfirmationPage

class CheckOutAsRegisteredUserLoggedOnChckOutPageDockersGB extends GebSpec{
	@GBDockersSmoke
	def "CheckOutAsRegisteredUserLoggedOnChckOutPageDockersGB 15869"()
	{
		when: "going to Dockers GB Home Page and searching for product"
		to LevisHomePage
		at LevisHomePage
		dismissPopup()
		searchProductForGuestUsr()
		clickOnTheSearchedItemForGuestUsr()
		
		
		then: "guest user goes to first Product Page and adding the product to Bag"
		at FirstProductPage
		addProductToBagLatest("1")
		viewBagFunctionality()
		
		when: "control goes to Cart Page and logged in from CheckOut Page"
		to CartPage
		at CartPage
		toCheckoutPageLatest()
		loginFromCheckOutPage()
		fillingShippingAddrDetails()
		submitData()
		chooseAmex()
		
		then: "giving the credentials for Amex CC and going to Order Confirmation Page"
		fillCreditCardDataLatestAmex()
		at OrderConfirmationPage
		}




}
