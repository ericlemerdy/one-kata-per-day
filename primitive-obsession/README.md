**Requirements**

* Transform all primitives into types
* Primitives cannot be passed as parameters or be returned by a method
* Primitives can only be passed into the constructor of an Object that defines what that primitive is

**Refactoring steps**

1. Introduce a Currency class or enum; Use it on ProfitCalculator.
2. Create an ExchageRates first class collection; Use it on ProfitCalculator.
3. Create a Money class. Identify all amount operations used by ProfitCalculator and add them to it. 
4. Change ProfitCalculator and its tests to use the Money class
5. Create an abstract Item class with the method Money amount();
6. Create classes Outgoing and Incoming implementing Item. Outgoing has negative amount.
7. Change ProfitCalculator and its tests to use Item.
8. Create an Items first class collection and store each Item added to ProfitCalculator.
9. Create boolean isIn(Currency) method in Item; 
10. Create Money amountIn(Currency) in Items.
11. Change ProfitCalculator.calculateTax() to use methods created in steps 9 and 10.
12. Remove localAmount field from ProfitCalculator, making necessary changes.
13. Create Items notIn(currency) and Money amountIn(Currency, ExchangeRates) in Items
14. Simplify ProfitCalculator, removing all the logic from add(Item). calculateProfit() must be simple
