import pl.refaktor.enversdemo.*
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils



for(i in 0..3){

    Booking.withTransaction {status->
        SpringSecurityUtils.doWithAuth("test"){
            def hotel = Hotel.list().first()
            hotel.name += " Test ${i}"
        }
    }
}
