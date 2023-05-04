package rapipay.nye.kafkawikimediaproducer.service

import com.launchdarkly.eventsource.EventHandler
import com.launchdarkly.eventsource.EventSource
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import rapipay.nye.kafkawikimediaproducer.datahandler.WikimediaChangesHandler
import java.net.URI
import java.util.concurrent.TimeUnit

@Service
class WikimediaProducer {

    var template: KafkaTemplate<String, String>
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    constructor(template: KafkaTemplate<String, String>){

        this.template = template
    }

    fun sendMessage(){

        val url: String = "https://stream.wikimedia.org/v2/stream/recentchange"
        val topic: String = "wikimedia_recentchange"

        var eventHandler: EventHandler = WikimediaChangesHandler(topic, template)
        var eventSource: EventSource = EventSource.Builder(eventHandler, URI.create(url)).build()

        eventSource.start()
        TimeUnit.MINUTES.sleep(10)
    }
}