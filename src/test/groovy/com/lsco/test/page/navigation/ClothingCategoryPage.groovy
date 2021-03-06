package com.lsco.test.page.navigation

import geb.Page

import com.lsco.test.PropertyProvider

class ClothingCategoryPage extends Page{
	
		static url = "category/men/pants/all"
	
		
		static content = {
			headline { $(".content > h1")}
		}
		
		static at = {
			String okValue = PropertyProvider.getInstance().getLocalizedPropertyValue("clothing.trousers")
			//Thread.sleep(5000)
			assert $(".content > h1").text().toUpperCase() == okValue
			return true
		}
	
		def toAllCollectionsPage(){
			$("#shop-by-collection>a.cta.see-all").click()
			//waitFor(30){ $("#main-container > article:nth-child(1) > header > article > div > h1").text() == "JEANS"}
		}


def ProductsUnderTrousersCategoryPage(){
			int minimum =1
			int maximum =4
			
			int i = minimum + (int)(Math.random()*maximum)
			assert $("#main-container>section:nth-of-type("+i+")").isDisplayed() == true
			
			return true
			}
		
		def PDPofAnyProduct(){
			
			int minimum =1
			int maximum =15
			
			int i = minimum + (int)(Math.random()*maximum)
            $("#container_results>li:nth-child("+i+")").click()
			$("#dismiss-btn").click()
			assert $(".title").isDisplayed() ==true
			return true
			}
}
