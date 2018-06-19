package hillermann.carl.learning.kotlin.spring.rest.simple.pinger

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PingerController(pingerService: PingerService) {
    val LOG = LoggerFactory.getLogger(this.javaClass.canonicalName)

    @Autowired
    val pingerService = pingerService

    @GetMapping(path = ["/pinger"])
    fun ping(@RequestParam(value = "from", defaultValue = "WHO ARE YOU???") from: String): String {
        LOG.info("$from just pinged me. Calling my Service...")
        return pingerService.ping(from)
    }

}