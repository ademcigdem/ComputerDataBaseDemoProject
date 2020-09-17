package com.computer_db.pages;

import com.computer_db.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerHomePage {

    public ComputerHomePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//a[.='Add a new computer']")
    public WebElement addANewComputerButton;

    @FindBy(css = "*[type='search']")
    public WebElement searchboxInput;

    @FindBy(id = "searchsubmit")
    public WebElement filterbyNameButton;


}
