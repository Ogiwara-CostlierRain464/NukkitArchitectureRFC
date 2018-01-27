package jp.ogiwara.nukkit.oauth

import cn.nukkit.Player
import cn.nukkit.command.Command
import cn.nukkit.command.CommandSender
import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerJoinEvent
import cn.nukkit.event.player.PlayerMoveEvent
import cn.nukkit.event.player.PlayerQuitEvent
import cn.nukkit.plugin.PluginBase
import jp.ogiwara.nukkit.oauth.event.OAuthLoginEvent
import jp.ogiwara.nukkit.oauth.event.OAuthRegisterEvent
import jp.ogiwara.nukkit.oauth.interfaces.Dispatcher

/**
 * DIは後で…
 */
@Suppress("unused")
class SampleOAuth: PluginBase() , Listener{

    private val dispatcher: Dispatcher = DispatcherImpl() //TODO

    override fun onEnable() {
        server.pluginManager.registerEvents(this,this)
    }

    @EventHandler
    fun onJoin(event: PlayerJoinEvent){
        dispatcher.onJoin(event.player)
    }

    @EventHandler
    fun onQuit(event: PlayerQuitEvent){
        dispatcher.onQuit(event.player)
    }

    @EventHandler
    fun omMove(event: PlayerMoveEvent){
        val movable = dispatcher.onMove(event.player)
        if(!movable){
            event.setCancelled()
        }
    }

    @EventHandler
    fun onRegister(event: OAuthRegisterEvent){
        dispatcher.onRegister(event.player,event.password)
    }

    @EventHandler
    fun onLogin(event: OAuthLoginEvent){
        dispatcher.onLogin(event.player, event.tryPass)
    }


    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if(sender !is Player){
            sender.sendMessage("プレイヤーのみがこのコマンドを実行できます")
            return true
        }

        if(args.size != 1){
            return false
        }

        when(command.name){
            "register" -> {
                //fire RegisterEvent
                val event = OAuthRegisterEvent(sender, args[0])
                server.pluginManager.callEvent(event)
            }
            "login" -> {
                //fire LoginEvent
                val event = OAuthLoginEvent(sender, args[0])
                server.pluginManager.callEvent(event)
            }
        }

        return true
    }
}