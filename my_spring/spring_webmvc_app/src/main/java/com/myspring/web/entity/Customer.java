package com.myspring.web.entity;

import javax.validation.constraints.Pattern;

import javax.validation.constraints.Email;

public class Customer extends User {
  private static final long serialVersionUID = 1L;

  @Pattern(regexp = "^1[3|4|5|7|8][0-9]{9}$", message = "Please enter the correct format of the phone number")
  private String phone;
  @Email(message = "Please enter a valid email address")
  private String email;

  /**
   * @param phone the phone to set
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }
}