package in.reqres.users;

import com.intuit.karate.Results;
import com.intuit.karate.junit5.Karate;

public class UsersRunner {

    @Karate.Test
    Karate testUsers() {
        return Karate.run("users").relativeTo(getClass());
    }

    @Karate.Test
    Karate runPostUsersByTags() {
        return Karate.run("users-post.feature").tags(
                "only").relativeTo(getClass());
    }
    @Karate.Test
    Karate runGetUsersByTags() {
        return Karate.run("users-get.feature").tags(
                "only").relativeTo(getClass());
    }

    @Karate.Test
    Karate runGetUsers() {
        return Karate.run("users-get.feature").relativeTo(getClass());
    }

    @Karate.Test
    Karate runPostUsers() {
        return Karate.run("users-post.feature").relativeTo(getClass());
    }
    @Karate.Test
    Karate runPutUsers() {
        return Karate.run("users-put.feature").relativeTo(getClass());
    }
    @Karate.Test
    Karate runPatchUsers() {
        return Karate.run("users-patch.feature").relativeTo(getClass());
    }
    @Karate.Test
    Karate runDeleteUsers() {
        return Karate.run("users-delete.feature").relativeTo(getClass());
    }
}

