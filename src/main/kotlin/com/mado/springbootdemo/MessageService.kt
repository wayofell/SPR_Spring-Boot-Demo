package com.mado.springbootdemo

import org.springframework.stereotype.Service
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import java.util.UUID
import org.springframework.data.repository.findByIdOrNull

//  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
// 1
//@Service
//class MessageService(private val db: JdbcTemplate) {
//    fun findMessages(): List<Message> = db.query("select * from messages") { response, _ ->
//        Message(response.getString("id"), response.getString("text"))
//    }
//
//    fun findMessageById(id: String): Message? = db.query("select * from messages where id = ?", id) { response, _ ->
//        Message(response.getString("id"), response.getString("text"))
//    }.singleOrNull()
//
//    fun save(message: Message): Message {
//        val id = message.id ?: UUID.randomUUID().toString()
//        db.update(
//            "insert into messages values ( ?, ? )",
//            id, message.text
//        )
//        return message.copy(id = id)
//    }
//}

//  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
// 2

@Service
class MessageService(private val db: MessageRepository) {
    fun findMessages(): List<Message> = db.findAll().toList()

    fun findMessageById(id: String): Message? = db.findByIdOrNull(id)

    fun save(message: Message): Message = db.save(message)
}