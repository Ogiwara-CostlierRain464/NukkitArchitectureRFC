package jp.ogiwara.nukkit.oauth.interfaces

//Offer player's login info
interface OAuthRepository {

    fun getState(playerName: String): State

    fun login(playerName: String, tryPass: String): Boolean
    fun logout(playerName: String)

    fun register(playerName: String, password: String): Boolean
}