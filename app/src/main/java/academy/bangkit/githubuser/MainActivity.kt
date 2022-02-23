package academy.bangkit.githubuser

import academy.bangkit.githubuser.adapter.UserAdapter
import academy.bangkit.githubuser.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private val userAdapter: UserAdapter by lazy { UserAdapter() }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showListUsers()
    }

    private fun showListUsers() {
        userAdapter.setListUsers(DummyData.getListUsers(this))
        with(binding.rvUser) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }
}