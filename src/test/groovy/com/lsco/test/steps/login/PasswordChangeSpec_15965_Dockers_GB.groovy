package com.lsco.test.steps.login

import com.lsco.test.GBDockersSmoke
import geb.*
import geb.spock.GebSpec;

import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisMyAccountPage
import com.lsco.test.page.login.LevisLoginPage


class PasswordChangeSpec_15965_Dockers_GB extends GebSpec{
	@GBDockersSmoke
	def passwordchange(){
	
	when: "We are Home page & click on MyAccount"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()

	then : "we are on the MyAccount Page"
	    at LevisLoginPage
		FillLoginFields()
		submitLoginForm()
		
	when: "We are into MyProfile-tab"
	    to LevisMyAccountPage
	    at LevisMyAccountPage
	    openPasswordTab()
		
	then:"Updating Password"
		editPassword()
		UpdateButton()
		verifyDataUpdateMesage()
		
		
		}
	}
	
	
