package com.gzy.springlab.controller

import com.gzy.springlab.entity.User
import com.gzy.springlab.service.IUserService
import jakarta.annotation.Resource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 *
 * 前端控制器
 *
 *
 * @author gzy
 * @since 2024-09-25
 */
@RestController
@RequestMapping("/user")
class UserController {

    @Resource
    private val userService: IUserService? = null

    @GetMapping("/queryAll")
    fun queryAll(): List<User?> {
        return userService!!.list()
    }
}
