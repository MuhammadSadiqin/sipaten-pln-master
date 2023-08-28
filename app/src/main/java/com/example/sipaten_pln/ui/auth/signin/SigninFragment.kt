package com.example.sipaten_pln.ui.auth.signin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.sipaten_pln.databinding.FragmentSigninBinding
import com.example.sipaten_pln.model.response.login.LoginResponse
import com.example.sipaten_pln.ui.MainActivity

class SigninFragment : Fragment(),SigninContract.View {

    lateinit var presenter: SigninPresenter

    private var _binding: FragmentSigninBinding? = null
    private val signinBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSigninBinding.inflate(inflater, container, false)
        return signinBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = SigninPresenter(this)

        signinBinding.btnSignin.setOnClickListener {
            val email = signinBinding.etEmail.text.toString()
            val password = signinBinding.etPassword.text.toString()

            if (email.isNullOrEmpty()){
                signinBinding.etEmail.error = "silahkan masukkan email anda"
                signinBinding.etEmail.requestFocus()
            }
            if (password.isNullOrEmpty()){
                signinBinding.etPassword.error = "silahkan masukkan password anda"
                signinBinding.etPassword.requestFocus()
            }else{

            }
            presenter.submitLogin(email,password)



        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Bersihkan untuk menghindari memory leak
    }

    override fun onLoginSuccess(loginResponse: LoginResponse) {
        val home = Intent(activity, MainActivity::class.java)
        startActivity(home)
        activity?.finish()
    }

    override fun onLoginFailed(massage: String) {
        Toast.makeText(activity,massage, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun dismissLoading() {
        TODO("Not yet implemented")
    }
}
