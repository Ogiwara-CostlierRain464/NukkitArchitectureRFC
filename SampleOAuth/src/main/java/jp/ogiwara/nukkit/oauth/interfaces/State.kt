package jp.ogiwara.nukkit.oauth.interfaces


interface State

interface BeforeAuth: State
interface AfterAuth: State

object NonRegister: BeforeAuth
object NonLogin: BeforeAuth
object Logined: AfterAuth

