package com.example.listingmovie.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.listingmovie.R
import com.example.listingmovie.databinding.ActivityProfileBinding



class ProfileActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener {

    private lateinit var mBinding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityProfileBinding.inflate(LayoutInflater.from(this))
        setContentView(R.layout.activity_profile)

        mBinding.etUsername.onFocusChangeListener=this
        mBinding.etEmail.onFocusChangeListener=this
        mBinding.etPassword.onFocusChangeListener=this
        mBinding.etPassword2.onFocusChangeListener=this
        mBinding.btnUpdate.setOnClickListener(this)
        mBinding.btnLogout.setOnClickListener(this)

        //load data user
        loadUserData()
    }

    private fun loadUserData() {
        mBinding.etUsername.setText("nabilaaz1777")
        mBinding.etEmail.setText("nabilazahra@gmail.com")
    }

    private fun validateUsername(): Boolean{
        var errorMessage: String? = null
        val value = mBinding.etUsername.text.toString()
        if (value.isEmpty()){
            errorMessage = "Username is required"
        }
        if (errorMessage!=null){
            mBinding.etUsername.error=errorMessage
        }
        return errorMessage==null
    }

    private fun validateEmail():Boolean{
        var errorMessage: String?=null
        val value=mBinding.etEmail.text.toString()
        if (value.isEmpty()){
            errorMessage = "Email  is required"
        }
        if (errorMessage!=null){
            mBinding.etPassword.error=errorMessage
        }
        return errorMessage == null
    }

    private fun validatePassword():Boolean{
        var errorMessage: String?=null
        val value=mBinding.etPassword.text.toString()
        if (value.isEmpty()){
            errorMessage = "Password  is required"
        }else if(value.length<6){
            errorMessage = "Password must be  6 character"
        }
        if (errorMessage!=null){
            mBinding.etPassword.error=errorMessage
        }
        return errorMessage == null
    }

    private fun validateConfirmPassword():Boolean{
        var errorMessage: String?=null
        val value=mBinding.etPassword2.text.toString()
        if (value.isEmpty()){
            errorMessage = "Password  is required"
        }else if(value!=mBinding.etPassword.toString()){
            errorMessage = "Confirm password doesn't match the password"
        }
        if (errorMessage!=null){
            mBinding.etPassword2.error=errorMessage
        }
        return errorMessage == null
    }

    private fun performUpdate(){
        //logic button update
        if(validateUsername() && validateEmail() && validatePassword() && validateConfirmPassword()){
            Toast.makeText(this, "Update was successfull", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.btnUpdate -> performUpdate()
            R.id.btnLogout -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if (view!=null){
            when(view.id){
                R.id.etUsername ->{
                    if (!hasFocus){
                        validateUsername()
                    }
                }
                R.id.etEmail ->{
                    if (!hasFocus){
                        validateEmail()
                    }
                }
                R.id.etPassword ->{
                    if (!hasFocus){
                        validatePassword()
                    }
                }
                R.id.etPassword2 ->{
                    if(!hasFocus){
                        validateConfirmPassword()
                    }
                }
            }
        }
    }


}