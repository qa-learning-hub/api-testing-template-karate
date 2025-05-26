package examples.users;

import com.intuit.karate.Results;
import com.intuit.karate.junit5.Karate;

public class UsersRunner {

    @Karate.Test
    Karate testUsers() {
        return Karate.run("users").relativeTo(getClass());
    }

    @Karate.Test
    Karate runByTags() {
        return Karate.run("users").tags(
                "~@sanity","@smoke").relativeTo(getClass());
    }
}
