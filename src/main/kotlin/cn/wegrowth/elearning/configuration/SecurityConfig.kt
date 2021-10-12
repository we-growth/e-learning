package cn.wegrowth.elearning.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager
import org.springframework.security.oauth2.provider.token.RemoteTokenServices
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Value("\${springdoc.api-docs.path}")
    private lateinit var restApiDocPath: String

    @Value("\${springdoc.swagger-ui.path}")
    private lateinit var swaggerPath: String

    @Value("\${remote-token.client-id}")
    private lateinit var clientId: String

    @Value("\${remote-token.client-credential}")
    private lateinit var clientSecret: String

    @Value("\${remote-token.check-authorization-url}")
    private lateinit var checkAuthUrl: String

    @Bean
    fun tokenServices(): ResourceServerTokenServices {
        val tokenServices = RemoteTokenServices()
        tokenServices.setClientId(clientId)
        tokenServices.setClientSecret(clientSecret)
        tokenServices.setCheckTokenEndpointUrl(checkAuthUrl)
        return tokenServices
    }

    override fun authenticationManager(): AuthenticationManager {
        val authenticationManager = OAuth2AuthenticationManager()
        authenticationManager.setTokenServices(tokenServices())
        return authenticationManager

    }

    override fun configure(web: WebSecurity) {
        web.ignoring()
            .antMatchers("%s/**".format(restApiDocPath))
            .antMatchers("%s/**".format(swaggerPath))
    }

    override fun configure(http: HttpSecurity) {

        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("%s/**".format("/actuator")).permitAll()
            .anyRequest().authenticated()
    }

}