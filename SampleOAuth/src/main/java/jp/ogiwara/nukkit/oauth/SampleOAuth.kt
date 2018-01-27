package jp.ogiwara.nukkit.oauth

import cn.nukkit.command.Command
import cn.nukkit.command.CommandSender
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerJoinEvent
import cn.nukkit.event.player.PlayerMoveEvent
import cn.nukkit.event.player.PlayerQuitEvent
import cn.nukkit.plugin.PluginBase
import jp.ogiwara.nukkit.oauth.interfaces.Dispatcher

/**
 * DIは後で…
 */
class SampleOAuth: PluginBase() , Listener{

    private val dispatcher: Dispatcher = DispatcherImpl() //TODO

    override fun onEnable() {
        server.pluginManager.registerEvents(this,this)
    }

    fun onJoin(event: PlayerJoinEvent){
        dispatcher.onJoin(event.player)
    }

    fun onQuit(event: PlayerQuitEvent){
        dispatcher.onQuit(event.player)
    }

    fun omMove(event: PlayerMoveEvent){

    }

    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {



        return true
    }
}