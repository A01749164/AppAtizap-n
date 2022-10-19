package mx.itesm.sxto.example.proyectoequipo4.model

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import mx.itesm.sxto.example.proyectoequipo4.R
import mx.itesm.sxto.example.proyectoequipo4.view.MainActivity

class MyFirebaseMessagingService : FirebaseMessagingService() {
    private val channelName = "alertasPC"
    private val channelId = "mx.itesm.sxto.example.proyectoequipo4"

    companion object {
        private const val TAG = "MyFirebaseMsgService"
    }

    override fun onMessageReceived(message: RemoteMessage) {
        println("Llega NOTIFICACION REMOTA!!!!!")
        if (message.notification != null){
            generarNotificacion(message)
        }
    }

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")
        sendRegistrationToServer(token)
    }

    private fun sendRegistrationToServer(token: String?) {
        Log.d(TAG, "sendRegistrationTokenToServer($token)")
    }

    private fun generarNotificacion(message: RemoteMessage) {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = PendingIntent.getActivity(this,
            0, intent, PendingIntent.FLAG_MUTABLE)

        var builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.notificacion)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000, 1000, 1000, 1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingIntent)
        builder = builder.setContent(crearVistaRemota(message))

        val admNotificaciones = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val canalNotificaciones = NotificationChannel(channelId, channelName,
                NotificationManager.IMPORTANCE_HIGH)
            admNotificaciones.createNotificationChannel(canalNotificaciones)
        }
        admNotificaciones.notify(0, builder.build())
    }

    @SuppressLint("RemoteViewLayout")
    private fun crearVistaRemota(message: RemoteMessage): RemoteViews {
        val titulo = message.notification?.title!!
        val mensaje = message.notification?.body!!
        val vistaRemota = RemoteViews("mx.itesm.sxto.example.proyectoequipo4", R.layout.activity_notificacion)
        vistaRemota.setTextViewText(R.id.tvTitulo, titulo)
        vistaRemota.setTextViewText(R.id.tvMensaje, mensaje)
        vistaRemota.setImageViewResource(R.id.imgIcono, R.drawable.notificacion)
        return vistaRemota
    }
}