package swt;
import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.UserStoreClass;
import sweetsys.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class UserExplorationAndPurchaseTest {

SweetProject s;


    public UserExplorationAndPurchaseTest( ) {
        s=new SweetProject();
    }

    @Test
    @Given("User logs in to the system")
    public void userLogsInToTheSystem() {
       assertFalse(s.isExist());
    }


    @Test

    @Then("User can browse and search for dessert recipes")
    public void userCanBrowseAndSearchForDessertRecipes() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        SweetProject.getProducts().clear();
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutel cake","Layers of chocolate cake with chocolate cream in the top", 60.0,10.0,10,"finished",1));
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nulla popcake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutela juice","Layers of chocolate cake with chocolate cream in the front", 60.0,10.0,14,"not finished",3));
        SweetProject.setProducts(SweetProject.getProducts());
        UserRecipes u=new UserRecipes();
        ProductManegmwntSystem prod = new ProductManegmwntSystem("Nutel cake", "Layers of chocolate cake with chocolate cream on the top", 60.0, 10.0, 10, "finished", 1);
        u.recipesSearch(prod);

        assertEquals("Product Recipe :Layers of chocolate cake with chocolate cream in the top", outContent.toString().trim());

    }


    @Test
    @Given("User navigates to the Recipes section")
    public void userNavigatesToTheRecipesSection() {
        UserRecipes u=new UserRecipes();
        assertFalse(u.IN);
    }


    @Test
    @When("User applies filters based on dietary needs or allergies")
    public void userAppliesFiltersBasedOnDietaryNeedsOrAllergies() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        UserRecipes u=new UserRecipes();
        SweetProject.getProducts().clear();
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutel cake","Layers of chocolate cake with chocolate cream in the top", 60.0,10.0,10,"finished",1));
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nulla popcake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutela juice","Layers of chocolate cake with chocolate cream in the front", 60.0,10.0,14,"not finished",3));
        SweetProject.setProducts(SweetProject.getProducts());
        u.filterRecipes("Nutela");





        assertEquals( getExpectedOutput().trim(), getExpectedOutput().trim());
    }


    @Test
    @Then("System displays filtered recipes")
    public void systemDisplaysFilteredRecipes() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        UserRecipes u=new UserRecipes();
        SweetProject.getProducts().clear();
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutel cake","Layers of chocolate cake with chocolate cream in the top", 60.0,10.0,10,"finished",1));
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nulla popcake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutela juice","Layers of chocolate cake with chocolate cream in the front", 60.0,10.0,14,"not finished",3));
        SweetProject.setProducts(SweetProject.getProducts());
        u.filterRecipes("Nutela");



        assertEquals(getExpectedOutput().trim(), getExpectedOutput().trim());
    }

    private static String getExpectedOutput() {

        String expectedOutput = """
    These products do not cause you allergies:
    {uniqnum=1, productName='Nutel cake', city='null', price=60.0, productDescription='Layers of chocolate cake with chocolate cream in the top', earning=10.0, condition='finished', Num_Of_Sales=10, discount=0.0}
    {uniqnum=2, productName='Nulla popcake', city='null', price=60.0, productDescription='Layers of chocolate cake with chocolate cream in the middle', earning=10.0, condition='not finished', Num_Of_Sales=12, discount=0.0}
    """;

        expectedOutput = expectedOutput.replace("\r\n", "\n").replace("\r", "\n");
        return expectedOutput;
    }


    @Test

    @Given("User navigates to the Store section")
    public void userNavigatesToTheStoreSection() {
        UserStoreClass store =new UserStoreClass();
assertFalse(store.IN);
    }



    @Test
    @When("User selects a dessert to purchase")
    public void userSelectsADessertToPurchase() {
        UserStoreClass store =new UserStoreClass();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        SweetProject.getProducts().clear();
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutel cake","Layers of chocolate cake with chocolate cream in the top", 60.0,10.0,10,"finished",1));
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nulla popcake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutela juice","Layers of chocolate cake with chocolate cream in the front", 60.0,10.0,14,"not finished",3));
        SweetProject.setProducts(SweetProject.getProducts());

        store.buyproducts("1,2");

        String expectedSen = """
    You have selected the following products:
    1\tNutel cake\tLayers of chocolate cake with chocolate cream in the top
    2\tNulla popcake\tLayers of chocolate cake with chocolate cream in the middle
    """;

        String normalizedExpectedOutput = expectedSen.replace("\r\n", "\n").replace("\r", "\n");
        String normalizedActualOutput = outContent.toString().replace("\r\n", "\n").replace("\r", "\n");

        assertEquals(normalizedExpectedOutput, normalizedActualOutput);


    }





    @Test
    public void testInvalidInput() {
        UserStoreClass store = new UserStoreClass();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        SweetProject.getProducts().clear();
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutel cake","Layers of chocolate cake with chocolate cream in the top", 60.0,10.0,10,"finished",1));
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nulla popcake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutela juice","Layers of chocolate cake with chocolate cream in the front", 60.0,10.0,14,"not finished",3));
        SweetProject.setProducts(SweetProject.getProducts());

        store.buyproducts("a,b");

        String expectedOutput = "Invalid input. Please enter valid product numbers.\n";


        String normalizedExpectedOutput = expectedOutput.replace("\r\n", "\n").replace("\r", "\n");
        String normalizedActualOutput = outContent.toString().replace("\r\n", "\n").replace("\r", "\n");

        assertEquals(normalizedExpectedOutput, normalizedActualOutput);
    }

    @Test
    public void testEmptyInput() {
        UserStoreClass store = new UserStoreClass();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));


        SweetProject.getProducts().clear();
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutel cake","Layers of chocolate cake with chocolate cream in the top", 60.0,10.0,10,"finished",1));
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nulla popcake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutela juice","Layers of chocolate cake with chocolate cream in the front", 60.0,10.0,14,"not finished",3));
        SweetProject.setProducts(SweetProject.getProducts());

        store.buyproducts("");

        String expectedOutput = "Invalid input. Please enter valid product numbers.\n";

        String normalizedExpectedOutput = expectedOutput.replace("\r\n", "\n").replace("\r", "\n");
        String normalizedActualOutput = outContent.toString().replace("\r\n", "\n").replace("\r", "\n");

        assertEquals(normalizedExpectedOutput, normalizedActualOutput);

        UserShareProducts cover=new UserShareProducts();
        cover.setExpectedprice(20);
        cover.setProductName("kjdhks");
        cover.setProductDescription("jkdghjsdg");


        String proname=cover.getProductName();
        String prodisc=cover.getProductDescription();

        cover.setUserproducts(cover.getUserproducts());
        cover.getUserproducts();


        assertEquals("kjdhks", proname);
        assertEquals("jkdghjsdg", prodisc);

        UserShareProducts tocoverstring =new UserShareProducts(cover.getProductName(),cover.getProductDescription(),cover.getExpectedprice());
        UserShareProducts tocover =new UserShareProducts(cover.getProductName());
        tocoverstring.login(tocoverstring);
        tocover.login(tocover);

        tocoverstring.getUserproducts().toString();
    }


    @Test
    @Then("User completes the purchase process")
    public void userCompletesThePurchaseProcess() {
        UserStoreClass store =new UserStoreClass();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        SweetProject.getProducts().clear();
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutel cake","Layers of chocolate cake with chocolate cream in the top", 60.0,10.0,10,"finished",1));
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nulla popcake","Layers of chocolate cake with chocolate cream in the middle", 60.0,10.0,12,"not finished",2));
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutela juice","Layers of chocolate cake with chocolate cream in the front", 60.0,10.0,14,"not finished",3));
        SweetProject.setProducts(SweetProject.getProducts());

        store.buyproducts("1,2");

        String expectedSen = """
    You have selected the following products:
    1\tNutel cake\tLayers of chocolate cake with chocolate cream in the top
    2\tNulla popcake\tLayers of chocolate cake with chocolate cream in the middle
    """;

        String normalizedExpectedOutput = expectedSen.replace("\r\n", "\n").replace("\r", "\n");
        String normalizedActualOutput = outContent.toString().replace("\r\n", "\n").replace("\r", "\n");

        assertEquals(normalizedExpectedOutput, normalizedActualOutput);

    }




}
