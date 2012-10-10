import pl.refaktor.enversdemo.*
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

class BootStrap {

    def init = { servletContext ->

        environments {
            development {
                createSomeUsersAndData()
            }
        }
    }

    def destroy = {
    }

    public void createSomeUsersAndData() {
        User.findByUsername('system') ?: new User(
                username: 'system',
                password: 'system',
                enabled: false).save(flush: true, failOnError: true)

        SpringSecurityUtils.doWithAuth("system") {
            createTestRoleAndUser()

            if (Hotel.count() == 0) {
                createAstoria()
                createHolidayInn()
            }
        }
    }

    void createTestRoleAndUser() {
        User.withTransaction {
            def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(flush: true, failOnError: true)
            def testUser = User.findByUsername('test') ?: new User(
                    username: 'test',
                    password: 'test',
                    enabled: true).save(flush: true, failOnError: true)
            if (!testUser.authorities.contains(userRole)) {
                UserRole.create(testUser, userRole)
            }

        }
    }

    void createAstoria() {
        Hotel.withTransaction {
            def hotel = new Hotel(name: 'Astoria')
            def weekBooking = new Booking(surname: 'Doe', startDate: new Date(), daysCount: 7)
            def weekendBooking = new Booking(surname: 'Marcy', startDate: new Date(), daysCount: 2)
            hotel.addToBookings(weekBooking)
            hotel.addToBookings(weekendBooking)
            hotel.save(failOnError: true, flush: true)
        }
    }

    void createHolidayInn() {
        Hotel.withTransaction {
            def hotel = new Hotel(name: 'Holiday Inn')
            def honeymoonBooking = new Booking(surname: 'Smiths', startDate: new Date(), daysCount: 10)
            hotel.addToBookings(honeymoonBooking)
            hotel.save(failOnError: true, flush: true)
        }
    }
}
