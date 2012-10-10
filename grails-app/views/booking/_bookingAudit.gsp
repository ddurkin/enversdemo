<li class="fieldcontain">
    <span id="bookings-label" class="property-label">
        <g:message code="hotel.bookings.label"
                   default="Bookings"/></span>

    <span class="property-value" >
        <g:link controller="booking"
                action="show"
                id="${booking.id}">current booking</g:link></span>
    <span id="bookings-label" class="property-label">data :</span>
    <span class="property-value" >surname: ${booking.surname.encodeAsHTML()} daysCount: ${booking.daysCount} startDate : ${booking.startDate} idx : TBD</span>
</li>