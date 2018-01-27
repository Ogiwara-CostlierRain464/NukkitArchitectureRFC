package jp.ogiwara.nukkit.oauth

import jp.ogiwara.nukkit.oauth.interfaces.Logined
import jp.ogiwara.nukkit.oauth.interfaces.NonRegister
import jp.ogiwara.nukkit.oauth.interfaces.State

//ユーザーのOAuth情報
data class UserAuthData(var state: State = NonRegister,
                        private var password: String? = null){

    val isLogined: Boolean
        get() = state is Logined

    val isRegistered: Boolean
        get() = password != null

    fun register(password: String): Boolean
        = if(this.password != null){
            false
        }else{
            this.password = password
            state = Logined
            true
        }

    fun tryLogin(tryPass: String): Boolean
        = if(tryPass == password){
            state = Logined
            true
        }else{
            false
        }

}