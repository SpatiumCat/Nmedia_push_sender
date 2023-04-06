package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val token = "eLg5Qg0sStiV0i1XDoWu3a:APA91bHPoVZQ2kUNq9HkhY9Tyc0AxxNWO4xk_Jsgx1GWnj5w_B1OSOEBnDjdB_Bblf6IVr9d4qt8nWeU7HxelCC9icZ_ISg2DKjojuGDGxHViCsAskkLmMuTlEOapo76a_2G_XT4YoIe"

    val message = Message.builder()
        .putData("action", "POST")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
}
