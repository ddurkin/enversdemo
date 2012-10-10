package pl.refaktor.enversdemo

import org.hibernate.envers.Audited

@Audited
class Booking {

    String surname
    Date   startDate
    Integer daysCount

    Hotel hotel

    static belongsTo = [hotel:Hotel]


    static constraints = {
    }






}
