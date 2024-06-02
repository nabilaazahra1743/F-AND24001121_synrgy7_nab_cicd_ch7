package com.example.listingmovie.loginRegister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import com.example.listingmovie.R
import com.example.listingmovie.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener {

    private lateinit var mBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(LayoutInflater.from(this))
        setContentView(R.layout.activity_register)
        mBinding.etUsername.onFocusChangeListener = this
        mBinding.etEmail.onFocusChangeListener = this
        mBinding.etPassword.onFocusChangeListener = this
        mBinding.etPassword2.onFocusChangeListener = this
    }

    private fun validateUsername(): Boolean{
        var errorMessage: String? = null
        val value: String = mBinding.etUsername.text.toString()
        if(value.isEmpty()){
            errorMessage = "Username is required"
        }

        if(errorMessage != null){
            mBinding.etUsername.apply {
                isTextInputLayoutFocusedRectEnabled = true
                error = errorMessage

            }
        }
        return errorMessage == null
    }

    private fun validateEmail(): Boolean{
        var errorMessage: String? = null
        val value = mBinding.etEmail.text.toString()
        if(value.isEmpty()){
            errorMessage = "Email is required"
        }else if(Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            errorMessage = "Email address is invalid"
        }
        if(errorMessage != null){
            mBinding.etEmail.apply {
                isTextInputLayoutFocusedRectEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validatePassword(): Boolean{
        var errorMessage: String? = null
        val value = mBinding.etPassword.text.toString()
        if(value.isEmpty()){
            errorMessage = "Password is required"
        }else if(value.length < 6){
            errorMessage = "Password must be 6 characters long"
        }
        if(errorMessage != null){
            mBinding.etPassword.apply {
                isTextInputLayoutFocusedRectEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validateConfirmPassword(): Boolean{
        var errorMessage: String? = null
        val value = mBinding.etPassword2.text.toString()
        if(value.isEmpty()){
            errorMessage = "Confirm Password is required"
        }else if(value.length < 6){
            errorMessage = "Confirm Password must be 6 characters long"
        }
        if(errorMessage != null){
            mBinding.etPassword2.apply {
                isTextInputLayoutFocusedRectEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    //untuk validasi password dan confirm password
    private fun validatePasswordAndConfirmPassword(): Boolean{
        var errorMessage: String? = null
        val password = mBinding.etPassword.text.toString()
        val confirmPassword = mBinding.etPassword2.text.toString()
        if(password != confirmPassword){
            errorMessage = "Confirm password doesn't match password"
        }
        if(errorMessage != null){
            mBinding.etPassword2.apply {
                isTextInputLayoutFocusedRectEnabled = true
                errorMessage = errorMessage
            }
        }
        return errorMessage == null
    }

    override fun onClick(view: View?) {
        TODO("Not yet implemented")
    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if(view != null){
            when(view.id){
                R.id.etUsername -> {
                    if(hasFocus){
                        if(mBinding.etUsername.isEnabled){
                            mBinding.etUsername.isTextInputLayoutFocusedRectEnabled = false
                        }
                    }else{
                        validateUsername()
                    }
                }
                R.id.etEmail -> {
                    if (hasFocus){
                        if(mBinding.etEmail.isEnabled){
                            mBinding.etEmail.isTextInputLayoutFocusedRectEnabled = false
                        }
                    }else{
                        validateEmail()
                    }
                }
                R.id.etPassword -> {
                    if (hasFocus){
                        if(mBinding.etPassword.isEnabled){
                            mBinding.etPassword.isTextInputLayoutFocusedRectEnabled = false
                        }

                    }else{
                        if(validatePassword() && mBinding.etPassword.text!!.isNotEmpty() && validateConfirmPassword() && validatePasswordAndConfirmPassword()
                        ){
                            if(mBinding.etPassword.isEnabled){
                                mBinding.etPassword.isEnabled  = false
                            }
                            mBinding.etPassword.startActionMode = R.drawable.
                        }
                    }
                }
                R.id.etPassword2 -> {
                    if(hasFocus){
                        if(mBinding.etPassword2.isEnabled){
                            mBinding.etPassword2.isTextInputLayoutFocusedRectEnabled = false
                        }

                    }else{
                        validateConfirmPassword()
                    }
                }
            }
        }
    }

    override fun onKey(view: View?, kekeyCode: Int, KeyEvent: KeyEvent?): Boolean {
       return false
    }
}