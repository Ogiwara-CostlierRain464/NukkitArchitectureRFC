package jp.ogiwara.nukkit.oauth.event

import cn.nukkit.Player
import cn.nukkit.event.Cancellable
import cn.nukkit.event.Event
import cn.nukkit.event.HandlerList


class OAuthLoginEvent(val player: Player,
                      val tryPass: String): Event(), Cancellable{
    companion object {
        val handlerList = HandlerList()

        @JvmStatic
        fun getHandlers() = handlerList
    }
}