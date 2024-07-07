package com.mudurlu.lifecycle

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mudurlu.lifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //onCreate oluşum
        println("onCreate çalıştı")

        binding.button2.setOnClickListener {
            val oncekiIsım = binding.textView.text.toString()
            binding.textView.text = "$oncekiIsım kontrollü aktarıldı"
        }
    }

    override fun onStart() {
        super.onStart()
        //onCreate ve onResume arası bir bölüm
        println("onStart çalıştı")
    }

    override fun onResume() {
        super.onResume()
        // Kullanıcının ekranına gelen kısım
        println("onResume çalıştı")
    }

    override fun onPause() {
        super.onPause()
        //Uygulamadan çıkınca ilk pause çalışır
        println("onPause çalıştı")
    }

    override fun onStop() {
        super.onStop()
        //Uygulamadan çıkınca ikinci pause çalışır
        println("onStop çalıştı")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy çalıştı")
    }

    fun ismiAl(view : View){
        val isim:String = binding.editText1.text.toString()
        binding.textView.text = isim
    }




}