package jp.ogiwara.nukkit.oauth.event

import cn.nukkit.Player
import cn.nukkit.event.Cancellable
import cn.nukkit.event.Event


class OAuthLoginEvent: Event(), Cancellable{
    lateinit var player: Player
}