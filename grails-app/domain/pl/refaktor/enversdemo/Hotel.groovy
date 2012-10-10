package pl.refaktor.enversdemo

import org.hibernate.envers.Audited

@Audited
class Hotel {

    String name

    static constraints = {
    }


    List<Booking> bookings = [] as List<Booking>

    static hasMany = [bookings: Booking]


}
