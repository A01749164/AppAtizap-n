package mx.itesm.sxto.example.proyectoequipo4.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import mx.itesm.sxto.example.proyectoequipo4.R
import mx.itesm.sxto.example.proyectoequipo4.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginBinding

    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { result ->
        this.onSignInResult(result)
    }

    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        if (result.resultCode == RESULT_OK) {
            val response = result.idpResponse
            val usuario = FirebaseAuth.getInstance().currentUser
            println("BIENVENIDO ${usuario?.displayName}")
            println("Correo: ${usuario?.email}")
            println("Token: ${usuario?.uid}")
            // Cambiaremos al MENU
            mostrarMenu()
        } else {
            println("Datos incorrectos al hacer LOGIN / canceló")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_ProyectoEquipo4)
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registrarEventos()

        verificarUsuarioLogin()
    }

    private fun verificarUsuarioLogin() {
        val usuario = FirebaseAuth.getInstance().currentUser
        if (usuario != null) {
            println("Bienvenido NUEVAMENTE ${usuario?.displayName}")
            println("Correo: ${usuario?.email}")
            // CAMBIAR A MENU
            mostrarMenu()
        } else {
            println("EL USUARIO NO ESTABA firmado anteriormente")
        }
    }

    private fun mostrarMenu() {
        val intMenu = Intent(this, MainActivity::class.java)
        startActivity(intMenu)
        finish()
    }

    private fun registrarEventos() {
        binding.btnLogin.setOnClickListener {
            autenticar()
        }
        // Boton que nos manda a la vista principal
        binding.btnGratis.setOnClickListener {
            println("Voy a menú")
            val intMenu = Intent(this, MainActivity2::class.java)
            startActivity(intMenu)
        }
    }

    private fun autenticar() {
        val providers = arrayListOf(
            AuthUI.IdpConfig.GoogleBuilder().build(),
        )

        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        signInLauncher.launch(signInIntent)
    }
}