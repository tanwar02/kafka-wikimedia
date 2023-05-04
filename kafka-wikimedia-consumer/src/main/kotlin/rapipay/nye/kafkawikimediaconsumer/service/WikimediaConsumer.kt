package rapipay.nye.kafkawikimediaconsumer.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class WikimediaConsumer {

    var logger: Logger = LoggerFactory.getLogger(this::class.java)
    @KafkaListener(topics = arrayOf("wikimedia_recentchange"), groupId = "myGroup")
    fun consumeMessage(message: String){

        logger.info("Event message received : $message")
    }
}