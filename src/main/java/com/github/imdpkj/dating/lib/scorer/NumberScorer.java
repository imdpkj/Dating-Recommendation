package com.github.imdpkj.dating.lib.scorer;

/**
 * DPKJ
 * 12/06/20
 */
public class NumberScorer implements Scorer
{
  private final int source;
  private final int target;
  private final String format;

  public NumberScorer(int source, int target, int padding)
  {
    this.source = source;
    this.target = target;
    this.format = "%0" + padding + "d";
  }

  @Override
  public String getScore()
  {
    return String.format(format, Math.abs(source - target));
  }
}
