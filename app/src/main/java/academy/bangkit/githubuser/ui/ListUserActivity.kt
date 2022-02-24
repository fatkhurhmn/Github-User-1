package academy.bangkit.githubuser.ui

import academy.bangkit.githubuser.adapter.UserAdapter
import academy.bangkit.githubuser.databinding.ActivityListUserBinding
import academy.bangkit.githubuser.model.UserModel
import academy.bangkit.githubuser.utils.DummyData
import android.content.Intent
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
        with(userAdapter) {
            setListUsers(DummyData.getListUsers(this@ListUserActivity))
            setOnItemClickCallback(object : UserAdapter.OnItemClickCallback {
                override fun onItemClicked(user: UserModel) {
                    val detailUserIntent = Intent(this@ListUserActivity, DetailUserActivity::class.java)
                    detailUserIntent.putExtra(DetailUserActivity.EXTRA_DETAIL_USER, user)
                    startActivity(detailUserIntent)
                }
            })
        }

        with(binding.rvUser) {
            layoutManager = LinearLayoutManager(this@ListUserActivity)
            adapter = userAdapter
        }

    }
}