package swt;

import io.cucumber.java.en.*;
import org.junit.Test;
import sweetsys.*;

import static org.junit.Assert.*;

public class AdminContentManagementTest {

SweetProject s;

    public AdminContentManagementTest( ) {
        s =new SweetProject();
    }


    @Test
    @When("Admin navigates to the Content Management section")
    public void adminNavigatesToTheContentManagementSection() {
ContentSection i =new ContentSection();

assertFalse(i.IN);

    }



    @Test

    @Then("Admin can add, update, or delete recipes and posts shared by users")
    public void adminCanAddUpdateOrDeleteRecipesAndPostsSharedByUsers() {

        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutella cake", "Layers of chocolate cake with chocolate cream in the middle", 60.0, 10.0, 10, "finished", 1));
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutella cake", "Layers of chocolate cake with chocolate cream in the middle", 60.0, 10.0, 12, "not finished", 2));
        SweetProject.getProducts().add(new ProductManegmwntSystem("Nutella cake", "Layers of chocolate cake with chocolate cream in the middle", 60.0, 10.0, 14, "not finished", 3));

        UserShareProducts prod = new UserShareProducts("cake", "Layers of chocolate cake with chocolate cream in the middle", 60.0);
        UserShareProducts pro = new UserShareProducts("ds cake", "Layers of chocolate cake with chocolate cream in the middle", 60.0);
        prod.addnewProductForUser(prod);
        prod.addnewProductForUser(pro);

        UserShareProducts toupdatepro = new UserShareProducts("cake", "Layers of chocolate cake with chocolate", 20.0);
        ContentSection c = new ContentSection();
        c.updateUserrecipes(toupdatepro);

        for (UserShareProducts p : UserShareProducts.getUserproducts()) {
            if (p.getProductName().equalsIgnoreCase("cake") && p.getExpectedprice() == 20.0) {
                break;
            }
        }


        c.deleteUserrecipes(toupdatepro);

        for (UserShareProducts p : UserShareProducts.getUserproducts()) {
            if (p.getProductName().equalsIgnoreCase("cake")) {
                break;
            }
        }

assertFalse(s.isExist());


    }



    @Test

    @When("Admin navigates to the Feedback Management section")
    public void adminNavigatesToTheFeedbackManagementSection() {
AdminFeedback a=new AdminFeedback();
assertFalse(a.IN);
    }



    @Test

    @When("Admin can view all feedback from users")
    public void adminCanViewAllFeedbackFromUsers() {
        FeedBack feed=new FeedBack();
        assertFalse(feed.IN);

        AdminFeedback adminfeed=new AdminFeedback();

        adminfeed.setAdminresponse(adminfeed.getAdminresponse());
        adminfeed.setAdminname("sjkdfhks");
        adminfeed.setResponse("jkdhksjd");
        adminfeed.setUsername("hjgsd");
        adminfeed.setResponseNumber(1);



        AdminFeedback firstadminfeed=new AdminFeedback(adminfeed.getAdminname(),adminfeed.getResponseNumber(),adminfeed.getUsername(), adminfeed.getResponse());
        AdminFeedback admincover=new AdminFeedback(adminfeed.getAdminname(),adminfeed.getResponseNumber(),adminfeed.getResponse(),adminfeed.getUsername());
        firstadminfeed.login(firstadminfeed);
        admincover.login(admincover);
    }



    @Test

    @Then("Admin can respond to or moderate feedback")
    public void adminCanRespondToOrModerateFeedback() {
SweetProject.getUsers().clear();
FeedBack.getFeedBacklist().clear();
AdminFeedback.getAdminresponse().clear();
        SweetProject.getUsers().add(new User("rama", "123455", 2,"rama123455@gmail.com","nablus"));
        SweetProject.getUsers().add(new User("tala", "12345566", 2,"tala12345566@gmail.com","Jenin"));
        SweetProject.setUsers(SweetProject.getUsers());
        User u=new User("talaa", "12346", 3,"talaa12346@gmail.com","Jenin");
        s.login(u);
        SweetProject.getProducts().add(new ProductManegmwntSystem(1,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",5));
        SweetProject.getProducts().add(new ProductManegmwntSystem(2,"Nutella cake","Jenin","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",10));
        SweetProject.getProducts().add(new ProductManegmwntSystem(3,"Nutella cake","Nablus","Layers of chocolate cake with chocolate cream in the middle",10.0,60.0,"finished",12));
        FeedBack fe=new FeedBack();
        fe.userFeedback(u,1,"this is my msg to you");
        User uuu=new User("eeee", "1", 1,"eeee1@gmail.com","Jenin");
        s.login(uuu);


        AdminFeedback aa=new AdminFeedback();
        aa.adminResponsemessege(uuu,1,"this is my response to you");
        assertEquals(1, FeedBack.getFeedBacklist().size());
        assertEquals("this is my msg to you", FeedBack.getFeedBacklist().get(0).getFeedbackMessage());
        assertEquals(1, AdminFeedback.getAdminresponse().size());
        assertEquals("this is my response to you", AdminFeedback.getAdminresponse().get(0).getResponse());
        assertEquals("talaa", AdminFeedback.getAdminresponse().get(0).getUsername());

int expectedproductssize=SweetProject.getProducts().size();
        assertEquals(expectedproductssize, SweetProject.getProducts().size());
        assertEquals("Nutella cake", SweetProject.getProducts().get(0).getProductName());

        String expectedcity=SweetProject.getProducts().get(0).getCity();
        assertEquals(expectedcity, SweetProject.getProducts().get(0).getCity());
        assertEquals(2, SweetProject.getUsers().size());
        assertEquals("rama", SweetProject.getUsers().get(0).getUsername());

    }


}
