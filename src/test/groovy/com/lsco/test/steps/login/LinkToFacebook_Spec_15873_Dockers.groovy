package com.lsco.test.steps.login

import com.lsco.test.GBDockersSmoke
import geb.*
import geb.spock.GebSpec;

import com.lsco.test.page.LevisHomePage
import com.lsco.test.page.login.LevisMyAccountPage
import com.lsco.test.page.login.LevisLoginPage
import com.lsco.test.page.login.FacebookLoginPage

class LinkToFacebook_Spec_15873_Dockers extends GebSpec{
	//@GBDockersSmoke
		def FacebookLogin(){
			
			when: "User is at Home page & click on MyAccount"
			to LevisHomePage
			at LevisHomePage
			toMyAccountPage()
			
			then: "User logged in as a register user"
			at LevisLoginPage
			FillLoginFields()
			submitLoginForm()
			
			when: "User clicks on- link to facebook"
			at LevisMyAccountPage
			LinkToFB()
						
			then:"Users logs-in with fb account"
			at FacebookLoginPage
			FillFacebookLogin()
			RelaunchMyAccount_LEVI()
			
			when: "User re-enters the Levi's account with fb credentials"
			at LevisLoginPage
	        signInWithFacebook()
			
			then: "User can easily logs-in with fb credentials, also see the fb name in haeder"
			at LevisMyAccountPage
			validateFBloggedIn()
			VerifyLEVISOrdersUsingFBlogIn()
			VerifyOrderHistory() // User verifies the previous order-history with LEVI account after logging with FB credentials
			
		}
}
		 
	
