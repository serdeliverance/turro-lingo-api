package io.github.sd3v.mflashcardsbe.io.github.sd3v.mflashcardsbe.config

import org.jooq.impl.DataSourceConnectionProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy
import javax.sql.DataSource

@Configuration
class DbConfig(val dataSource: DataSource) {

    @Bean
    fun connectionProvider() =
        DataSourceConnectionProvider(TransactionAwareDataSourceProxy(dataSource))
}
