package com.github.imdpkj.dating;

import com.github.imdpkj.dating.lib.User;
import com.github.imdpkj.dating.lib.UserScoreSort;

import java.util.ArrayList;
import java.util.List;

/**
 * DPKJ
 * 12/06/20
 */
public class Application
{
  private static final List<User> users = new ArrayList<>();

  /**
   * @param user "New user"
   *             Register new user to system
   */
  public void register(User user)
  {
    users.add(user);
  }


  /**
   * @param user "User against whom we need to match"
   * @param size "Number of matches need to return, i.e. of return list"
   * @return "List of matched users"
   */
  public List<User> findMathFor(User user, int size)
  {
    users.sort(new UserScoreSort(user));

    if (size > users.size()) size = users.size();

    return users.subList(0, size);
  }
}
