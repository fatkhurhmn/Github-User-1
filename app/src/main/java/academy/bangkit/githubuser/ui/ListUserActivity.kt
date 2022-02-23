package academy.bangkit.githubuser.ui

import academy.bangkit.githubuser.adapter.UserAdapter
import academy.bangkit.githubuser.databinding.ActivityListUserBinding
import academy.bangkit.githubuser.utils.DummyData
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

class ListUserActivity : AppCompatActivity() {

    private val userAdapter: UserAdapter by lazy { UserAdapter() }
    private lateinit var binding: ActivityListUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showListUsers()
    }

    private fun showListUsers() {
        userAdapter.setListUsers(DummyData.getListUsers(this))
        with(binding.rvUser) {
            layoutManager = LinearLayoutManager(this@ListUserActivity)
            adapter = userAdapter
        }
    }
}