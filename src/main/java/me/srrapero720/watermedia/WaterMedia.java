package me.srrapero720.watermedia;

import me.srrapero720.watermedia.api.WaterMediaAPI;
import me.srrapero720.watermedia.core.*;
import me.srrapero720.watermedia.util.ThreadUtil;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.io.InputStream;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
public class WaterMedia {
	public static final String ID = "watermedia";
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);
	public static final Marker IT = MarkerFactory.getMarker("Bootstrap");

	// EXCEPTION RETAINER
	private Exception exception;

	private final IMediaLoader loader;
	public WaterMedia(IMediaLoader modLoader) {
		loader = modLoader;
		LOGGER.info(IT, "Running WATERMeDIA on {}", loader.getLoaderName());

		// ENSURE WATERMeDIA IS NOT RUNNING ON SERVERS (except FABRIC)
		if (!loader.isClient() && !loader.isDev()) {
			LOGGER.error(IT, "###########################  ILLEGAL ENVIRONMENT  ###################################");
			LOGGER.error(IT, "WATERMeDIA is not designed to run on SERVERS. remove this mod from server to stop crashes");
			LOGGER.error(IT, "If dependant mods throws error loading WATERMeDIA classes report it to the creator");
			LOGGER.error(IT, "###########################  ILLEGAL ENVIRONMENT  ###################################");

			exception = new IllegalStateException("WATERMeDIA is running on a invalid DIST (dedicated_server)");
		} else LOGGER.info(IT, "Special environment detected, avoiding forced server crash");

		// ENSURE FANCYVIDEO_API IS NOT INSTALLED (to prevent more bugreports about it)
		if (loader.isInstalled("fancyvideo_api"))
			exception = new IllegalStateException("FancyVideo-API is explicit incompatible with WATERMeDIA, please remove it");

		// ENSURE IS NOT RUNNING BY TLAUNCHER
		if (loader.isTLauncher())
			exception = new IllegalStateException("[CRITICAL] TLauncher is a virus launcher and not supported by WATERMeDIA - Suggested: SKLauncher, MultiMC");
	}

	public void init() {
		if (!loader.isClient()) return;
		LOGGER.info(IT, "Starting WaterMedia");

		// PREPARE API
		LOGGER.info(IT, "Loading {}", WaterMediaAPI.class.getSimpleName());
		ThreadUtil.trySimple(() -> WaterMediaAPI.init(loader), e -> exception(WaterMediaAPI.class.getSimpleName(), e));

		// PREPARE STORAGES
		LOGGER.info(IT, "Loading {}", MediaStorage.class.getSimpleName());
		ThreadUtil.trySimple(() -> MediaStorage.init(loader), e -> exception(MediaStorage.class.getSimpleName(), e));

		// PREPARE VLC BINARIES
		LOGGER.info(IT, "Loading {}", VideoLANBin.class.getSimpleName());
		ThreadUtil.trySimple(() -> VideoLANBin.init(loader), e -> exception(VideoLANBin.class.getSimpleName(), e));

		// PREPARE VLC
		LOGGER.info(IT, "Loading {}", VideoLAN.class.getSimpleName());
		ThreadUtil.trySimple(() -> VideoLAN.init(loader), e -> exception(VideoLAN.class.getSimpleName(), e));

		// PREPARE LAVAPLAYER
		LOGGER.info(IT, "Loading {}", LavaPlayer.class.getSimpleName());
		ThreadUtil.trySimple(() -> LavaPlayer.init(loader), e -> exception(LavaPlayer.class.getSimpleName(), e));

		LOGGER.info(IT, "Finished WaterMedia startup");
		if (exception != null) LOGGER.warn(IT, "Detected some critical exceptions after startup");
	}

	public void throwException() { if (exception != null) throw new RuntimeException(exception); }
	private void exception(String module, Exception e) {
		LOGGER.error(IT, "Exception loading {}", module, e);
		if (exception != null) exception = e;
	}

	// TESTERS
	public boolean test$classLoader(ClassLoader loader) {
		InputStream dummy = loader.getResourceAsStream("/vlc/args.json");
		IOUtils.closeQuietly(dummy);
		return dummy != null;
	}
}