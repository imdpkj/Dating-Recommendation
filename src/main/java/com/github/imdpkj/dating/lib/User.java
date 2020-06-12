package com.github.imdpkj.dating.lib;

import java.util.Set;

/**
 * DPKJ
 * 12/06/20
 */
public class User
{
  private Long id;
  private String name;
  private Integer age;
  private Gender gender;
  private Set<String> interests;

  public User(Long id, String name, Integer age, Gender gender, Set<String> interests)
  {
    this.id = id;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.interests = interests;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Integer getAge()
  {
    return age;
  }

  public void setAge(Integer age)
  {
    this.age = age;
  }

  public Gender getGender()
  {
    return gender;
  }

  public void setGender(Gender gender)
  {
    this.gender = gender;
  }

  public Set<String> getInterests()
  {
    return interests;
  }

  public void setInterests(Set<String> interests)
  {
    this.interests = interests;
  }

  @Override
  public String toString()
  {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
