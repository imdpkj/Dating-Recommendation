package com.github.imdpkj.dating.lib;

import com.github.imdpkj.dating.lib.scorer.EqualityScorer;
import com.github.imdpkj.dating.lib.scorer.NumberScorer;
import com.github.imdpkj.dating.lib.scorer.SetScorer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * DPKJ
 * 12/06/20
 * Scoring each user and sorting
 */
public class UserScoreSort implements Comparator<User>
{
  private final List<Function<User, String>> functions;

  public UserScoreSort(final User source)
  {
    //Ordered scoring functions;
    functions = Arrays.asList(
        u -> new EqualityScorer<>(source.getGender(), u.getGender()).getScore(),
        u -> new NumberScorer(source.getAge(), u.getAge(), 2).getScore(),
        u -> new SetScorer<>(source.getInterests(), u.getInterests()).getScore()
    );
  }

  private String score(User user)
  {
    return functions.stream().map(f -> f.apply(user)).reduce("", String::concat);
  }

  @Override
  public int compare(User one, User two)
  {
    return score(one).compareTo(score(two));
  }
}
