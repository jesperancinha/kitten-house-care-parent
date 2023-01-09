package org.jesperancinha.housing

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class CatCareLauncher {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(CatCareLauncher::class.java, *args)
        }
    }
}