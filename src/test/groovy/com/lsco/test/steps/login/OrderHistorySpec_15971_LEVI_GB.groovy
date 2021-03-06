package com.lsco.test.steps.login

import com.lsco.test.GBLevisSmoke
import geb.*
import geb.spock.GebSpec;

import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisMyAccountPage
import com.lsco.test.page.login.LevisLoginPage

class OrderHistorySpec_15971_LEVI_GB extends GebSpec{
	@GBLevisSmoke
	def verifyOrderHistory(){
	
	when: "We are Home page & click on MyAccount"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()

	then : "we are on the MyAccount Page"
	    at LevisLoginPage
		FillLoginFieldsToCheckOrderHistory()
		submitLoginForm()
				
	when: "We are into Orders-tab"
	      to LevisMyAccountPage
	      at LevisMyAccountPage
	      openOrdersTab()
		  
	then:"Validating Order-history links navigate to corresponding order detail pages"
	     //at LevisMyAccountPage
		 VerifyOrderHistory()
         VerifyOrderDetailsFromOrderHistory()
		}
	}
	
	
