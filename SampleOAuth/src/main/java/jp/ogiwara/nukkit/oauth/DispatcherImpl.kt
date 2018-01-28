package jp.ogiwara.nukkit.oauth

import cn.nukkit.Player
import cn.nukkit.event.player.PlayerJoinEvent
import cn.nukkit.event.player.PlayerMoveEvent
import cn.nukkit.event.player.PlayerQuitEvent
import jp.ogiwara.nukkit.oauth.event.OAuthLoginEvent
import jp.ogiwara.nukkit.oauth.event.OAuthRegisterEvent
import jp.ogiwara.nukkit.oauth.interfaces.*

class DispatcherImpl: Dispatcher {

    private val repository: OAuthRepository = OAuthRepositoryImpl()

    override fun onJoin(event: PlayerJoinEvent) {
        when(repository.getState(event.player.name)){
            is NonLogin -> {
                event.player.sendMessage("'/login <password>' to login your account")
            }
            is NonRegister -> {
                event.player.sendMessage("'/register <password>' to register your account")
            }
        }
    }

    override fun onQuit(event: PlayerQuitEvent) {
        repository.logout(event.player.name)
    }

    override fun onMove(event: PlayerMoveEvent){
        if(repository.getState(event.player.name) !is Logined){
            event.setCancelled()
        }
    }

    override fun onLogin(event: OAuthLoginEvent) {
        val result = repository.login(event.player.name, event.tryPass)
        event.player.sendMessage(
                if(result) "Login succeed"
                else "Failed to login. Try again."
        )
    }

    override fun onRegister(event: OAuthRegisterEvent) {
        repository.register(event.player.name, event.password)
        event.player.sendMessage("Your password has saved as:'${event.password}'")
    }
}