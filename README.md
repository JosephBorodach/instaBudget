# Budget

## What is the general purpose? 
* Budget an individual’s money by tracking income, spending, ect
* Additionally, actually transfer and spend money - kind of like a bank account, venmo 
	* Can pay rent for example from the app(i.e utilities)

## Who uses it? Why would someone use this product?
* Anyone who wants to budget their money more efficiently
* Anyone who has issues not over spending and prioritizing their funds to what is actually important to them
* Anyone who wants to not worry about their spending and allocate their money to their everyday needs easily and efficiently 

## How does it budget money?  
* Choose how to allocate his money
* Track how much he spends 
* If the user is about to surpass their budget, they will be notified and their account will be frozen - The user cannot override his budget limitations at all. 
	* If the total money tried to allocate exceeds money in his bank account throw an error 
* Give priority to certain genres (i.e. one can prioritize their allocation of funds to food over sports games).
* How does the program transer money?
	* Each time the user spend or receives money, the program rebalances their account holding.  

## Functionality 
* Choose which categories to allocate money to 
* Warns you when you are going over budget 
* Can pay for various bills in app
* Can chose to give priority to different categories 
* Track how much you spend 

## How to use 
* Sign up
	* Name 
	* Username Password 
	* Email 
	* Bank account info 
* Choose different categories to allocate money to
* Set amounts and inform user of the "consequences" of allocating amounts of funds to one categories decreasing the available funds for others categories


## Data Modeling
* We used a Hash Set to hold the users categories 
* We used a Priority Que to prioritize the categories
* We used a Hash Map to map the their account name to the users bank accounts

