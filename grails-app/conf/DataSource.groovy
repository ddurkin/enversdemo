dataSource {
    dbCreate='create-drop'
    //dbCreate='create'
    url = 'jdbc:oracle:thin:@vmbarddev:1521:barddev'
    driverClassName = 'oracle.jdbc.driver.OracleDriver'
    username = "ddurkin"
    password = "hPE8eXjCXUi8"
    pooled = true
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
