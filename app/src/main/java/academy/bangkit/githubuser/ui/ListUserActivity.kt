package academy.bangkit.githubuser.ui

import academy.bangkit.githubuser.adapter.UserAdapter
import academy.bangkit.githubuser.databinding.ActivityListUserBinding
import academy.bangkit.githubuser.model.UserModel
import academy.bangkit.githubuser.utils.DummyData
import android.os.Bundle
import android.widget.Toast
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
        with(userAdapter) {
            setListUsers(DummyData.getListUsers(this@ListUserActivity))
            setOnItemClickCallback(object : UserAdapter.OnItemClickCallback {
                override fun onItemClicked(user: UserModel) {
                    Toast.makeText(this@ListUserActivity, user.name, Toast.LENGTH_LONG).show()
                }
            })
        }

        with(binding.rvUser) {
            layoutManager = LinearLayoutManager(this@ListUserActivity)
            adapter = userAdapter
        }

    }
}