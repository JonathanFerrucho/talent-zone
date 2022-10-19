package kickoff.discussion.dumies;

import kickoff.discussion.ItemsData;
import kickoff.discussion.gateway.DiscussionClient;
import org.junit.Assert;
import org.junit.Test;

public class ProductClientDummyTest {


    @Test
    public void getProductClient() {

        DiscussionClient discussionClient = DiscussionClientDummy.getDiscussionClient();

        discussionClient.getDiscussionsOctopia("date", "date")
                .subscribe(itemsData -> {
                    Assert.assertEquals(ItemsData.builder().build(), itemsData);
                });

    }
}