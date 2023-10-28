package tests;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {

    String firstName = "Anastasiya";
    String lastName = "Shpakova";
    String eMail = "test1@bk.ru";
    String gender = "Female";
    String phoneNumber = "9991002030";
    String birthDay = "22";
    String birthMonth = "September";
    String birthYear = "1987";
    String subject = "Maths";
    String hobby = "Music";
    String fileName = "nature3.jpg";
    String address = "Testing 12-35";
    String state = "Haryana";
    String city = "Panipat";


    @Test
    void successfulFillAllFieldsRegTest() {
        registration
                .openRegistrationPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(eMail)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .setSubject(subject)
                .setHobbies(hobby)
                .uploadPicture(fileName)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmitButton();

        registration.checkTitleResultTable()
                .checkValuesResultTable(firstName + " " + lastName)
                .checkValuesResultTable(eMail)
                .checkValuesResultTable(gender)
                .checkValuesResultTable(phoneNumber)
                .checkValuesResultTable(birthDay + " " + birthMonth + "," + birthYear)
                .checkValuesResultTable(subject)
                .checkValuesResultTable(hobby)
                .checkValuesResultTable(fileName)
                .checkValuesResultTable(address)
                .checkValuesResultTable(state + " " + city)
                .closeResultTable();

    }

    @Test
    void successfulFillRequiredFieldsRegTest() {
        registration
                .openRegistrationPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(eMail)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setAddress(address)
                .clickSubmitButton();

        registration.checkTitleResultTable()
                .checkValuesResultTable(firstName + " " + lastName)
                .checkValuesResultTable(eMail)
                .checkValuesResultTable(gender)
                .checkValuesResultTable(phoneNumber)
                .checkValuesResultTable(address)
                .closeResultTable()
                .checkHiddenResultTable();

    }

    @Test
    void negativeNotFillRequiredFieldsRegTest() {
        registration
                .openRegistrationPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .clickSubmitButton();

        registration.checkHiddenResultTable();

    }

}