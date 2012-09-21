
import pl.refaktor.enversdemo.*



  for(Hotel hotel : Hotel.list()){
    println("${hotel.name} - [${hotel.id}]")
    printBookings(hotel.bookings)
  }

void printBookings(Set bookings){

  for(Booking b : bookings){
    println( "  " + b.properties.findAll{k,v-> k!='hotel'}.sort{l, r -> l.key <=> r.key} )

  }
}