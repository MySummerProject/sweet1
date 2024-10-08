package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.*;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class AdminMonitoringAndReportingTest {

SweetProject s;

    public AdminMonitoringAndReportingTest( ) {
        s = new SweetProject();
    }

    @Before
    public void setUp() {
        SweetProject.getProducts().clear();
        SweetProject.getNablusProdcuts().clear();
        SweetProject.getJeninprodcuts().clear();
        SweetProject.getNablusbestselling().clear();
        SweetProject.getJeninbestselling().clear();
        SweetProject.getNablususers().clear();
        SweetProject.getJeninUsers().clear();
    }

    @Test
    @Given("Admin logs in to the system")
    public void adminLogsInToTheSystem() {
assertFalse(s.isExist());
    }


    @Test
    @When("Admin navigates to the Reports section")
    public void adminNavigatesToTheReportsSection() {
        AdminReports admin=new AdminReports();
assertFalse(admin.IN);
    }


    @Test
    @When("Admin selects the desired report type \\(e.g., monthly profits)")
    public void adminSelectsTheDesiredReportTypeEGMonthlyProfits() {
        SalesReport sales=new SalesReport();
        assertFalse(sales.isUserIn());
    }


    @Test
    @Then("System generates and displays the financial report")
    public void systemGeneratesAndDisplaysTheFinancialReport() {

        SweetProject.getProducts().clear();

        SweetProject.getProducts().add(new ProductManegmwntSystem(1,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",5));
        SweetProject.getProducts().add(new ProductManegmwntSystem(2,"Nutella cake","Jenin","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",10));
        SweetProject.getProducts().add(new ProductManegmwntSystem(3,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",12));


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {

            SalesReport sales = new SalesReport();
            sales.shoewSalesreport();
            String output = outputStream.toString();
            String expectedHeader = "Product Name:\tDescrption:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPrice\tEwarning:\tCondition:\tNum_OF_Sales:\tUniq Num:\n";
            assertTrue("Sales report header should be displayed correctly", output.contains(expectedHeader));

        } finally {
            System.setOut(originalOut);
        }
    }


    @Test
    @When("Admin navigates to the Best-Selling Products section")
    public void adminNavigatesToTheBestSellingProductsSection() {
        SalesReport sales=new SalesReport();
        assertFalse(sales.isUserIn());
    }



    @Test
    @Then("System displays a list of best-selling products for each store")
    public void systemDisplaysAListOfBestSellingProductsForEachStore() {
        SweetProject.getProducts().add(new ProductManegmwntSystem(1,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",5));
        SweetProject.getProducts().add(new ProductManegmwntSystem(2,"Nutella ","Jenin","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",10));
        SweetProject.getProducts().add(new ProductManegmwntSystem(3,"pop cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",12));
        SweetProject.getProducts().add(new ProductManegmwntSystem(4,"marcemillo cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",13));
        SweetProject.getProducts().add(new ProductManegmwntSystem(5,"lotos cake","Jenin","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",30));
        SweetProject.getProducts().add(new ProductManegmwntSystem(6,"juice la","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",35));
        AdminReports a=new AdminReports();
        a.separateEachCity();
        a.showBestSellingForNablus();
        a.showBestSellingForJenin();


        assertEquals(1, SweetProject.getNablusbestselling().size());
        assertTrue(SweetProject.getNablusbestselling().stream().anyMatch(p -> p.getProductName().equals("juice la") && p.getNumOfsales()==35));

        assertEquals(1, SweetProject.getJeninbestselling().size());
        assertTrue(SweetProject.getJeninbestselling().stream().anyMatch(p -> p.getProductName().equals("lotos cake") && p.getNumOfsales() == 30));


    }



    @Test
    @When("Admin navigates to the User Statistics section")
    public void adminNavigatesToTheUserStatisticsSection() {
AdminReports a=new AdminReports();
assertFalse(a.IN);
    }


    @Test
    @Then("System displays user statistics categorized by city \\(e.g., Nablus, Jenin)")
    public void systemDisplaysUserStatisticsCategorizedByCityEGNablusJenin() {
        SweetProject.getUsers().clear();
        SweetProject.getUsers().add(new User("anwar", "123", 1,"anwar123@gmail.com","Jenin"));
        SweetProject.getUsers().add(new User("ahmad", "1234", 3,"ahmad1234@gmail.com","Nablus"));
        SweetProject.getUsers().add(new User("yasmine", "12345", 1,"yasmine12345@gmail.com","nablus"));
        SweetProject.getUsers().add(new User("tarneem", "123456", 3,"tarneem123456@gmail.com","Jenin"));
        AdminReports a=new AdminReports();

        a.separateUsersByCity();
        System.out.println("Nablus Users:");
        SweetProject.getNablususers().forEach(System.out::println);
        System.out.println("Jenin Users:");
        SweetProject.getJeninUsers().forEach(System.out::println);

        assertEquals(2, SweetProject.getNablususers().size());
        assertTrue(SweetProject.getNablususers().stream().anyMatch(u -> u.getUsername().equals("ahmad")));
        assertTrue(SweetProject.getNablususers().stream().anyMatch(u -> u.getUsername().equals("yasmine")));

        assertEquals(2, SweetProject.getJeninUsers().size());
        assertTrue(SweetProject.getJeninUsers().stream().anyMatch(u -> u.getUsername().equals("anwar")));
        assertTrue(SweetProject.getJeninUsers().stream().anyMatch(u -> u.getUsername().equals("tarneem")));
    }


}
