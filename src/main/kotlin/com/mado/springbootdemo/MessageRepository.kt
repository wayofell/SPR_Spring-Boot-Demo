package com.mado.springbootdemo

import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<Message, String>