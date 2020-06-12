package com.github.imdpkj.dating.lib.scorer;

/**
 * DPKJ
 * 12/06/20
 */
public class EqualityScorer<T> implements Scorer
{
  private final T source;
  private final T target;

  public EqualityScorer(T source, T target)
  {
    this.source = source;
    this.target = target;
  }

  @Override
  public String getScore()
  {
    if (source.equals(target)) return "1";

    return "0";
  }
}
