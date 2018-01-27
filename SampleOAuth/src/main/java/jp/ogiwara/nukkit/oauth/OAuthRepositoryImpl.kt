package jp.ogiwara.nukkit.oauth

import jp.ogiwara.nukkit.oauth.interfaces.NonLogin
import jp.ogiwara.nukkit.oauth.interfaces.NonRegister
import jp.ogiwara.nukkit.oauth.interfaces.OAuthRepository
import jp.ogiwara.nukkit.oauth.interfaces.State


class OAuthRepositoryImpl: OAuthRepository {

    private val record: MutableMap<String,UserAuthData> = hashMapOf()

    override fun getState(playerName: String): State {
        if(record[playerName] == null){
            createEmptyColumn(playerName)
        }

        return record[playerName]!!.state
    }

    override fun login(playerName: String, tryPass: String): Boolean {
        return record[playerName]!!.tryLogin(tryPass)
    }

    override fun logout(playerName: String) {
        record[playerName]!!.state = NonLogin
    }

    override fun register(playerName: String, password: String): Boolean {
        return record[playerName]!!.register(password)
    }

    private fun createEmptyColumn(playerName: String){
        record[playerName] = UserAuthData(NonRegister,null)
    }
}