package ambitious.net.instrumentedunittest4kotlin

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text) as TextView

        val checkButton = findViewById(R.id.check_button) as Button
        checkButton.setOnClickListener {
            check()
        }
    }

    private fun check() {
        MyDialog(textView!!.text.toString()).show(fragmentManager, "test")
    }
}

class MyDialog internal constructor(val text: String): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog =  AlertDialog.Builder(activity)

        if (TextUtils.isEmpty(text)) {
            dialog.setTitle(R.string.error_title)
            dialog.setMessage(R.string.empty_error)
        } else if (!text.equals(getString(R.string.correct_answer))) {
            dialog.setTitle(R.string.error_title)
            dialog.setMessage(R.string.not_equal_error)
        } else {
            dialog.setTitle(R.string.success_title)
            dialog.setMessage(R.string.success_message)
        }

        dialog.setPositiveButton(R.string.dismiss_button, null)

        return dialog.create()
    }

}

