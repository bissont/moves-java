#Java client for the Moves API

The documentation for the API can be found at [https://dev.moves-app.com](https://dev.moves-app.com)

```Java

public class Example {

    public static void main(String[] args) throws Exception {

        final String token = System.getenv("ACCESS_TOKEN");

        Moves moves = new MovesBuilder().setToken(token).build();

        final Profile profile = moves.profile();

        final List<Summary> summary = moves.summary("2013-11-15");
        final List<Summary> summaryBetween = moves.summary("2013-11-14", "2013-11-15");
        final List<Summary> past30days = moves.summary(30);

        final List<Summary> activities = moves.activities("2013-11-14");
        final List<Summary> storyline = moves.storyline("2013-11-14");
        final List<Summary> places = moves.places("2013-11-14");

        final List<ActivityDescription> descriptions = moves.listOfActivities();

        System.out.println(summary);
        System.out.println(summaryBetween);
        System.out.println(past30days);

        System.out.println(activities);
        System.out.println(profile);

        System.out.println(storyline);
        System.out.println(places);
        System.out.println(descriptions);
    }
}
```

**This is not intended to be used in production.**

It is mostly an excuse to play with [Jackson](https://github.com/FasterXML/jackson-core)
and [Retrofit](http://square.github.io/retrofit/).


##LICENSE

```
The MIT License (MIT)

Copyright (c) 2014 Tim Bart

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
