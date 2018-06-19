package hillermann.carl.learning.kotlin.spring.rest.simple.pinger

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PingerService(restTemplate: RestTemplate) {
    val LOG = LoggerFactory.getLogger(this.javaClass.canonicalName)

    @Value("\${application.name}")
    val name: String = ""
    @Value("\${gcloud.project}")
    val project: String = ""

    @Autowired
    val restTemplate = restTemplate

    fun ping(from: String): String {
        LOG.info(name + " was pinged from " + from)
        return "You Pinged $name looks like you're $from"
    }

    fun reachOut(services: List<String>) {
        services.forEach {
            logReachingOut(it)
        }

    }

    fun logReachingOut(service: String) {
        LOG.info("Reaching out to $service from $name...")
        val response = restTemplate.getForObject("$service-dot-$project.appspot.com/pinger?name=$name", String.javaClass)
        LOG.info("Got response $response from $service ...")
    }

}