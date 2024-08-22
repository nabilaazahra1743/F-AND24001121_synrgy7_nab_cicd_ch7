package com.example.listingmovie



import android.widget.EditText
import com.example.listingmovie.databinding.ActivityMainBinding
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito



/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Mock
    private lateinit var mBinding: ActivityMainBinding

    @Mock
    private lateinit var etEmail: EditText

    @Mock
    private lateinit var etPassword: EditText
    @Before
    fun setUp(){
        mBinding.etUsername = etEmail
        mBinding.etPassword = etPassword
    }

    private fun validateEmail(): Boolean{
        var errorMessage: String? = null
        var value = mBinding.etUsername.text.toString()
        if(value.isEmpty()){
            errorMessage = "Email is required"
        }
        if(errorMessage != null){
            mBinding.etPassword.error = errorMessage
        }
        return errorMessage == null
    }
    @Test
    fun validateemail_withemptyemail() {
        Mockito.'when'(mBinding.etUsername.text.toString()).thenReturn("")
        val result = validateEmail()
        assertFalse(result)
        Mockito.verify(mBinding.etPassword).error = "Email is required"
    }

    @Test
    fun validateemail_withvalidemail(){
        Mockito.'when'(mBinding.etUsername.text.toString()).thenReturn("studywithnabz@gmail.com")

        val result = validateEmail()
        assertTrue(result)
        Mockito.verify(mBinding.etPassword, Mockito.never()).error = Mocikto.anyString()
    }
}

annotation class Mock
