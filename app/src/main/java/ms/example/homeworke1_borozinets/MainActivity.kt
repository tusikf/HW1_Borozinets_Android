package ms.example.homeworke1_borozinets

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ms.example.homeworke1_borozinets.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var counter = 0
        var color1 = "#44C146"
        var color2 = "#382AF4"
        var color3 = "#F42C2A"
        binding.score.text = counter.toString()
        binding.minusButton.isEnabled = false
        binding.plusButton.isEnabled = true

        binding.plusButton.setOnClickListener {
            if (binding.plusButton.isEnabled == true) {
                when (counter) {
                    0 -> {
                        counter++
                        binding.mainText.text = binding.mainText.context.getText(R.string.text1)
                        binding.mainText.text = binding.mainText.context.getColor(color1.toInt()).toString()
                    }
                    in 1..49 -> {
                        counter++
                        binding.mainText.text = binding.mainText.context.getText(R.string.text2)
                        binding.mainText.text = binding.mainText.context.getColor(color2.toInt()).toString()
                    }
                    50 -> {
                        binding.mainText.text = binding.mainText.context.getText(R.string.text3)
                        binding.mainText.text = binding.mainText.context.getColor(color3.toInt()).toString()
                        binding.sbros.visibility = View.VISIBLE
                        binding.plusButton.isEnabled = false
                    }

                }
            }

        }
        binding.minusButton.setOnClickListener {
            if (binding.minusButton.isEnabled == true) {
                when (counter) {
                    0 -> {
                        binding.minusButton.isEnabled = false
                    }
                    in 1..49 -> {
                        counter--
                        binding.mainText.text = binding.mainText.context.getText(R.string.text2)
                        binding.mainText.text = binding.mainText.context.getColor(color2.toInt()).toString()
                    }

                }
            }

        }
        binding.sbros.setOnClickListener {
            counter = 0
            binding.mainText.text = binding.mainText.context.getText(R.string.text1)
            binding.mainText.text = binding.mainText.context.getColor(color1.toInt()).toString()
            binding.minusButton.isEnabled = false
        }




    }
}
