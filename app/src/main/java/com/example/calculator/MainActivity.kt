package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.convertTo
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import com.example.calculator.databinding.ActivityMainBinding
import org.w3c.dom.Text
import java.math.BigInteger

class MainActivity : AppCompatActivity() {
    lateinit var text:String


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        convertFromBinaryEditText()
        convertFromDecimalEditText()
        convertFromOctalEditText()
        convertFromHexalEditText()

        binding.btnClear.setOnClickListener {
            clearALl()
        }


    }

    fun convertFromBinaryEditText(){
        binding.binaryEdit.addTextChangedListener( object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.binaryEdit.hasFocus()&&binding.binaryEdit.text.isNotEmpty()) {
                    convertFromBin()
                }
                if (binding.binaryEdit.hasFocus()&&binding.binaryEdit.text.isEmpty()) {
                    clearALl()
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        } )
    }
    fun convertFromDecimalEditText(){
        binding.decimalEdit.addTextChangedListener( object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.decimalEdit.hasFocus()&&binding.decimalEdit.text.isNotEmpty()) {
                    convertFromDec()
                }
                if (binding.decimalEdit.hasFocus()&&binding.decimalEdit.text.isEmpty()) {
                    clearALl()
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        } )
    }
    fun convertFromOctalEditText(){
        binding.octalEdit.addTextChangedListener( object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.octalEdit.hasFocus()&&binding.octalEdit.text.isNotEmpty()) {
                    convertFromOct()
                }
                if (binding.octalEdit.hasFocus()&&binding.octalEdit.text.isEmpty()) {
                    clearALl()
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        } )
    }
    fun convertFromHexalEditText(){
        binding.hexaEdit.addTextChangedListener( object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.hexaEdit.hasFocus()&&binding.hexaEdit.text.isNotEmpty()) {
                    convertFromHex()
                }
                if (binding.hexaEdit.hasFocus()&&binding.hexaEdit.text.isEmpty()) {
                    clearALl()
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        } )
    }


    fun convertFromBin(){
        val d = binding.binaryEdit.text.toString().toLong(2).toString()
        val dec=BigInteger(d)
        binding.decimalEdit.setText(dec.toString())
        binding.octalEdit.setText(dec.toString(8))
        binding.hexaEdit.setText(dec.toString(16).uppercase())
    }

    fun convertFromDec(){

            val d =binding.decimalEdit.text.toString()
            val dec=BigInteger(d)
            binding.binaryEdit.setText(dec.toString(2))
            binding.octalEdit.setText(dec.toString(8))
            binding.hexaEdit.setText(dec.toString(16).uppercase())

    }
    fun convertFromHex(){

            val d=binding.hexaEdit.text.toString().toLong(16).toString()
            val dec=BigInteger(d)
            binding.binaryEdit.setText(dec.toString(2))
            binding.octalEdit.setText(dec.toString(8))
            binding.decimalEdit.setText(dec.toString())


    }

    fun convertFromOct(){

            val d=binding.octalEdit.text.toString().toLong(8).toString()
            val dec=BigInteger(d)
            binding.binaryEdit.setText(dec.toString(2))
            binding.decimalEdit.setText(dec.toString())
            binding.hexaEdit.setText(dec.toString(16).uppercase())

    }

    fun clearALl(){
        binding.decimalEdit.text.clear()
        binding.binaryEdit.text.clear()
        binding.octalEdit.text.clear()
        binding.hexaEdit.text.clear()
    }

}

