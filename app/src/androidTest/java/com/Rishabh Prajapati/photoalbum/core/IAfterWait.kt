package com.Rishabh Prajapati.photoalbum.core

import com.Rishabh Prajapati.photoalbum.event.Event


interface IAfterWait {
    fun afterWait(events: List<Event>)
}