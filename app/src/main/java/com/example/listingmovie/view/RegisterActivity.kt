package com.example.listingmovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.example.listingmovie.R
import com.example.listingmovie.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener{

    private lateinit var mBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(LayoutInflater.from(this))
        setContentView(R.layout.activity_register)

        mBinding.etUsername.onFocusChangeListener = this
        mBinding.etEmail.onFocusChangeListener = this
        mBinding.etPassword.onFocusChangeListener = this
        mBinding.etPassword2.onFocusChangeListener = this

        mBinding.btnRegister.setOnClickListener(this)
    }

    private fun validateUsername(): Boolean{
        var errorMessage: String? = null
        val value: String = mBinding.etUsername.text.toString()
        if(value.isEmpty()){
            errorMessage = "Username is required"
        }else if(errorMessage != null){
            mBinding.etUsername.error = errorMessage
        }
        return errorMessage == null
    }

    private fun validateEmail(): Boolean{
        var errorMessage: String? = null
        val value = mBinding.etEmail.text.toString()
        if(value.isEmpty()){
            errorMessage = "Email is required"
        }else if(!Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            errorMessage = "Email address is invalid"
        }
        if(errorMessage != null){
            mBinding.etEmail.error = errorMessage
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
            mBinding.etPassword.error = errorMessage
        }
        return errorMessage == null
    }

    private fun validateConfirmPassword(): Boolean{
        var errorMessage: String? = null
        val value = mBinding.etPassword2.text.toString()
        if(value.isEmpty()){
            errorMessage = "Confirm Password is required"
        }else if(value!=mBinding.etPassword.text.toString()){
            errorMessage = "Confirm Password doesn't match password"
        }
        if(errorMessage != null){
            mBinding.etPassword2.error = errorMessage
        }
        return errorMessage == null
    }

    //function for register
    private fun performRegister(){
        if (validateUsername() && validateEmail() && validatePassword() && validateConfirmPassword()){
            Toast.makeText(this, "Registration is successfull", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onClick(view: View?) {
        when(view?.id){
            mBinding.btnRegister.id -> performRegister()
        }
    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if (!hasFocus){
            when(view?.id){
                mBinding.etUsername.id-> validateUsername()
                mBinding.etEmail.id-> validateEmail()
                mBinding.etPassword.id-> validatePassword()
                mBinding.etPassword2.id-> validateConfirmPassword()
            }
        }
    }


}