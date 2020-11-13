package com.example.android.codelabs.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class ProfileFragment : Fragment() {

  private lateinit var viewModel: ProfileViewModel
  private val userViewModel: UserViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.profile_fragment, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    val navController = findNavController()
    userViewModel.user.observe(viewLifecycleOwner, { user ->
      if (user != null) {
        Toast.makeText(requireContext(), "SUCCESS LOGIN", Toast.LENGTH_SHORT).show()
      } else {
        navController.navigate(R.id.loginFragment)
      }
    })
  }

}