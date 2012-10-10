
['booking_aud','booking', 'hotel', 'hotel_aud','app_user_aud','user_revision_entity'].each {
  	String sql = "delete from $it"
  	println(sql)
    ctx.sessionFactory.currentSession.createSQLQuery(sql).executeUpdate()
}