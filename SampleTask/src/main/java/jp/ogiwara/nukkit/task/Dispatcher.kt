package jp.ogiwara.nukkit.task

import cn.nukkit.Server
import cn.nukkit.event.player.PlayerJoinEvent
import cn.nukkit.plugin.Plugin
import cn.nukkit.scheduler.PluginTask


class Dispatcher(private val plugin: Plugin){

    fun onJoin(event: PlayerJoinEvent){
        Server.getInstance().scheduler.scheduleDelayedTask(object: PluginTask<Plugin>(plugin){
            override fun onRun(p0: Int) {
                onDelay(event.player.name)
            }
        }, 100)
    }

    fun onDelay(playerName: String){
        Server.getInstance().getPlayer(playerName)?.sendTitle("HELLOOOOO")
    }
}