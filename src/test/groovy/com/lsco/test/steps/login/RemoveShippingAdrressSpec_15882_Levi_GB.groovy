package com.lsco.test.steps.login

import com.lsco.test.GBLevisSmoke
import geb.*
import geb.spock.GebSpec;
import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.math.RandomUtils
import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisMyAccountPage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.register.AccountRegistrationPage
import com.lsco.test.page.CartPage
import com.lsco.test.page.FirstProductPage


class RemoveShippingAdressSpec_15882_Levi_GB extends GebSpec{
	@GBLevisSmoke
	def RemoveShippingAdress(){
	
	when: "We are Home page & click on MyAccount"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()

	then:"we are on the MyAccount Page"
	    at LevisLoginPage
		FillLoginFields()
		submitLoginForm()
				
	when:"We are into MyProfile-tab"
	     to LevisMyAccountPage
	     at LevisMyAccountPage
	     openAdrressTab()
		 def shippingAddressbefore=shippingAddress.size()
		
	then:"Removing saved shipping address & logout"
	    RemoveShippingAdrressSection()
    	logOut()
		
	when: "Register user re-logs-into account & verifies the address has been removed"	
	     at LevisLoginPage
	     FillLoginFields()
		 submitLoginForm()
	
	then:"User re-enters address tab & verifies the added billing address"	
	    to LevisMyAccountPage
	    at LevisMyAccountPage
	    openAdrressTab()
	    assert shippingAddressbefore-1==shippingAddress.size()
		
	when:"User does perform a search "
	   searchProduct()
	   clickOnTheSearchedItem()
	   
	then: "User goes to First Product Page and adding product to Bag"   
	   at FirstProductPage
	   addProductToBagLatest("1")
	   viewBagFunctionality()
	   
	when: "user goes to Cart Page and proceed to check out"
	   to CartPage
	   at CartPage
	   toCheckoutPageLatest()
	  // fillingShippingAddrDetailsUpdated()
	   phone()
	   submitData()
	   chooseMasterCard()
   	   
	then: "Checking out the order with Credit Card Details"
	   fillCreditCardDataLatest()
	   
	   }
	}
	

