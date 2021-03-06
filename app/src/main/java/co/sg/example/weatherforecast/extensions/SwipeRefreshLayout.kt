package co.sg.example.weatherforecast.extensions

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

fun SwipeRefreshLayout?.start() {
    this?.apply {
        isRefreshing = true
        isEnabled = false
    }
}

fun SwipeRefreshLayout?.stop() {
    this?.apply {
        isRefreshing = false
        isEnabled = true
    }
}