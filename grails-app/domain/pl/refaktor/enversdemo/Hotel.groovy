package pl.refaktor.enversdemo

import org.hibernate.annotations.IndexColumn
import org.hibernate.envers.AuditMappedBy
import org.hibernate.envers.Audited

import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Audited
class Hotel {

    String name

    List<Booking> bookings = [] as List<Booking>

    static hasMany = [bookings: Booking]

    static constraints = {
    }

    static mapping = {
        bookings(indexColumn: [name: 'position', type: Integer])
    }

    @AuditMappedBy(mappedBy = "hotel", positionMappedBy = "position")
    public List<Booking> getBookings() {
        this.bookings
    }
}
