# Single Sign On Kata

Sometimes corporate security measures can really get out of hand. You log into your machine when you arrive in the
morning, then log in again to your email client, then log in again to the corporate intranet, then log in again to your
project file sharing area, then log in again ... Typing your password ten times before you can actually do anything gets
pretty irritating. There are various ways to solve the problem, and in this Kata we're looking at one of them.

The way it works is the first time you log in to any service, you give your username and password, and the service
validates these credentials against a central registry. The Single Sign On Registry then gives you a token. Then when
you want to access a different service, you give it this token instead of having to type in your username and password
again. The service can then check with the Single Sign On Registry whether the token is valid, and if it is, you get
seamless access. If the Single Sign On Registry doesn't recognize your token, it will notify the service and your
request will be denied.

For this Kata, your job is to develop a new service, that uses the Single Sign On registry. The actual functionality of
the service is simple - it says "Hello Emily!" (or whatever your name is) if your single sign on token is valid.

The starting code here is the interface for the Single Sign On Registry.

## Test Doubles

This kata is useful for practicing using different kinds of test doubles. I have used it as a worked example in Emily
Bache's book ["Mocks, Fakes and Stubs"](https://leanpub.com/mocks-fakes-stubs)

## Credits

The original design of this Kata was by Fredrik Wendt and he published it on
[the codingdojo.org wiki](http://codingdojo.org/cgi-bin/index.pl?KataJEEWebAuthentication)

Reference: [emilybache/Single-Sign-On-Kata: a kata useful for understanding Test Doubles](https://github.com/emilybache/Single-Sign-On-Kata.git)