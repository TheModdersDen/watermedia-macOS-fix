package me.srrapero720.watermedia.core.videolan;

import me.srrapero720.watermedia.Util;

import java.io.File;
import java.nio.file.Path;

import static me.srrapero720.watermedia.WaterMedia.LOGGER;
import static me.srrapero720.watermedia.core.videolan.VideoLAN.IT;

public enum VLCBinaries {
    // CORES
    libvlc(Type.BIN, null),
    libvlccore(Type.BIN, null),

//    // plugins/aarch64
//    libdeinterlace_aarch64_plugin("aarch64"),
//    libdeinterlace_sve_plugin("aarch64"),

    // plugins/access
    libfilesystem_plugin(Type.BIN, "access"),
    libhttp_plugin(Type.BIN, "access"),
    libhttps_plugin(Type.BIN, "access"),
    libimem_plugin(Type.BIN, "access"),
    libtcp_plugin(Type.BIN, "access"),
    libudp_plugin(Type.BIN, "access"),

    // plugins/audio_filter
    libaudio_format_plugin(Type.BIN, "audio_filter"),
    libaudiobargraph_a_plugin(Type.BIN, "audio_filter"),
    libchorus_flanger_plugin(Type.BIN, "audio_filter"),
    libcompressor_plugin(Type.BIN, "audio_filter"),
    libdolby_surround_decoder_plugin(Type.BIN, "audio_filter"),
    libequalizer_plugin(Type.BIN, "audio_filter"),
    libgain_plugin(Type.BIN, "audio_filter"),
    libheadphone_channel_mixer_plugin(Type.BIN, "audio_filter"),
    libkaraoke_plugin(Type.BIN, "audio_filter"),
    libmad_plugin(Type.BIN, "audio_filter"),
    libmono_plugin(Type.BIN, "audio_filter"),
    libnormvol_plugin(Type.BIN, "audio_filter"),
    libparam_eq_plugin(Type.BIN, "audio_filter"),
    libremap_plugin(Type.BIN, "audio_filter"),
    libsamplerate_plugin(Type.BIN, "audio_filter"),
    libscaletempo_pitch_plugin(Type.BIN, "audio_filter"),
    libscaletempo_plugin(Type.BIN, "audio_filter"),
    libsimple_channel_mixer_plugin(Type.BIN, "audio_filter"),
    libspatialaudio_plugin(Type.BIN, "audio_filter"),
    libspatializer_plugin(Type.BIN, "audio_filter"),
    libspeex_resampler_plugin(Type.BIN, "audio_filter"),
    libstereo_widen_plugin(Type.BIN, "audio_filter"),
    libtospdif_plugin(Type.BIN, "audio_filter"),
    libtrivial_channel_mixer_plugin(Type.BIN, "audio_filter"),
    libugly_resampler_plugin(Type.BIN, "audio_filter"),

    // plugins/audio_mixer
    libfloat_mixer_plugin(Type.BIN, "audio_mixer"),
    libinteger_mixer_plugin(Type.BIN, "audio_mixer"),

    // plugins/audio_output
    libadummy_plugin(Type.BIN, "audio_output"),
    libamem_plugin(Type.BIN, "audio_output"),
    libdirectsound_plugin(Type.BIN, "audio_output"),
    libwasapi_plugin(Type.BIN, "audio_output"),
    libwaveout_plugin(Type.BIN, "audio_output"),

    // plugins/codec
    liba52_plugin(Type.BIN, "codec"),
    libadpcm_plugin(Type.BIN, "codec"),
    libaes3_plugin(Type.BIN, "codec"),
    libaom_plugin(Type.BIN, "codec"),
    libaraw_plugin(Type.BIN, "codec"),
    libaribsub_plugin(Type.BIN, "codec"),
    libavcodec_plugin(Type.BIN, "codec"),
    libcc_plugin(Type.BIN, "codec"),
    libcdg_plugin(Type.BIN, "codec"),
    libcrystalhd_plugin(Type.BIN, "codec"),
    libcvdsub_plugin(Type.BIN, "codec"),
    libd3d11va_plugin(Type.BIN, "codec"),
    libdav1d_plugin(Type.BIN, "codec"),
    libdca_plugin(Type.BIN, "codec"),
    libddummy_plugin(Type.BIN, "codec"),
    libdmo_plugin(Type.BIN, "codec"),
    libdvbsub_plugin(Type.BIN, "codec"),
    libdxva2_plugin(Type.BIN, "codec"),
    libedummy_plugin(Type.BIN, "codec"),
    libfaad_plugin(Type.BIN, "codec"),
    libflac_plugin(Type.BIN, "codec"),
    libfluidsynth_plugin(Type.BIN, "codec"),
    libg711_plugin(Type.BIN, "codec"),
    libjpeg_plugin(Type.BIN, "codec"),
    libkate_plugin(Type.BIN, "codec"),
    liblibass_plugin(Type.BIN, "codec"),
    liblibmpeg2_plugin(Type.BIN, "codec"),
    liblpcm_plugin(Type.BIN, "codec"),
    libmft_plugin(Type.BIN, "codec"),
    libmpg123_plugin(Type.BIN, "codec"),
    liboggspots_plugin(Type.BIN, "codec"),
    libopus_plugin(Type.BIN, "codec"),
    libpng_plugin(Type.BIN, "codec"),
    libqsv_plugin(Type.BIN, "codec"),
    librawvideo_plugin(Type.BIN, "codec"),
    librtpvideo_plugin(Type.BIN, "codec"),
    libschroedinger_plugin(Type.BIN, "codec"),
    libscte18_plugin(Type.BIN, "codec"),
    libscte27_plugin(Type.BIN, "codec"),
    libsdl_image_plugin(Type.BIN, "codec"),
    libspdif_plugin(Type.BIN, "codec"),
    libspeex_plugin(Type.BIN, "codec"),
    libspudec_plugin(Type.BIN, "codec"),
    libstl_plugin(Type.BIN, "codec"),
    libsubsdec_plugin(Type.BIN, "codec"),
    libsubstx3g_plugin(Type.BIN, "codec"),
    libsubsusf_plugin(Type.BIN, "codec"),
    libsvcdsub_plugin(Type.BIN, "codec"),
    libt140_plugin(Type.BIN, "codec"),
    libtextst_plugin(Type.BIN, "codec"),
    libtheora_plugin(Type.BIN, "codec"),
    libttml_plugin(Type.BIN, "codec"),
    libtwolame_plugin(Type.BIN, "codec"),
    libuleaddvaudio_plugin(Type.BIN, "codec"),
    libvorbis_plugin(Type.BIN, "codec"),
    libvpx_plugin(Type.BIN, "codec"),
    libwebvtt_plugin(Type.BIN, "codec"),
    libx264_plugin(Type.BIN, "codec"),
    libx265_plugin(Type.BIN, "codec"),
    libx26410b_plugin(Type.BIN, "codec"),
    libzvbi_plugin(Type.BIN, "codec"),

    // plugins/demux
    libadaptive_plugin(Type.BIN, "demux"),
    libaiff_plugin(Type.BIN, "demux"),
    libasf_plugin(Type.BIN, "demux"),
    libau_plugin(Type.BIN, "demux"),
    libavi_plugin(Type.BIN, "demux"),
    libcaf_plugin(Type.BIN, "demux"),
    libdemux_cdg_plugin(Type.BIN, "demux"),
    libdemux_chromecast_plugin(Type.BIN, "demux"),
    libdemux_stl_plugin(Type.BIN, "demux"),
    libdemuxdump_plugin(Type.BIN, "demux"),
    libdiracsys_plugin(Type.BIN, "demux"),
    libdirectory_demux_plugin(Type.BIN, "demux"),
    libes_plugin(Type.BIN, "demux"),
    libflacsys_plugin(Type.BIN, "demux"),
    libgme_plugin(Type.BIN, "demux"),
    libh26x_plugin(Type.BIN, "demux"),
    libimage_plugin(Type.BIN, "demux"),
    libmjpeg_plugin(Type.BIN, "demux"),
    libmkv_plugin(Type.BIN, "demux"),
    libmod_plugin(Type.BIN, "demux"),
    libmp4_plugin(Type.BIN, "demux"),
    libmpc_plugin(Type.BIN, "demux"),
    libmpgv_plugin(Type.BIN, "demux"),
    libnoseek_plugin(Type.BIN, "demux"),
    libnsc_plugin(Type.BIN, "demux"),
    libnsv_plugin(Type.BIN, "demux"),
    libnuv_plugin(Type.BIN, "demux"),
    libogg_plugin(Type.BIN, "demux"),
    libplaylist_plugin(Type.BIN, "demux"),
    libps_plugin(Type.BIN, "demux"),
    libpva_plugin(Type.BIN, "demux"),
    librawaud_plugin(Type.BIN, "demux"),
    librawdv_plugin(Type.BIN, "demux"),
    librawvid_plugin(Type.BIN, "demux"),
    libreal_plugin(Type.BIN, "demux"),
    libsid_plugin(Type.BIN, "demux"),
    libsmf_plugin(Type.BIN, "demux"),
    libsubtitle_plugin(Type.BIN, "demux"),
    libts_plugin(Type.BIN, "demux"),
    libtta_plugin(Type.BIN, "demux"),
    libty_plugin(Type.BIN, "demux"),
    libvc1_plugin(Type.BIN, "demux"),
    libvobsub_plugin(Type.BIN, "demux"),
    libvoc_plugin(Type.BIN, "demux"),
    libwav_plugin(Type.BIN, "demux"),
    libxa_plugin(Type.BIN, "demux"),

    // plugins/logger
    libconsole_logger_plugin(Type.BIN, "logger"),
    libfile_logger_plugin(Type.BIN, "logger"),

    // plugins/lua
    liblua_plugin(Type.BIN,"lua"),

    // plugins/misc
    libgnutls_plugin(Type.BIN, "misc"),
    libxml_plugin(Type.BIN, "misc"),

    // plugins/mux
    libmux_asf_plugin(Type.BIN, "mux"),
    libmux_avi_plugin(Type.BIN, "mux"),
    libmux_dummy_plugin(Type.BIN, "mux"),
    libmux_mp4_plugin(Type.BIN, "mux"),
    libmux_mpjpeg_plugin(Type.BIN, "mux"),
    libmux_ogg_plugin(Type.BIN, "mux"),
    libmux_ps_plugin(Type.BIN, "mux"),
    libmux_ts_plugin(Type.BIN, "mux"),
    libmux_wav_plugin(Type.BIN, "mux"),

    // plugins/packetizer
    libpacketizer_a52_plugin(Type.BIN, "packetizer"),
    libpacketizer_av1_plugin(Type.BIN, "packetizer"),
    libpacketizer_copy_plugin(Type.BIN, "packetizer"),
    libpacketizer_dirac_plugin(Type.BIN, "packetizer"),
    libpacketizer_dts_plugin(Type.BIN, "packetizer"),
    libpacketizer_flac_plugin(Type.BIN, "packetizer"),
    libpacketizer_h264_plugin(Type.BIN, "packetizer"),
    libpacketizer_hevc_plugin(Type.BIN, "packetizer"),
    libpacketizer_mlp_plugin(Type.BIN, "packetizer"),
    libpacketizer_mpeg4audio_plugin(Type.BIN, "packetizer"),
    libpacketizer_mpeg4video_plugin(Type.BIN, "packetizer"),
    libpacketizer_mpegaudio_plugin(Type.BIN, "packetizer"),
    libpacketizer_mpegvideo_plugin(Type.BIN, "packetizer"),
    libpacketizer_vc1_plugin(Type.BIN, "packetizer"),

    // plugins/spu
    liblogo_plugin(Type.BIN,"spu"),
    libmarq_plugin(Type.BIN,"spu"),

    // plugins/stream_filter
    libadf_plugin(Type.BIN, "stream_filter"),
    libaribcam_plugin(Type.BIN, "stream_filter"),
    libcache_block_plugin(Type.BIN, "stream_filter"),
    libcache_read_plugin(Type.BIN, "stream_filter"),
    libhds_plugin(Type.BIN, "stream_filter"),
    libinflate_plugin(Type.BIN, "stream_filter"),
    libprefetch_plugin(Type.BIN, "stream_filter"),
    librecord_plugin(Type.BIN, "stream_filter"),
    libskiptags_plugin(Type.BIN, "stream_filter"),

    // plugins/video_chroma
    libswscale_plugin(Type.BIN, "video_chroma"),
    libyuy2_i422_plugin(Type.BIN, "video_chroma"),
    libi420_rgb_mmx_plugin(Type.BIN, "video_chroma"),
    libi422_yuy2_plugin(Type.BIN, "video_chroma"),
    libi422_i420_plugin(Type.BIN, "video_chroma"),
    libchain_plugin(Type.BIN, "video_chroma"),
    libi422_yuy2_mmx_plugin(Type.BIN, "video_chroma"),
    libi420_nv12_plugin(Type.BIN, "video_chroma"),
    libi420_10_p010_plugin(Type.BIN, "video_chroma"),
    libgrey_yuv_plugin(Type.BIN, "video_chroma"),
    libi420_rgb_plugin(Type.BIN, "video_chroma"),
    libi422_yuy2_sse2_plugin(Type.BIN, "video_chroma"),
    libyuvp_plugin(Type.BIN, "video_chroma"),
    libi420_yuy2_sse2_plugin(Type.BIN, "video_chroma"),
    librv32_plugin(Type.BIN, "video_chroma"),
    libi420_yuy2_plugin(Type.BIN, "video_chroma"),
    libi420_rgb_sse2_plugin(Type.BIN, "video_chroma"),
    libyuy2_i420_plugin(Type.BIN, "video_chroma"),
    libi420_yuy2_mmx_plugin(Type.BIN, "video_chroma"),

    // plugins/video_filter
    libadjust_plugin(Type.BIN, "video_filter"),
    libalphamask_plugin(Type.BIN, "video_filter"),
    libdeinterlace_plugin(Type.BIN, "video_filter"),
    libfps_plugin(Type.BIN, "video_filter"),

    // plugins/video_output
    libvdummy_plugin(Type.BIN, "video_output"),
    libvmem_plugin(Type.BIN, "video_output"),

    /*
        #####################
        #### LUA SCRIPTS ####
        #####################
    */

    // extensions
    VLSub(Type.LUAC, "extensions"),

    // intf
    cli(Type.LUAC, "intf"),
    dummy(Type.LUAC, "intf"),
    dumpmeta(Type.LUAC, "intf"),
    http(Type.LUAC, "intf"),
    luac(Type.LUAC, "intf"),
    telnet(Type.LUAC, "intf"),

    // intf/modules
    host(Type.LUAC, "intf/modules"),
    httprequests(Type.LUAC, "intf/modules"),

    // modules
    common(Type.LUAC, "modules"),
    dkjson(Type.LUAC, "modules"),
    sandbox(Type.LUAC, "modules"),
    simplexml(Type.LUAC, "modules"),

    // playlist
    newgrounds(Type.LUAC, "playlist"),
    soundcloud(Type.LUAC, "playlist"),
    vimeo(Type.LUAC, "playlist"),
    vocaroo(Type.LUAC, "playlist"),
    youtube(Type.LUAC, "playlist"),
    ;

    private static Path rootVLC;
    private final String resourceOrigin;
    private final String intendedDestination;

    VLCBinaries(Type type, String dir) {
        String relativeDir = (dir != null
                ? (type.equals(Type.BIN) ? "plugins/" : "") + dir + "/"
                : "") + name() + type.extension;
        
        this.resourceOrigin = type.rootDir + "/" + relativeDir;
        this.intendedDestination = (type.equals(Type.LUAC) ? "/lua/" : "/") + relativeDir;
    }

    void extract() {
        Util.extractFrom(resourceOrigin, rootVLC.toAbsolutePath() + intendedDestination);
    }

    void delete() {
        String destination = rootVLC.toAbsolutePath() + intendedDestination;
        if (new File(destination).delete()) LOGGER.warn(IT, "File '{}' cannot be deleted", name());
    }

    void checkIntegrity() {
        if (!Util.integrityCheck(resourceOrigin, new File(rootVLC.toAbsolutePath() + intendedDestination))) {
            delete();
            extract();
        }
    }

    static void init(Path rootDir) {
        LOGGER.info("Running on {} reading path {}", Util.ARCH, rootDir);
        rootVLC = rootDir;
    }
    static void cleanup() { Util.deleteFrom(rootVLC.toAbsolutePath().toString()); }
    static void extractAll() { for (VLCBinaries bin: VLCBinaries.values()) bin.extract(); }
    static String installedVersion() { return Util.readFrom(rootVLC.resolve("version.cfg").toAbsolutePath()); }
    static String resVersion() { return "3.0.18b"; }

    enum Type {
        LUAC("/vlc/lua", ".luac"),
        BIN("/vlc/" + Util.ARCH, Util.ARCH.EXT);
        public final String rootDir;
        public final String extension;
        Type(String rootDir, String ext) { this.rootDir = rootDir; this.extension = ext; }
    }
}