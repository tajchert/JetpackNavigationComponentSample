package com.example.android.codelabs.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment() {

  companion object {
    fun newInstance() = LoginFragment()
  }

  private val userViewModel: UserViewModel by activityViewModels()
  private lateinit var viewModel: LoginViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.login_fragment, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
  }



  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    val buttonLoginSuccess =  view.findViewById(R.id.buttonLoginSuccess) as Button
    val buttonLoginFail =  view.findViewById(R.id.buttonLoginFail) as Button

    buttonLoginSuccess.setOnClickListener {
      userViewModel.login(true)
    }
    buttonLoginFail.setOnClickListener {
      userViewModel.login(true)
    }
    userViewModel.user.observe(viewLifecycleOwner, { user ->
      if (user != null) {
        findNavController().popBackStack()
      }
    })
  }
}