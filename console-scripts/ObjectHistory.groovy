import pl.refaktor.enversdemo.Booking
import pl.refaktor.enversdemo.Hotel

def firstHotel = Hotel.list().first()
for (Hotel rev : firstHotel.findAllRevisionsById(firstHotel.id)) {
    println("*********************************************************")
    def userRevisionEntityProps = prettyProps(rev.revisionEntity, ['id', 'revisionDate'])
    userRevisionEntityProps << rev.revisionEntity.currentUser?.username ?: null
    println("rev.revisionEntity : " + userRevisionEntityProps)
    println(rev.revisionType)
    println("  hotel : " + prettyProps(rev, ['id', 'version', 'name']))

    println("  rev.bookings :  ${rev.bookings}")
    for (Booking booking : rev.bookings) {
        println("    booking : " + prettyProps(booking, ['id', 'version', 'surname', 'startDate', 'daysCount']))
        //println("    booking.dump() : " + booking.dump())

    }
    println("*********************************************************")
}


for (Booking rev : Booking.findAllRevisionsById(8L)) {

    println("*********************************************************")
    def userRevisionEntityProps = prettyProps(rev.revisionEntity, ['id', 'revisionDate'])
    userRevisionEntityProps << rev.revisionEntity.currentUser?.username ?: null
    println("rev.revisionEntity : " + userRevisionEntityProps)
    println(rev.revisionType)
    println("  booking : " + prettyProps(rev, ['id', 'version', 'surname', 'startDate', 'daysCount']))

    println("    rev.hotel :  ${rev.hotel}")
    println("    hotel : " + prettyProps(rev.hotel, ['id', 'version', 'name']))

    println("*********************************************************")


}

public List<String> prettyProps(def rev, ArrayList<String> props) {
    def values = props.collect {(rev."$it" as String) }
    values.collect {(it ?: '').padLeft(10)}
}