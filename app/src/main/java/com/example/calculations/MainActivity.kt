package com.example.calculations
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.widget.doOnTextChanged
import com.example.calculations.R
import com.google.android.material.navigation.NavigationBarView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.btResult)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val edtxt2: EditText = findViewById(R.id.ednum2)
        val resultTV: TextView = findViewById(R.id.textResult)

        var flag : String = "sum"

        val spinnerVal : Spinner = findViewById(R.id.spinnerV)
        var options = arrayOf("sum","multiply")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )

        button.setOnClickListener{ view ->

            var x: Int = edtxt1.text.toString().toInt();
            var y: Int = edtxt2.text.toString().toInt();
            if(flag =="sum")
                resultTV.text = sum(x,y).toString();
            else
                resultTV.text = multiply(x,y).toString();
        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}
public fun sum(a: Int, b: Int): Int {
    return a+b
}
public fun multiply(a: Int, b: Int): Int {
    return a*b
}


