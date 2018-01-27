package jp.ogiwara.nukkit.oauth.interfaces

//ログインに関する、現在の状態を確認
interface OAuthRepository {

    fun getState(playerName: String): State

    fun login(playerName: String, tryPass: String): Boolean
    fun logout(playerName: String)

    fun register(playerName: String, password: String): Boolean
}