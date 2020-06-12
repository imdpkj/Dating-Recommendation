package com.github.imdpkj.dating.lib.scorer;

import java.util.HashSet;
import java.util.Set;

/**
 * DPKJ
 * 12/06/20
 */
public class SetScorer<T> implements Scorer
{
  private final Set<T> source;
  private final Set<T> target;

  private final String format;

  public SetScorer(Set<T> source, Set<T> target)
  {
    this.source = source;
    this.target = target;
    this.format = "%0" + (Math.log10(source.size()) + 1) + "d";
  }

  @Override
  public String getScore()
  {
    Set<T> intersection = new HashSet<>(source);
    intersection.retainAll(target);

    return String.format(format, intersection.size());
  }
}
