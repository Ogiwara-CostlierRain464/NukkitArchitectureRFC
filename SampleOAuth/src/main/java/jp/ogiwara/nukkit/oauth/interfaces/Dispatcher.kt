package jp.ogiwara.nukkit.oauth.interfaces

import cn.nukkit.Player

//抽象かされたイベントごとの処理
interface Dispatcher {
    fun onJoin(player: Player)
    fun onQuit(player: Player)
    fun onMove(player: Player): Boolean
    fun onLogin(player: Player, tryPass: String)
    fun onRegister(player: Player, password: String)
}