package ru.rsue.kuznetsov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    companion object{
        private val TAG = "QuestActivity"
        private val KEY_INDEX = "index"
        private val REQUEST_CODE_DECEIT = 0
    }

    private lateinit var mTrueButton: Button
    private lateinit var mFalseButton: Button
    private lateinit var mNextButton: Button
    private lateinit var mPrevButton: Button
    private lateinit var mQuestionTextView: TextView
    private lateinit var mDeceitButton: Button
    private var mCurrentIndex = 0
    private var mIsDeceiter = false

    private val mQuestionBank = listOf(
        Question(R.string.question_android, true),
        Question(R.string.question_linear, false),
        Question(R.string.question_service, false),
        Question(R.string.question_res, true),
        Question(R.string.question_manifest, true),
        Question(R.string.question_version, false),
        Question(R.string.question_emulate, false),
        Question(R.string.question_source, true),
        Question(R.string.question_rate, false),
        Question(R.string.question_root, true),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate(Bundle) вызван")

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        mQuestionTextView = findViewById(R.id.question_text_view)
        mQuestionTextView.setOnClickListener {
            mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.size
            updateQuestion()
        }

        mTrueButton = findViewById(R.id.true_button)
        mTrueButton.setOnClickListener {
            checkAnswer(true)
        }
        mFalseButton = findViewById(R.id.false_button)
        mFalseButton.setOnClickListener{
            checkAnswer(false)
        }
        mNextButton = findViewById(R.id.next_button)
        mNextButton.setOnClickListener {
            mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.size
            mIsDeceiter = false
            updateQuestion()
        }
        mPrevButton = findViewById(R.id.prev_button)
        mPrevButton.setOnClickListener {
            mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.size
            updateQuestion()
        }
        mDeceitButton = findViewById(R.id.deceit_button)
        mDeceitButton.setOnClickListener{
            val answerIsTrue = mQuestionBank[mCurrentIndex].answerTrue
            val intent = DeceitActivity.newIntent(this,
                answerIsTrue)
            startActivityForResult(intent, REQUEST_CODE_DECEIT)
        }
        updateQuestion()
    }

    override fun onActivityResult(
        requestCode: Int, resultCode:
        Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_CODE_DECEIT) {
            if (data == null) {
                return;
            }
            mIsDeceiter = DeceitActivity.wasAnswerShown(result = data);
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState")
        outState!!.putInt(KEY_INDEX, mCurrentIndex)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() вызван")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() вызван")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() вызван")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() вызван")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() вызван")
    }

    private fun updateQuestion() {
        val question = mQuestionBank[mCurrentIndex].textResId
        mQuestionTextView.setText(question)
    }

    private fun checkAnswer(userPressedTrue: Boolean) {
        val answerIsTrue = mQuestionBank[mCurrentIndex].answerTrue
        val messageResId = if (mIsDeceiter) R.string.judgment_toast
        else if (userPressedTrue == answerIsTrue) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
}