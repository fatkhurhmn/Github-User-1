package academy.bangkit.githubuser.ui

import academy.bangkit.githubuser.databinding.ActivityDetailUserBinding
import academy.bangkit.githubuser.model.UserModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUser()
    }

    private fun initUser() {
        val user = intent.getParcelableExtra<UserModel>(EXTRA_DETAIL_USER)
        user?.let {
            with(binding) {
                tvDetailName.text = user.name
                tvDetailUsername.text = user.username
                imgDetailAvatar.setImageResource(user.avatar)
                tvDetailLocation.text = user.location
                tvDetailCompany.text = user.company
                tvFollowersValue.text = user.followers
                tvFollowingValue.text = user.following
                tvRepositoryValue.text = user.repository
            }
            supportActionBar?.title = user.username
        }
    }

    companion object {
        const val EXTRA_DETAIL_USER = "extra detail user"
    }
}