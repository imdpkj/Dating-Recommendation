package com.github.imdpkj.dating;

import com.github.imdpkj.dating.lib.Gender;
import com.github.imdpkj.dating.lib.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

public class MatchFinderTest
{
  private static final Logger logger = LoggerFactory.getLogger(MatchFinderTest.class);

  //Path to list of users for testing
  private final static String USER_DATA = "src/test/resources/users.json";

  private static MatchFinder application;

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
      application = new MatchFinder();
      Arrays.stream(users).forEach(user -> application.register(user));

      logger.info("Users added");
    }
  }

  @Test
  public void haveMatchedInterests()
  {
    User dummy = new User(100L, "X", 25, Gender.MALE, Stream.of("Movies", "Cricket").collect(Collectors.toSet()));

    List<User> matches = application.findMathFor(dummy, 2);

    logger.info("Matches for " + dummy + " are " + matches);
    assert matches.size() == 2;
  }


  @Test
  public void haveMatchedAge()
  {
    User dummy = new User(100L, "X", 21, Gender.MALE, Stream.of("Movies", "Cricket").collect(Collectors.toSet()));

    List<User> matches = application.findMathFor(dummy, 1);

    logger.info("Matches for " + dummy + " are " + matches);

    assert matches.size() == 1;
    assert matches.get(0).getName().equals("F");
  }
}
