package com.tops.recyclerviewstaticdemo.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.tops.recyclerviewstaticdemo.MainActivity
import com.tops.recyclerviewstaticdemo.R
import com.tops.recyclerviewstaticdemo.databinding.FragmentRegisterBinding

val USERNAME = "USERNAME"
val PASSWORD = "PASSWORD"

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentRegisterBinding.inflate(layoutInflater)
//        return inflater.inflate(R.layout.fragment_register, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            if (validity()){

                val sharedpref = activity?.getSharedPreferences(getString(R.string.app_name),Context.MODE_PRIVATE)?: return@setOnClickListener

                with(sharedpref.edit()){
                    putString(USERNAME, binding.etUsername.text.toString())
                    putString(PASSWORD, binding.etpassword.text.toString())
                    apply()
                }

                activity?.supportFragmentManager?.commit {
                    setReorderingAllowed(true)
                    replace<LoginFragment>(R.id.container_login_signup)
                }
            }
            else{
                Toast.makeText(context, "Enter Proper Details", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validity(): Boolean{

        var isValid = true
        if (binding.etFirstname.text.toString().isEmpty()){
            binding.etFirstname.error = "*Require"
            return false
        }
        else{
            binding.etFirstname.error = null
        }
        if (binding.etLastname.text.toString().isEmpty()){
            binding.etLastname.error = "*Require"
            return false
        }else{
            binding.etLastname.error = null
        }
        if (binding.etUsername.text.toString().isEmpty()){
            binding.etUsername.error = "*Require"
            return false
        }else{
            binding.etUsername.error = null
        }

        if (binding.etpassword.length()< 8 || binding.etpassword.text.toString().isEmpty() ){
            binding.etpassword.setError("*Min. size must 8 Char")
            return false
        }else if (binding.etpassword.text.toString().equals(binding.etConfirmPassword.text.toString())){
            binding.etConfirmPassword.error = null
        }else{
            binding.etConfirmPassword.error = "* Password Did not Matched!!"
            return false
        }

        //After All this validation
        //Will return True
        return isValid
    }
}