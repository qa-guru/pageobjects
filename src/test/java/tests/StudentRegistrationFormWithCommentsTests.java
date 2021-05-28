package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormWithCommentsTests extends TestBase {

    String firstName = "Egor",
            lastName = "Alexov",
            email = "aa@aa.com",
            gender = "Other",
            mobile = "1234567890",
            monthOfBirth = "May",
            yearOfBirth = "2004",
            dayOfBirth = "27",
            dayOfWeekOfBirth = "Friday",
            subject1 = "Chemistry",
            hobby1 = "Sports",
            picture = "img/1.png",
            currentAddress = "Montenegro 123",
            state = "Uttar Pradesh",
            city = "Merrut";

    @Test
    void successfulRegistrationTest() {
        // Arrange / Given / Open site
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        // Act / When / Fill the form
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(email);
        $("#genterWrapper").$(byText(gender)).click();
//        $(byText(gender)).click();
//        $("[for=gender-radio-1]").click();
        $("#userNumber").val(mobile);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);

//        <div class="react-datepicker__day react-datepicker__day--027 react-datepicker__day--outside-month" tabindex="-1" aria-label="Choose Tuesday, April 27th, 2004" role="option" aria-disabled="false">27</div>
//        <div class="react-datepicker__day react-datepicker__day--027" tabindex="-1" aria-label="Choose Thursday, May 27th, 2004" role="option" aria-disabled="false">27</div>

//        String.format("hello %s %s", "SOME", "World") == "hello SOME World";
//        $(String.format("[aria-label='Choose %s, %s %sth, %s']",
//                dayOfWeekOfBirth, monthOfBirth, dayOfBirth, yearOfBirth)).click();
//        $x(String.format("//*[contains(aria-label, '%s %sth, %s')]",
//                monthOfBirth, dayOfBirth, yearOfBirth)).click();
//        $("[aria-label='Choose Friday, May 27th, 1988']").click();
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", dayOfBirth)).click();
        $("#subjectsInput").val(subject1).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#uploadPicture").uploadFromClasspath("img/" + picture);
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/" + picture));
        $("#currentAddress").val(currentAddress);

        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();


        // Assert / Then / Verify successful form submit
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        // #1
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text(email), text(gender));
        // #2
        $(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Name")).parent()
                .shouldHave(text(firstName + " " + lastName));

        // #3
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(mobile));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject1));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby1));
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));

//        $("#closeLargeModal").click();
//        $("#example-modal-sizes-title-lg").should(disappear);

    }

}
