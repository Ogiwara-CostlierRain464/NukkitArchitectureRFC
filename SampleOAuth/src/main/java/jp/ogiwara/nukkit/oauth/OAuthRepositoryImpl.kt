package jp.ogiwara.nukkit.oauth

import jp.ogiwara.nukkit.oauth.interfaces.OAuthRepository
import jp.ogiwara.nukkit.oauth.interfaces.State


class OAuthRepositoryImpl: OAuthRepository {

    //playerName, state, password
    private val record: MutableMap<String,UserAuthData> = hashMapOf()

    override fun updateColumn(playerName: String, state: State) {
        if(!record.contains(playerName)){
            record[playerName] = UserAuthData()
        }

        record[playerName]!!.state = state
    }

    override fun checkState(playerName: String) = record[playerName]!!.state

    override fun login(playerName: String, tryPass: String): Boolean {
        //guard
        if(record[playerName]!!.isLogined){
            return false
        }

        return record[playerName]!!.tryLogin(tryPass)
    }


    override fun register(playerName: String, password: String): Boolean{
        //guard
        if(record[playerName]!!.isRegistered){
            return false
        }

        record[playerName]!!.register(password)
        return true
    }
}