package com.example.listingmovie.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.listingmovie.R
import com.example.listingmovie.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity(), View.OnFocusChangeListener, View.OnClickListener{

    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        mBinding.etUsername.onFocusChangeListener = this
        mBinding.etPassword.onFocusChangeListener = this
        mBinding.btnLogin.setOnClickListener(this)
    }

    private fun validateUsername():Boolean{
        var errorMessage: String? = null
        val value = mBinding.etUsername.text.toString()
        if(value.isEmpty()){
            errorMessage = "Username is required"
        }
        if(errorMessage!=null){
            mBinding.etUsername.error = errorMessage
            }
        return errorMessage == null
        }

    private fun validatePassword(): Boolean{
        var errorMessage: String? = null
        val value = mBinding.etPassword.text.toString()
        if (value.isEmpty()){
            errorMessage = "Password is required"
        }else if (value.length<6){
            errorMessage = "Password must be 6 character"
        }
        if (errorMessage!=null){
            mBinding.etPassword.error = errorMessage
        }
        return errorMessage == null
    }

    private fun performLogin(){
        if(validateUsername() && validatePassword()){
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if (view!=null){
            when(view.id){
                R.id.etUsername->{
                    if (!hasFocus){
                        validateUsername()
                    }
                }
                R.id.etPassword->{
                    if (hasFocus){
                        validatePassword()
                    }
                }
            }
        }
    }

    override fun onClick(view: View?) {
        if(view?.id == R.id.btnLogin){
            performLogin()
        }
    }

}