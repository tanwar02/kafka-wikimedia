package rapipay.nye.kafkawikimediaproducer.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaTopicConfig {

    fun buildTopic(): NewTopic{

        return TopicBuilder.name("wikimedia_recentchange").build()
    }
}