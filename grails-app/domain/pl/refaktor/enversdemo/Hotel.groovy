package pl.refaktor.enversdemo

import org.hibernate.annotations.IndexColumn
import org.hibernate.envers.AuditMappedBy
import org.hibernate.envers.Audited

import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Audited
class Hotel {

    String name

    static constraints = {
    }


    List<Booking> bookings = [] as List<Booking>

    static hasMany = [bookings: Booking]

    static mapping = {
        bookings(indexColumn: [name: 'position', type: Integer])
    }

    @OneToMany(mappedBy='hotel')
    @JoinColumn(name = "hotel_id")
    @IndexColumn(name = "position", nullable = false)
    @AuditMappedBy(mappedBy = "hotel", positionMappedBy = "position")
    public List<Booking> getBookings() {
        this.bookings
    }


}
