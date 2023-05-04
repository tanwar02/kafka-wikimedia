package rapipay.nye.kafkawikimediaproducer.datahandler

import com.launchdarkly.eventsource.EventHandler
import com.launchdarkly.eventsource.MessageEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate

class WikimediaChangesHandler: EventHandler {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    private val topic: String
    private var template: KafkaTemplate<String, String>

    constructor(topic: String, template: KafkaTemplate<String, String>) {

        this.topic = topic
        this.template = template
    }


    override fun onOpen() {

        logger.info("Event Handler : Opened")
    }

    override fun onClosed() {

        logger.info("Event Handler : Closed")
    }

    //Whenever there is a new event on wikimedia, this method executes and read that event
    override fun onMessage(s: String, messageEvent: MessageEvent) {

        logger.info("message received : ${messageEvent.data}")
        template.send(topic, messageEvent.data)
    }

    override fun onComment(p0: String?) {

        logger.info("Event Handler : Comment")
    }

    override fun onError(p0: Throwable?) {

        logger.info("Event Handler : Error")
    }
}