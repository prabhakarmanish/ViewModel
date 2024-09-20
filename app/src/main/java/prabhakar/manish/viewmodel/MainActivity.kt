package prabhakar.manish.viewmodel

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var mainviewmodel:MainViewModel
    lateinit var text : TextView
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mainviewmodel = ViewModelProvider(this).get(MainViewModel::class.java)

        text = findViewById(R.id.num)
        btn = findViewById(R.id.increment)
        text.text = mainviewmodel.count.toString()
        btn.setOnClickListener {
            mainviewmodel.increment()
            text.text = mainviewmodel.count.toString()
        }


    }
}