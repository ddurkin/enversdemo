import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils
import pl.refaktor.enversdemo.Hotel

10.times {
    SpringSecurityUtils.doWithAuth("test") {
        Hotel.withTransaction {
            Hotel hotel = Hotel.list([sort: 'id', order: 'asc']).first()
            hotel.bookings.reverse(true)
        }
    }
}