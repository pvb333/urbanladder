Feature: UrbanLadder Feature File

Scenario Outline: Search Product From Urban Ladder
Given navigate to Urban Ladder website <URL>
When user enter <Search data> in the searchbox
Then user press Enter Keyword

Examples:
|URL						 |Search data|Product Name		|
|https://www.urbanladder.com/|Table		 |Eloise Study Table|



Scenario: Selecting Study table by applying filters
Given User landed on searched product page
When user selects study table from category
And Study Table result will display
When User select Exclude out of stock checkbox
And In stock Product gets displayed
When user select Sort by Low to High price
And Products should get sorted from low to high price
Then user selects required product "Eloise Study Table" 


Scenario: Check Product details and add it to cart
Given Product details page displayed
When user check product is on sale
When user check product is available on EMI
Then user click Add to cart

Scenario: Check product added to cart or not
Given user landed on homepage
When user clicks cart icon
Then Product should display
