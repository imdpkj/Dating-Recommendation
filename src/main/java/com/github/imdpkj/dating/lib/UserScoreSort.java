package com.github.imdpkj.dating.lib;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * DPKJ
 * 12/06/20
 * Scoring each user and sorting
 */
public class UserScoreSort implements Comparator<User>
{
  private User source;

  public UserScoreSort(User source)
  {
    this.source = source;
  }

  private int score(User user)
  {
    //Gender score - x
    StringBuilder builder = new StringBuilder();
    builder.append(getGenderScore(user));

    //xx - age diff
    builder.append(getAgeScore(user));

    //xxxxxx - interests match
    builder.append(getInterestsScore(user));

    return Integer.parseInt(builder.toString());
  }

  private String getGenderScore(User user)
  {
    if (source.getGender().equals(user.getGender())) {
      return "1";
    }

    return "0";
  }

  private String getAgeScore(User user)
  {
    return String.format("%02d", Math.abs(source.getAge() - user.getAge()));
  }

  private String getInterestsScore(User user)
  {
    Set<String> intersection = new HashSet<String>(source.getInterests());
    intersection.retainAll(user.getInterests());

    return String.format("%05d", intersection.size());
  }


  @Override
  public int compare(User one, User two)
  {
    return score(one) - score(two);
  }
}
