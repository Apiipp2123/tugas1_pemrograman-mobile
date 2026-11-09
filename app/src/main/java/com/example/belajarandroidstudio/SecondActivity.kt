package com.example.belajarandroidstudio

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.belajarandroidstudio.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcBtnTambah.setOnClickListener { hitung('+') }
        binding.calcBtnKurang.setOnClickListener { hitung('-') }
        binding.calcBtnKali.setOnClickListener { hitung('*') }
        binding.calcBtnBagi.setOnClickListener { hitung('/') }
        binding.calcBtnKembali.setOnClickListener { finish() }
    }

    private fun hitung(operasi: Char) {
        val s1 = binding.calcAngka1.text.toString().trim()
        val s2 = binding.calcAngka2.text.toString().trim()

        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "Isi kedua angka terlebih dahulu", Toast.LENGTH_SHORT).show()
            return
        }

        val a = s1.toDoubleOrNull()
        val b = s2.toDoubleOrNull()
        if (a == null || b == null) {
            Toast.makeText(this, "Format angka tidak valid", Toast.LENGTH_SHORT).show()
            return
        }

        val hasil = when (operasi) {
            '+' -> a + b
            '-' -> a - b
            '*' -> a * b
            else -> {
                if (b == 0.0) {
                    Toast.makeText(this, "Pembagi tidak boleh nol", Toast.LENGTH_SHORT).show()
                    return
                }
                a / b
            }
        }

        // Tampilkan tanpa ".0" jika hasilnya bilangan bulat
        val teks = if (hasil % 1.0 == 0.0) hasil.toLong().toString() else hasil.toString()
        binding.calcHasil.text = "Hasil: $teks"
    }
}