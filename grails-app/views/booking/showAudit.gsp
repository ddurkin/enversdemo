<%@ page import="pl.refaktor.enversdemo.Booking" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'booking.label', default: 'Booking')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-booking" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                              default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="revisions" action="revisions"><g:message code="default.revisions.label"
                                                                    args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-booking" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

    <g:each in="${revisions}" var="rev">

        <ol class="property-list booking">
            <li class="fieldcontain">
                <span id="version-label" class="property-label"><g:message code="booking.version.label"
                                                                             default="Version"/></span>

                <span class="property-value" aria-labelledby="version-label"><g:fieldValue
                        bean="${rev}"
                        field="version"/></span>

            </li>
            <g:if test="${rev?.daysCount}">
                <li class="fieldcontain">
                    <span id="daysCount-label" class="property-label"><g:message code="booking.daysCount.label"
                                                                                 default="Days Count"/></span>

                    <span class="property-value" aria-labelledby="daysCount-label"><g:fieldValue
                            bean="${rev}"
                            field="daysCount"/></span>

                </li>
            </g:if>

            <g:if test="${rev?.hotel}">
                <li class="fieldcontain">
                    <span id="hotel-label" class="property-label"><g:message code="booking.hotel.label"
                                                                             default="Hotel"/></span>

                    <span class="property-value" aria-labelledby="hotel-label"><g:link controller="hotel" action="show"
                                                                                       id="${rev?.hotel?.id}">${rev?.hotel?.name?.encodeAsHTML()}</g:link></span>

                </li>
            </g:if>

            <g:if test="${rev?.startDate}">
                <li class="fieldcontain">
                    <span id="startDate-label" class="property-label"><g:message code="booking.startDate.label"
                                                                                 default="Start Date"/></span>

                    <span class="property-value" aria-labelledby="startDate-label"><g:formatDate
                            date="${rev?.startDate}"/></span>

                </li>
            </g:if>

            <g:if test="${rev?.surname}">
                <li class="fieldcontain">
                    <span id="surname-label" class="property-label"><g:message code="booking.surname.label"
                                                                               default="Surname"/></span>

                    <span class="property-value" aria-labelledby="surname-label"><g:fieldValue bean="${rev}"
                                                                                               field="surname"/></span>

                </li>
            </g:if>

        </ol>
    </g:each>
    <g:paginate
                    params="${[id : revisions.first().id]}"
                    maxsteps="0"
                    max="5"
                    action="showAudit"
                    total="$totalCount"/>
    <g:form>
        <fieldset class="buttons">
            <g:link class="back" action="show" id="${revisions?.first()?.id}"><g:message
                                code="default.button.back.label"
                                default="Back"/></g:link>
        </fieldset>
    </g:form>
</div>
</body>
</html>
