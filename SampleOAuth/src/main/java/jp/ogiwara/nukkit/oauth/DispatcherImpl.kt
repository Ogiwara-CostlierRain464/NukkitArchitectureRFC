package jp.ogiwara.nukkit.oauth

import cn.nukkit.Player
import jp.ogiwara.nukkit.oauth.interfaces.*

class DispatcherImpl: Dispatcher {

    private val repository: OAuthRepository = OAuthRepositoryImpl()

    override fun onJoin(player: Player) {
        when(repository.getState(player.name)){
            is NonLogin -> {
                player.sendMessage("'/login <password>' でログインして下さい")
            }
            is NonRegister -> {
                player.sendMessage("'/register <password>' でログインして下さい")
            }
        }
    }

    override fun onQuit(player: Player) {
        repository.logout(player.name)
    }

    override fun onMove(player: Player): Boolean = repository.getState(player.name) is Logined

    override fun onLogin(player: Player, tryPass: String) {
        val result = repository.login(player.name, tryPass)
        player.sendMessage(if(result) "ログインに成功しました" else "ログインに失敗しました、再度お試し下さい")
    }

    override fun onRegister(player: Player, password: String) {
        repository.register(player.name, password)
        player.sendMessage("あなたのパスワードは、'${password}'として登録されました")
    }
}