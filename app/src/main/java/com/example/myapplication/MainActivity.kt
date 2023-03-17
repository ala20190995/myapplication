package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.btResult)
        val edtxt1: EditText = findViewById(R.id.num1)
        val resultTV: TextView = findViewById(R.id.textResult)
        var flag = "dollar"
        val spinnerVal : Spinner = findViewById(R.id.spSelect)
        val options = arrayOf("dollar","euro")
        spinnerVal.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,options )
        button.setOnClickListener{
            val x: Double = edtxt1.text.toString().toInt().toDouble()

            if(flag =="dollar")
                resultTV.text = dollar(x).toString()
            else
                resultTV.text = euro(x).toString()
        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options[p2] //p2 is the index of selected item
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}
fun dollar(a: Double): Double {
    return a*1.41
}
fun euro(a: Double): Double {
    return a*1.33
}
