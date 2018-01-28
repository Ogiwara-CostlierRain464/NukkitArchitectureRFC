package jp.ogiwara.nukkit.task

import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerJoinEvent
import cn.nukkit.plugin.PluginBase


class SampleTask : PluginBase(), Listener{

    private val dispatcher = Dispatcher(this)

    override fun onEnable() {
        server.pluginManager.registerEvents(this,this)
    }

    @EventHandler
    fun onJoin(event: PlayerJoinEvent){
        dispatcher.onJoin(event)
    }
}