import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils
import pl.refaktor.enversdemo.Booking
import pl.refaktor.enversdemo.Hotel

//['booking_aud', 'booking', 'hotel_booking_aud', 'hotel', 'hotel_aud', 'app_user_aud', 'user_revision_entity'].each {
//    String sql = "delete from $it"
//    println(sql)
//    ctx.sessionFactory.currentSession.createSQLQuery(sql).executeUpdate()
//}
//new BootStrap().createSomeUsersAndData()

Random random = new Random()
for (i in 0..10) {
    SpringSecurityUtils.doWithAuth("test") {
        Booking.withTransaction {status ->

            def hotel = Hotel.list().first()
            hotel.name = "Astoria Test ${i}"

            for (Booking booking : hotel.bookings) {
                //booking.daysCount = random.nextInt(4) + 1
                hotel.bookings.reverse(true)
            }
        }
    }
}
