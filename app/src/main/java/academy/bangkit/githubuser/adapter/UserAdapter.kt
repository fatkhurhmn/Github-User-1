package academy.bangkit.githubuser.adapter

import academy.bangkit.githubuser.databinding.ItemUserBinding
import academy.bangkit.githubuser.model.UserModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserAdapter : RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    private var listUsers = ArrayList<UserModel>()
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setListUsers(users: ArrayList<UserModel>) {
        with(listUsers) {
            clear()
            addAll(users)
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
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
        val user = listUsers[position]
        holder.bind(user)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(user)
        }
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

    interface OnItemClickCallback {
        fun onItemClicked(user: UserModel)
    }
}