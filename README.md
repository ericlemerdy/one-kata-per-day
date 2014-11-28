## Some kata !

One kata per day ?

## Next kata to integrate

 - https://github.com/jbrains/trivia
 - fizzbuzzkata
 - https://github.com/NotMyself/GildedRose

----
# Secret Santas Kata

Honoring a long standing tradition, my friends all play a Secret Santa game around Christmas time. We draw names and spend a week sneaking that person gifts and clues to our identity. On the last night of the game, we get together, have dinner, share stories, and, most importantly, try to guess who our Secret Santa was. It's a crazily fun way to enjoy each other's company during the holidays.

To choose Santas, we use to draw names out of a hat. This system was tedious, prone to many "Wait, I got myself..." problems. This year, we made a change to the rules that further complicated picking and we knew the hat draw would not stand up to the challenge. Naturally, to solve this problem, I scripted the process. Since that turned out to be more interesting than I had expected, I decided to share.

This quiz is to implement a Secret Santa selection script.

Your script will be fed a list of names on STDIN. An example might be:

	Walter White
	Skyler White
	Gustavo Fring
	Saul Goodman
	Jesse Pinkman
	Henry Schrader
	Marie Schrader

The format for these names is:

`FIRST_NAME space FAMILY_NAME newline`. We'll keep things simple and say that people only have two names, so you don't have to worry about tricky names like Walter White Junior.

First, in **step 1**, your script should choose a Secret Santa for every name in the list. Obviously, a person cannot be their own Secret Santa. 

Then, in **step 2**, my friends no longer allow people in the same family to be Santas for each other and your script should take this into account.

The output should be something that can be easily mailed to the organizer so he can dispatch the information to the participant :

	Walter White -> Gustavo Fring
	Saul Goodman-> Jesse Pinkman
	Marie Schrader -> Skyler White
	...

Or any other structure than can easily shows the relationship between the people.

In **step 3**, if you feel like you can handle more, each name is associated to an email address.

So the input change and is now : `FIRST_NAME space FAMILY_NAME space <EMAIL_ADDRESS> newline`

	Walter White <walter@caltech.edu>
	Skyler White <skyler@gmail.com>
	Gustavo Fring <fring@polos.com>
	Saul Goodman <saul@goodman.com>
	Jesse Pinkman <jesse.pinkman@gmail.com
	Henry Schrader <henry.shrader@dea.us>
	Marie Schrader <marieshrader723@yahoo.com>
	
The rules are the same, but the output is more realistic, as we all like self organized group, you should send to each santa an email describing who they have to give a gift to, thus bypassing the need for an organizer.

Happy Coding

## References

The kata is almost a blatant copy paste from Ruby Quiz #2 
