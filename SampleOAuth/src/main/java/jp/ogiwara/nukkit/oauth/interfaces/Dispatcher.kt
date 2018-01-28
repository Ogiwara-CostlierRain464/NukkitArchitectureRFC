package jp.ogiwara.nukkit.oauth.interfaces

import cn.nukkit.Player
import cn.nukkit.event.player.PlayerJoinEvent
import cn.nukkit.event.player.PlayerMoveEvent
import cn.nukkit.event.player.PlayerQuitEvent
import jp.ogiwara.nukkit.oauth.event.OAuthLoginEvent
import jp.ogiwara.nukkit.oauth.event.OAuthRegisterEvent

// Abstracted event call back.
interface Dispatcher {
    fun onJoin(event: PlayerJoinEvent)
    fun onQuit(event: PlayerQuitEvent)
    fun onMove(event: PlayerMoveEvent)
    fun onLogin(event: OAuthLoginEvent)
    fun onRegister(event: OAuthRegisterEvent)
}