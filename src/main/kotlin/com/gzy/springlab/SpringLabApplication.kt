package com.gzy.springlab

//import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
//@MapperScan("com.gzy.springlab.mapper")
class SpringLabApplication

fun main(args: Array<String>) {
    runApplication<SpringLabApplication>(*args)
}
