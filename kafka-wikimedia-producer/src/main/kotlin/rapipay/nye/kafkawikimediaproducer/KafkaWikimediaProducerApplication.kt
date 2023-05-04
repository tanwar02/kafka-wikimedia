package rapipay.nye.kafkawikimediaproducer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import rapipay.nye.kafkawikimediaproducer.service.WikimediaProducer

@SpringBootApplication
class KafkaWikimediaProducerApplication: CommandLineRunner {

    @Autowired
    lateinit var producer: WikimediaProducer

    override fun run(vararg args: String?) {

        producer.sendMessage()
    }
}

fun main(args: Array<String>) {
        runApplication<KafkaWikimediaProducerApplication>(*args)
    }

