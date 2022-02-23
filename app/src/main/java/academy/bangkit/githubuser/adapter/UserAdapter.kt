package academy.bangkit.githubuser.adapter

import academy.bangkit.githubuser.databinding.ItemUserBinding
import academy.bangkit.githubuser.model.UserModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserAdapter : RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    private var listUsers = ArrayList<UserModel>()

    fun setListUsers(users: ArrayList<UserModel>) {
        with(listUsers) {
            clear()
            addAll(users)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val itemUserBinding =
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemUserBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUsers[position])
    }

    override fun getItemCount(): Int = listUsers.size

    class ListViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserModel) {
            with(binding) {
                tvItemName.text = user.name
                tvItemUsername.text = user.username
                imgItemProfile.setImageResource(user.avatar)
            }
        }
    }
}