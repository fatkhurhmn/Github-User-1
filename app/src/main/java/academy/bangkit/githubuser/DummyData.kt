package academy.bangkit.githubuser

import academy.bangkit.githubuser.model.UserModel
import android.annotation.SuppressLint
import android.content.Context

object DummyData {
    @SuppressLint("Recycle")
    fun getListUsers(context: Context): ArrayList<UserModel> {
        val listUsers = ArrayList<UserModel>()
        with(context.resources) {
            val dataName = getStringArray(R.array.name)
            val dataUsername = getStringArray(R.array.username)
            val dataLocation = getStringArray(R.array.location)
            val dataRepository = getStringArray(R.array.repository)
            val dataCompany = getStringArray(R.array.company)
            val dataFollowers = getStringArray(R.array.followers)
            val dataFollowing = getStringArray(R.array.following)
            val dataAvatar = obtainTypedArray(R.array.avatar)

            for (i in dataName.indices) {
                val user = UserModel(
                    dataName[i],
                    dataUsername[i],
                    dataLocation[i],
                    dataRepository[i],
                    dataCompany[i],
                    dataFollowers[i],
                    dataFollowing[i],
                    dataAvatar.getResourceId(i, -1)
                )
                listUsers.add(user)
            }
        }
        return listUsers
    }
}