package com.wang.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hppc on 2017/1/17.
 */
@Table(name = "jpa_persons")
@Entity
public class Person {
  private int id;
  private String lastname;
  private String email;

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", lastname='" + lastname + '\'' +
        ", email='" + email + '\'' +
        '}';
  }

  @GeneratedValue
  @Id
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public Person() {
  }
}
