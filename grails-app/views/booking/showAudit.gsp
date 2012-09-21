<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'hotel.label', default: 'Hotel')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-hotel" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
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

<div id="show-hotel-audit" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

    <g:each in="${revisions}" var="rev">

        <ol class="property-list hotel">
            <li class="fieldcontain">
                <span id="transaction-label" class="property-label">transaction id :</span>
                <span class="property-value">${rev.revisionEntity.id}</span>
            </li>
            <li class="fieldcontain">
                <span id="revisionDate-label" class="property-label">revisionDate :</span>
                <span class="property-value">${rev.revisionEntity.revisionDate}</span>
            </li>

            <li class="fieldcontain">
                <span id="username-label" class="property-label">username :</span>
                <span class="property-value">${rev.revisionEntity.currentUser?.username}</span>
            </li>
            <g:if test="${rev?.name}">
                <li class="fieldcontain">
                    <span id="name-label" class="property-label"><g:message code="hotel.name.label" default="Name"/></span>
                    <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${rev}" field="name"/></span>
                </li>
            </g:if>
            <g:if test="${rev?.bookings}">
                <g:render template="../booking/bookingAudit" var="booking" collection="${rev?.bookings}"/>
            </g:if>

        </ol>
    </g:each>


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
