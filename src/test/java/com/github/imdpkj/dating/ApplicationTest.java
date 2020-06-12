package com.github.imdpkj.dating;

import com.github.imdpkj.dating.lib.Gender;
import com.github.imdpkj.dating.lib.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * DPKJ
 * 12/06/20
 */

public class ApplicationTest
{
  //Path to list of users for testing
  private final static String USER_DATA = "src/test/resources/users.json";

  private static Application application;

  /**
   * @throws IOException Register users from json file
   */
  @BeforeClass
  public static void beforeClass() throws IOException
  {

    Gson gson = new GsonBuilder().create();

    Path path = new File(USER_DATA).toPath();

    try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
      User[] users = gson.fromJson(reader, User[].class);
      application = new Application();
      Arrays.stream(users).forEach(user -> {
        application.register(user);
      });
    }
  }

  @Test
  public void haveMatchedInterests()
  {
    User dummy = new User(100L, "X", 25, Gender.MALE, Stream.of("Movies", "Cricket").collect(Collectors.toSet()));

    List<User> matches = application.findMathFor(dummy, 2);

    System.out.println(matches);
  }

}
