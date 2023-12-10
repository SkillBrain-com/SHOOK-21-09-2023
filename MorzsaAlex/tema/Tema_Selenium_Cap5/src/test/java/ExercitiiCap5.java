import driver.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.A;
import org.example.Main;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ExercitiiCap5 {


    public static void main(String[] args) throws IOException, InterruptedException {




        basicWebPageExample();

        elementAttributesExamples();

        findByPlayground();

        simpleWebPage();

//        youtTube();

        textBox();

        checkBox();

        radioButton();

        webTables();
//
        buttons();
    }
    public static void basicWebPageExample(){

        ChromeDriver driver = WebDriverManager.createChromeDrive();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver.manage().window().maximize();
        driver.get("https://testpages.eviltester.com/styled/basic-web-page-test.html");

        //By xpath
        WebElement firstParagraph = driver.findElement(By.xpath("//div[@class='centered']/p[@id='para1']"));
        System.out.println(firstParagraph.getText());

        WebElement secondParagraph = driver.findElement(By.xpath("//div[@class='centered']/p[@id='para2']"));
        System.out.println(secondParagraph.getText());

        //By id
        WebElement firstIdParagraph = driver.findElement(By.id("para1"));
        System.out.println(firstIdParagraph.getText());

        WebElement secondIdParagraph = driver.findElement(By.id("para2"));
        System.out.println(secondIdParagraph.getText());

        //By cssSelector

        WebElement firstCssParagraph = driver.findElement(By.cssSelector("div.centered #para1"));
        System.out.println(firstCssParagraph.getText());

        WebElement secoundCssParagraph = driver.findElement(By.cssSelector("div.centered #para2"));
        System.out.println(secoundCssParagraph.getText());

        //value of atribut ID

        WebElement valueIdParagraph = driver.findElement(By.cssSelector("div.centered p"));
        System.out.println(valueIdParagraph.getAttribute("id"));

        //by link

        WebElement linkEvilTester = driver.findElement(By.linkText("EvilTester.com"));
        linkEvilTester.click();

        WebElement linkCompendiumDevelopments = driver.findElement(By.linkText("Compendium Developments"));
        linkCompendiumDevelopments.click();


        driver.quit();

    }


    public static void elementAttributesExamples(){



        ChromeDriver driver = WebDriverManager.createChromeDrive();
        driver.get("https://testpages.eviltester.com/styled/attributes-test.html");

        //By id
        WebElement title = driver.findElement(By.id("domattributes"));
        System.out.println(title.getAttribute("original-title"));


        //By xpath
        WebElement title1 = driver.findElement(By.xpath("//div[@class='centered']/div[@class='coloured-para-blue']/p[@id='domattributes']"));
        System.out.println(title1.getAttribute("original-title"));


        //Aici am intrat cu un for ca erau atribute dinamice si sa se afiseze de 5 ori sa se vada ca sunt idferite
        int contor = 0;

        while (contor<5){

            WebElement dynamicAttribute = driver.findElement(By.id("jsautoattributes"));
            System.out.println("AttributeName este: " + dynamicAttribute.getAttribute("name"));
            System.out.println("Data-count este: " + dynamicAttribute.getAttribute("data-count"));
            System.out.println("Data-dynamic este: " + dynamicAttribute.getAttribute("data-dynamic"));

            contor++;

        }

        /*Aici de fiecare data cand apasai button de add se adauga inca un element
        * si la fel am intrat cu un for sa afisez cateva clickuri si am luat atributul dupa fiecare click */

        WebElement custom1 = driver.findElement(By.cssSelector("div.coloured-para-green p"));
        System.out.println(custom1.getAttribute("nextid"));

        while (contor<10){

            WebElement clikRefresh = driver.findElement(By.className("styled-click-button"));
            clikRefresh.click();

            WebElement custom = driver.findElement(By.cssSelector("div.coloured-para-green p"));
            System.out.println(custom.getAttribute("nextid"));
            contor++;
        }


        driver.quit();

    }

    public static void findByPlayground() {

        ChromeDriver driver = WebDriverManager.createChromeDrive();
        driver.get("https://testpages.eviltester.com/styled/find-by-playground-test.html");

        WebElement nestedParagraph = driver.findElement(By.xpath("//div[@class='nestedDiv']/div/div/div/div[@class='nestedDiv']/p[@id='p30']"));
        System.out.println("Sunt paragraful 30 " + nestedParagraph.getText());

        WebElement paraghraphY = driver.findElement(By.id("p25"));
        System.out.println(paraghraphY.getText());

        WebElement attributeId = driver.findElement(By.cssSelector("#p25 a"));
        System.out.println(attributeId.getAttribute("id"));


        WebElement jumpLink = driver.findElement(By.linkText("jump to para 14"));
        jumpLink.click();


        WebElement withinBttomPage = driver.findElement(By.cssSelector("#div19 pre#pre1"));
        System.out.println(withinBttomPage.getText());



        driver.quit();

    }



    public static void simpleWebPage() {

        ChromeDriver driver = WebDriverManager.createChromeDrive();
        driver.get("https://testpages.eviltester.com/styled/webdriver-example-page?number-entry=123456789");

        //By xpath
        WebElement firstParagraph = driver.findElement(By.xpath("//div[@class='centered']/div/div/p[@id='para1']"));
        System.out.println(firstParagraph.getText() + " by path");

        WebElement secoundParagraph = driver.findElement(By.xpath("//div[@class='centered']/div/div/p[@id='para2']"));
        System.out.println(secoundParagraph.getText()+ " by path");
        System.out.println();

        //By id
        WebElement firstParagraphById = driver.findElement(By.id("para1"));
        System.out.println(firstParagraphById.getText() + " by ID");

        WebElement secoundParagraphById = driver.findElement(By.id("para2"));
        System.out.println(secoundParagraphById.getText() + " by ID");
        System.out.println();

        //By css
        WebElement firstParagraphByCss = driver.findElement(By.cssSelector(".centered div.main-content #main-example-paras p#para1"));
        System.out.println(firstParagraphByCss.getText()+ " by css");


        WebElement secoundParagraphByCss = driver.findElement(By.cssSelector(".centered div.main-content #main-example-paras p#para2"));
        System.out.println(secoundParagraphByCss.getText() + " by css");
        System.out.println();

        //By cssSelector
        WebElement listItem1 = driver.findElement(By.cssSelector("#main-example-list .example-list-item"));
        System.out.println(listItem1.getText());

        List<WebElement> listItems = driver.findElements(By.cssSelector("#main-example-list li"));

        //Cu un for sa le afisam pe toate, ca vad ca cu css nu pot sa le targetez pe rand fara for ca si cu xpath

        for(int i =0; i< listItems.size();i++){
            System.out.println(listItems.get(i).getText());
        }

        System.out.println();


        //By xpath putem sa le afisam si pe rand nu toate odata
        WebElement listItemBypath = driver.findElement(By.xpath("//div[@data-locator='example-ul']//ul[@id='main-example-list']/li[@class='example-list-item' and @data-locator='li1']"));
        System.out.println(listItemBypath.getText());
        WebElement listItem2Bypath = driver.findElement(By.xpath("//div[@data-locator='example-ul']//ul[@id='main-example-list']/li[@class='example-list-item' and @data-locator='li2']"));
        System.out.println(listItem2Bypath.getText());
        WebElement listItem3Bypath = driver.findElement(By.xpath("//div[@data-locator='example-ul']//ul[@id='main-example-list']/li[@class='example-list-item' and @data-locator='li3']"));
        System.out.println(listItem3Bypath.getText());


        WebElement whiteBox = driver.findElement(By.id("numentry"));
        whiteBox.clear();
        whiteBox.sendKeys("4");

        WebElement clickButton = driver.findElement(By.id("submit-to-server"));
        clickButton.click();

        WebElement savedInputNumber = driver.findElement(By.id("message"));
        System.out.println(savedInputNumber.getText());



        WebElement showAsAlert = driver.findElement(By.cssSelector("div button#show-as-alert"));
        showAsAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement showAsPara = driver.findElement(By.cssSelector("div button#show-as-para"));
        showAsPara.click();

        WebElement messageFromPara = driver.findElement(By.id("message"));
        System.out.println(messageFromPara.getAttribute("style"));

        WebElement showFromLink = driver.findElement(By.linkText("Show From Link"));
        showFromLink.click();

        WebElement showFromLinkMessage = driver.findElement(By.id("clickable-link"));
        System.out.println(showFromLinkMessage.getText());


        driver.quit();

    }


    public static void youtTube() throws InterruptedException {

        ChromeDriver driver = WebDriverManager.createChromeDrive();
        driver.get("https://www.youtube.com/");

        TimeUnit.SECONDS.sleep(3);

        WebElement popup = driver.findElement(By.xpath("//div[@class='eom-button-row style-scope ytd-consent-bump-v2-lightbox']/ytd-button-renderer/yt-button-shape/button"));
        popup.click();

        TimeUnit.SECONDS.sleep(1);

        WebElement searchBox = driver.findElement(By.cssSelector("div#container #search"));
        searchBox.sendKeys("2pac");


        WebElement clickButton = driver.findElement(By.cssSelector("#container button#search-icon-legacy"));
        clickButton.click();

        TimeUnit.SECONDS.sleep(2);


        //music play - 2Pac - Hit 'Em Up
        WebElement playVideo = driver.findElement(By.xpath("//div[@id='title-wrapper']//a[@id='video-title']"));
        playVideo.click();

        TimeUnit.SECONDS.sleep(10);

        driver.get("https://www.youtube.com/watch?v=41qC3w3UUkU"); // cand trece pe alt link , intra reclama si trebuie pus time altfel da erroare


        TimeUnit.SECONDS.sleep(2); // time ca trece pe alt link si incep iara reclama, si am obs cu time gaseste buttonul de like altfel da erroare


        WebElement clickLike = driver.findElement(By.id("segmented-like-button"));
        clickLike.click();

        TimeUnit.SECONDS.sleep(1200);//am pus timp ca sa pot sa ascult melodia inainte de quit

        driver.quit();

    }


    public static void textBox() throws InterruptedException {


        ChromeDriver driver = WebDriverManager.createChromeDrive();
        driver.get("https://demoqa.com/text-box");


        /*----------Home BUtton Logo-ul-----------*/

            //By tagName
            WebElement header = driver.findElement(By.tagName("header"));
            header.click();

            //By cssSelector
            WebElement headerCss = driver.findElement(By.cssSelector("header a"));
            headerCss.click();



        driver.get("https://demoqa.com/text-box");



        //By css luam ce se afiseaza in main-header adica - > 'textul box' si luam numele atributului class
        WebElement maintext = driver.findElement(By.cssSelector("div.main-header"));
        System.out.println(maintext.getText());
        System.out.println(maintext.getAttribute("class"));

        //By id

        WebElement firstName = driver.findElement(By.id("userName"));
        firstName.clear();
        firstName.sendKeys("Alex");

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.clear();
        userEmail.sendKeys("alex@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//div[@class='col-md-9 col-sm-12']/textarea[@id='currentAddress']"));
        currentAddress.clear();
        currentAddress.sendKeys("Barniutiu nr 14 ");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.clear();
        permanentAddress.sendKeys("Barniutiu nr 14 ");



        TimeUnit.SECONDS.sleep(2);

        WebElement submitButton = driver.findElement(By.xpath("//div[@class='text-right col-md-2 col-sm-12']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).build().perform();

        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        TimeUnit.SECONDS.sleep(2);
        submitButton.click();


        driver.quit();

    }




    public static void checkBox() throws InterruptedException {


        ChromeDriver driver = WebDriverManager.createChromeDrive();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/checkbox");


        //By cssSelector , luam Textul din main header adica -> Check Box, si numele de la atributul class header

        WebElement mainHeader = driver.findElement(By.cssSelector("div.body-height div.main-header"));
        System.out.println(mainHeader.getText());
        System.out.println(mainHeader.getAttribute("class"));

//        By cssSelector and xpath
                WebElement hideElement = driver.findElement(By.cssSelector("#app div.body-height div.check-box-tree-wrapper ol button svg"));
                hideElement.click();

                WebElement hideElemnetByXpath = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']//ol//button"));
                hideElemnetByXpath.click();

//        By xpath and css

                WebElement checkBox = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']//ol//label[@for='tree-node-home']"));
                checkBox.click();

                WebElement checkBoxByCSS = driver.findElement(By.cssSelector("div.check-box-tree-wrapper ol label span"));
                checkBoxByCSS.click();

//        By css and xpath

                WebElement plusButton = driver.findElement(By.cssSelector("div.rct-options button"));
                plusButton.click();

                WebElement plusButtonByXpath = driver.findElement(By.xpath("//div[@class='rct-options']/button[@aria-label='Expand all']"));
                plusButtonByXpath.click();

//        By xpath and css , aici minusButton merge impreuna cu plusButton , unul extinde si unul inchide un meniu sa zic asa

                WebElement minusButton = driver.findElement(By.xpath("//div[@class='rct-options']/button[@aria-label='Collapse all']"));
                minusButton.click();

                WebElement minusButtonByCss = driver.findElement(By.cssSelector("div.rct-options button[aria-label=\"Collapse all\"] svg"));
                minusButtonByCss.click();



//        By css , extindem de pe butonul plus si selectam  Public din Office si afisam si textul Public

                WebElement plusButton2 = driver.findElement(By.cssSelector("div.rct-options button"));
                plusButton2.click();

                WebElement publicCheckBox = driver.findElement(By.cssSelector("label[for=\"tree-node-public\"]"));
                Actions actions = new Actions(driver);
//                actions.moveToElement(publicCheckBox).build().perform();
                actions.sendKeys(Keys.PAGE_DOWN).build().perform();
                TimeUnit.SECONDS.sleep(2);
                publicCheckBox.click();
                System.out.println(publicCheckBox.getText());

//        Afisam din folderul Desktop textul Desktop dupa ce dam click pe button

                WebElement plusButton1 = driver.findElement(By.cssSelector("div.rct-options button"));
                plusButton1.click();

                WebElement desktopText = driver.findElement(By.cssSelector("label[for=\"tree-node-desktop\"]"));
                System.out.println(desktopText.getText());

                //by cssSelector luam textul Private din Office

                WebElement privateText = driver.findElement(By.cssSelector("label[for=\"tree-node-private\"]"));
                System.out.println(privateText.getText());

        driver.quit();

    }


    /*---------Radio Button------------*/

    public static void radioButton(){

        ChromeDriver driver = WebDriverManager.createChromeDrive();
        driver.get("https://demoqa.com/radio-button");


//        By cssSelector luam si denumirea butonul aidca YES
        WebElement yesButtonRadio = driver.findElement(By.cssSelector("label[class=\"custom-control-label\"][for=\"yesRadio\"]"));
        System.out.println(yesButtonRadio.getText());
        yesButtonRadio.click();

//        By css luam si denumirea butonul aidca NO
        WebElement noButtonRadio = driver.findElement(By.cssSelector("label[class=\"custom-control-label disabled\"][for=\"noRadio\"]"));
        System.out.println(noButtonRadio.getText());
        noButtonRadio.click();
        assertTrue(noButtonRadio.isEnabled(),"Button can't be clickable");



        driver.quit();

    }


    public static void webTables() throws InterruptedException{


        ChromeDriver driver = WebDriverManager.createChromeDrive();
        driver.get("https://demoqa.com/webtables");

        List<WebElement> tabelWeb = driver.findElements(By.className("rt-tr"));
        WebElement headerfirstRow = tabelWeb.get(0);

        List<WebElement> shoeNameHeader = headerfirstRow.findElements(By.className("rt-th"));
        for(int i =0; i< shoeNameHeader.size();i++){
            System.out.println("Coloana " + (i+1) + " de pe linia header " +  shoeNameHeader.get(i).getText());
        }
//        System.out.println("Coloana1 din headerLine " + shoeNameHeader.get(0).getText());
//        System.out.println("Coloana2 din headerLine " + shoeNameHeader.get(1).getText());
//        System.out.println("Coloana3 din headerLine " + shoeNameHeader.get(2).getText());
//        System.out.println("Coloana4 din headerLine " + shoeNameHeader.get(3).getText());
//        System.out.println("Coloana5 din headerLine " + shoeNameHeader.get(4).getText());
//        System.out.println("Coloana6 din headerLine " + shoeNameHeader.get(5).getText());
//        System.out.println("Coloana7 din headerLine " + shoeNameHeader.get(6).getText());


        List<WebElement> lineFromTable = driver.findElements(By.className("rt-tr-group"));
        WebElement firstLine = lineFromTable.get(0);

        List<WebElement> nameFromFirstLine = firstLine.findElements(By.className("rt-td"));

        for(int i = 0 ; i< nameFromFirstLine.size()-1; i++){

            //cu for mergem pana la ultima pozitie din lista ca ultima pozitie ar fi goala ca in header este ACtion (delete,edit etc) si pe linia 1 ar fi gol

            System.out.println("Coloana " + (i+1) + " de pe linia 1: " + nameFromFirstLine.get(i).getText());
        }
//        System.out.println("Coloana1 de pe linia1 " + nameFromFirstLine.get(0).getText());
//        System.out.println("Coloana2 de pe linia1 " + nameFromFirstLine.get(1).getText());

        WebElement secoundLine = lineFromTable.get(1);
        List<WebElement> nameFromSecoundLine = secoundLine.findElements(By.className("rt-td"));

        for(int i = 0 ; i < nameFromSecoundLine.size()-1; i++){

            System.out.println("Coloana " + (i+1) + " de pe linia 2: " + nameFromSecoundLine.get(i).getText());
        }
//        System.out.println("Coloana1 de pe linia 2 " + nameFromSecoundLine.get(0).getText());
//        System.out.println("Coloana2 de pe linia 2 "+ nameFromSecoundLine.get(1).getText());

        WebElement thirdLine = lineFromTable.get(2);
        List<WebElement> nameFromThirdLine = thirdLine.findElements(By.className("rt-td"));

        for(int i = 0; i < nameFromThirdLine.size()-1; i++){

            System.out.println("Coloana " + (i+1) + " de pe linia 3: " + nameFromThirdLine.get(i).getText());
        }

        WebElement addButtonOpen = driver.findElement(By.id("addNewRecordButton"));
        addButtonOpen.click();


//        WebElement closeAddButtonFromX = driver.findElement(By.cssSelector("button[type=\"button\"][class=\"close\"]"));
//        closeAddButtonFromX.click();


        WebElement addPersonFirstName = driver.findElement(By.id("firstName"));
        addPersonFirstName.clear();
        addPersonFirstName.sendKeys("Alex");

        WebElement addPersonLastName = driver.findElement(By.id("lastName"));
        addPersonLastName.clear();
        addPersonLastName.sendKeys("Morja");

        WebElement addPersonEmail = driver.findElement(By.id("userEmail"));
        addPersonEmail.clear();
        addPersonEmail.sendKeys("alex@gmail.com");

        WebElement addPersonAge = driver.findElement(By.id("age"));
        addPersonAge.clear();
        addPersonAge.sendKeys("37");

        WebElement addPersonSalary = driver.findElement(By.cssSelector("#salary-wrapper div.col-md-9 input[id=\"salary\"]"));
        addPersonSalary.clear();;
        addPersonSalary.sendKeys("4000");

        WebElement addPersonDepartment = driver.findElement(By.xpath("//div[@class='col-md-6 col-sm-6']/input[@id='department']"));
        addPersonDepartment.clear();
        addPersonDepartment.sendKeys("QA Testing");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();


        List<WebElement> lineFromTable1 = driver.findElements(By.className("rt-tr-group"));
        WebElement fourthLine  = lineFromTable1.get(3);
        List<WebElement> nameFromFourthLine = fourthLine.findElements(By.className("rt-td"));

        for(int i = 0 ; i< nameFromFourthLine.size()-1; i++){

            System.out.println("Coloana " + (i+1) + " de pe linia 4: " + nameFromFourthLine.get(i).getText());
        }



        WebElement searchField = driver.findElement(By.id("searchBox"));
        searchField.clear();
        searchField.sendKeys("Alex");
        searchField.clear();



//        TimeUnit.SECONDS.sleep(5);
        WebElement selectRowButtonDownOnThePage = driver.findElement(By.xpath("//span[@class='select-wrap -pageSizeOptions']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(selectRowButtonDownOnThePage).build().perform();

        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        TimeUnit.SECONDS.sleep(2);

        selectRowButtonDownOnThePage.click();

        //By xpath luam si atributul si afisam si textul de la 20 Rows
        WebElement selectButton20Rows = driver.findElement(By.xpath("//select[@aria-label='rows per page']/option[@value='20']"));
        selectButton20Rows.click();
        System.out.println(selectButton20Rows.getText());
        System.out.println(selectButton20Rows.getAttribute("value"));

        driver.quit();

    }


    public static void buttons() throws InterruptedException, IOException {

        ChromeDriver driver = WebDriverManager.createChromeDrive();
        driver.get("https://demoqa.com/buttons");


        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick).perform();
        System.out.println(doubleClick.getText());


        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        Actions actions1 = new Actions(driver);
        actions1.contextClick(rightClick).perform();
        System.out.println(rightClick.getText());


        File file = driver.getScreenshotAs(OutputType.FILE);
        File destinFile = new File("adresa unde vrem sa se salveze screenShot-ul in pc");
        FileUtils.copyFile(file,destinFile);


        //By xpath
        WebElement click = driver.findElement(By.xpath("//button[text()='Click Me']"));
         click.click();
        System.out.println(click.getText());


        driver.quit();
    }


}
