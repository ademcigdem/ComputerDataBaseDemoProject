package com.computer_db.utils;

import com.computer_db.pages.AddAComputerPage;

public class Pages {

    private AddAComputerPage addAComputerPage;

    public AddAComputerPage addAComputerPage() {
        if (addAComputerPage == null) {
            addAComputerPage = new AddAComputerPage();
        }
        return addAComputerPage;
    }
}
