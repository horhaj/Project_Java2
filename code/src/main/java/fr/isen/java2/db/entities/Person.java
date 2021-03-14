package fr.isen.java2.db.entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Person
 */
public class Person {

    private Integer id;
    private String lastName;
    private String firstName;
    private String nickName;
    private String phoneNumber;
    private String address;
    private String emailAddress;
    private LocalDate birthDate;

    public Person(){
    
    }

    public Person(Integer id, String lastName, String firstName, String nickName, String phoneNumber, String address, String emailAddress, LocalDate birthDate) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.emailAddress = emailAddress;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Person id(Integer id) {
        setId(id);
        return this;
    }

    public Person lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public Person firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Person nickName(String nickName) {
        setNickName(nickName);
        return this;
    }

    public Person phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    public Person address(String address) {
        setAddress(address);
        return this;
    }

    public Person emailAddress(String emailAddress) {
        setEmailAddress(emailAddress);
        return this;
    }

    public Person birthDate(LocalDate birthDate) {
        setBirthDate(birthDate);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(lastName, person.lastName) && Objects.equals(firstName, person.firstName) && Objects.equals(nickName, person.nickName) && Objects.equals(phoneNumber, person.phoneNumber) && Objects.equals(address, person.address) && Objects.equals(emailAddress, person.emailAddress) && Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, nickName, phoneNumber, address, emailAddress, birthDate);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", nickName='" + getNickName() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", address='" + getAddress() + "'" +
            ", emailAddress='" + getEmailAddress() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            "}";
    }

}

