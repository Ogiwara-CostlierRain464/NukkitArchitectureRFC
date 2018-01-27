package jp.ogiwara.nukkit.oauth

import cn.nukkit.Player
import jp.ogiwara.nukkit.oauth.interfaces.Dispatcher
import jp.ogiwara.nukkit.oauth.interfaces.OAuthRepository


class DispatcherImpl: Dispatcher {

    private lateinit var repository: OAuthRepository

    override fun onJoin(player: Player) {
        repository.createEmptyColumn(player.name)
    }

    override fun onQuit(player: Player) {
        repository.
    }

    override fun onMove(player: Player) {
    }

    override fun onLogin(player: Player) {
    }

    override fun onRegister(player: Player) {
    }
}