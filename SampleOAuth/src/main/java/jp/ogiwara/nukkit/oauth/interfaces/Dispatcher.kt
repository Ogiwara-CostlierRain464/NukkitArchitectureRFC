package jp.ogiwara.nukkit.oauth.interfaces

import cn.nukkit.Player

interface Dispatcher {
    fun onJoin(player: Player)
    fun onQuit(player: Player)
    fun onMove(player: Player)
    fun onLogin(player: Player)
    fun onRegister(player: Player)
}