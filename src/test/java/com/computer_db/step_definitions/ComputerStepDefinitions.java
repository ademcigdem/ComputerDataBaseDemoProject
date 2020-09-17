package com.computer_db.step_definitions;

import com.computer_db.utils.Driver;
import com.computer_db.utils.Pages;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


import static org.junit.Assert.*;

public class ComputerStepDefinitions {

    Pages pages = new Pages();

    @Given("user go to main page")
    public void user_go_to_main_page() {
    }

    @Then("user verify that title {string}")
    public void user_verify_that_title(String expectedTitle) {
        assertEquals(expectedTitle, Driver.get().getTitle());
    }

    @When("user click Add new computer button")
    public void user_click_add_new_computer_button() {
        pages.addAComputerPage().addANewComputerButton.click();
    }

    @When("Verify add computer page title {string}")
    public void verify_add_computer_page(String expectedTitle) {
        assertEquals(expectedTitle, Driver.get().getTitle());
    }

    @When("user enter computer name {string}, Introduced {string}, Discontinued {string}, Company {string} and click Create computer button")
    public void user_enter_computer_name_introduced_discontinued_company_and_click_create_computer_button(String computerName, String introduced, String discontinued, String company) {
        pages.addAComputerPage().computerNameInput.sendKeys(computerName);
        pages.addAComputerPage().introducedInput.sendKeys(introduced);
        pages.addAComputerPage().discontinuedInput.sendKeys(discontinued);
        pages.addAComputerPage().getSelectCompanyName().selectByVisibleText(company);
        pages.addAComputerPage().createThisComputerButton.click();
    }

    @When("user enter computer name {string} Filter by name input box and click search button")
    public void user_enter_computer_name_filter_by_name_input_box_and_click_search_button(String computerName) {
        pages.addAComputerPage().searchboxInput.sendKeys(computerName);
        pages.addAComputerPage().filterbyNameButton.click();
    }

    @Then("verify that computer name {string} in the result table")
    public void verify_that_computer_name_introduced_discontinued_company_in_the_result_table(String computerName) {
        try {
            assertEquals(computerName, Driver.get().findElement(By.xpath("//td[.='" + computerName + "']")).getText());
        } catch (Exception e) {
            fail("------Nothing to display-----");
        }
    }


    @When("user click computer name {string}")
    public void userClickComputerName(String computerName) {
        Driver.get().findElement(By.xpath("//a[.='" + computerName + "']")).click();
    }

    @And("user click Save this computer button")
    public void userClickSaveThisComputerButton() {
        pages.addAComputerPage().saveThisComputerBtn.click();
    }


    @Then("user verify computer name {string} update in the table")
    public void userVerifyComputerNameUpdateInTheTable(String computerName) {
        try {
            assertTrue(Driver.get().findElement(By.xpath("//td[.='" + computerName + "']")).isDisplayed());
        } catch (Exception e) {
            fail("----Nothing to display-----");
        }
    }

    @And("user enter {string}, {string} value")
    public void userEnterValue(String name, String value) {
        Driver.get().findElement(By.id("" + name + "")).sendKeys(value);
    }

    @And("user click delete this computer button")
    public void userClickDeleteThisComputerButton() {
        pages.addAComputerPage().deletThisComputerBtn.click();
    }

    @Then("verify that computer name {string} not in the result table")
    public void verifyThatComputerNameNotInTheResultTable(String computerName) {
        try {
            assertFalse(Driver.get().findElement(By.xpath("//td[.='" + computerName + "']")).isDisplayed());
        } catch (Exception e) {
            fail("----Nothing to display-----");
        }
    }

    @Then("verify user shouldn't second duplicate computer name as a {string}")
    public void verifyUserShouldnTSecondDuplicateComputerNameAsA(String computerName) {
        try {
            assertFalse(Driver.get().findElement(By.xpath("//td[.='" + computerName + "']")).isDisplayed());
        } catch (NoSuchElementException e) {
            fail("----Nothing to display-----");
        }
    }

    @Then("verify {string}")
    public void verify(String errorMessage) {
        if (errorMessage.contains("Failed to refine type")) {
            try {
                String actualErrorMessage = Driver.get().findElement(By.xpath("//span[.='" + errorMessage + " : Predicate isEmpty() did not fail.']")).getText().substring(0, 21);
                assertEquals(errorMessage, actualErrorMessage);
                assertTrue(Driver.get().findElement(By.xpath("//span[.='" + errorMessage + " : Predicate isEmpty() did not fail.']")).isDisplayed());

            } catch (NoSuchElementException e) {
                fail("Failed to refine type");
            }
        } else {
            String actualErrorMessage = Driver.get().findElement(By.xpath("(//*[@class='help-inline'])[2]")).getText().substring(0, 21);
            assertEquals(errorMessage, actualErrorMessage);
            assertTrue(Driver.get().findElement(By.xpath("(//*[@class='help-inline'])[2]")).isDisplayed());
        }
    }

    @When("user enter computer name {string}, Introduced {string}, Discontinued {string}, Company {string} and click Cancel button")
    public void userEnterComputerNameIntroducedDiscontinuedCompanyAndClickCancelButton(String computerName, String introducedDate, String discontinuedDate, String company) {
        pages.addAComputerPage().computerNameInput.sendKeys(computerName);
        pages.addAComputerPage().introducedInput.sendKeys(introducedDate);
        pages.addAComputerPage().discontinuedInput.sendKeys(discontinuedDate);
        pages.addAComputerPage().getSelectCompanyName().selectByVisibleText(company);
        pages.addAComputerPage().cancelButton.click();
    }

    @Then("verify that computer name {string} not display in the result table")
    public void verifyThatComputerNameNotDiplayInTheResultTable(String computerName) {
        assertTrue("---Nothing to display Message----", Driver.get().findElement(By.xpath("//em[.='Nothing to display']")).isDisplayed());
    }

    @And("user click Cancel this computer button")
    public void userClickCancelThisComputerButton() {
        pages.addAComputerPage().cancelButton.click();
    }

    @When("user click {string} link")
    public void userClickLink(String linkName) {
        Driver.get().findElement(By.xpath("//th/a[.='" + linkName + "']")).click();
    }

    @Then("verify {string} result should be ascending {string}")
    public void verifyResultShouldBeAscending(String linkName,String order) {
        assertTrue(Driver.get().findElement(By.xpath("//a[@href='/computers?p=0&n=10&s="+linkName+"&d="+order+"']")).isDisplayed());
    }
}
