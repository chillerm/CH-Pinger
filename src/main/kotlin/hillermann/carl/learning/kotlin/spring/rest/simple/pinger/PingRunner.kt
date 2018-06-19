package hillermann.carl.learning.kotlin.spring.rest.simple.pinger

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import java.util.Collections.singletonList

@EnableScheduling
class PingRunner(@Autowired val pingerService: PingerService) {

    @Scheduled(fixedDelay = 3000)
    fun reachOut() {
        pingerService.reachOut(singletonList("ponger"))
    }
}