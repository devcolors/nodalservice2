package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SendAndReceive(private val rabbitTemplate: RabbitTemplate) : CommandLineRunner {

    override fun run(vararg args: String?) {
        while (true) {
            Thread.sleep(10000) // Wait 10 seconds
            println("S2: Sending 'ping'")
            rabbitTemplate.convertAndSend("amq.direct", "routing-key2", "ping")
        }
    }

    @RabbitListener(queues = ["myQueue"])
    fun listen(message: String) {
        println("S2: Received message - $message")
        if (message == "ping") {
            rabbitTemplate.convertAndSend("amq.direct", "routing-key2", "pong")
            println("S2: Sending 'pong'")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<SendAndReceive>(*args)
}