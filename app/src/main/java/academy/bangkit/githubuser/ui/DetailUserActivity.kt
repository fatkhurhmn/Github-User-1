package academy.bangkit.githubuser.ui

import academy.bangkit.githubuser.R
import academy.bangkit.githubuser.databinding.ActivityDetailUserBinding
import academy.bangkit.githubuser.model.UserModel
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initToolbar()
        initUser()
        actionButton()
    }

    private fun actionButton() {
        val user = intent.getParcelableExtra<UserModel>(EXTRA_DETAIL_USER)

        val message = resources.getString(
            R.string.message,
            user?.name,
            user?.username,
            user?.location,
            user?.company,
            user?.followers,
            user?.following,
            user?.repository,
        )

        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            type = "text/plain"
        }

        binding.btnShare.setOnClickListener {
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }

    private fun initToolbar() {
        val user = intent.getParcelableExtra<UserModel>(EXTRA_DETAIL_USER)
        supportActionBar?.apply {
            title = user?.username
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
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
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_DETAIL_USER = "extra detail user"
    }
}