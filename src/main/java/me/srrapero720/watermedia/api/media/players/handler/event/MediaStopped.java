package me.srrapero720.watermedia.api.media.players.handler.event;

import me.srrapero720.watermedia.api.media.players.Player;
import me.srrapero720.watermedia.api.media.players.VideoLanPlayer;

public interface MediaStopped<T extends Player<T>> extends Event<T> {
    void call(T player);
}
