package com.computer_db.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddAComputerPage extends ComputerHomePage {

    @FindBy(id = "name")
    public WebElement computerNameInput;

    @FindBy(id = "introduced")
    public WebElement introducedInput;

    @FindBy(id = "discontinued")
    public WebElement discontinuedInput;

    @FindBy(css = "*[id='company']")
    public WebElement companyDropDownElement;

    @FindBy(css = "input[value='Create this computer']")
    public WebElement createThisComputerButton;

    @FindBy(xpath = "//a[.='Cancel']")
    public WebElement cancelButton;

    @FindBy(css = "input[value='Save this computer']")
    public WebElement saveThisComputerBtn;

    @FindBy(css = "input[value='Delete this computer']")
    public WebElement deletThisComputerBtn;



    /**
     * This method return select object
     * @return
     */
    public Select getSelectCompanyName() {
        return new Select(companyDropDownElement);
    }


    public String dateConversion(String date){
        DateFormat format = new SimpleDateFormat("dd MMM yyyy");
        Date dateNew=null;
        try {
           dateNew = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return String.valueOf(dateNew);
    }



}
