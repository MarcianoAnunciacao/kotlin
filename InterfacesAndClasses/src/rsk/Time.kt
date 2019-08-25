package rsk

interface Time {
    fun setTime(hours: Int, mins: Int = 0, secs: Int = 0)
    fun setTime(time: MarcianoTime) = setTime(time.hours)
}

interface EndOfTheWorld{
    fun setTime(time: MarcianoTime){}
}

class MarcianoTime{
    var hours: Int = 0
    var minutes: Int = 0
    var seconds: Int =0
}

class YetTime : Time, EndOfTheWorld{
    override fun setTime(time: MarcianoTime) {
        super<Time>.setTime(time)
        super<EndOfTheWorld>.setTime(time)
    }

    override fun setTime(hours: Int, mins: Int, secs: Int) {

    }

}