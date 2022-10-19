package kickoff.defaults;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Level;

@Log
@Configuration
public class DefaultBeansConfig {

    private void alertFakeBean(String beanName) {
        log.log(Level.WARNING, "########\n########\n########CONFIGURACION FAKE########\n {0} Fake!", beanName);
    }

    /*
    @Bean
    @ConditionalOnMissingBean
    public DiscussionClient discussionClient() {
        alertFakeBean("DiscussionClient");
        return DiscussionClientDummy.getDiscussionClient();
    }

    @Bean
    @ConditionalOnMissingBean
    public DiscussionMessageSender discussionMessageSender() {
        alertFakeBean("DiscussionMessageSender");
        return DiscussionMessageSenderDummy.getDiscussionMessageSender();
    }

     */
}
