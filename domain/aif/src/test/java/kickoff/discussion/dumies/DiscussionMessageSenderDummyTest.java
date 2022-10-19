package kickoff.discussion.dumies;

import kickoff.discussion.gateway.DiscussionMessageSender;
import org.junit.Assert;
import org.junit.Test;

public class DiscussionMessageSenderDummyTest {

    @Test
    public void getProductMessageSender() {


        DiscussionMessageSender discussionMessageSender= DiscussionMessageSenderDummy.getDiscussionMessageSender();

        discussionMessageSender.send("message")
                .subscribe(message -> {
                    Assert.assertEquals("message", message);
                });

    }
}