package pl.refaktor.enversdemo

import org.hibernate.envers.Audited

@Audited
class Booking {

    String surname
    Date startDate
    Integer daysCount


    Hotel hotel

    Integer position

    static belongsTo = [hotel: Hotel]

    static constraints = {
    }

    static mapping = {
        hotel(insertable: false, updateable: false)
        position(insertable: false, updateable: false)
    }


}
