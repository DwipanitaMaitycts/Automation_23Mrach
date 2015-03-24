package com.lsco.test.steps.login

import com.lsco.test.GBDockersSmoke
import geb.*
import geb.spock.GebSpec;

import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisMyAccountPage
import com.lsco.test.page.login.LevisLoginPage


class VerifySuccessfulLogInSpec_15583_Dockers_GB extends GebSpec{
	@GBDockersSmoke
	def SuccessfulLogIn(){
	
	when: "We are Home page & click on MyAccount"
		to LevisHomePage
		at LevisHomePage
		toMyAccountPage()

	then : "we are on the MyAccount Page after succesfull log-in"
	    at LevisLoginPage
		FillLoginFields()
		submitLoginForm()
		at LevisMyAccountPage
			
		}
	}
	
	
