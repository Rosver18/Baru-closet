package com.example.mysinglepageassesementapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val accessory = arrayOf("No accesssory", "Bowtie", "Santa Hat", "Robin Hat")
    private val prop = arrayOf("No prop", "Stick", "Sword", "Dagger")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, accessory)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, prop)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item)

        val b1 = findViewById<Button>(R.id.button)
        val proplist = findViewById<Spinner>(R.id.spinner2)
        val accessorylist = findViewById<Spinner>(R.id.spinner)

        accessorylist.adapter = adapter
        proplist.adapter = adapter2

        b1.setOnClickListener {
            val propPosition = proplist.selectedItemPosition
            val accessoryPosition = accessorylist.selectedItemPosition
            var resultText = ""
            var imageResId = 0

            //No accessory
            if (propPosition == 0 && accessoryPosition == 0) {
                resultText = "Bro??? Give him something at least!"
                imageResId = R.drawable.nohat_noitem
            }
            if (propPosition == 1 && accessoryPosition == 0) {
                resultText = "Is he trying to cosplay a homeless cat?"
                imageResId = R.drawable.nohat_stick
            }
            if (propPosition == 2 && accessoryPosition == 0) {
                resultText = "Honestly not bad, but get some head protection at least"
                imageResId = R.drawable.nohat_sword
            }
            if (propPosition == 3 && accessoryPosition == 0) {
                resultText = "He looks like a naked thief! get him a hat or a bowtie!"
                imageResId = R.drawable.nohat_dagger
            }

            //Bowtie
            if (propPosition == 0 && accessoryPosition == 1) {
                resultText = "Very cool bowtie :3"
                imageResId = R.drawable.bowtie_noitem
            }
            if (propPosition == 1 && accessoryPosition == 1) {
                resultText = "really weird combination I must say"
                imageResId = R.drawable.bowtie_stick
            }
            if (propPosition == 2 && accessoryPosition == 1) {
                resultText = "Very sophisticated swordsman!"
                imageResId = R.drawable.bowtie_sword
            }
            if (propPosition == 3 && accessoryPosition == 1) {
                resultText = "Okay, now he just looks like an assassin"
                imageResId = R.drawable.bowtie_dagger
            }

            //Santa Hat
            if (propPosition == 0 && accessoryPosition == 2) {
                resultText = "MERRY CHRISTMAS! (It's Halloween)"
                imageResId = R.drawable.santa_noitem
            }
            if (propPosition == 1 && accessoryPosition == 2) {
                resultText = "MERRY CHRISTMAS! (why is he holding a stick?)"
                imageResId = R.drawable.santa_stick
            }
            if (propPosition == 2 && accessoryPosition == 2) {
                resultText = "There is NO situation where santa needs a sword >:("
                imageResId = R.drawable.santa_sword
            }
            if (propPosition == 3 && accessoryPosition == 2) {
                resultText = "Okay who is this at this point, bro is NOT cosplaying as santa"
                imageResId = R.drawable.santa_dagger
            }

            //Robin Hat
            if (propPosition == 0 && accessoryPosition == 3) {
                resultText = "Robin Hood :))"
                imageResId = R.drawable.robin_noitem
            }
            if (propPosition == 1 && accessoryPosition == 3) {
                resultText = "Bro look like he needs to steal the money for himself"
                imageResId = R.drawable.robin_stick
            }
            if (propPosition == 2 && accessoryPosition == 3) {
                resultText = "Robin hood standing on business???"
                imageResId = R.drawable.robin_sword
            }
            if (propPosition == 3 && accessoryPosition == 3) {
                resultText = "This ain't robin hood no more he's just a thief"
                imageResId = R.drawable.robin_dagger
            }

            showDialog(resultText, imageResId)
        }
    }

    @SuppressLint("MissingInflatedId")
    private fun showDialog(resultText: String, imageResId: Int) {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.popup, null)
        val builder = AlertDialog.Builder(this).setView(dialogView)
        val dialog = builder.create()
        val resultTextView = dialogView.findViewById<TextView>(R.id.result)
        val characterPhoto = dialogView.findViewById<ImageView>(R.id.baruPhoto)
        val closeButton: Button = dialogView.findViewById(R.id.closeButton)

        resultTextView.text = resultText
        characterPhoto.setImageResource(imageResId)

        closeButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}