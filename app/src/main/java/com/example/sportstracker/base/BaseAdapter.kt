package com.example.sportstracker.base

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

/**
 * Generic Base adapter for recycler views
 *
 *
 * Author: Lajesh D
 * Email: lajeshds2007@gmail.com
 * Created: 7/24/2018
 * Modified: 7/24/2018
 */
abstract class BaseAdapter<T : ViewHolder?, D> : RecyclerView.Adapter<T>() {
    abstract fun setData(data: List<D>?)
}