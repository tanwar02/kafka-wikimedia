package rapipay.nye.kafkawikimediaconsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaWikimediaConsumerApplication

fun main(args: Array<String>) {
    runApplication<KafkaWikimediaConsumerApplication>(*args)
}