package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
     private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");

//    void typeFirstName() {
//        firstNameInput.val("asd");
//    }
    public void typeFirstName(String value) {
        firstNameInput.val(value);
    }

    public void clearFirstName() {
        firstNameInput.clear();
    }

    public void typeLastName(String value) {
        lastNameInput.val(value);
    }

    public void setDate(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        new CalendarComponent().setDate(dayOfBirth, monthOfBirth, yearOfBirth);
    }
}
