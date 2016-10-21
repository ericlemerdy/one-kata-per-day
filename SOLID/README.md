Exercise: Applying SOLID principles
-----------------------------------

The Code has the following behaviour:    

* Books can be added to the basket    
* Basket calculates the total price with no discounts    
* Basket calculates discounts for IT and Travel books    
* Tests are provided for the current functionality    

**Requirement:** Give 20% discount for each Fantasy book when more than one is in the basket.

**Proposed refactoring:**

- Transform the books List in a First Class Collection called Books:    
	- Move respective behavior to it.
		- Questions about books, number of book types, sum of prices, etc 
- Extract discount offers from Basket
	- Each discount type should have its own class
	- Discount classes should implement the same interface
	- You may need a NoDiscountsBook class to cater for books with no discounts
- Create a DiscountCalculator that contains a list of discount classes
	- Iterates through discount classes and calculate price with discounts
- Pass the DiscountCalculator into the Basket constructor
	- Basket delegates discount calculation to DiscountCalculator

**Implementing the requirement**

* Test-Drive the Fantasy Book discount offer
* Create the basket adding the Fantasy discount offer to it.

**Lesson:**

- New features can be slid into the code almost without change
	- Minor change on DiscountCalculator and NoDiscountBooks   
- Changes while adding new functionality are small and localised
- Changes happen in the main (application assembly) and not in the domain
	- This would happen if using Dependency Injection frameworks

**How to start ?**

You have to reset to a specific point in the history:

    git checkout 76cd0abbaf95d50d7686e57b4c2061904fac8467