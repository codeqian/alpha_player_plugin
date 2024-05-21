package android.src.main.kotlin.com.example.alpha_player_plugin

class AliPlayerImpl(private val context: Context) : AbsPlayer(context) {
    private lateinit var aliPlayer: AliPlayer
    private var currVideoWidth: Int = 0
    private var currVideoHeight: Int = 0
    private var isLooping: Boolean = false

    override fun initMediaPlayer() {
        aliPlayer = AliPlayerFactory.createAliPlayer(context)
        aliPlayer.isAutoPlay = true
        aliPlayer.scaleMode = IPlayer.ScaleMode.SCALE_ASPECT_FILL;
        aliPlayer.setOnVideoSizeChangedListener { width, height ->
            currVideoWidth = width; currVideoHeight = height
        }
    }

    override fun setDataSource(dataPath: String) {
        reset()
        aliPlayer.setDataSource(UrlSource())
    }

    override fun prepareAsync() {
        aliPlayer.prepare()
        aliPlayer
    }

    override fun start() {
        aliPlayer.start()
    }

    override fun pause() {
        aliPlayer.pause()
    }

    override fun stop() {
        aliPlayer.stop()
    }

    override fun reset() {
        aliPlayer.stop()
        aliPlayer.clearScreen()
    }

    override fun release() {
        aliPlayer.release()
    }

    override fun setLooping(looping: Boolean) {
        this.isLooping = looping
        aliPlayer. = if (isLooping) REPEAT_MODE_ONE else REPEAT_MODE_OFF
    }

    override fun setScreenOnWhilePlaying(onWhilePlaying: Boolean) {
    }

    override fun setSurface(surface: Surface) {
        aliPlayer.setSurface(surface)
    }

    override fun getVideoInfo(): VideoInfo {
        return VideoInfo(currVideoWidth, currVideoHeight)
    }

    override fun getPlayerType(): String {
        return "AliPlayerImpl"
    }
}