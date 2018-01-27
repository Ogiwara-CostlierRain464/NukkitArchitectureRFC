package jp.ogiwara.nukkit.oauth.interfaces

//ログインに関する、現在の状態を確認
interface OAuthRepository {

    //新規プレイヤーログイン時に、空のカラムを作る
    fun createEmptyColumn(playerName: String)

    /**
     * プレイヤーListの隠蔽
     *
     * login, logout, register ...
     */

    fun notifyJoin()
    fun notifyQuit()
    fun notifyLogin()
    fun notifyRegister()


    fun getState(playerName: String): State

    fun login(playerName: String, tryPass: String): Boolean

    fun register(playerName: String, password: String): Boolean
}