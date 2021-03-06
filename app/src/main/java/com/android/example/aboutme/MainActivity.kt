package com.android.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isGone

class MainActivity : AppCompatActivity() {

    private fun addNickname(view: View){ //A parameter called view of type View
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nickNameTextView = findViewById<TextView>(R.id.nickname_text)
        /*We set variables equal to the IDs of both our editText (what the user enters)
        and what the textView that the user will see once they click the "Done" button
        */

        nickNameTextView.text = editText.text
        /*We set the textView - which is currently in gone visibility
        (invisible and doesn't take up space) - equal to the editText that the user has entered.
        */

        editText.visibility = View.GONE
        /*We now set the visibility of the editView that the user was previously typing into GONE
        */

        view.visibility = View.GONE
        /*We now set the view parameter of this function to GONE visibility (we change the button
        View into GONE visibility
        */

        nickNameTextView.visibility = View.VISIBLE
        /*Finally we make the text View which will show the user's nick name visible
        */

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        /*Function to hide the keyboard after pressing the "Done" button.
        Before, the keyboard would remain visible even after entering the user's nickname*/
    }

    private fun updateNickname(view: View){ /*This function will allow the user to edit
                                            their nicknames*/
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.button_done)

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
        //This will bring the keyboard back up, so the user can begin typing their new nicknames

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_done).setOnClickListener{ /*" setOnClickListener" is
            a method of button Views which will execute when the button is clicked*/

            addNickname(it) //"it" refers to the button_done view which is passed in as a reference
        }

        findViewById<TextView>(R.id.nickname_text).setOnClickListener{ /* If the user clicks on
                                            their nickname, then they will be able to update it */
            updateNickname(it)
        }
    }
}