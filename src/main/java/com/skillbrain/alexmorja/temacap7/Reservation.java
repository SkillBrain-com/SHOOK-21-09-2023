package com.skillbrain.alexmorja.temacap7;
import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Reservation extends BeforeAfterLogin {


    @Test(description = "Pozitive reservation",groups = {"with-login"})
    public void pozitiveReservation(){

        //Aici cu List am selectat un idex din listFAcility
        List<WebElement> listFacility = driver.findElements(By.cssSelector("select[id=\"combo_facility\"]"));
        WebElement elementFromList = listFacility.get(0);
        List<WebElement> secoundElement = elementFromList.findElements(By.cssSelector("#combo_facility option"));
        secoundElement.get(2).click();


        //Aici am selectat din Facility list la fel un idex cu Select ca tagul era <select> si e mai simplist asa
        Select select = new Select(driver.findElement(By.cssSelector("select[id=\"combo_facility\"]")));
        select.selectByIndex(1);

        //Checkboxul apply for readmission
        WebElement applyForReadmissionCheckBox = driver.findElement(By.id("chk_hospotal_readmission"));
        applyForReadmissionCheckBox.click();

        //radio buttons healthcare program
        WebElement healthcareProgramButtonsMedicaid = driver.findElement(By.cssSelector("label[class=\"radio-inline\"] input[id=\"radio_program_medicaid\"]"));
        healthcareProgramButtonsMedicaid.click();

        //Tabelul cu visite date
        WebElement visiteDate = driver.findElement(By.id("txt_visit_date"));
        visiteDate.click();

        //Aici am verificat daca merge next month -> next page
        WebElement nextPageFromTableData = driver.findElement(By.xpath("//th[text() = \"»\"]"));
        nextPageFromTableData.click();
        //Inca odata click pe next month
        WebElement nextPageFromTableData2 = driver.findElement(By.xpath("//th[text() = \"»\"]"));
        nextPageFromTableData2.click();

        //Revenim cu o luna inapoi back
        WebElement backPageFromTableData = driver.findElement(By.xpath("//th[text() = \"«\"]"));
        backPageFromTableData.click();

        //Aici am luat textul de la fiecare zi din sapt si am verificat daca sunt isDispalyed
        List<WebElement> daysFromTable = driver.findElements(By.cssSelector("th[class=\"dow\"]"));
        for(WebElement element : daysFromTable){
            System.out.println(element.getText());
            assertTrue(element.isDisplayed(),"Element should be displayed");
        }

        //Aici am extras zilele
        List<WebElement> tableDate = driver.findElements(By.cssSelector("td[class=\"day\"]"));
        for(WebElement element : tableDate){
            System.out.println(element.getText());

        }
        //Si aici am selectat o zi , ziua 4 din tabel
        System.out.println(tableDate.size());
        tableDate.get(3).click();




        WebElement commentField = driver.findElement(By.id("txt_comment"));
        commentField.clear();
        commentField.sendKeys("I have mental problems  -  HAHAHAHAHA ");

        WebElement bookAppointmentButton = driver.findElement(By.id("btn-book-appointment"));
        bookAppointmentButton.click();

        assertTrue(driver.getCurrentUrl().contains("appointment.php#summary"),"The date table is mandatory");

        //Ne intoarcem la pagina pringipala
//        WebElement goToHomePageButton = driver.findElement(By.cssSelector("a[class=\"btn btn-default\"]"));
//        assertTrue(goToHomePageButton.isDisplayed(),"Buuton GoToHomepage is not displayed");
//        goToHomePageButton.click();

        //Ne intoarcem la pagina principala din meniul hamburgher buttonul home
        driver.findElement(By.cssSelector(".fa.fa-bars")).click();
        WebElement homeButton = driver.findElement(By.cssSelector("a[href= \"./\"]"));
        homeButton.click();




    }

    @Test(description = "Negative reservation",groups = {"with-login"})
    public void negativeReservation(){
        //Aici cu List am selectat un idex din listFAcility
        List<WebElement> listFacility = driver.findElements(By.cssSelector("select[id=\"combo_facility\"]"));
        WebElement elementFromList = listFacility.get(0);
        List<WebElement> secoundElement = elementFromList.findElements(By.cssSelector("#combo_facility option"));
        secoundElement.get(2).click();


        //Aici am selectat din Facility list la fel un idex cu Select ca tagul era <select> si e mai simplist asa
        Select select = new Select(driver.findElement(By.cssSelector("select[id=\"combo_facility\"]")));
        select.selectByIndex(1);

        //Checkboxul apply for readmission
        WebElement applyForReadmissionCheckBox = driver.findElement(By.id("chk_hospotal_readmission"));
        applyForReadmissionCheckBox.click();

        //radio buttons healthcare program
        WebElement healthcareProgramButtonsMedicaid = driver.findElement(By.cssSelector("label[class=\"radio-inline\"] input[id=\"radio_program_medicaid\"]"));
        healthcareProgramButtonsMedicaid.click();

        //Tabelul cu visite date
        WebElement visiteDate = driver.findElement(By.id("txt_visit_date"));
        visiteDate.click();

        //Aici am verificat daca merge next month -> next page
        WebElement nextPageFromTableData = driver.findElement(By.xpath("//th[text() = \"»\"]"));
        nextPageFromTableData.click();
        //Inca odata click pe next month
        WebElement nextPageFromTableData2 = driver.findElement(By.xpath("//th[text() = \"»\"]"));
        nextPageFromTableData2.click();

        //Revenim cu o luna inapoi back
        WebElement backPageFromTableData = driver.findElement(By.xpath("//th[text() = \"«\"]"));
        backPageFromTableData.click();






        WebElement commentField = driver.findElement(By.id("txt_comment"));
        commentField.clear();
        commentField.sendKeys("I have mental problems  -  HAHAHAHAHA ");

        WebElement bookAppointmentButton = driver.findElement(By.id("btn-book-appointment"));
        bookAppointmentButton.click();

        assertFalse(driver.getCurrentUrl().contains("appointment.php#summary"),"The user should not be able to reserve without a date");


    }




}
