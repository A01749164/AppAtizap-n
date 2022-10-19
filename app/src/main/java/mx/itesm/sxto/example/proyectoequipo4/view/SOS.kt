package mx.itesm.sxto.example.proyectoequipo4.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mx.itesm.sxto.example.proyectoequipo4.databinding.ActivitySosBinding

class SOS : AppCompatActivity()
{
    // binding
    private lateinit var binding: ActivitySosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("Estoy en sos")

        registrarEventos()
    }

    private fun registrarEventos() {
        // Botón que nos manda a la página de Facebook de Atizapán
        binding.btnFacebook.setOnClickListener {
            val webpage: Uri = Uri.parse("https://www.facebook.com/GobAtizapan")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }
        // Botón que nos manda a la página de Twitter de Atizapán
        binding.btnTwitter.setOnClickListener {
            val webpage: Uri = Uri.parse("https://twitter.com/GobAtizapan")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }
        // Botón que nos manda a la página de Youtube de Atizapán
        binding.btnYoutube.setOnClickListener {
            val webpage: Uri = Uri.parse("https://www.youtube.com/channel/UCIsPma1XWG9ozEvY9ZT94KA")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }
        // Botón que nos manda a la página de Oficial de Atizapán
        binding.btnPagina.setOnClickListener {
            val webpage: Uri = Uri.parse("https://atizapan.gob.mx/")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }
        // Botón que nos manda a marcar emergencias
        binding.btnEmergencias.setOnClickListener {
            val webpage: Uri = Uri.parse("tel: 911")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }
        // Botón que nos manda a marcar servicios públicos
        binding.btnServiciosPublicos.setOnClickListener {
            val webpage: Uri = Uri.parse("tel: 072")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }
        // Botón que nos manda a marcar servicios públicos
        binding.btnC4.setOnClickListener {
            val webpage: Uri = Uri.parse("tel: 5553667193")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }
        // Botón que nos manda a marcar seguridad pública y tránsito
        binding.btnSeguridadPT.setOnClickListener {
            val webpage: Uri = Uri.parse("tel: 5511062163")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }
        // Botón que nos manda a marcar SAPASA
        binding.btnSAPASA.setOnClickListener {
            val webpage: Uri = Uri.parse("tel: 5510836700")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }

    }

}