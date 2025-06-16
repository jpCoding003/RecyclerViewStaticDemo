package com.tops.recyclerviewstaticdemo.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.tops.recyclerviewstaticdemo.MainActivity
import com.tops.recyclerviewstaticdemo.R
import com.tops.recyclerviewstaticdemo.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     //   binding = FragmentLoginBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                setReorderingAllowed(true)
                replace<RegisterFragment>(R.id.container_login_signup)
            }
        }

        binding.btnlogin.setOnClickListener {

            if (validity()){
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            }else{
//                Toast.makeText(this , "Enter Details Properly", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "Enter Details Properly", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validity(): Boolean{

        var isValid = true
        if (binding.etusername.text.toString().isEmpty()){
            binding.etusername.error = "*Require"
            return false
        }
        else{
            binding.etusername.error = null
        }
        if (binding.etpassword.text.toString().isEmpty()){
            binding.etpassword.error = "*Require"
            return false
        }else{
            binding.etpassword.error = null
        }

        if (binding.etpassword.length()< 8){
            binding.etpassword.setError("*Min. size must 8 Char")
            return false
        }else{
            binding.etpassword.error = "* Atleast 8 char must"
        }

        //After All this validation
        //Will return True
        return isValid
    }


}

