package com.example.android.codelabs.navigation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.codelabs.navigation.data.User
import java.util.UUID

class UserViewModel : ViewModel() {

  val user = MutableLiveData<User?>()

  fun login(shouldSuccess: Boolean) {
    user.postValue(
        when (shouldSuccess) {
          true -> User(UUID.randomUUID())
          else -> null
        }
    )
  }
}