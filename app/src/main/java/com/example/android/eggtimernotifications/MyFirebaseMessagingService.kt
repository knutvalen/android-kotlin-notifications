package com.example.android.eggtimernotifications

import android.app.NotificationManager
import androidx.core.content.ContextCompat
import com.example.android.eggtimernotifications.util.sendNotification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import timber.log.Timber

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)
        Timber.i("From: ${remoteMessage?.from}")

        remoteMessage?.data?.let {
            Timber.i("Message data payload: $it")
        }

        remoteMessage?.notification?.body?.let { body ->
            Timber.i("Message notification body: $body")
            val notificationManager = ContextCompat.getSystemService(applicationContext, NotificationManager::class.java) as NotificationManager
            notificationManager.sendNotification(body, applicationContext)
        }
    }

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Timber.i("Refreshed token: $token")
        sendTokenToServer(token)
    }

    private fun sendTokenToServer(token: String?) {
        //TODO
    }

}