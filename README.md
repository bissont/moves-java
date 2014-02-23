#Java client for the Moves API

The documentation for the API can be found at [https://dev.moves-app.com](https://dev.moves-app.com)

```Java

public class Example {

    public static void main(String[] args) throws Exception {

        final String token = "<INSERT OAUTH2 TOKEN HERE>";

        Moves moves = new MovesBuilder().setToken(token).build();

        final Profile profile = moves.profile();
        final List<Summary> summary = moves.summary("2013-11-15");
        final List<Summary> activities = moves.activities("2013-11-14");
        final List<Summary> storyline = moves.storyline("2013-11-14");
        final List<Summary> places = moves.places("2013-11-14");

        System.out.println(summary);
        System.out.println(activities);
        System.out.println(profile);

        System.out.println(storyline);
        System.out.println(places);
    }
}
```

**This is not intended to be used in production.**

It is mostly an excuse to play with [Jackson](https://github.com/FasterXML/jackson-core)
and [Retrofit](http://square.github.io/retrofit/).
